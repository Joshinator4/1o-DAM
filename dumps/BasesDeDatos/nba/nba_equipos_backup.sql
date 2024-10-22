CREATE DATABASE  IF NOT EXISTS `nba` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nba`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: nba
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `equipos_backup`
--

DROP TABLE IF EXISTS `equipos_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos_backup` (
  `nombre` varchar(20) NOT NULL,
  `ciudad` varchar(20) DEFAULT NULL,
  `conferencia` varchar(4) DEFAULT NULL,
  `division` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos_backup`
--

LOCK TABLES `equipos_backup` WRITE;
/*!40000 ALTER TABLE `equipos_backup` DISABLE KEYS */;
INSERT INTO `equipos_backup` VALUES ('76ers','Philadelphia','East',1),('Bobcats','Charlotte','East',2),('Bucks','Milwaukee','East',3),('Bulls','Chicago','East',3),('Cavaliers','Cleveland','East',3),('Celtics','Boston','East',1),('Clippers','Los Angeles','West',4),('Grizzlies','Memphis','West',5),('Hawks','Atlanta','East',2),('Heat','Miami','East',2),('Hornets','New Orleans','West',5),('Jazz','Utah','West',6),('Kings','Sacramento','West',4),('Knicks','New York','East',1),('Lakers','Los Angeles','West',4),('Magic','Orlando','East',2),('Mavericks','Dallas','West',5),('Nets','New Jersey','East',1),('Nuggets','Denver','West',6),('Pacers','Indiana','East',3),('Pistons','Detroit','East',3),('Raptors','Toronto','East',1),('Rockets','Houston','West',5),('Spurs','San Antonio','West',5),('Suns','Phoenix','West',4),('Supersonics','Seattle','West',6),('Timberwolves','Minnesota','West',6),('Trail Blazers','Portland','West',6),('Warriors','Golden State','West',4),('Wizards','Washington','East',2);
/*!40000 ALTER TABLE `equipos_backup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-06 22:55:47
