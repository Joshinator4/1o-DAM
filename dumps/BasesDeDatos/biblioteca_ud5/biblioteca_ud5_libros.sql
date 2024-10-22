CREATE DATABASE  IF NOT EXISTS `biblioteca_ud5` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca_ud5`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca_ud5
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
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros` (
  `id_libro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `id_autor` int NOT NULL,
  PRIMARY KEY (`id_libro`),
  KEY `id_autor` (`id_autor`),
  CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id_autor`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (1,'Cien años de soledad',1),(2,'Orgullo y prejuicio',2),(3,'El viejo y el mar',4),(4,'Mrs. Dalloway',5),(5,'La metamorfosis',5),(6,'Harry Potter y la piedra filosofal',7),(7,'Grandes esperanzas',8),(8,'Beloved',10),(9,'Ulises',12),(10,'Las aventuras de Tom Sawyer',14),(11,'El cuento de la criada',15),(12,'1984',16),(13,'Poemas',17),(14,'La insoportable levedad del ser',18),(15,'El extranjero',19),(16,'La casa de los espíritus',20),(17,'El amor en los tiempos del cólera',1),(18,'La hojarasca',1),(19,'Noticias de un secuestro',1),(20,'El general en su laberinto',1),(21,'Eva Luna',1),(22,'La ciudad y los perros',1),(23,'La fiesta del chivo',1),(24,'Ensayo sobre la ceguera',1),(25,'El libro de los abrazos',1),(26,'Emma',2),(27,'Sentido y sensibilidad',2),(28,'Persuasión',2),(29,'Mansfield Park',2),(30,'La abadí­a de Northanger',2),(31,'Lady Susan',2),(32,'Las nieves del Kilimanjaro',4),(33,'Por quién doblan las campanas',4),(34,'París era una fiesta',4),(35,'Adiós a las armas',4),(36,'El viejo y el mar',4),(37,'Islas en el golfo',4),(38,'Orlando',5),(39,'La señora Dalloway',5),(40,'Al faro',5),(41,'Flush',5),(42,'Un cuarto propio',5),(43,'Los años',5),(44,'Cartas a Vera',5),(45,'Diarios',6),(46,'El proceso',6),(47,'El castillo',6),(48,'Amerika',6),(49,'La condena',6),(50,'El desaparecido',6),(51,'Harry Potter y la cámara secreta',7),(52,'Harry Potter y el prisionero de Azkaban',7),(53,'Harry Potter y el cáliz de fuego',7),(54,'Harry Potter y la orden del Fénix',7),(55,'Harry Potter y el misterio del príncipe',7),(56,'Harry Potter y las reliquias de la muerte',7),(57,'Los cuentos de Beedle el bardo',7),(58,'Oliver Twist',8),(59,'Grandes esperanzas',8),(60,'David Copperfield',8),(61,'Cuento de Navidad',8),(62,'Nuestro común amigo',8),(63,'Tiempos difíciles',8),(64,'La pequeña Dorrit',8),(65,'Jazz',10),(66,'Paradise',10),(67,'Love',10),(68,'Home',10),(69,'Beloved',10),(70,'Sula',10),(71,'Dublineses',12),(72,'Retrato del artista adolescente',12),(73,'Ulises',12),(74,'Finnegans Wake',12),(75,'La hija del granjero',12),(76,'El hobbit',13),(77,'El Señor de los Anillos: La comunidad del anillo',13),(78,'El Señor de los Anillos: Las dos torres',13),(79,'El Señor de los Anillos: El retorno del rey',13),(80,'El Silmarillion',13),(81,'Cuentos inconclusos',13),(82,'Las aventuras de Huckleberry Finn',14),(83,'Las aventuras de Tom Sawyer',14),(84,'El príncipe y el mendigo',14),(85,'Un yanqui en la corte del Rey Arturo',14),(86,'Vida en el Mississippi',14),(87,'Tom Sawyer',14),(88,'detective',14),(89,'Alias Grace',15),(90,'Ojo de gato',15),(91,'La mujer comestible',15),(92,'La novia ladrona',15),(93,'Asesinato en la oscuridad',15),(94,'El cuento de la criada',15),(95,'Rebelión en la granja',16),(96,'Homenaje a Cataluña',16),(97,'La hija del clérigo',16),(98,'Burmese Days',16),(99,'Poemas',17),(100,'Cartas',17),(101,'Poesía completa',17),(102,'Vida',17),(103,'Selección de poemas',17),(104,'Corrección de pruebas',17),(105,'La insoportable levedad del ser',18),(106,'La broma',18),(107,'La inmortalidad',18),(108,'La lentitud',18),(109,'La ignorancia',18),(110,'El extranjero',19),(111,'La peste',19),(112,'El mito de Sísifo',19),(113,'El hombre rebelde',19),(114,'Bodas de sangre',19),(115,'De amor y de sombra',20),(116,'Eva Luna',20),(117,'La suma de los días',20),(118,'Paula',20);
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-06 22:54:32
