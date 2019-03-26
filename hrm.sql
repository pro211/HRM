CREATE DATABASE  IF NOT EXISTS `hrm` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `hrm`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hrm
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `branch` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` (`id`, `code`, `name`, `note`, `active`) VALUES (1,'HO','Hanoi Office',NULL,1);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `certificate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `issued_by` varchar(50) NOT NULL,
  `issued_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_certificate_employee_idx` (`employee_id`),
  CONSTRAINT `fk_certificate_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`, `code`, `name`, `note`, `active`) VALUES (1,'1','IT',NULL,1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependent`
--

DROP TABLE IF EXISTS `dependent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `dependent` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `relationship` varchar(20) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dependent_employee_idx` (`employee_id`),
  CONSTRAINT `fk_dependent_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependent`
--

LOCK TABLES `dependent` WRITE;
/*!40000 ALTER TABLE `dependent` DISABLE KEYS */;
/*!40000 ALTER TABLE `dependent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `education` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `level` varchar(100) NOT NULL,
  `name` varchar(45) NOT NULL,
  `major` varchar(45) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `score` decimal(3,1) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_education_employee_idx` (`employee_id`),
  CONSTRAINT `fk_education_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergency_contact`
--

DROP TABLE IF EXISTS `emergency_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `emergency_contact` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `relationship` varchar(20) NOT NULL,
  `home_telephone` varchar(15) DEFAULT NULL,
  `personal_mobile` varchar(15) DEFAULT NULL,
  `work_telephone` varchar(15) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_emergency_employee_idx` (`employee_id`),
  CONSTRAINT `fk_emergency_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emergency_contact`
--

LOCK TABLES `emergency_contact` WRITE;
/*!40000 ALTER TABLE `emergency_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `emergency_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `name` varchar(50) NOT NULL,
  `identity_number` varchar(20) DEFAULT NULL,
  `gender` tinyint(1) NOT NULL,
  `nationality` varchar(30) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `marital_status` varchar(10) DEFAULT NULL,
  `address_street_1` varchar(100) DEFAULT NULL,
  `address_street_2` varchar(100) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state_province` varchar(30) DEFAULT NULL,
  `zip_postal_code` varchar(10) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `home_telephone` varchar(15) DEFAULT NULL,
  `personal_mobile` varchar(15) DEFAULT NULL,
  `work_telephone` varchar(15) DEFAULT NULL,
  `work_email` varchar(255) DEFAULT NULL,
  `personal_email` varchar(255) DEFAULT NULL,
  `joined_date` date NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `department_id` int(10) unsigned NOT NULL,
  `branch_id` int(10) unsigned NOT NULL,
  `manager_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_department_idx` (`department_id`),
  KEY `fk_branch_idx` (`branch_id`),
  CONSTRAINT `fk_employee_branch` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  CONSTRAINT `fk_employee_department` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `code`, `password`, `name`, `identity_number`, `gender`, `nationality`, `date_of_birth`, `marital_status`, `address_street_1`, `address_street_2`, `city`, `state_province`, `zip_postal_code`, `country`, `home_telephone`, `personal_mobile`, `work_telephone`, `work_email`, `personal_email`, `joined_date`, `admin`, `active`, `department_id`, `branch_id`, `manager_id`) VALUES (1,'admin','$2a$10$eppHiHCXnlJysrgYlSIW3uH6i0Qv19rRnEnwofgFdLNr3ITMae63y','admin',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-01-01',1,1,1,1,1),(2,'employee','$2a$10$eppHiHCXnlJysrgYlSIW3uH6i0Qv19rRnEnwofgFdLNr3ITMae63y','employee',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-01-01',1,1,1,1,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employment_contract`
--

DROP TABLE IF EXISTS `employment_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `employment_contract` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `position` varchar(50) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `salary` decimal(14,2) NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_employee_idx` (`employee_id`),
  CONSTRAINT `fk_contract_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employment_contract`
--

LOCK TABLES `employment_contract` WRITE;
/*!40000 ALTER TABLE `employment_contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `employment_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `immigration`
--

DROP TABLE IF EXISTS `immigration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `immigration` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL,
  `number` varchar(20) NOT NULL,
  `issued_by` varchar(50) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_immigration_employee_idx` (`employee_id`),
  CONSTRAINT `fk_immigration_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immigration`
--

LOCK TABLES `immigration` WRITE;
/*!40000 ALTER TABLE `immigration` DISABLE KEYS */;
/*!40000 ALTER TABLE `immigration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `language` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `language` varchar(30) NOT NULL,
  `competency` varchar(20) NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_language_employee_idx` (`employee_id`),
  CONSTRAINT `fk_language_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave`
--

DROP TABLE IF EXISTS `leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `leave` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `apply_date` datetime NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `status` varchar(15) NOT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_idx` (`employee_id`),
  CONSTRAINT `fk_leave_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave`
--

LOCK TABLES `leave` WRITE;
/*!40000 ALTER TABLE `leave` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `apply_date` varchar(45) NOT NULL,
  `reason` varchar(45) NOT NULL,
  `type` tinyint(1) NOT NULL,
  `amount` decimal(14,2) unsigned NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_idx` (`employee_id`),
  CONSTRAINT `fk_record_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `salary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `work_day` tinyint(2) unsigned NOT NULL,
  `salary` decimal(14,2) unsigned NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `allowance` decimal(14,2) DEFAULT NULL,
  `bonus` decimal(14,2) DEFAULT NULL,
  `deduction` decimal(14,2) DEFAULT NULL,
  `tax` decimal(14,2) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salary_employee_id_idx` (`employee_id`),
  CONSTRAINT `fk_salary_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_experience`
--

DROP TABLE IF EXISTS `work_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `work_experience` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(100) NOT NULL,
  `job_title` varchar(50) NOT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_work_employee_idx` (`employee_id`),
  CONSTRAINT `fk_work_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_experience`
--

LOCK TABLES `work_experience` WRITE;
/*!40000 ALTER TABLE `work_experience` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_experience` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-27  2:08:11
