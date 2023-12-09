-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: recipefy
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `RecipeID` int NOT NULL AUTO_INCREMENT,
  `UserID` int DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `RecipeDetailID` int DEFAULT NULL,
  `OriginalRecipeID` int DEFAULT NULL,
  `ImagePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RecipeID`),
  KEY `UserID` (`UserID`),
  KEY `OriginalRecipeID` (`OriginalRecipeID`),
  KEY `recipe_ibfk_3` (`RecipeDetailID`),
  CONSTRAINT `recipe_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`),
  CONSTRAINT `recipe_ibfk_2` FOREIGN KEY (`OriginalRecipeID`) REFERENCES `recipe` (`RecipeID`),
  CONSTRAINT `recipe_ibfk_3` FOREIGN KEY (`RecipeDetailID`) REFERENCES `recipedetail` (`RecipeDetailID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (9,4,'Tasty Pasta',2,NULL,'/images/pasta_thumb.jpg'),(10,5,'Vegetarian Salad',3,NULL,'/images/pasta_thumb.jpg'),(29,0,'Bocconotti',6,NULL,'/images/pasta_thumb.jpg'),(35,0,'Uramaki California',7,NULL,'/images/Ura-California-600x400.jpg'),(39,0,'shrimp noodles',7,NULL,'/images/shrimp-noodles.jpg'),(40,0,'Hamburger',7,NULL,'/images/hamburgher-mediterraneo.jpg'),(41,0,'chickenbreast',13,NULL,'/images/600x400-SFD-chickenbreast.jpg'),(51,0,'Recipe Test',14,NULL,'/images/placeholder.jpg'),(52,0,'Dotti',15,NULL,'/images/placeholder.jpg');
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-09 14:52:11
