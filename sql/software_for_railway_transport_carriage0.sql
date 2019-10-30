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
-- Table structure for table `carriage`
--

DROP TABLE IF EXISTS `carriage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carriage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `id_typeCarriage` bigint(20) DEFAULT NULL,
  `id_train` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `carriage_typecarriage_id_fk` (`id_typeCarriage`),
  KEY `carriage_train_id_fk` (`id_train`),
  CONSTRAINT `carriage_train_id_fk` FOREIGN KEY (`id_train`) REFERENCES `train` (`id`),
  CONSTRAINT `carriage_typecarriage_id_fk` FOREIGN KEY (`id_typeCarriage`) REFERENCES `typecarriage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carriage`
--

LOCK TABLES `carriage` WRITE;
/*!40000 ALTER TABLE `carriage` DISABLE KEYS */;
INSERT INTO `carriage` VALUES (1,1,1,1),(2,2,2,1),(3,2,2,2),(4,11,NULL,NULL),(5,11,NULL,NULL),(6,11,NULL,NULL),(7,11,NULL,NULL),(8,11,NULL,NULL),(9,11,NULL,NULL),(10,11,NULL,NULL),(11,11,NULL,NULL),(12,11,NULL,NULL),(21,11,21,21),(22,11,22,22),(23,11,25,23),(24,11,26,24),(25,11,27,25),(26,11,28,26),(27,11,29,27),(28,11,30,32),(29,11,31,33),(30,11,32,34),(31,11,33,35),(32,11,34,36),(34,11,36,39),(36,11,37,41),(37,777,38,42);
/*!40000 ALTER TABLE `carriage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-30 19:27:22
