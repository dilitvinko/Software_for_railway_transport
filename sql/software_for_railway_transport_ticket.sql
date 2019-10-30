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
  `id_seat` bigint(20) NOT NULL,
  `id_carriage` bigint(20) NOT NULL,
  `id_train` bigint(20) NOT NULL,
  `id_out_city_time` bigint(20) NOT NULL,
  `id_in_city_time` bigint(20) NOT NULL,
  `id_person` bigint(20) NOT NULL,
  `id_route` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ticket_carriage_id_fk` (`id_carriage`),
  KEY `ticket_city_time_in_id__fk` (`id_in_city_time`),
  KEY `ticket_city_time_out_id__fk` (`id_out_city_time`),
  KEY `ticket_route_id__fk` (`id_route`),
  KEY `ticket_seat_id__fk` (`id_seat`),
  KEY `ticket_person_id__fk` (`id_person`),
  KEY `ticket_train_id__fk_idx` (`id_train`),
  CONSTRAINT `ticket_carriage_id_fk` FOREIGN KEY (`id_carriage`) REFERENCES `carriage` (`id`),
  CONSTRAINT `ticket_city_time_in_id__fk` FOREIGN KEY (`id_in_city_time`) REFERENCES `city_time` (`id`),
  CONSTRAINT `ticket_city_time_out_id__fk` FOREIGN KEY (`id_out_city_time`) REFERENCES `city_time` (`id`),
  CONSTRAINT `ticket_person_id__fk` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`),
  CONSTRAINT `ticket_route_id__fk` FOREIGN KEY (`id_route`) REFERENCES `route` (`id`),
  CONSTRAINT `ticket_seat_id__fk` FOREIGN KEY (`id_seat`) REFERENCES `numberSeat` (`id`),
  CONSTRAINT `ticket_train_id__fk` FOREIGN KEY (`id_train`) REFERENCES `train` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
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

-- Dump completed on 2019-10-25 18:23:19
