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
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numberSeat` int(11) DEFAULT NULL,
  `id_carriage` bigint(20) NOT NULL,
  `id_train` bigint(20) NOT NULL,
  `id_outSchedule` bigint(20) NOT NULL,
  `id_inSchedule` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ticket_carriage_id_fk` (`id_carriage`),
  KEY `ticket_schedule_id_fk` (`id_outSchedule`),
  KEY `ticket_schedule_id_fk_2` (`id_inSchedule`),
  KEY `ticket_train_id_fk` (`id_train`),
  CONSTRAINT `ticket_carriage_id_fk` FOREIGN KEY (`id_carriage`) REFERENCES `carriage` (`id`),
  CONSTRAINT `ticket_schedule_id_fk` FOREIGN KEY (`id_outSchedule`) REFERENCES `schedule` (`id`),
  CONSTRAINT `ticket_schedule_id_fk_2` FOREIGN KEY (`id_inSchedule`) REFERENCES `schedule` (`id`),
  CONSTRAINT `ticket_train_id_fk` FOREIGN KEY (`id_train`) REFERENCES `train` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,4,1,1,1,3,'2019-10-20',5),(2,3,1,1,2,4,'2019-10-20',4),(3,5,2,1,3,4,'2019-10-20',3),(4,5,3,2,6,8,'2019-10-20',7),(5,3,1,1,1,2,'2019-10-20',2),(6,1,1,1,2,4,'2019-10-20',34),(7,6,1,1,3,4,'2019-10-20',42),(8,4,1,1,1,4,'2019-10-20',12),(9,9,1,1,1,3,'2019-10-20',3),(10,3,1,1,2,4,'2019-10-20',2),(11,10,1,1,1,3,'2019-10-21',12),(43,6,1,1,1,3,'2019-10-20',999);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-06 19:20:20
