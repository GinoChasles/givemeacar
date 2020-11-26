-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: givemeacar2
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
/*!40000 ALTER TABLE `agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Abricot'),(2,'Acajou'),(3,'Aigue-marine'),(4,'Alezan'),(5,'Amande'),(6,'Amarante'),(7,'Ambre'),(8,'Améthyste'),(9,'Anthracite'),(10,'Aquilain'),(11,'Argent'),(12,'Aubergine'),(13,'Auburn'),(14,'Aurore'),(15,'Avocat'),(16,'Azur'),(17,'Baillet'),(18,'Basané'),(19,'Beurre'),(20,'Bis'),(21,'Bisque'),(22,'Bistre'),(23,'Bitume'),(24,'Blanc cassé'),(25,'Blanc lunaire'),(26,'Blé'),(27,'Bleu acier'),(28,'Bleu barbeau ou bleuet'),(29,'Bleu canard'),(30,'Bleu céleste'),(31,'Bleu charrette'),(32,'Bleu ciel'),(33,'Bleu de cobalt'),(34,'Bleu de Prusse'),(35,'Bleu électrique'),(36,'Bleu givré'),(37,'Bleu marine'),(38,'Bleu nuit'),(39,'Bleu outremer'),(40,'Bleu paon'),(41,'Bleu persan'),(42,'Bleu pétrole'),(43,'Bleu roi ou de France'),(44,'Bleu turquin'),(45,'Blond vénitien'),(46,'Blond'),(47,'Bouton d\'or'),(48,'Brique'),(49,'Bronze'),(50,'Brou de noix'),(51,'Caca d\'oie'),(52,'Cacao'),(53,'Cachou'),(54,'Cæruleum'),(55,'Café'),(56,'Café au lait'),(57,'Cannelle'),(58,'Capucine'),(59,'Caramel'),(60,'Carmin'),(61,'Carotte'),(62,'Chamois'),(63,'Chartreuse'),(64,'Châtain'),(65,'Chaudron'),(66,'Chocolat'),(67,'Cinabre'),(68,'Citrouille'),(69,'Coquille d\'œuf'),(70,'Corail'),(71,'Cramoisi'),(72,'Cuisse de nymphe'),(73,'Cuivre'),(74,'Cyan'),(75,'Écarlate'),(76,'Écru'),(77,'Émeraude'),(78,'Fauve'),(79,'Flave'),(80,'Fraise'),(81,'Fraise écrasée'),(82,'Framboise'),(83,'Fuchsia'),(84,'Fumée'),(85,'Garance'),(86,'Glauque'),(87,'Glycine'),(88,'Grège'),(89,'Grenadine'),(90,'Grenat'),(91,'Gris acier'),(92,'Gris de Payne'),(93,'Gris fer'),(94,'Gris perle'),(95,'Gris souris'),(96,'Groseille'),(97,'Gueules'),(98,'Héliotrope'),(99,'Incarnat'),(100,'Indigo'),(101,'Indigo'),(102,'Isabelle'),(103,'Jaune canari'),(104,'Jaune citron'),(105,'Jaune d\'or'),(106,'Jaune de cobalt'),(107,'Jaune de Mars'),(108,'Jaune de Naples'),(109,'Jaune impérial'),(110,'Jaune mimosa'),(111,'Lapis-lazuli'),(112,'Lavallière'),(113,'Lavande'),(114,'Lie de vin'),(115,'Lilas'),(116,'Lime ou vert citron'),(117,'Lin'),(118,'Magenta'),(119,'Maïs'),(120,'Malachite'),(121,'Mandarine'),(122,'Marron'),(123,'Mastic'),(124,'Mauve'),(125,'Menthe'),(126,'Moutarde'),(127,'Nacarat'),(128,'Nankin'),(129,'Noisette'),(130,'Ocre jaune'),(131,'Ocre rouge'),(132,'Olive'),(133,'Or'),(134,'Orange brûlé'),(135,'Orchidée'),(136,'Orpiment'),(137,'Paille'),(138,'Parme'),(139,'Pelure d\'oignon'),(140,'Pervenche'),(141,'Pistache'),(142,'Poil de chameau'),(143,'Ponceau ou Coquelicot'),(144,'Pourpre'),(145,'Prasin'),(146,'Prune'),(147,'Puce'),(148,'Rose Mountbatten'),(149,'Rouge anglais'),(150,'Rouge cardinal'),(151,'Rouge cerise'),(152,'Rouge d\'Andrinople'),(153,'Rouge de Falun'),(154,'Rouge feu'),(155,'Rouge indien'),(156,'Rouge sang'),(157,'Rouge tomette'),(158,'Rouille'),(159,'Roux'),(160,'Rubis'),(161,'Sable'),(162,'Sable'),(163,'Safre'),(164,'Sang de bœuf'),(165,'Sanguine'),(166,'Saphir'),(167,'Sarcelle'),(168,'Saumon'),(169,'Sépia'),(170,'Sinople'),(171,'Smalt'),(172,'Soufre'),(173,'Tabac'),(174,'Taupe'),(175,'Terre d\'ombre'),(176,'Tomate'),(177,'Topaze'),(178,'Tourterelle ou Colombin'),(179,'Turquoise'),(180,'Vanille'),(181,'Vermeil'),(182,'Vermillon'),(183,'Vert bouteille'),(184,'Vert céladon'),(185,'Vert d\'eau'),(186,'Vert de chrome'),(187,'Vert-de-gris'),(188,'Vert de Hooker'),(189,'Vert de vessie'),(190,'Vert émeraude ou Smaragdin'),(191,'Vert épinard'),(192,'Vert impérial'),(193,'Vert lichen'),(194,'Vert olive'),(195,'Vert perroquet'),(196,'Vert poireau'),(197,'Vert pomme'),(198,'Vert prairie'),(199,'Vert printemps'),(200,'Vert sapin'),(201,'Vert sauge'),(202,'Vert tilleul'),(203,'Vert Véronèse'),(204,'Violet'),(205,'Violet d\'évêque'),(206,'Viride'),(207,'Zinzolin');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Afghanistan'),(201,'Afrique du Sud'),(2,'Albanie'),(4,'Algérie'),(84,'Allemagne'),(6,'Andorre'),(7,'Angola'),(186,'Anguilla'),(3,'Antarctique'),(8,'Antigua-et-Barbuda'),(151,'Antilles Néerlandaises'),(192,'Arabie Saoudite'),(10,'Argentine'),(16,'Arménie'),(152,'Aruba'),(11,'Australie'),(12,'Autriche'),(9,'Azerbaïdjan'),(13,'Bahamas'),(14,'Bahreïn'),(15,'Bangladesh'),(17,'Barbade'),(34,'Bélarus'),(18,'Belgique'),(26,'Belize'),(59,'Bénin'),(19,'Bermudes'),(20,'Bhoutan'),(21,'Bolivie'),(22,'Bosnie-Herzégovine'),(23,'Botswana'),(25,'Brésil'),(30,'Brunéi Darussalam'),(31,'Bulgarie'),(233,'Burkina Faso'),(33,'Burundi'),(35,'Cambodge'),(36,'Cameroun'),(37,'Canada'),(38,'Cap-vert'),(43,'Chili'),(44,'Chine'),(57,'Chypre'),(48,'Colombie'),(49,'Comores'),(54,'Costa Rica'),(110,'Côte d\'Ivoire'),(55,'Croatie'),(56,'Cuba'),(60,'Danemark'),(79,'Djibouti'),(61,'Dominique'),(227,'Égypte'),(64,'El Salvador'),(218,'Émirats Arabes Unis'),(63,'Équateur'),(67,'Érythrée'),(203,'Espagne'),(68,'Estonie'),(164,'États Fédérés de Micronésie'),(231,'États-Unis'),(66,'Éthiopie'),(182,'Fédération de Russie'),(72,'Fidji'),(73,'Finlande'),(75,'France'),(80,'Gabon'),(82,'Gambie'),(81,'Géorgie'),(71,'Géorgie du Sud et les Îles Sandwich du Sud'),(85,'Ghana'),(86,'Gibraltar'),(88,'Grèce'),(90,'Grenade'),(89,'Groenland'),(91,'Guadeloupe'),(92,'Guam'),(93,'Guatemala'),(94,'Guinée'),(65,'Guinée Équatoriale'),(176,'Guinée-Bissau'),(95,'Guyana'),(76,'Guyane Française'),(96,'Haïti'),(99,'Honduras'),(100,'Hong-Kong'),(101,'Hongrie'),(24,'Île Bouvet'),(46,'Île Christmas'),(229,'Île de Man'),(160,'Île Norfolk'),(70,'Îles (malvinas) Falkland'),(74,'Îles Åland'),(39,'Îles Caïmanes'),(47,'Îles Cocos (Keeling)'),(53,'Îles Cook'),(69,'Îles Féroé'),(97,'Îles Heard et Mcdonald'),(162,'Îles Mariannes du Nord'),(165,'Îles Marshall'),(163,'Îles Mineures Éloignées des États-Unis'),(28,'Îles Salomon'),(222,'Îles Turks et Caïques'),(29,'Îles Vierges Britanniques'),(232,'Îles Vierges des États-Unis'),(103,'Inde'),(104,'Indonésie'),(106,'Iraq'),(107,'Irlande'),(102,'Islande'),(108,'Israël'),(109,'Italie'),(125,'Jamahiriya Arabe Libyenne'),(111,'Jamaïque'),(112,'Japon'),(114,'Jordanie'),(113,'Kazakhstan'),(115,'Kenya'),(119,'Kirghizistan'),(87,'Kiribati'),(118,'Koweït'),(226,'L\'ex-République Yougoslave de Macédoine'),(122,'Lesotho'),(123,'Lettonie'),(121,'Liban'),(124,'Libéria'),(126,'Liechtenstein'),(127,'Lituanie'),(128,'Luxembourg'),(129,'Macao'),(130,'Madagascar'),(132,'Malaisie'),(131,'Malawi'),(133,'Maldives'),(134,'Mali'),(135,'Malte'),(144,'Maroc'),(136,'Martinique'),(138,'Maurice'),(137,'Mauritanie'),(50,'Mayotte'),(139,'Mexique'),(140,'Monaco'),(141,'Mongolie'),(143,'Montserrat'),(145,'Mozambique'),(32,'Myanmar'),(147,'Namibie'),(148,'Nauru'),(149,'Népal'),(156,'Nicaragua'),(157,'Niger'),(158,'Nigéria'),(159,'Niué'),(161,'Norvège'),(153,'Nouvelle-Calédonie'),(155,'Nouvelle-Zélande'),(146,'Oman'),(224,'Ouganda'),(235,'Ouzbékistan'),(167,'Pakistan'),(166,'Palaos'),(168,'Panama'),(169,'Papouasie-Nouvelle-Guinée'),(170,'Paraguay'),(150,'Pays-Bas'),(171,'Pérou'),(172,'Philippines'),(173,'Pitcairn'),(174,'Pologne'),(77,'Polynésie Française'),(178,'Porto Rico'),(175,'Portugal'),(179,'Qatar'),(211,'République Arabe Syrienne'),(40,'République Centrafricaine'),(117,'République de Corée'),(142,'République de Moldova'),(52,'République Démocratique du Congo'),(120,'République Démocratique Populaire Lao'),(62,'République Dominicaine'),(51,'République du Congo'),(105,'République Islamique d\'Iran'),(116,'République Populaire Démocratique de Corée'),(58,'République Tchèque'),(230,'République-Unie de Tanzanie'),(180,'Réunion'),(181,'Roumanie'),(228,'Royaume-Uni'),(183,'Rwanda'),(204,'Sahara Occidental'),(185,'Saint-Kitts-et-Nevis'),(190,'Saint-Marin'),(188,'Saint-Pierre-et-Miquelon'),(98,'Saint-Siège (état de la Cité du Vatican)'),(189,'Saint-Vincent-et-les Grenadines'),(184,'Sainte-Hélène'),(187,'Sainte-Lucie'),(238,'Samoa'),(5,'Samoa Américaines'),(191,'Sao Tomé-et-Principe'),(193,'Sénégal'),(240,'Serbie-et-Monténégro'),(194,'Seychelles'),(195,'Sierra Leone'),(196,'Singapour'),(197,'Slovaquie'),(199,'Slovénie'),(200,'Somalie'),(205,'Soudan'),(41,'Sri Lanka'),(209,'Suède'),(210,'Suisse'),(206,'Suriname'),(207,'Svalbard etÎle Jan Mayen'),(208,'Swaziland'),(212,'Tadjikistan'),(45,'Taïwan'),(42,'Tchad'),(78,'Terres Australes Françaises'),(27,'Territoire Britannique de l\'Océan Indien'),(83,'Territoire Palestinien Occupé'),(213,'Thaïlande'),(177,'Timor-Leste'),(214,'Togo'),(215,'Tokelau'),(216,'Tonga'),(217,'Trinité-et-Tobago'),(219,'Tunisie'),(221,'Turkménistan'),(220,'Turquie'),(223,'Tuvalu'),(225,'Ukraine'),(234,'Uruguay'),(154,'Vanuatu'),(236,'Venezuela'),(198,'Viet Nam'),(237,'Wallis et Futuna'),(239,'Yémen'),(202,'Zimbabwe');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `credit_card`
--

LOCK TABLES `credit_card` WRITE;
/*!40000 ALTER TABLE `credit_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `energy`
--

LOCK TABLES `energy` WRITE;
/*!40000 ALTER TABLE `energy` DISABLE KEYS */;
/*!40000 ALTER TABLE `energy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `energy_type`
--

LOCK TABLES `energy_type` WRITE;
/*!40000 ALTER TABLE `energy_type` DISABLE KEYS */;
INSERT INTO `energy_type` VALUES (1,'Sans Plomb 95'),(2,'Sans Plomb 98'),(3,'Sans Plomb 95-E10'),(4,'Diesel');
/*!40000 ALTER TABLE `energy_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `geolocation`
--

LOCK TABLES `geolocation` WRITE;
/*!40000 ALTER TABLE `geolocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `geolocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'vivien','le duc','ldvv@gmail.com','hrgdergdrg','gtrtgergerg');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `street_suffix`
--

LOCK TABLES `street_suffix` WRITE;
/*!40000 ALTER TABLE `street_suffix` DISABLE KEYS */;
INSERT INTO `street_suffix` VALUES (1,'BIS'),(3,'QUATER'),(2,'TER');
/*!40000 ALTER TABLE `street_suffix` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `street_type`
--

LOCK TABLES `street_type` WRITE;
/*!40000 ALTER TABLE `street_type` DISABLE KEYS */;
INSERT INTO `street_type` VALUES (1,'Allée'),(2,'Anse'),(3,'Avenue'),(45,'Berge'),(4,'Boulevard'),(5,'Carrefour'),(6,'Chaussée'),(7,'Chemin'),(8,'Cité'),(9,'Clos'),(10,'Côte'),(11,'Cour'),(12,'Cours'),(47,'Cul-de-Sac'),(13,'Degré'),(14,'Descente'),(46,'Digue'),(15,'Drève'),(48,'Escalier'),(16,'Escoussière'),(17,'Esplanade'),(18,'Gaffe'),(49,'Giratoire'),(19,'Grand-route'),(20,'Impasse'),(50,'Jardin'),(21,'Liaison'),(22,'Mail'),(23,'Montée'),(51,'Parvis'),(24,'Passage'),(52,'Passerelle'),(25,'Place'),(26,'Placette'),(27,'Pont'),(28,'Promenade'),(29,'Quai'),(32,'Rampe'),(31,'Rang'),(30,'Résidence'),(33,'Rond-point'),(34,'Route'),(35,'Rue'),(36,'Ruelle'),(37,'Sente'),(38,'Sentier'),(39,'Square'),(40,'Traboule'),(41,'Traverse'),(42,'Venelle'),(43,'Villa'),(44,'Voie'),(53,'Voies sans nom de Paris');
/*!40000 ALTER TABLE `street_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-26 18:46:58
