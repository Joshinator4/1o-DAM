CREATE DATABASE  IF NOT EXISTS `ejercicio_ud6` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ejercicio_ud6`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: ejercicio_ud6
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
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paises` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pais` varchar(30) NOT NULL,
  `ue` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=215 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'Afganistán',0),(2,'Albania',0),(3,'Alemania',1),(4,'Algeria',0),(5,'Andorra',0),(6,'Angola',0),(7,'Anguilla',0),(8,'Antigua y Barbuda',0),(9,'Antillas Holandesas',0),(10,'Arabia Saudita',0),(11,'Argentina',0),(12,'Armenia',0),(13,'Aruba',0),(14,'Australia',0),(15,'Austria',1),(16,'Azerbaiyán',0),(17,'Bélgica',1),(18,'Bahamas',0),(19,'Bahrein',0),(20,'Bangladesh',0),(21,'Barbados',0),(22,'Belice',0),(23,'Benín',0),(24,'Bermudas',0),(25,'Bielorrusia',0),(26,'Bolivia',0),(27,'Bosnia y Herzegovina',0),(28,'Botsuana',0),(29,'Brasil',0),(30,'Brunéi',0),(31,'Bulgaria',1),(32,'Burkina Faso',0),(33,'Burundi',0),(34,'Bután',0),(35,'Cabo Verde',0),(36,'Camboya',0),(37,'Camerún',0),(38,'Canadá',0),(39,'Chad',0),(40,'Chile',0),(41,'China',0),(42,'Chipre',1),(43,'Colombia',0),(44,'Comores',0),(45,'Congo (Brazzaville)',0),(46,'Congo (Kinshasa)',0),(47,'Cook, Islas',0),(48,'Corea del Norte',0),(49,'Corea del Sur',0),(50,'Costa de Marfil',0),(51,'Costa Rica',0),(52,'Croacia',1),(53,'Cuba',0),(54,'Dinamarca',1),(55,'Djibouti, Yibuti',0),(56,'Ecuador',0),(57,'Egipto',0),(58,'El Salvador',0),(59,'Emiratos Árabes Unidos',0),(60,'Eritrea',0),(61,'Eslovaquia',1),(62,'Eslovenia',1),(63,'España',1),(64,'Estados Unidos',0),(65,'Estonia',1),(66,'Etiopía',0),(67,'Feroe, Islas',0),(68,'Filipinas',0),(69,'Finlandia',1),(70,'Fiyi',0),(71,'Francia',1),(72,'Gabón',0),(73,'Gambia',0),(74,'Georgia',0),(75,'Ghana',0),(76,'Gibraltar',0),(77,'Granada',0),(78,'Grecia',1),(79,'Groenlandia',0),(80,'Guadalupe',0),(81,'Guatemala',0),(82,'Guernsey',0),(83,'Guinea',0),(84,'Guinea Ecuatorial',0),(85,'Guinea-Bissau',0),(86,'Guyana',0),(87,'Haiti',0),(88,'Honduras',0),(89,'Hong Kong',0),(90,'Hungría',1),(91,'India',0),(92,'Indonesia',0),(93,'Irán',0),(94,'Irak',0),(95,'Irlanda',1),(96,'Isla Pitcairn',0),(97,'Islandia',0),(98,'Islas Salomón',0),(99,'Islas Turcas y Caicos',0),(100,'Islas Virgenes Británicas',0),(101,'Israel',0),(102,'Italia',1),(103,'Jamaica',0),(104,'Japón',0),(105,'Jersey',0),(106,'Jordania',0),(107,'Kazajstán',0),(108,'Kenia',0),(109,'Kirguistán',0),(110,'Kiribati',0),(111,'Kuwait',0),(112,'Líbano',0),(113,'Laos',0),(114,'Lesotho',0),(115,'Letonia',1),(116,'Liberia',0),(117,'Libia',0),(118,'Liechtenstein',0),(119,'Lituania',1),(120,'Luxemburgo',1),(121,'México',0),(122,'Mónaco',0),(123,'Macedonia',0),(124,'Madagascar',0),(125,'Malí',0),(126,'Malasia',0),(127,'Malawi',0),(128,'Maldivas',0),(129,'Malta',1),(130,'Man, Isla de',0),(131,'Marruecos',0),(132,'Martinica',0),(133,'Mauricio',0),(134,'Mauritania',0),(135,'Moldavia',0),(136,'Mongolia',0),(137,'Mozambique',0),(138,'Myanmar',0),(139,'Níger',0),(140,'Namibia',0),(141,'Nauru',0),(142,'Nepal',0),(143,'Nicaragua',0),(144,'Nigeria',0),(145,'Norfolk Island',0),(146,'Noruega',0),(147,'Nueva Caledonia',0),(148,'Nueva Zelanda',0),(149,'Omán',0),(150,'Países Bajos, Holanda',1),(151,'Pakistán',0),(152,'Panamá',0),(153,'Papúa-Nueva Guinea',0),(154,'Paraguay',0),(155,'Perú',0),(156,'Polinesia Francesa',0),(157,'Polonia',1),(158,'Portugal',1),(159,'Puerto Rico',0),(160,'Qatar',0),(161,'Reino Unido',0),(162,'República Checa',1),(163,'República Dominicana',0),(164,'Reunión',0),(165,'Ruanda',0),(166,'Rumanía',1),(167,'Rusia',0),(168,'Sáhara Occidental',0),(169,'Samoa',0),(170,'San Cristobal y Nevis',0),(171,'San Marino',0),(172,'San Pedro y Miquelón',0),(173,'San Tomé y Príncipe',0),(174,'San Vincente y Granadinas',0),(175,'Santa Elena',0),(176,'Santa Lucía',0),(177,'Senegal',0),(178,'Serbia y Montenegro',0),(179,'Seychelles',0),(180,'Sierra Leona',0),(181,'Singapur',0),(182,'Siria',0),(183,'Somalia',0),(184,'Sri Lanka',0),(185,'Sudáfrica',0),(186,'Sudán',0),(187,'Suecia',1),(188,'Suiza',0),(189,'Surinam',0),(190,'Swazilandia',0),(191,'Tadjikistan',0),(192,'Tailandia',0),(193,'Taiwan',0),(194,'Tanzania',0),(195,'Túnez',0),(196,'Timor Oriental',0),(197,'Togo',0),(198,'Tokelau',0),(199,'Tonga',0),(200,'Trinidad y Tobago',0),(201,'Turkmenistan',0),(202,'Turquía',0),(203,'Tuvalu',0),(204,'Ucrania',0),(205,'Uganda',0),(206,'Uruguay',0),(207,'Uzbekistán',0),(208,'Vanuatu',0),(209,'Venezuela',0),(210,'Vietnam',0),(211,'Wallis y Futuna',0),(212,'Yemen',0),(213,'Zambia',0),(214,'Zimbabwe',0);
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-06 22:55:18
