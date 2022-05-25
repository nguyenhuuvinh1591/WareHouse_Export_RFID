package rfid_project;

import com.impinj.octane.*;

import java.util.Scanner;
import javax.swing.JFrame;

public class ReadTags {

    public static void main(String[] args) {
try {
            String hostname = "169.254.172.228";
            if (hostname == null) {
                throw new Exception("Must specify the '"
                        + SampleProperties.hostname + "' property");
            }

            ImpinjReader reader = new ImpinjReader();

            System.out.println("Connecting");
            reader.connect(hostname);

            Settings settings = reader.queryDefaultSettings();

            ReportConfig report = settings.getReport();
            report.setIncludeAntennaPortNumber(true);
            report.setMode(ReportMode.BatchAfterStop);
            report.getIncludeFirstSeenTime();
            report.getIncludeLastSeenTime();
            // The reader can be set into various modes in which reader
            // dynamics are optimized for specific regions and environments.
            // The following mode, AutoSetDenseReader, monitors RF noise and interference and then automatically
            // and continuously optimizes the reader's configuration
            settings.setReaderMode(ReaderMode.AutoSetDenseReader);
            
            settings.getAutoStart().setMode(AutoStartMode.Periodic);
            settings.getAutoStart().setPeriodInMs(2000);  
            settings.getAutoStop().setMode(AutoStopMode.Duration);
            settings.getAutoStop().setDurationInMs(1000);
            // set some special settings for antenna 1
            AntennaConfigGroup antennas = settings.getAntennas();
            antennas.disableAll();
            antennas.enableById(new short[]{1});
            antennas.getAntenna((short) 1).setIsMaxRxSensitivity(false);
            antennas.getAntenna((short) 1).setIsMaxTxPower(false);
            antennas.getAntenna((short) 1).setTxPowerinDbm(20.0);
            antennas.getAntenna((short) 1).setRxSensitivityinDbm(-70);

            reader.setTagReportListener(new TagReportListenerImplementation2());

            System.out.println("Applying Settings");
            reader.applySettings(settings);

            System.out.println("Starting");
            reader.start();
            Main main = new Main();
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setVisible(true);
            System.out.println("Press Enter to exit.");
            Scanner s = new Scanner(System.in);
            s.nextLine();
            reader.stop();
            reader.disconnect();
        } catch (OctaneSdkException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }

    public static void readTags() {
        
    }
}
