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
-- Table structure for table `typecarriage`
--

DROP TABLE IF EXISTS `typecarriage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typecarriage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `amountSeats` int(11) DEFAULT NULL,
  `cooffPrise` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typecarriage`
--

LOCK TABLES `typecarriage` WRITE;
/*!40000 ALTER TABLE `typecarriage` DISABLE KEYS */;
INSERT INTO `typecarriage` VALUES (1,'O',10,1),(2,'P',5,2),(3,'test',1,2.2),(4,'test',1,2.2),(5,'test',1,2.2),(6,'test',1,2.2),(7,'test',1,2.2),(8,'test',1,2.2),(9,'test',1,2.2),(10,'test',1,2.2),(11,'test',1,2.2),(12,'test',1,2.2),(13,'test',1,2.2),(14,'test',1,2.2),(15,'test',1,2.2),(16,'test',1,2.2),(17,'test',1,2.2),(18,'test',1,2.2),(19,'test',1,2.2),(20,'test',1,2.2),(21,'test',1,2.2),(22,'test',1,2.2),(23,'qwe',1,3.3),(24,'asd',1,4.4),(25,'test',1,2.2),(26,'test',1,2.2),(27,'test',1,2.2),(28,'test',1,2.2),(29,'test',1,2.2),(30,'test',1,2.2),(31,'test',1,2.2),(32,'test',1,2.2),(33,'test',1,2.2),(34,'test',1,2.2),(35,'test',1,2.2),(36,'test',1,2.2),(37,'test',1,2.2),(38,'testtestqwe',999,111.11);
/*!40000 ALTER TABLE `typecarriage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-30 19:27:21