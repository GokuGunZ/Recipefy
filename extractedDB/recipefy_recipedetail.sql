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
-- Table structure for table `recipedetail`
--

DROP TABLE IF EXISTS `recipedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipedetail` (
  `RecipeDetailID` int NOT NULL AUTO_INCREMENT,
  `RecipeID` int DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Description` text,
  `lImagePath` varchar(255) DEFAULT NULL,
  `Ingredients` json DEFAULT NULL,
  `Instruction` json DEFAULT NULL,
  `PreparationTime` int DEFAULT NULL,
  `CookingTime` int DEFAULT NULL,
  `TotalTime` int DEFAULT NULL,
  `DifficultyLevel` varchar(15) DEFAULT NULL,
  `CuisineType` varchar(250) DEFAULT NULL,
  `NutritionalAttribute` text,
  `CaloricInfo` varchar(100) DEFAULT NULL,
  `Ratings` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`RecipeDetailID`),
  KEY `recipedetail_ibfk_1` (`RecipeID`),
  CONSTRAINT `recipedetail_ibfk_1` FOREIGN KEY (`RecipeID`) REFERENCES `recipe` (`RecipeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipedetail`
--

LOCK TABLES `recipedetail` WRITE;
/*!40000 ALTER TABLE `recipedetail` DISABLE KEYS */;
INSERT INTO `recipedetail` VALUES (2,9,'Tasty Pasta','Delicious pasta dish','/images/pasta.jpg','[{\"Qty:\": \"200\", \"Unit:\": \"g\", \"Entity:\": \"pasta\"}, {\"Qty:\": \"130\", \"Unit:\": \"g\", \"Entity:\": \"tomato sauce\"}, {\"Qty:\": \"4\", \"Unit:\": \"piece\", \"Entity:\": \"prezzemolo\"}]','[{\"Step 1:\": \"boil water\"}, {\"Step 2:\": \"put pasta\"}, {\"Step 3:\": \"cook tomato sauce\"}, {\"Step 4:\": \"mix pasta and tomato sauce\"}]',20,30,50,'2','1','1','300 calories per serving',4.50),(3,10,'Vegetarian Salad','Fresh salad recipe','/images/salad.jpg','[{\"Qty:\": \"200\", \"Unit:\": \"g\", \"Entity:\": \"tomato\"}, {\"Qty:\": \"130\", \"Unit:\": \"g\", \"Entity:\": \"avocado\"}, {\"Qty:\": \"140\", \"Unit:\": \"g\", \"Entity:\": \"olive\"}]','[{\"Step 1:\": \"mix in a bowl\"}, {\"Step 2:\": \"serve\"}]',15,0,15,'1','2','3','150 calories per serving',4.00),(6,29,'Bocconotti','Buonissimapasta',NULL,'[{\"Qty:\": \"200\", \"Unit:\": \"g\", \"Entity:\": \"pasta\"}, {\"Qty:\": \"130\", \"Unit:\": \"g\", \"Entity:\": \"tomato sauce\"}, {\"Qty:\": \"4\", \"Unit:\": \"piece\", \"Entity:\": \"prezzemolo\"}]','[{\"Step 1:\": \"boil water\"}, {\"Step 2:\": \"put pasta\"}, {\"Step 3:\": \"cook tomato sauce\"}, {\"Step 4:\": \"mix pasta and tomato sauce\"}]',1,20,NULL,'Medium','Italian Cuisine','[]','200 cal per porzione',NULL),(7,35,'Uramaki California','Uramaki is one of 5 traditional sushi rolls, or makizushi, in traditional Japanese cuisine. The meaning of its name is, literally, “inside out” roll. It could be defined as a “rebel roll” because it goes against the usual norm of wrapping the roll of rice from the outside.',NULL,'[{\"Qty:\": \"200\", \"Unit:\": \"g\", \"Entity:\": \"rice\"}, {\"Qty:\": \"130\", \"Unit:\": \"g\", \"Entity:\": \"avocado\"}, {\"Qty:\": \"140\", \"Unit:\": \"g\", \"Entity:\": \"salmon\"}]','[{\"Step 1:\": \"put the rice over plastic\"}, {\"Step 2:\": \"mix avocado and salmon over rice\"}, {\"Step 3:\": \"roll the rice\"}, {\"Step 4:\": \"cut in pieces\"}]',20,0,NULL,'Hard','Japanese Cuisine','[]','60 kcal per roll ',NULL),(11,39,'shrimp noodles','This is an Asian inspired Shrimp Garlic Noodle recipe where chewy spaghetti noodles (or any noodles really) is tossed in a garlic butter sauce with savory umami Asian inspired flavors. Juicy seared shrimp compliments it perfectly, bringing some additional flavor and texture to the dish',NULL,'[{\"Qty:\": \"200\", \"Unit:\": \"g\", \"Entity:\": \"noodles\"}, {\"Qty:\": \"130\", \"Unit:\": \"g\", \"Entity:\": \"shrimp\"}, {\"Qty:\": \"140\", \"Unit:\": \"g\", \"Entity:\": \"olive oil\"}]','[{\"Step 1:\": \"cook noodles\"}, {\"Step 2:\": \"cook shrimps\"}, {\"Step 3:\": \"mix together\"}]',10,10,NULL,'Medium','Thai Cuisine','[Dairy-Free]','230kcal per portion',NULL),(12,40,'Hamburger','Gnam',NULL,'[{\"Qty:\": \"220\", \"Unit:\": \"g\", \"Entity:\": \"hamburger\"}, {\"Qty:\": \"2\", \"Unit:\": \"pieces\", \"Entity:\": \"bread\"}, {\"Qty:\": \"70\", \"Unit:\": \"g\", \"Entity:\": \"bacon\"}]','[{\"Step 1:\": \"cook hamburger\"}, {\"Step 2:\": \"cook bacon\"}, {\"Step 3:\": \"compose hamburger\"}]',5,5,NULL,'Easy','Mediterranean Cuisine','[Vegan]','600 kcal',NULL),(13,41,'chickenbreast','chickenbreast grilled',NULL,'[{\"Qty:\": \"220\", \"Unit:\": \"g\", \"Entity:\": \"chickenbreast\"}, {\"Qty:\": \"1\", \"Unit:\": \"qb\", \"Entity:\": \"oil\"}]','[{\"Step 1:\": \"grill chickenbreast\"}, {\"Step 2:\": \"serve with oil\"}]',2,10,NULL,'Easy','Mediterranean Cuisine','[]','200kcal per piece',NULL),(14,51,'Recipe Test','This is a test',NULL,'[{\"Qty:\": \"1\", \"Unit:\": \"piece\", \"Entity:\": \"entity\"}, {\"Qty:\": \"30\", \"Unit:\": \"g\", \"Entity:\": \"entity\"}, {\"Qty:\": \"4\", \"Unit:\": \"piece\", \"Entity:\": \"dotti\"}]','[{\"Step 1:\": \"do something\"}, {\"Step 2:\": \"something else\"}, {\"Step 3:\": \"eat\"}]',5,0,NULL,'Easy','Italian Cuisine','[]','',NULL),(15,52,'Dotti','pitucci',NULL,'[{\"Qty:\": \"one\", \"Unit:\": \"piece\", \"Entity:\": \"dotti\"}, {\"Qty:\": \"two\", \"Unit:\": \"dotti\", \"Entity:\": \"pitucci\"}, {\"Qty:\": \"hey\", \"Unit:\": \"brother\", \"Entity:\": \"ther\'s an endless\"}]','[{\"Step 1:\": \"road to rediscover\"}, {\"Step 2:\": \"hey\"}, {\"Step 3:\": \"sister\"}]',1,4,NULL,'Easy','Italian Cuisine','[]','',NULL);
/*!40000 ALTER TABLE `recipedetail` ENABLE KEYS */;
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
