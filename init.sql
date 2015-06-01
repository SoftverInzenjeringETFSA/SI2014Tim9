CREATE DATABASE  IF NOT EXISTS `sahovski_klub_pijun` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_slovenian_ci */;
USE `sahovski_klub_pijun`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: sahovski_klub_pijun
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `klubovi`
--

DROP TABLE IF EXISTS `klubovi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klubovi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `sjediste` varchar(50) NOT NULL,
  `datumOsnivanja` datetime NOT NULL,
  `predsjednik` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `korisnici`
--

DROP TABLE IF EXISTS `korisnici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnici` (
  `id` int(11) NOT NULL,
  `korisnickoIme` varchar(50) NOT NULL,
  `sifra` varchar(128) NOT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `korisnickoIme_UNIQUE` (`korisnickoIme`),
  KEY `id_idx` (`id`),
  CONSTRAINT `ido1` FOREIGN KEY (`id`) REFERENCES `osobe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mecevi`
--

DROP TABLE IF EXISTS `mecevi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mecevi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `turnir` int(11) NOT NULL,
  `takmicar1` int(11) NOT NULL,
  `takmicar2` int(11) NOT NULL,
  `rezultat1` double NOT NULL,
  `rezultat2` double NOT NULL,
  `datumPocetka` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idt_idx` (`turnir`),
  KEY `idt1_idx` (`takmicar1`),
  KEY `idt2_idx` (`takmicar2`),
  CONSTRAINT `idt` FOREIGN KEY (`turnir`) REFERENCES `turniri` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idt1` FOREIGN KEY (`takmicar1`) REFERENCES `takmicari` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idt2` FOREIGN KEY (`takmicar2`) REFERENCES `takmicari` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `osobe`
--

DROP TABLE IF EXISTS `osobe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osobe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `jmbg` varchar(13) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idosobe_UNIQUE` (`id`),
  UNIQUE KEY `jmbg_UNIQUE` (`jmbg`)
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `takmicari`
--

DROP TABLE IF EXISTS `takmicari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `takmicari` (
  `id` int(11) NOT NULL,
  `datumRodjenja` datetime NOT NULL,
  `brojBodova` double DEFAULT '0',
  `klub` int(11) DEFAULT NULL,
  `kategorija` varchar(25) DEFAULT NULL,
  `brojTitula` int(11) DEFAULT '0',
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idk_idx` (`klub`),
  CONSTRAINT `idk` FOREIGN KEY (`klub`) REFERENCES `klubovi` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `ido2` FOREIGN KEY (`id`) REFERENCES `osobe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `turnir_takmicar_veza`
--

DROP TABLE IF EXISTS `turnir_takmicar_veza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turnir_takmicar_veza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `turnir` int(11) NOT NULL,
  `takmicar` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idturnir_takmicar_veza_UNIQUE` (`id`),
  KEY `idtu_idx` (`turnir`),
  KEY `idta_idx` (`takmicar`),
  CONSTRAINT `idta` FOREIGN KEY (`takmicar`) REFERENCES `takmicari` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idtu` FOREIGN KEY (`turnir`) REFERENCES `turniri` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `turniri`
--

DROP TABLE IF EXISTS `turniri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turniri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `datumPocetka` datetime NOT NULL,
  `trajanje` int(11) DEFAULT '1',
  `formatTakmicenja` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `naziv_UNIQUE` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-02  0:14:14
