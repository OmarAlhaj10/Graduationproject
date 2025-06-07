CREATE DATABASE  IF NOT EXISTS `gymapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gymapp`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: gymapp
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `id_exercise` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_exercise`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Bench Press'),(2,'Squats'),(3,'Pull-ups'),(4,'Military Press'),(5,'Pushups'),(6,'Plank'),(7,'Lunges'),(8,'Abdominal'),(35,'Backflips'),(36,'Triple Backflips'),(37,'Intermediate Pull-Ups');
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_routine`
--

DROP TABLE IF EXISTS `exercise_routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_routine` (
  `id_exercise_routine` int NOT NULL AUTO_INCREMENT,
  `id_exercise` int DEFAULT NULL,
  `id_routine` int DEFAULT NULL,
  `series` int DEFAULT NULL,
  `repetitions` int DEFAULT NULL,
  `previous_weight` decimal(6,2) DEFAULT NULL,
  `current_weight` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_exercise_routine`),
  KEY `id_routine` (`id_routine`),
  KEY `id_exercise` (`id_exercise`),
  CONSTRAINT `exercise_routine_ibfk_1` FOREIGN KEY (`id_routine`) REFERENCES `routine` (`id_routine`),
  CONSTRAINT `exercise_routine_ibfk_2` FOREIGN KEY (`id_exercise`) REFERENCES `exercise` (`id_exercise`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `exercise_routine`
--

LOCK TABLES `exercise_routine` WRITE;
/*!40000 ALTER TABLE `exercise_routine` DISABLE KEYS */;
INSERT INTO `exercise_routine` VALUES (13,5,2,3,15,0.00,0.00),(14,6,2,2,30,0.00,0.00),(15,7,2,3,12,20.00,25.00),(16,8,2,4,20,0.00,0.00),(21,1,1,4,10,50.00,55.00),(22,2,1,3,12,60.00,65.00),(23,3,1,5,8,0.00,0.00),(24,4,1,15,3,15.00,15.00),(25,1,3,4,10,50.00,55.00),(26,2,3,3,12,60.00,65.00),(27,3,3,5,8,0.00,0.00),(28,4,3,5,10,40.00,45.00),(36,3,7,1,5,0.00,0.00),(37,1,7,2,5,0.00,0.00),(38,6,7,3,5,0.00,0.00),(39,8,7,4,5,0.00,0.00),(48,8,13,1,2,1.00,5.00),(49,3,13,1,3,10.00,5.00);
/*!40000 ALTER TABLE `exercise_routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stretch`
--

DROP TABLE IF EXISTS `stretch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stretch` (
  `id_stretch` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_stretch`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stretch`
--

LOCK TABLES `stretch` WRITE;
/*!40000 ALTER TABLE `stretch` DISABLE KEYS */;
INSERT INTO `stretch` VALUES (1,'Mobility','Prepare your body with mobility before exercise. Optimize your performance and reduce the risk of injury with these short exercises!','https://www.youtube.com/embed/5aAkskctYGY?si=ItJITk-HxpArosNZ'),(2,'Stretching','Post-workout stretching is essential to maintain flexibility and prevent injury. Take time to stretch your muscles to improve recovery and keep your body in tip-top condition.','https://www.youtube.com/embed/YQQfhILVR7c?si=xl2FQfWGdVEqi4l0'),(3,'Yoga', 'helps prepare your body and mind for yoga stretching training. Stretching before exercising improves flexibility and reduces the risk of injury. Try it today!','https://www.youtube.com/embed/d-xp2uOl3Gc?si=2aOEL8BBdyH6Gq77'),(4,'Flexibility','Flexibility exercises are essential to maintain range of motion in the joints, which helps prevent injuries, improves posture and promotes blood circulation, thus contributing to the overall health and well-being of the body.','https://www.youtube.com/embed/y87vSUoIMGU?si=UpQ2ax13ONpWs5Eo');
/*!40000 ALTER TABLE `stretch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measure`
--

DROP TABLE IF EXISTS `measure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `measure` (
  `id_measure` int NOT NULL AUTO_INCREMENT,
  `weight` decimal(10,2) DEFAULT NULL,
  `fat` decimal(5,2) DEFAULT NULL,
  `neck` decimal(10,2) DEFAULT NULL,
  `shoulders` decimal(10,2) DEFAULT NULL,
  `left_bicep` decimal(10,2) DEFAULT NULL,
  `right_bicep` decimal(10,2) DEFAULT NULL,
  `waist` decimal(10,2) DEFAULT NULL,
  `hip` decimal(10,2) DEFAULT NULL,
  `left_thigh` decimal(10,2) DEFAULT NULL,
  `right_thigh` decimal(10,2) DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_measure`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `measure_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measure`
--

LOCK TABLES `measure` WRITE;
/*!40000 ALTER TABLE `measure` DISABLE KEYS */;
/*!40000 ALTER TABLE `measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_role`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `role_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_USER',2),(3,'ROLE_USER',3),(8,'ROLE_USER',NULL),(11,'ROLE_USER',10);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routine`
--

DROP TABLE IF EXISTS `routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routine` (
  `id_routine` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_routine`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `routine_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine`
--

LOCK TABLES `routine` WRITE;
/*!40000 ALTER TABLE `routine` DISABLE KEYS */;
INSERT INTO `routine` VALUES (1,'Fiorella routine',2),(2,'Daniel Routine',3),(3,'Fiorella routine 2',2),(7,'TEST EXERCISE',3),(13,'TEST 3',2);
/*!40000 ALTER TABLE `routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routine`
--

DROP TABLE IF EXISTS `routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routine` (
  `id_routine` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_routine`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `routine_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine`
--

LOCK TABLES `routine` WRITE;
/*!40000 ALTER TABLE `routine` DISABLE KEYS */;
INSERT INTO `routine` VALUES (1,'Fiorella routine',2),(2,'Daniel Routine',3),(3,'Fiorella routine 2',2),(7,'TEST EXERCISE',3),(13,'TEST 3',2);
/*!40000 ALTER TABLE `routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(512) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','admin','admin','admin@admin.com','Male'),(2,'fiorella','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Fiorella','Hernández','fiorella@user.com','Female'),(3,'daniel','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Daniel','Vega','daniel@user.com','Masculino'),(10,'juan28','$2a$10$pTEt8gVButPICF2CCacKUe7v8HUK6MrqWX4E/l8eTIBLHpEm0ZrPO','Juan','Vargas','juan@gmail.com','Masculino');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping events for database 'gymapp'
--

--
-- Dumping routines for database 'gymapp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-20 18:20:24
