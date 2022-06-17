-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pizzeria
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Viktor','Skachkov','dragonslayer','mahata','viktor.skachkov01@gmail.com','Pieter Breughelstraat 19','94387758434785','CLIENT'),(2,'Pavel','Dimitrov','bomber','Jackal','pavel.dimitrov01@gmail.com','Pieter Breughelstraat 19','43554373753745','CLIENT'),(3,'Todor','Petrov','kalipso','manhattan','todor.petrov@gmail.com','Pieter Breughelstraat 19','65789809087645','CLIENT'),(4,'Martin','Yordanov','lampofthegenie','Waaargh','martin.yordanov@gmail.com','Pieter Breughelstraat 19','67893424545636','CLIENT'),(5,'Radostin','Martinov','qyburn','uhata','radostin.martinov@gmail.com','Pieter Breughelstraat 19','87964356567645','CLIENT'),(6,'Wat','Tambor','StarWars','starcraft','Wat.Tambor@gmail.com','Pieter Breughelstraat 19','11143565784554','CLIENT'),(7,'Sarah','Kerrigan','queenOfBlades','zergQueen','sarah.kerrigan@gmail.com','Pieter Breughelstraat 19','23456467788656','WORKER'),(8,'John','Arryn','asoiaf','eagleSigil','john.arryn@gmail.com','Pieter Breughelstraat 19','33545768989764','WORKER'),(9,'Katrin','Jonathan','romani','TheKingBeyond','katrin.jonathan@gmail.com','Pieter Breughelstraat 19','743578967543434','WORKER'),(11,'rr','rr','rr','rr','rr','rr','rr','CLIENT'),(12,'Pavel','Jason','PavelTerminator','JasonHunter','pavel.jason@gmail.com','grthyuyjy','345667898','CLIENT'),(13,'Martin','Stoyanov','Nagash','Eternal','martin.stoyanov@gmail.com','retyuioioujytg','3245679889','CLIENT'),(22,'firstName','lastName','username','pwd','email','address','phone','CLIENT'),(23,'Kristofer','Shahud','kyras','azariah','kristofer.shahud@gmail.com','vrtyuiuyujtgvf','56876878587','CLIENT'),(25,'Oliver','Twist','tatara','aratat','oliver.twist@gmail.com','erthyjuiyuyy','45678965','CLIENT');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-16 13:27:25
