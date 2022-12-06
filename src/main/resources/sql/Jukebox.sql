CREATE DATABASE  IF NOT EXISTS `jukebox` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jukebox`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `Playlist_number` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `song_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Playlist_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'favs','1,5,8,9'),(2,'OST','1,2,3'),(3,'Rock','6,7,8,9'),(5,'KK','10');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `serial_number` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `duration` float NOT NULL,
  `genre` varchar(45) NOT NULL,
  `artist_name` varchar(45) NOT NULL,
  `album` varchar(45) DEFAULT NULL,
  `song_path` varchar(100) NOT NULL,
  PRIMARY KEY (`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'Genshin Impact Main Theme',1.46,'game ost','Yu-Peng Chen','The Wind and the Star Traveler','src/main/resources/songs/01-Genshin-Impact-Main-Theme.wav'),(2,'Liyue',4.36,'game ost','Yu-Peng Chen','Jade Moon Upon a Sea of Clouds','src/main/resources/songs/01-Liyue.wav'),(3,'Moon in One\'s Cup',1.57,'game ost','Yu-Peng Chen','Jade Moon Upon a Sea of Clouds','src/main/resources/songs/02-Moon-in-One_s-Cup.wav'),(4,'Make it bun dem',3.33,'Reggaestep dubstep','Skrillex','Make It Bun Dem After Hours','src/main/resources/songs/skrillex-damian-jr-gong-marley-make-it-bun-dem-audio.wav'),(5,'Animals',3.12,'Big room house','Martin Garrix','Gold Skies','src/main/resources/songs/Martin_Garrix_-_Animals__Official_Video_HD_.wav'),(6,'Believer',3.22,'Pop rock','Imagine Dragons','Evolve','src/main/resources/songs/Imagine-Dragons-Believer-_Audio.wav'),(7,'Thunder',3.24,'Electropop','Imagine Dragons','Evolve','src/main/resources/songs/Imagine-Dragons-Thunder.wav'),(8,'Demons',2.55,'Electropop','Imagine Dragons','Night Visions','src/main/resources/songs/Imagine-Dragons-Demons.wav'),(9,'Bones',2.45,'Rock','Imagine Dragons','Acts 1 & 2','src/main/resources/songs/Bones.wav');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'jukebox'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-06  8:41:24
