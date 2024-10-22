CREATE DATABASE  IF NOT EXISTS `simulacro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `simulacro`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: simulacro
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
-- Table structure for table `bulto`
--

DROP TABLE IF EXISTS `bulto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bulto` (
  `id_bulto` int NOT NULL AUTO_INCREMENT,
  `peso` decimal(5,2) NOT NULL,
  `fragil` char(1) NOT NULL DEFAULT 'n',
  `codigo_envio` int NOT NULL,
  PRIMARY KEY (`id_bulto`,`codigo_envio`),
  KEY `codigo_envio` (`codigo_envio`),
  CONSTRAINT `bulto_ibfk_1` FOREIGN KEY (`codigo_envio`) REFERENCES `envio` (`codigo_envio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bulto`
--

LOCK TABLES `bulto` WRITE;
/*!40000 ALTER TABLE `bulto` DISABLE KEYS */;
/*!40000 ALTER TABLE `bulto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carta`
--

DROP TABLE IF EXISTS `carta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carta` (
  `id_bulto` int NOT NULL,
  `certificado` char(1) NOT NULL DEFAULT 'n',
  PRIMARY KEY (`id_bulto`),
  CONSTRAINT `carta_ibfk_1` FOREIGN KEY (`id_bulto`) REFERENCES `bulto` (`id_bulto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carta`
--

LOCK TABLES `carta` WRITE;
/*!40000 ALTER TABLE `carta` DISABLE KEYS */;
/*!40000 ALTER TABLE `carta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `codigo_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido1` varchar(20) NOT NULL,
  `apellido2` varchar(20) DEFAULT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` int NOT NULL,
  PRIMARY KEY (`codigo_cliente`),
  KEY `idx_nombre` (`nombre`),
  KEY `idx_apellido1` (`apellido1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrega`
--

DROP TABLE IF EXISTS `entrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrega` (
  `id_entrega` int NOT NULL AUTO_INCREMENT,
  `fecha_entrega` date NOT NULL,
  `codigo_envio` int DEFAULT NULL,
  `matricula` char(10) DEFAULT NULL,
  `id_empleado` int DEFAULT NULL,
  PRIMARY KEY (`id_entrega`),
  KEY `codigo_envio` (`codigo_envio`),
  KEY `matricula` (`matricula`),
  KEY `id_empleado` (`id_empleado`),
  KEY `idx_fechaentrega` (`fecha_entrega` DESC),
  CONSTRAINT `entrega_ibfk_1` FOREIGN KEY (`codigo_envio`) REFERENCES `envio` (`codigo_envio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `entrega_ibfk_2` FOREIGN KEY (`matricula`) REFERENCES `vehiculo` (`matricula`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `entrega_ibfk_3` FOREIGN KEY (`id_empleado`) REFERENCES `mensajero` (`id_empleado`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrega`
--

LOCK TABLES `entrega` WRITE;
/*!40000 ALTER TABLE `entrega` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envio`
--

DROP TABLE IF EXISTS `envio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `envio` (
  `codigo_envio` int NOT NULL AUTO_INCREMENT,
  `fecha_creacion` date NOT NULL,
  `tipo_envio` int NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `receptor` varchar(40) NOT NULL,
  `codigo_cliente` int NOT NULL,
  PRIMARY KEY (`codigo_envio`,`codigo_cliente`),
  KEY `codigo_cliente` (`codigo_cliente`),
  CONSTRAINT `envio_ibfk_1` FOREIGN KEY (`codigo_cliente`) REFERENCES `cliente` (`codigo_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `envio_chk_1` CHECK ((`tipo_envio` >= 5))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envio`
--

LOCK TABLES `envio` WRITE;
/*!40000 ALTER TABLE `envio` DISABLE KEYS */;
/*!40000 ALTER TABLE `envio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajero`
--

DROP TABLE IF EXISTS `mensajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensajero` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nif` char(9) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido1` varchar(20) NOT NULL,
  `apellido2` varchar(20) NOT NULL,
  `fecha_alta` date NOT NULL,
  `categoria` int NOT NULL,
  `es_jefe` int DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `es_jefe` (`es_jefe`),
  KEY `idx_nombre` (`nombre`),
  KEY `idx_apellido1` (`apellido1`),
  CONSTRAINT `mensajero_ibfk_1` FOREIGN KEY (`es_jefe`) REFERENCES `mensajero` (`id_empleado`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `mensajero_chk_1` CHECK ((`categoria` <= 3)),
  CONSTRAINT `mensajero_chk_2` CHECK (((`categoria` >= 1) and (`categoria` <= 3)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajero`
--

LOCK TABLES `mensajero` WRITE;
/*!40000 ALTER TABLE `mensajero` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paquete` (
  `alto` int NOT NULL,
  `largo` int NOT NULL,
  `ancho` int NOT NULL,
  `id_bulto` int NOT NULL,
  PRIMARY KEY (`id_bulto`),
  CONSTRAINT `paquete_ibfk_1` FOREIGN KEY (`id_bulto`) REFERENCES `bulto` (`id_bulto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paquete_chk_1` CHECK ((`alto` > 1)),
  CONSTRAINT `paquete_chk_2` CHECK ((`largo` > 1)),
  CONSTRAINT `paquete_chk_3` CHECK ((`ancho` > 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `matricula` char(10) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `volumen` int NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-17 23:53:02
