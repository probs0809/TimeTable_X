-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: TimeTable
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `Slots`
--

DROP TABLE IF EXISTS `Slots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Slots` (
  `SlotId` int(11) NOT NULL,
  `GrpId` int(11) DEFAULT NULL,
  `SubId` varchar(45) DEFAULT NULL,
  `TeacherId` int(11) DEFAULT NULL,
  PRIMARY KEY (`SlotId`),
  UNIQUE KEY `SlotId_UNIQUE` (`SlotId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Slots`
--

LOCK TABLES `Slots` WRITE;
/*!40000 ALTER TABLE `Slots` DISABLE KEYS */;
INSERT INTO `Slots` VALUES (0,11,'CAP-632',18),(1,11,'CAP-632',18),(2,11,'CAP-632',18),(3,11,'CAP-632',18),(4,11,'CAP-927',19),(5,11,'CAP-927',19),(6,11,'CAP-658',20),(7,11,'CAP-658',20),(8,11,'CAP-658',20),(9,11,'CAP-658',20),(10,11,'CAP-615',15),(11,11,'CAP-615',15),(12,11,'CAP-615',15),(13,11,'CAP-437',17),(14,11,'CAP-437',17),(15,11,'CAP-437',17),(16,11,'FR-0000',-1),(17,11,'FR-0000',-1),(18,11,'FR-0000',-1),(19,11,'FR-0000',-1),(20,11,'FR-0000',-1),(21,11,'FR-0000',-1),(22,11,'FR-0000',-1),(23,11,'FR-0000',-1),(24,11,'FR-0000',-1),(25,11,'FR-0000',-1),(26,11,'FR-0000',-1),(27,11,'FR-0000',-1),(28,11,'FR-0000',-1),(29,11,'FR-0000',-1),(30,11,'FR-0000',-1),(31,11,'FR-0000',-1),(32,11,'FR-0000',-1),(33,11,'FR-0000',-1),(34,11,'FR-0000',-1),(35,13,'CAP-632',18),(36,13,'CAP-632',18),(37,13,'CAP-632',18),(38,13,'CAP-632',18),(39,13,'CAP-927',19),(40,13,'CAP-927',19),(41,13,'CAP-658',20),(42,13,'CAP-658',20),(43,13,'CAP-658',20),(44,13,'CAP-658',20),(45,13,'CAP-615',15),(46,13,'CAP-615',15),(47,13,'CAP-615',15),(48,13,'CAP-437',17),(49,13,'CAP-437',17),(50,13,'CAP-437',17),(51,13,'FR-0000',-1),(52,13,'FR-0000',-1),(53,13,'FR-0000',-1),(54,13,'FR-0000',-1),(55,13,'FR-0000',-1),(56,13,'FR-0000',-1),(57,13,'FR-0000',-1),(58,13,'FR-0000',-1),(59,13,'FR-0000',-1),(60,13,'FR-0000',-1),(61,13,'FR-0000',-1),(62,13,'FR-0000',-1),(63,13,'FR-0000',-1),(64,13,'FR-0000',-1),(65,13,'FR-0000',-1),(66,13,'FR-0000',-1),(67,13,'FR-0000',-1),(68,13,'FR-0000',-1),(69,13,'FR-0000',-1),(70,14,'CAP-632',18),(71,14,'CAP-632',18),(72,14,'CAP-632',18),(73,14,'CAP-632',18),(74,14,'CAP-927',19),(75,14,'CAP-927',19),(76,14,'CAP-658',20),(77,14,'CAP-658',20),(78,14,'CAP-658',20),(79,14,'CAP-658',20),(80,14,'CAP-615',15),(81,14,'CAP-615',15),(82,14,'CAP-615',15),(83,14,'CAP-437',17),(84,14,'CAP-437',17),(85,14,'CAP-437',17),(86,14,'FR-0000',-1),(87,14,'FR-0000',-1),(88,14,'FR-0000',-1),(89,14,'FR-0000',-1),(90,14,'FR-0000',-1),(91,14,'FR-0000',-1),(92,14,'FR-0000',-1),(93,14,'FR-0000',-1),(94,14,'FR-0000',-1),(95,14,'FR-0000',-1),(96,14,'FR-0000',-1),(97,14,'FR-0000',-1),(98,14,'FR-0000',-1),(99,14,'FR-0000',-1),(100,14,'FR-0000',-1),(101,14,'FR-0000',-1),(102,14,'FR-0000',-1),(103,14,'FR-0000',-1),(104,14,'FR-0000',-1);
/*!40000 ALTER TABLE `Slots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StudentGroup`
--

DROP TABLE IF EXISTS `StudentGroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `StudentGroup` (
  `GrpId` int(11) NOT NULL AUTO_INCREMENT,
  `GrpName` varchar(100) DEFAULT NULL,
  `NoOfSub` int(11) DEFAULT NULL,
  PRIMARY KEY (`GrpId`),
  UNIQUE KEY `GrpName` (`GrpName`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StudentGroup`
--

LOCK TABLES `StudentGroup` WRITE;
/*!40000 ALTER TABLE `StudentGroup` DISABLE KEYS */;
INSERT INTO `StudentGroup` VALUES (11,'MCA',5),(13,'MCA(Hons)',5),(14,'MCA[Lateral]',5);
/*!40000 ALTER TABLE `StudentGroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubHrs`
--

DROP TABLE IF EXISTS `SubHrs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubHrs` (
  `GrpId` int(11) NOT NULL,
  `SubId` varchar(45) DEFAULT NULL,
  `Hours` int(11) DEFAULT NULL,
  `TeacherId` int(11) DEFAULT NULL,
  KEY `SubId_idx` (`SubId`),
  KEY `GrpId_idx` (`GrpId`),
  KEY `TeacherId_idx` (`TeacherId`),
  CONSTRAINT `GrpId` FOREIGN KEY (`GrpId`) REFERENCES `studentgroup` (`GrpId`) ON DELETE CASCADE,
  CONSTRAINT `SubId` FOREIGN KEY (`SubId`) REFERENCES `subject` (`SubId`) ON DELETE CASCADE,
  CONSTRAINT `TeacherId` FOREIGN KEY (`TeacherId`) REFERENCES `teacher` (`TeacherId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubHrs`
--

LOCK TABLES `SubHrs` WRITE;
/*!40000 ALTER TABLE `SubHrs` DISABLE KEYS */;
INSERT INTO `SubHrs` VALUES (11,'CAP-632',4,18),(14,'CAP-632',4,18),(13,'CAP-632',4,18),(11,'CAP-927',2,19),(14,'CAP-927',2,19),(13,'CAP-927',2,19),(11,'CAP-658',4,20),(14,'CAP-658',4,20),(13,'CAP-658',4,20),(11,'CAP-615',3,15),(14,'CAP-615',3,15),(13,'CAP-615',3,15),(11,'CAP-437',3,17),(14,'CAP-437',3,17),(13,'CAP-437',3,17);
/*!40000 ALTER TABLE `SubHrs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subject`
--

DROP TABLE IF EXISTS `Subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subject` (
  `SubId` varchar(45) NOT NULL,
  `SubName` varchar(45) NOT NULL,
  PRIMARY KEY (`SubId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subject`
--

LOCK TABLES `Subject` WRITE;
/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES ('CAP-437','Software Engineering'),('CAP-615','JAVA'),('CAP-632','TOC'),('CAP-658','System Software'),('CAP-927','Statistics'),('FR-0000','Free');
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Teacher` (
  `TeacherId` int(11) NOT NULL AUTO_INCREMENT,
  `TeacherName` varchar(100) NOT NULL,
  `assign` int(11) DEFAULT NULL,
  PRIMARY KEY (`TeacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES (-1,'NO_ALLOCATION',NULL),(15,'Prabodh Mayekar',3),(17,'Amit Kumar',3),(18,'Abisek',3),(19,'Bittu',3),(20,'Rohit Verma',3);
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TeacherSubject`
--

DROP TABLE IF EXISTS `TeacherSubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TeacherSubject` (
  `TeacherId` int(11) NOT NULL,
  `SubId` varchar(45) DEFAULT NULL,
  KEY `TeacherIdts_idx` (`TeacherId`),
  KEY `SubIdts_idx` (`SubId`),
  CONSTRAINT `SubIdts` FOREIGN KEY (`SubId`) REFERENCES `subject` (`SubId`) ON DELETE CASCADE,
  CONSTRAINT `TeacherIdts` FOREIGN KEY (`TeacherId`) REFERENCES `teacher` (`TeacherId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TeacherSubject`
--

LOCK TABLES `TeacherSubject` WRITE;
/*!40000 ALTER TABLE `TeacherSubject` DISABLE KEYS */;
INSERT INTO `TeacherSubject` VALUES (15,'CAP-615'),(17,'CAP-437'),(18,'CAP-632'),(19,'CAP-927'),(20,'CAP-658');
/*!40000 ALTER TABLE `TeacherSubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TimeTable`
--

DROP TABLE IF EXISTS `TimeTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TimeTable` (
  `Day` varchar(45) DEFAULT NULL,
  `Hour` varchar(45) DEFAULT NULL,
  `SubId` varchar(45) DEFAULT NULL,
  `GrpId` int(11) DEFAULT NULL,
  `TeacherId` int(11) DEFAULT NULL,
  KEY `SubId_idx` (`SubId`),
  KEY `GroupIdtt_idx` (`GrpId`),
  KEY `TeacherIdtt_idx` (`TeacherId`),
  CONSTRAINT `GroupIdtt` FOREIGN KEY (`GrpId`) REFERENCES `studentgroup` (`GrpId`) ON DELETE CASCADE,
  CONSTRAINT `SubIdtt` FOREIGN KEY (`SubId`) REFERENCES `subject` (`SubId`) ON DELETE CASCADE,
  CONSTRAINT `TeacherIdtt` FOREIGN KEY (`TeacherId`) REFERENCES `teacher` (`TeacherId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TimeTable`
--

LOCK TABLES `TimeTable` WRITE;
/*!40000 ALTER TABLE `TimeTable` DISABLE KEYS */;
INSERT INTO `TimeTable` VALUES ('Monday','09:00 AM','FR-0000',13,-1),('Monday','10:00 AM','FR-0000',13,-1),('Monday','11:00 AM','CAP-615',13,15),('Monday','12:00 PM','FR-0000',13,-1),('Monday','01:00 PM','FR-0000',13,-1),('Monday','02:00 PM','CAP-632',13,18),('Monday','03:00 PM','FR-0000',13,-1),('Tuesday','09:00 AM','CAP-632',13,18),('Tuesday','10:00 AM','CAP-658',13,20),('Tuesday','11:00 AM','FR-0000',13,-1),('Tuesday','12:00 PM','FR-0000',13,-1),('Tuesday','01:00 PM','CAP-632',13,18),('Tuesday','02:00 PM','CAP-615',13,15),('Tuesday','03:00 PM','FR-0000',13,-1),('Wenesday','09:00 AM','FR-0000',13,-1),('Wenesday','10:00 AM','CAP-615',13,15),('Wenesday','11:00 AM','CAP-927',13,19),('Wenesday','12:00 PM','FR-0000',13,-1),('Wenesday','01:00 PM','FR-0000',13,-1),('Wenesday','02:00 PM','FR-0000',13,-1),('Wenesday','03:00 PM','FR-0000',13,-1),('Thursday','09:00 AM','CAP-632',13,18),('Thursday','10:00 AM','CAP-437',13,17),('Thursday','11:00 AM','FR-0000',13,-1),('Thursday','12:00 PM','FR-0000',13,-1),('Thursday','01:00 PM','CAP-437',13,17),('Thursday','02:00 PM','CAP-927',13,19),('Thursday','03:00 PM','CAP-658',13,20),('Friday','09:00 AM','FR-0000',13,-1),('Friday','10:00 AM','FR-0000',13,-1),('Friday','11:00 AM','CAP-658',13,20),('Friday','12:00 PM','FR-0000',13,-1),('Friday','01:00 PM','FR-0000',13,-1),('Friday','02:00 PM','CAP-658',13,20),('Friday','03:00 PM','CAP-437',13,17);
/*!40000 ALTER TABLE `TimeTable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-04 16:06:06
