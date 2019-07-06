-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 192.168.99.100    Database: bdturno
-- ------------------------------------------------------
-- Server version	5.7.26
create database bdturno;
use bdturno;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CATEGORIA`
--

DROP TABLE IF EXISTS `CATEGORIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CATEGORIA` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `rango` int(11) NOT NULL,
  `descripcion` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORIA`
--

LOCK TABLES `CATEGORIA` WRITE;
/*!40000 ALTER TABLE `CATEGORIA` DISABLE KEYS */;
INSERT INTO `CATEGORIA` VALUES (1,1,'muy bajo',1),(2,2,'bajo',1),(3,3,'medio',1),(4,4,'alto',1);
/*!40000 ALTER TABLE `CATEGORIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CERTIFICADO`
--

DROP TABLE IF EXISTS `CERTIFICADO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CERTIFICADO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CERTIFICADO`
--

LOCK TABLES `CERTIFICADO` WRITE;
/*!40000 ALTER TABLE `CERTIFICADO` DISABLE KEYS */;
INSERT INTO `CERTIFICADO` VALUES (1,'alfa',5000.00,1),(2,'beta',10000.00,1),(3,'plus',15000.00,1);
/*!40000 ALTER TABLE `CERTIFICADO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CLIENTE` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nombre` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fk_id_categoria` int(11) NOT NULL,
  `fecha_ult_visita` datetime DEFAULT NULL,
  `preferente` tinyint(1) DEFAULT NULL,
  `fk_id_producto` int(11) DEFAULT NULL,
  `fec_creacion` datetime DEFAULT NULL,
  `fec_modificacion` datetime DEFAULT NULL,
  `usu_creacion` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `usu_modificacion` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CATEGORIA_idx` (`fk_id_categoria`),
  KEY `FK_PRODUCTO_idx` (`fk_id_producto`),
  CONSTRAINT `FK_CATEGORIA` FOREIGN KEY (`fk_id_categoria`) REFERENCES `CATEGORIA` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_PRODUCTO` FOREIGN KEY (`fk_id_producto`) REFERENCES `PRODUCTO` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
INSERT INTO `CLIENTE` VALUES (3,'41586558','ERIKA BALANDA',1,'2018-06-30 00:00:00',1,1,NULL,NULL,NULL,NULL,1),(4,'41857845','PAOLO GUERRERO',4,'2019-07-05 22:56:22',0,5,NULL,NULL,NULL,NULL,1),(5,'98784598','RENATO TAPIA',3,'2018-02-23 16:55:01',0,3,NULL,NULL,NULL,NULL,1),(6,'48788787','PEDRO GALLESE',2,'2012-11-24 13:05:14',0,2,NULL,NULL,NULL,NULL,1),(7,'48454849','THAISA LEAL',1,'2016-02-01 14:02:02',1,1,NULL,NULL,NULL,NULL,1),(8,'48784848','RICARDO GARECA',4,'2009-05-05 11:48:23',1,4,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FUNCIONARIO`
--

DROP TABLE IF EXISTS `FUNCIONARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `FUNCIONARIO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fk_id_backup` int(11) DEFAULT NULL,
  `fec_creacion` datetime DEFAULT NULL,
  `fec_modificacion` datetime DEFAULT NULL,
  `usu_creacion` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `usu_modificacion` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_FUNCIONARIO_idx` (`fk_id_backup`),
  CONSTRAINT `FK_FUNCIONARIO_ID` FOREIGN KEY (`fk_id_backup`) REFERENCES `FUNCIONARIO` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FUNCIONARIO`
--

LOCK TABLES `FUNCIONARIO` WRITE;
/*!40000 ALTER TABLE `FUNCIONARIO` DISABLE KEYS */;
INSERT INTO `FUNCIONARIO` VALUES (1,'FUNCIONARIO 1',1,NULL,NULL,NULL,NULL,1),(2,'FUNCIONARIO 2',1,NULL,NULL,NULL,NULL,1),(3,'FUNCIONARIO 3',2,NULL,NULL,NULL,NULL,1),(4,'FUNCIONARIO 4',1,NULL,NULL,NULL,NULL,1),(5,'FUNCIONARIO 5',4,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `FUNCIONARIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCTO`
--

DROP TABLE IF EXISTS `PRODUCTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `PRODUCTO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `valor_dolares` decimal(10,2) DEFAULT NULL,
  `disponible` tinyint(1) DEFAULT NULL,
  `fk_id_certificado` int(11) DEFAULT NULL,
  `fk_id_tipo_producto` int(11) DEFAULT NULL,
  `fec_creacion` datetime DEFAULT NULL,
  `fec_modificacion` datetime DEFAULT NULL,
  `usu_creacion` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CERTIFICADO_idx` (`fk_id_certificado`),
  KEY `FK_TIPO_PRODUCTO_idx` (`fk_id_tipo_producto`),
  CONSTRAINT `FK_CERTIFICADO` FOREIGN KEY (`fk_id_certificado`) REFERENCES `CERTIFICADO` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TIPO_PRODUCTO` FOREIGN KEY (`fk_id_tipo_producto`) REFERENCES `TIPO_PRODUCTO` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTO`
--

LOCK TABLES `PRODUCTO` WRITE;
/*!40000 ALTER TABLE `PRODUCTO` DISABLE KEYS */;
INSERT INTO `PRODUCTO` VALUES (1,'PRODUCTO 1',17990.00,1,3,1,NULL,NULL,NULL,NULL,1),(2,'PRODUCTO 2',15480.00,1,3,2,NULL,NULL,NULL,NULL,1),(3,'PRODUCTO 3',3547.99,1,1,3,NULL,NULL,NULL,NULL,1),(4,'PRODUCTO 4',9870.50,1,2,1,NULL,NULL,NULL,NULL,1),(5,'PRODUCTO 5',1487.99,1,3,2,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `PRODUCTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_PRODUCTO`
--

DROP TABLE IF EXISTS `TIPO_PRODUCTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `TIPO_PRODUCTO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `preferente` tinyint(1) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_PRODUCTO`
--

LOCK TABLES `TIPO_PRODUCTO` WRITE;
/*!40000 ALTER TABLE `TIPO_PRODUCTO` DISABLE KEYS */;
INSERT INTO `TIPO_PRODUCTO` VALUES (1,'tipo producto 1',1,1),(2,'tipo producto 2',0,1),(3,'tipo producto 3',0,1);
/*!40000 ALTER TABLE `TIPO_PRODUCTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TURNO`
--

DROP TABLE IF EXISTS `TURNO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `TURNO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_cliente` int(11) DEFAULT NULL,
  `fk_id_funcionario` int(11) DEFAULT NULL,
  `preferente` tinyint(1) DEFAULT NULL,
  `codigo` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `atendido` tinyint(1) DEFAULT NULL,
  `fec_ingreso` datetime DEFAULT NULL,
  `fec_atendido` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CLIENTE_idx` (`fk_id_cliente`),
  KEY `FK_FUNCIONARIO_idx` (`fk_id_funcionario`),
  CONSTRAINT `FK_CLIENTE` FOREIGN KEY (`fk_id_cliente`) REFERENCES `CLIENTE` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_FUNCIONARIO` FOREIGN KEY (`fk_id_funcionario`) REFERENCES `FUNCIONARIO` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TURNO`
--

LOCK TABLES `TURNO` WRITE;
/*!40000 ALTER TABLE `TURNO` DISABLE KEYS */;
INSERT INTO `TURNO` VALUES (1,3,NULL,1,'2',0,'2019-07-05 17:25:24',NULL),(2,5,NULL,0,'4',0,'2019-07-05 18:58:41',NULL);
/*!40000 ALTER TABLE `TURNO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-05 20:25:10
