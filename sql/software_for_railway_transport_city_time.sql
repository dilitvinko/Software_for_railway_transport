-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: software_for_railway_transport
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `city_time`
--

DROP TABLE IF EXISTS `city_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city_time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `timeDate` timestamp NOT NULL,
  `id_route` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cityTime_route_id__fk` (`id_route`),
  CONSTRAINT `cityTime_route_id__fk` FOREIGN KEY (`id_route`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_time`
--

LOCK TABLES `city_time` WRITE;
/*!40000 ALTER TABLE `city_time` DISABLE KEYS */;
INSERT INTO `city_time` VALUES (5,'Minsk','2019-07-07 12:00:00',1),(6,'Bereza','2019-07-07 15:00:00',1),(7,'Brest','2019-07-07 16:00:00',1),(8,'Brest','2019-07-08 08:00:00',2),(9,'Bereza','2019-07-08 09:00:00',2),(10,'Baranovichi','2019-07-08 10:00:00',2),(11,'Minsk','2019-07-08 12:00:00',2),(12,'Brest','2019-07-10 08:00:00',3),(13,'Moskva','2019-07-08 19:00:00',3),(14,'Moskva','2019-07-08 08:00:00',4),(15,'Gomel','2019-07-08 12:00:00',4),(16,'Minsk','2019-07-08 14:00:00',4),(17,'Bereza','2019-07-08 17:00:00',4),(18,'Brest','2019-07-08 18:00:00',4),(19,'Minsk','2019-07-10 12:00:00',3);
/*!40000 ALTER TABLE `city_time` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-25 18:23:19
