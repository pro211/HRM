-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: hrm
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_date` date DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `amount` decimal(14,2) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_idx` (`employee_id`),
  CONSTRAINT `fk_employeea` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
INSERT INTO `achievement` VALUES (2,'2019-08-14','Đẹp zai',0,600000.00,NULL,3),(6,'2019-09-10','đi muộn',0,500000.00,NULL,8),(7,'2019-09-18','Đi muộn',0,200000.00,NULL,3),(8,'2019-10-08','...',0,-450000.00,NULL,3);
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `type` int(2) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `base_salary` decimal(14,2) DEFAULT NULL,
  `subsidies_salary` decimal(14,2) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_job_idx` (`position`),
  KEY `fk_emploee_idx` (`employee_id`),
  KEY `fk_type_idx` (`type`),
  CONSTRAINT `fk_emploee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_job` FOREIGN KEY (`position`) REFERENCES `jobtitle` (`id`),
  CONSTRAINT `fk_type` FOREIGN KEY (`type`) REFERENCES `contract_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'HD03',3,1,'2017-01-01','2018-01-01',10000000.00,500000.00,NULL,3),(2,'HD02',4,2,'2017-01-01','2018-01-01',2000000.00,1000000.00,NULL,3),(6,'HD01',6,2,'2019-08-09','2020-03-18',8000000.00,2000000.00,NULL,8);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_type`
--

DROP TABLE IF EXISTS `contract_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contract_type` (
  `id` int(2) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_type`
--

LOCK TABLES `contract_type` WRITE;
/*!40000 ALTER TABLE `contract_type` DISABLE KEYS */;
INSERT INTO `contract_type` VALUES (3,'Dịch vụ'),(6,'Học việc'),(2,'Không thời hạn'),(4,'Partime'),(1,'Thời hạn'),(5,'Thử việc');
/*!40000 ALTER TABLE `contract_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'TC','Phòng Tài Chính','',0),(2,'NG','Phòng Ngoại Giao',NULL,1),(3,'IT','Phòng Kỹ Thuật',NULL,0),(4,'TK','Phòng Thiết Kế ',NULL,1),(5,'HR','Phòng Nhân Sự','',0),(6,'KS','Phòng Khảo Sát',NULL,1),(7,'KT','Phòng Kế Toán',NULL,1),(8,'KD','Phòng Kinh Doanh',NULL,1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_name` varchar(45) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `avatar` varchar(45) DEFAULT NULL,
  `identity_number` varchar(45) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `marital_status` tinyint(1) DEFAULT NULL,
  `address_street_1` varchar(45) DEFAULT NULL,
  `address_street_2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state_province` varchar(45) DEFAULT NULL,
  `zip_postal_code` varchar(10) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `home_telephone` varchar(15) DEFAULT NULL,
  `personal_mobile` varchar(15) DEFAULT NULL,
  `work_telephone` varchar(15) DEFAULT NULL,
  `work_email` varchar(255) DEFAULT NULL,
  `personal_email` varchar(255) DEFAULT NULL,
  `emergency_contact` varchar(255) DEFAULT NULL,
  `joined_date` timestamp NULL DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`business_name`),
  KEY `fk_deparment_idx` (`department_id`),
  CONSTRAINT `fk_deparment` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin','$2a$10$SeeV7hqcxuSn6zzPsF32pOa8NM.KCWAOeyCfGy94qBVlnWz2OS3S6','Admin','employee1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,5),(3,'linhpv','$2a$10$SeeV7hqcxuSn6zzPsF32pOa8NM.KCWAOeyCfGy94qBVlnWz2OS3S6','Phạm Văn Linh','employee1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,7),(4,'maudd','$2a$10$SeeV7hqcxuSn6zzPsF32pOa8NM.KCWAOeyCfGy94qBVlnWz2OS3S6','Đỗ Duy Mậu','employee1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,1),(5,'duongdk','$2a$10$SeeV7hqcxuSn6zzPsF32pOa8NM.KCWAOeyCfGy94qBVlnWz2OS3S6','Đinh Khánh Dương','employee1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,4),(8,'hadv','$2a$10$SeeV7hqcxuSn6zzPsF32pOa8NM.KCWAOeyCfGy94qBVlnWz2OS3S6','Đỗ Hoàng Việt Hà','employee1.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,4);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobtitle`
--

DROP TABLE IF EXISTS `jobtitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `jobtitle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_department_idx` (`department_id`),
  CONSTRAINT `fk_department` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobtitle`
--

LOCK TABLES `jobtitle` WRITE;
/*!40000 ALTER TABLE `jobtitle` DISABLE KEYS */;
INSERT INTO `jobtitle` VALUES (1,'NV','Nhân Viên',NULL,1),(2,'GD','Giám Đốc',NULL,1),(3,'BV','Bảo Vệ',NULL,1);
/*!40000 ALTER TABLE `jobtitle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_status`
--

DROP TABLE IF EXISTS `leave_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `leave_status` (
  `id` int(2) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_status`
--

LOCK TABLES `leave_status` WRITE;
/*!40000 ALTER TABLE `leave_status` DISABLE KEYS */;
INSERT INTO `leave_status` VALUES (4,'Chờ xác nhận'),(3,'Đã lên kế hoạch'),(5,'Đã nghỉ'),(2,'Hủy bỏ'),(1,'Từ chối');
/*!40000 ALTER TABLE `leave_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaves`
--

DROP TABLE IF EXISTS `leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_date` timestamp NULL DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `status_id` int(2) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_idx` (`employee_id`),
  KEY `fk_status_idx` (`status_id`),
  CONSTRAINT `fk_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_status` FOREIGN KEY (`status_id`) REFERENCES `leave_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaves`
--

LOCK TABLES `leaves` WRITE;
/*!40000 ALTER TABLE `leaves` DISABLE KEYS */;
INSERT INTO `leaves` VALUES (1,'2019-07-31 17:00:00','2019-09-02','2019-12-01','ốm',1,8),(4,'2019-08-13 17:00:00','2019-08-02','2019-08-20','mmmm',5,8);
/*!40000 ALTER TABLE `leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `social_security` decimal(14,2) DEFAULT NULL,
  `health_insurance` decimal(14,2) DEFAULT NULL,
  `personal_income_tax` decimal(14,2) DEFAULT NULL,
  `achievement` decimal(14,2) DEFAULT NULL,
  `commission` decimal(14,2) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `basic_day_work` int(2) DEFAULT NULL,
  `real_day_work` int(2) DEFAULT NULL,
  `contract_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_idx` (`contract_id`),
  KEY `fk_emp_idx` (`employee_id`),
  CONSTRAINT `fk_contract` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`),
  CONSTRAINT `fk_emp` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,20000.00,10000.00,2000.00,0.00,2000.00,7,2019,20,18,2,3),(2,2000.00,1500.00,2500.00,0.00,1000.00,8,2019,20,18,6,8),(4,20000.00,10000.00,2000.00,-450000.00,100000.00,10,2019,20,18,2,3),(8,20000.00,10000.00,2000.00,500000.00,100000.00,9,2019,20,18,6,8),(9,20000.00,10000.00,2000.00,0.00,100000.00,11,2019,20,18,1,3);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-24 13:56:20
