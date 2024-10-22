CREATE DATABASE  IF NOT EXISTS `ejercicio_biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ejercicio_biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ejercicio_biblioteca
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
-- Table structure for table `autores`
--

DROP TABLE IF EXISTS `autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autores` (
  `id_del_autor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellidos` varchar(40) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`id_del_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autores`
--

LOCK TABLES `autores` WRITE;
/*!40000 ALTER TABLE `autores` DISABLE KEYS */;
/*!40000 ALTER TABLE `autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactos` (
  `id_de_contacto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellidos` varchar(40) COLLATE utf8mb3_spanish_ci NOT NULL,
  `telefono` varchar(15) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `empresa` char(9) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_de_contacto`),
  UNIQUE KEY `email` (`email`),
  KEY `empresa` (`empresa`),
  CONSTRAINT `contactos_ibfk_1` FOREIGN KEY (`empresa`) REFERENCES `empresas` (`cif`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creadores`
--

DROP TABLE IF EXISTS `creadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creadores` (
  `id_creador` int NOT NULL AUTO_INCREMENT,
  `producto` int DEFAULT NULL,
  `autor` int DEFAULT NULL,
  PRIMARY KEY (`id_creador`),
  KEY `producto` (`producto`),
  KEY `autor` (`autor`),
  CONSTRAINT `creadores_ibfk_1` FOREIGN KEY (`producto`) REFERENCES `productos` (`id_del_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `creadores_ibfk_2` FOREIGN KEY (`autor`) REFERENCES `autores` (`id_del_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creadores`
--

LOCK TABLES `creadores` WRITE;
/*!40000 ALTER TABLE `creadores` DISABLE KEYS */;
/*!40000 ALTER TABLE `creadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejemplares`
--

DROP TABLE IF EXISTS `ejemplares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejemplares` (
  `signatura` char(10) COLLATE utf8mb3_spanish_ci NOT NULL,
  `fecha_de_adquisicion` date DEFAULT NULL,
  `estanteria` int DEFAULT NULL,
  `balda` int DEFAULT NULL,
  `producto` int NOT NULL,
  PRIMARY KEY (`signatura`),
  KEY `producto` (`producto`),
  CONSTRAINT `ejemplares_ibfk_1` FOREIGN KEY (`producto`) REFERENCES `productos` (`id_del_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplares`
--

LOCK TABLES `ejemplares` WRITE;
/*!40000 ALTER TABLE `ejemplares` DISABLE KEYS */;
/*!40000 ALTER TABLE `ejemplares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresas` (
  `cif` char(9) COLLATE utf8mb3_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE utf8mb3_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `sede` char(3) COLLATE utf8mb3_spanish_ci DEFAULT 'es',
  PRIMARY KEY (`cif`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `sede` (`sede`),
  CONSTRAINT `empresas_ibfk_1` FOREIGN KEY (`sede`) REFERENCES `paises` (`codigo_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paises` (
  `codigo_pais` char(3) COLLATE utf8mb3_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`codigo_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamos` (
  `ejemplar` char(10) COLLATE utf8mb3_spanish_ci NOT NULL,
  `socio` int NOT NULL,
  `fecha_prestamo` date NOT NULL,
  PRIMARY KEY (`ejemplar`,`socio`,`fecha_prestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamos`
--

LOCK TABLES `prestamos` WRITE;
/*!40000 ALTER TABLE `prestamos` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_del_producto` int NOT NULL AUTO_INCREMENT,
  `titulo` char(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  `fecha_de_publicacion` date NOT NULL,
  `empresa` char(9) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `tipo_de_producto` int NOT NULL DEFAULT '1',
  `isbn` char(13) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `num_paginas` int DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  PRIMARY KEY (`id_del_producto`),
  KEY `empresa` (`empresa`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`empresa`) REFERENCES `empresas` (`cif`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `productos_chk_1` CHECK (((`tipo_de_producto` <= 3) and (`tipo_de_producto` > 0)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referencias`
--

DROP TABLE IF EXISTS `referencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referencias` (
  `id_referencia` int NOT NULL AUTO_INCREMENT,
  `socio` int DEFAULT NULL,
  `autor` int DEFAULT NULL,
  PRIMARY KEY (`id_referencia`),
  KEY `socio` (`socio`),
  KEY `autor` (`autor`),
  CONSTRAINT `referencias_ibfk_1` FOREIGN KEY (`socio`) REFERENCES `socios` (`id_socio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `referencias_ibfk_2` FOREIGN KEY (`autor`) REFERENCES `autores` (`id_del_autor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referencias`
--

LOCK TABLES `referencias` WRITE;
/*!40000 ALTER TABLE `referencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `referencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socios`
--

DROP TABLE IF EXISTS `socios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socios` (
  `id_socio` int NOT NULL AUTO_INCREMENT,
  `nif` char(9) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellidos` varchar(40) COLLATE utf8mb3_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `telefono` varchar(15) COLLATE utf8mb3_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_de_alta` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_socio`),
  UNIQUE KEY `nif` (`nif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socios`
--

LOCK TABLES `socios` WRITE;
/*!40000 ALTER TABLE `socios` DISABLE KEYS */;
/*!40000 ALTER TABLE `socios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temas`
--

DROP TABLE IF EXISTS `temas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temas` (
  `id_del_tema` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`id_del_tema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temas`
--

LOCK TABLES `temas` WRITE;
/*!40000 ALTER TABLE `temas` DISABLE KEYS */;
/*!40000 ALTER TABLE `temas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ejercicio_biblioteca'
--

--
-- Dumping routines for database 'ejercicio_biblioteca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-13 19:35:32
