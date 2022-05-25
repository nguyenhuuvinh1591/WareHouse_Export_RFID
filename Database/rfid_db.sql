-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: rfid_db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderid` (`orderid`),
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'1',0,'Áo 1du so luong: 2\n','2022-04-28 10:46:09'),(2,'1',0,'Áo 1du so luong: 2\n','2022-04-28 11:34:18'),(3,'3',1,'Order 3 handle success','2022-04-28 14:17:54'),(4,'2',1,'Order 2 handle success','2022-04-28 14:27:19'),(5,'4',0,'Áo 4du so luong: 1\n','2022-04-28 20:29:49'),(6,'9',0,'Áo 4du so luong: 4\n','2022-04-28 20:37:59'),(7,'9',0,'Áo 4thieu: 2\n','2022-04-28 20:40:24'),(8,'9',0,'Áo 4thieu: 2\nÁo 3thieu: 1\n','2022-04-28 20:42:10');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `order_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`),
  CONSTRAINT `FKb8bg2bkty0oksa3wiq5mp5qnc` FOREIGN KEY (`product_id`) REFERENCES `product` (`pid`),
  CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES ('1','PD01',6000,2,18000),('1','PD02',2000,1,2000),('2','PD01',6000,1,6000),('2','PD02',2000,1,2000),('3','PD01',2000,1,1111),('4','PD02',1,1,1111),('5','PD02',150000,2,300000),('5','PD04',350000,2,700000),('7','PD02',150000,2,300000),('8','PD01',450000,2,900000),('8','PD03',250000,2,500000),('9','PD02',150000,4,600000),('9','PD03',250000,2,500000);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orderdate` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  `total` double DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('1','2022-02-04 00:00:00',3,20000,'2022-04-28 14:11:52'),('2','2022-02-04 00:00:00',3,20000,'2022-04-28 14:27:19'),('3','2022-02-04 00:00:00',3,11111,'2022-04-28 14:17:54'),('4','2022-02-04 00:00:00',2,1111,'2022-02-04 00:00:00'),('5','2022-04-23 12:38:53',2,1000000,'2022-04-24 12:30:05'),('7','2022-04-24 12:30:06',3,300000,'2022-04-24 12:30:06'),('8','2022-04-24 12:30:05',2,1400000,'2022-04-24 12:30:05'),('9','2022-04-28 16:38:29',2,1100000,'2022-04-28 16:38:29');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('PD01','detail1','Áo 1',2,450000),('PD02','detail1','Áo 4',4,150000),('PD03','detail1','Áo 3',2,250000),('PD04','detail1','Áo 2',54,350000);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slot`
--

DROP TABLE IF EXISTS `slot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slot` (
  `slot_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int DEFAULT NULL,
  `pid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ware_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`slot_id`),
  KEY `FK99lpv45a3qbqnekpjagwykvb0` (`pid`),
  KEY `FK1hp948yf7d1hw4vnh31k7vlr4` (`ware_id`),
  CONSTRAINT `FK1hp948yf7d1hw4vnh31k7vlr4` FOREIGN KEY (`ware_id`) REFERENCES `warehouse` (`wareid`),
  CONSTRAINT `FK99lpv45a3qbqnekpjagwykvb0` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slot`
--

LOCK TABLES `slot` WRITE;
/*!40000 ALTER TABLE `slot` DISABLE KEYS */;
/*!40000 ALTER TABLE `slot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `tagid` varchar(255) NOT NULL,
  `tag_date_in` datetime DEFAULT NULL,
  `tag_date_out` datetime DEFAULT NULL,
  `tag_gate_in` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tag_gate_out` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tagid`),
  KEY `FKdal0uofqrt3xxhyig2jcd0dmi` (`product_id`),
  CONSTRAINT `FKdal0uofqrt3xxhyig2jcd0dmi` FOREIGN KEY (`product_id`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES ('00FF F145 2000 4093 CE01 00F9',NULL,'2022-04-28 14:11:52',NULL,'1','PD02'),('00FF F145 2000 4341 CDFC 00F9',NULL,'2022-04-28 14:27:19',NULL,'1','PD02'),('00FF F145 2000 44C6 CE60 00F9',NULL,NULL,NULL,NULL,'PD02'),('00FF F145 2000 485E CDE2 00F9',NULL,'2022-04-28 14:17:54',NULL,NULL,'PD01'),('300F 4F57 3AD0 01C0 8369 A230',NULL,NULL,NULL,NULL,'PD02'),('300F 4F57 3AD0 01C0 8369 A241',NULL,'2022-04-28 14:27:19',NULL,'1','PD01'),('300F 4F57 3AD0 01C0 8369 A245',NULL,'2022-04-28 14:11:52',NULL,'1','PD01'),('300F 4F57 3AD0 01C0 8369 A249',NULL,'2022-04-28 14:11:52',NULL,'1','PD01'),('300F 4F57 3AD0 01C0 8369 A250',NULL,'2022-04-28 14:17:56',NULL,'1','PD02'),('300F 4F57 3AD0 01C0 8369 A252',NULL,NULL,NULL,NULL,'PD02'),('300F 4F57 3AD0 01C0 8369 A2555',NULL,NULL,NULL,NULL,'PD03'),('300F 4F57 3AD0 01C0 8369 A2556',NULL,NULL,NULL,NULL,'PD04'),('300F 4F57 3AD0 01C0 8369 A2557',NULL,NULL,NULL,NULL,'PD03'),('300F 4F57 3AD0 01C0 8369 A2558',NULL,NULL,NULL,NULL,'PD04'),('300F 4F57 3AD0 01C0 8369 A2559',NULL,NULL,NULL,NULL,'PD02'),('300F 4F57 3AD0 01C0 8369 A2560',NULL,NULL,NULL,NULL,'PD04'),('4D4F 5300',NULL,'2022-04-24 13:24:25',NULL,'1','PD02'),('E200 1026 8110 0159 1490 7999',NULL,'2022-04-24 13:24:26',NULL,'1','PD02');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehouse` (
  `wareid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`wareid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-29 22:10:09
