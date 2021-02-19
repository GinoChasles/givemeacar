-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema givemeacar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema givemeacar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `givemeacar` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `givemeacar` ;

-- -----------------------------------------------------
-- Table `givemeacar`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`country` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(42) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`city` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(68) NOT NULL,
  `zipcode` VARCHAR(5) NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_city_country_idx` (`country_id` ASC) VISIBLE,
  CONSTRAint `fk_city_country`
    FOREIGN KEY (`country_id`)
    REFERENCES `givemeacar`.`country` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`street_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`street_type` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`street_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`street`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`street` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`street` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `street_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_street_street_type1_idx` (`street_type_id` ASC) VISIBLE,
  CONSTRAint `fk_street_street_type1`
    FOREIGN KEY (`street_type_id`)
    REFERENCES `givemeacar`.`street_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`street_suffix`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`street_suffix` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`street_suffix` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`address` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NULL DEFAULT NULL,
  `localities` VARCHAR(64) NULL DEFAULT NULL,
  `street_suffix_id` int NOT NULL,
  `street_id` int NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_street_suffix1_idx` (`street_suffix_id` ASC) VISIBLE,
  INDEX `fk_address_street1_idx` (`street_id` ASC) VISIBLE,
  INDEX `fk_address_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAint `fk_address_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `givemeacar`.`city` (`id`),
  CONSTRAint `fk_address_street1`
    FOREIGN KEY (`street_id`)
    REFERENCES `givemeacar`.`street` (`id`),
  CONSTRAint `fk_address_street_suffix1`
    FOREIGN KEY (`street_suffix_id`)
    REFERENCES `givemeacar`.`street_suffix` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`user_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`user_status` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`user_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`administrator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`administrator` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`administrator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(32) NOT NULL,
  `lastName` VARCHAR(32) NOT NULL,
  `mail` VARCHAR(64) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(12) NOT NULL,
  `user_status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE,
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  INDEX `fk_administrator_user_status1_idx` (`user_status_id` ASC) VISIBLE,
  CONSTRAint `fk_administrator_user_status1`
    FOREIGN KEY (`user_status_id`)
    REFERENCES `givemeacar`.`user_status` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`credit_card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`credit_card` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`credit_card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(16) NOT NULL,
  `expirationMonth` int NOT NULL,
  `expirationYear` int NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `society` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`client` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `lastName` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `mail` VARCHAR(64) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(64) CHARACTER SET 'utf8' NOT NULL,
  `phone` VARCHAR(12) CHARACTER SET 'utf8' NOT NULL,
  `address_id` int NOT NULL,
  `agency_id` int NOT NULL,
  `user_status_id` int NOT NULL,
  `credit_card_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  INDEX `fk_client_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_client_agency1_idx` (`agency_id` ASC) VISIBLE,
  INDEX `fk_client_user_status1_idx` (`user_status_id` ASC) VISIBLE,
  INDEX `fk_client_credit_card1_idx` (`credit_card_id` ASC) VISIBLE,
  CONSTRAint `fk_client_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `givemeacar`.`address` (`id`),
  CONSTRAint `fk_client_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `givemeacar`.`agency` (`id`),
  CONSTRAint `fk_client_credit_card1`
    FOREIGN KEY (`credit_card_id`)
    REFERENCES `givemeacar`.`credit_card` (`id`),
  CONSTRAint `fk_client_user_status1`
    FOREIGN KEY (`user_status_id`)
    REFERENCES `givemeacar`.`user_status` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`manager` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `lastName` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `mail` VARCHAR(64) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(64) CHARACTER SET 'utf8' NOT NULL,
  `phone` VARCHAR(12) CHARACTER SET 'utf8' NOT NULL,
  `agency_id` int NOT NULL,
  `user_status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  INDEX `fk_manager_agency1_idx` (`agency_id` ASC) VISIBLE,
  INDEX `fk_manager_user_status1_idx` (`user_status_id` ASC) VISIBLE,
  CONSTRAint `fk_manager_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `givemeacar`.`agency` (`id`),
  CONSTRAint `fk_manager_user_status1`
    FOREIGN KEY (`user_status_id`)
    REFERENCES `givemeacar`.`user_status` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`agency`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`agency` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`agency` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `address_id` int NOT NULL,
  `manager_id` int NOT NULL,
  `client_id` int NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_agency_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_agency_manager1_idx` (`manager_id` ASC) VISIBLE,
  INDEX `fk_agency_client1_idx` (`client_id` ASC) VISIBLE,
  CONSTRAint `fk_agency_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `givemeacar`.`address` (`id`),
  CONSTRAint `fk_agency_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `givemeacar`.`client` (`id`),
  CONSTRAint `fk_agency_manager1`
    FOREIGN KEY (`manager_id`)
    REFERENCES `givemeacar`.`manager` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`color`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`color` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`color` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`geolocation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`geolocation` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`geolocation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `latitude` DOUBLE NOT NULL,
  `longitude` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`brand` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`model`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`model` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`model` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `brand_id` int NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_model_brand1_idx` (`brand_id` ASC) VISIBLE,
  CONSTRAint `fk_model_brand1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `givemeacar`.`brand` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`energy_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`energy_type` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`energy_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`energy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`energy` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`energy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `max` TINYint NOT NULL,
  `current` TINYint NOT NULL,
  `energy_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_energy_energy_type1_idx` (`energy_type_id` ASC) VISIBLE,
  CONSTRAint `fk_energy_energy_type1`
    FOREIGN KEY (`energy_type_id`)
    REFERENCES `givemeacar`.`energy_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`car`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`car` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kilometers` int NOT NULL,
  `price` DOUBLE NOT NULL,
  `year` int NOT NULL,
  `availability` TINYint UNSIGNED NOT NULL,
  `onRent` TINYint UNSIGNED NOT NULL,
  `color_id1` int NOT NULL,
  `geolocation_id1` int NOT NULL,
  `model_id` int NOT NULL,
  `energy_id` int NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_car_color1_idx1` (`color_id1` ASC) VISIBLE,
  INDEX `fk_car_geolocation1_idx1` (`geolocation_id1` ASC) VISIBLE,
  INDEX `fk_car_model1_idx` (`model_id` ASC) VISIBLE,
  INDEX `fk_car_energy1_idx` (`energy_id` ASC) VISIBLE,
  CONSTRAint `fk_car_color1`
    FOREIGN KEY (`color_id1`)
    REFERENCES `givemeacar`.`color` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAint `fk_car_geolocation1`
    FOREIGN KEY (`geolocation_id1`)
    REFERENCES `givemeacar`.`geolocation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAint `fk_car_model1`
    FOREIGN KEY (`model_id`)
    REFERENCES `givemeacar`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAint `fk_car_energy1`
    FOREIGN KEY (`energy_id`)
    REFERENCES `givemeacar`.`energy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`rent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`rent` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`rent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start` DATETIME NOT NULL,
  `end` DATETIME NULL DEFAULT NULL,
  `car_id` int NOT NULL,
  `client_id` int NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rent_car1_idx` (`car_id` ASC) VISIBLE,
  INDEX `fk_rent_client1_idx` (`client_id` ASC) VISIBLE,
  CONSTRAint `fk_rent_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `givemeacar`.`car` (`id`),
  CONSTRAint `fk_rent_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `givemeacar`.`client` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`bill` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NOT NULL,
  `date` DATE NOT NULL,
  `agency_id` int NOT NULL,
  `rent_id` int NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bill_agency1_idx` (`agency_id` ASC) VISIBLE,
  INDEX `fk_bill_rent1_idx` (`rent_id` ASC) VISIBLE,
  CONSTRAint `fk_bill_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `givemeacar`.`agency` (`id`),
  CONSTRAint `fk_bill_rent1`
    FOREIGN KEY (`rent_id`)
    REFERENCES `givemeacar`.`rent` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`street_has_city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`street_has_city` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`street_has_city` (
  `street_id` int NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`street_id`, `city_id`),
  INDEX `fk_street_has_city_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_street_has_city_street1_idx` (`street_id` ASC) VISIBLE,
  CONSTRAint `fk_street_has_city_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `givemeacar`.`city` (`id`),
  CONSTRAint `fk_street_has_city_street1`
    FOREIGN KEY (`street_id`)
    REFERENCES `givemeacar`.`street` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
