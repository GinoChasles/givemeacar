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
DROP SCHEMA IF EXISTS `givemeacar` ;

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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(42) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`region` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_region_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_region_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `givemeacar`.`country` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`department` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `code` VARCHAR(45) NULL DEFAULT NULL,
  `region_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_department_region1_idx` (`region_id` ASC) VISIBLE,
  CONSTRAINT `fk_department_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `givemeacar`.`region` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`city` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(68) NOT NULL,
  `zipcode` VARCHAR(5) NOT NULL,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_city_department1_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `givemeacar`.`department` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`street_name`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`street_name` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`street_name` (
  `id` INT NOT NULL,
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `city_id` INT NOT NULL,
  `street_name_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_street_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_street_street_name1_idx` (`street_name_id` ASC) VISIBLE,
  CONSTRAINT `fk_street_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `givemeacar`.`city` (`id`),
  CONSTRAINT `fk_street_street_name1`
    FOREIGN KEY (`street_name_id`)
    REFERENCES `givemeacar`.`street_name` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`street_suffix`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`street_suffix` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`street_suffix` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(12) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`address` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NULL DEFAULT NULL,
  `street_id` INT NOT NULL,
  `street_suffix_id` INT NOT NULL,
  `longitude` DECIMAL(10,8) NOT NULL,
  `lattitude` DECIMAL(11,8) NOT NULL,
  `street_suffix_id1` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_street1_idx` (`street_id` ASC) VISIBLE,
  INDEX `fk_address_street_suffix1_idx` (`street_suffix_id1` ASC) VISIBLE,
  CONSTRAINT `fk_address_street1`
    FOREIGN KEY (`street_id`)
    REFERENCES `givemeacar`.`street` (`id`),
  CONSTRAINT `fk_address_street_suffix1`
    FOREIGN KEY (`street_suffix_id1`)
    REFERENCES `givemeacar`.`street_suffix` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`user_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`user_status` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`user_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(32) NOT NULL,
  `last_name` VARCHAR(32) NOT NULL,
  `mail` VARCHAR(64) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(12) NOT NULL,
  `user_status_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE,
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  INDEX `fk_administrator_user_status1_idx` (`user_status_id` ASC) VISIBLE,
  CONSTRAINT `fk_administrator_user_status1`
    FOREIGN KEY (`user_status_id`)
    REFERENCES `givemeacar`.`user_status` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`color`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`color` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`color` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`energy_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`energy_type` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`energy_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`brand` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `brand_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_model_brand1_idx` (`brand_id` ASC) VISIBLE,
  CONSTRAINT `fk_model_brand1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `givemeacar`.`brand` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`car`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`car` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kilometers` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  `year` INT NOT NULL,
  `available` INT NOT NULL,
  `rented` INT NOT NULL,
  `model_id` INT NOT NULL,
  `energy_id` INT NOT NULL,
  `color_id` INT NOT NULL,
  `energy_max` DOUBLE NOT NULL,
  `energy_current` DOUBLE NOT NULL,
  `energy_type_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_car_model1_idx` (`model_id` ASC) VISIBLE,
  INDEX `fk_car_color1_idx` (`color_id` ASC) VISIBLE,
  INDEX `fk_car_energy_type1_idx` (`energy_type_id` ASC) VISIBLE,
  INDEX `fk_car_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_car_color1`
    FOREIGN KEY (`color_id`)
    REFERENCES `givemeacar`.`color` (`id`),
  CONSTRAINT `fk_car_energy_type1`
    FOREIGN KEY (`energy_type_id`)
    REFERENCES `givemeacar`.`energy_type` (`id`),
  CONSTRAINT `fk_car_model1`
    FOREIGN KEY (`model_id`)
    REFERENCES `givemeacar`.`model` (`id`),
  CONSTRAINT `fk_car_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `givemeacar`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`credit_card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`credit_card` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`credit_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(16) NOT NULL,
  `expiration_month` INT NOT NULL,
  `expiration_year` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `last_name` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `mail` VARCHAR(64) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(64) CHARACTER SET 'utf8' NOT NULL,
  `phone` VARCHAR(12) CHARACTER SET 'utf8' NOT NULL,
  `address_id` INT NOT NULL,
  `user_status_id` INT NOT NULL,
  `bill_id` INT NOT NULL,
  `credit_card_id` INT NOT NULL,
  `agency_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  INDEX `fk_client_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_client_user_status1_idx` (`user_status_id` ASC) VISIBLE,
  INDEX `fk_client_bill1_idx` (`bill_id` ASC) VISIBLE,
  INDEX `fk_client_credit_card1_idx` (`credit_card_id` ASC) VISIBLE,
  INDEX `fk_client_agency1_idx` (`agency_id` ASC) VISIBLE,
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE,
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  CONSTRAINT `fk_client_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `givemeacar`.`address` (`id`),
  CONSTRAINT `fk_client_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `givemeacar`.`agency` (`id`),
  CONSTRAINT `fk_client_bill1`
    FOREIGN KEY (`bill_id`)
    REFERENCES `givemeacar`.`bill` (`id`),
  CONSTRAINT `fk_client_credit_card1`
    FOREIGN KEY (`credit_card_id`)
    REFERENCES `givemeacar`.`credit_card` (`id`),
  CONSTRAINT `fk_client_user_status1`
    FOREIGN KEY (`user_status_id`)
    REFERENCES `givemeacar`.`user_status` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`rent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`rent` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`rent` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start` DATETIME NOT NULL,
  `end` DATETIME NULL DEFAULT NULL,
  `car_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rent_car1_idx` (`car_id` ASC) VISIBLE,
  INDEX `fk_rent_client1_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `fk_rent_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `givemeacar`.`car` (`id`),
  CONSTRAINT `fk_rent_client1`
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NOT NULL,
  `date` DATE NOT NULL,
  `rent_id` INT NOT NULL,
  `agency_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bill_rent1_idx` (`rent_id` ASC) VISIBLE,
  INDEX `fk_bill_agency1_idx` (`agency_id` ASC) VISIBLE,
  CONSTRAINT `fk_bill_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `givemeacar`.`agency` (`id`),
  CONSTRAINT `fk_bill_rent1`
    FOREIGN KEY (`rent_id`)
    REFERENCES `givemeacar`.`rent` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar`.`manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar`.`manager` ;

CREATE TABLE IF NOT EXISTS `givemeacar`.`manager` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `last_name` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `mail` VARCHAR(64) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(64) CHARACTER SET 'utf8' NOT NULL,
  `phone` VARCHAR(12) CHARACTER SET 'utf8' NOT NULL,
  `user_status_id` INT NOT NULL,
  `agency_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  INDEX `fk_manager_user_status1_idx` (`user_status_id` ASC) VISIBLE,
  INDEX `fk_manager_agency1_idx` (`agency_id` ASC) VISIBLE,
  CONSTRAINT `fk_manager_agency1`
    FOREIGN KEY (`agency_id`)
    REFERENCES `givemeacar`.`agency` (`id`),
  CONSTRAINT `fk_manager_user_status1`
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) CHARACTER SET 'utf8' NOT NULL,
  `address_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  `bill_id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_agency_address_idx` (`address_id` ASC) INVISIBLE,
  INDEX `fk_agency_client_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_agency_bill_idx` (`bill_id` ASC) INVISIBLE,
  INDEX `fk_agency_manager1_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `fk_agency_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `givemeacar`.`address` (`id`),
  CONSTRAINT `fk_agency_bill`
    FOREIGN KEY (`bill_id`)
    REFERENCES `givemeacar`.`bill` (`id`),
  CONSTRAINT `fk_agency_client`
    FOREIGN KEY (`client_id`)
    REFERENCES `givemeacar`.`client` (`id`),
  CONSTRAINT `fk_agency_manager1`
    FOREIGN KEY (`manager_id`)
    REFERENCES `givemeacar`.`manager` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
