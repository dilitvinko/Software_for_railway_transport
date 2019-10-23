-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema software_for_railway_transport
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema software_for_railway_transport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `software_for_railway_transport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`mytable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`mytable` (
  `IDPHONEBOOK` INT(11) NOT NULL AUTO_INCREMENT,
  `LASTNAME` VARCHAR(50) NULL DEFAULT NULL,
  `PHONE` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`IDPHONEBOOK`))
ENGINE = InnoDB
AUTO_INCREMENT = 88
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `software_for_railway_transport` ;

-- -----------------------------------------------------
-- Table `software_for_railway_transport`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software_for_railway_transport`.`route` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `software_for_railway_transport`.`train`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software_for_railway_transport`.`train` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `id_route` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `train_route_id__fk` (`id_route` ASC) VISIBLE,
  CONSTRAINT `train_route_id__fk`
    FOREIGN KEY (`id_route`)
    REFERENCES `software_for_railway_transport`.`route` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `software_for_railway_transport`.`carriage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software_for_railway_transport`.`carriage` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NOT NULL,
  `type` VARCHAR(255) NOT NULL,
  `id_train` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `carriage_train_id__fk` (`id_train` ASC) VISIBLE,
  CONSTRAINT `carriage_train_id__fk`
    FOREIGN KEY (`id_train`)
    REFERENCES `software_for_railway_transport`.`train` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `software_for_railway_transport`.`city_time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software_for_railway_transport`.`city_time` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(255) NOT NULL,
  `timeDate` TIMESTAMP NOT NULL,
  `id_route` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cityTime_route_id__fk` (`id_route` ASC) VISIBLE,
  CONSTRAINT `cityTime_route_id__fk`
    FOREIGN KEY (`id_route`)
    REFERENCES `software_for_railway_transport`.`route` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `software_for_railway_transport`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software_for_railway_transport`.`person` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `experience` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `software_for_railway_transport`.`person_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software_for_railway_transport`.`person_role` (
  `id_person` BIGINT(20) NOT NULL,
  `role` VARCHAR(255) NOT NULL,
  INDEX `person_role_id__fk` (`id_person` ASC) VISIBLE,
  CONSTRAINT `person_role_id__fk`
    FOREIGN KEY (`id_person`)
    REFERENCES `software_for_railway_transport`.`person` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `software_for_railway_transport`.`seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software_for_railway_transport`.`seat` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NOT NULL,
  `isFree` TINYINT(1) NOT NULL,
  `id_carriage` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `seat_carriage_id_fk` (`id_carriage` ASC) VISIBLE,
  CONSTRAINT `seat_carriage_id_fk`
    FOREIGN KEY (`id_carriage`)
    REFERENCES `software_for_railway_transport`.`carriage` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `software_for_railway_transport`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `software_for_railway_transport`.`ticket` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `id_seat` BIGINT(20) NOT NULL,
  `id_carriage` BIGINT(20) NOT NULL,
  `id_route` BIGINT(20) NOT NULL,
  `id_out_city_time` BIGINT(20) NOT NULL,
  `id_in_city_time` BIGINT(20) NOT NULL,
  `id_person` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `ticket_carriage_id_fk` (`id_carriage` ASC) VISIBLE,
  INDEX `ticket_city_time_in_id__fk` (`id_in_city_time` ASC) VISIBLE,
  INDEX `ticket_city_time_out_id__fk` (`id_out_city_time` ASC) VISIBLE,
  INDEX `ticket_route_id__fk` (`id_route` ASC) VISIBLE,
  INDEX `ticket_seat_id__fk` (`id_seat` ASC) VISIBLE,
  INDEX `ticket_person_id__fk` (`id_person` ASC) VISIBLE,
  CONSTRAINT `ticket_carriage_id_fk`
    FOREIGN KEY (`id_carriage`)
    REFERENCES `software_for_railway_transport`.`carriage` (`id`),
  CONSTRAINT `ticket_city_time_in_id__fk`
    FOREIGN KEY (`id_in_city_time`)
    REFERENCES `software_for_railway_transport`.`city_time` (`id`),
  CONSTRAINT `ticket_city_time_out_id__fk`
    FOREIGN KEY (`id_out_city_time`)
    REFERENCES `software_for_railway_transport`.`city_time` (`id`),
  CONSTRAINT `ticket_person_id__fk`
    FOREIGN KEY (`id_person`)
    REFERENCES `software_for_railway_transport`.`person` (`id`),
  CONSTRAINT `ticket_route_id__fk`
    FOREIGN KEY (`id_route`)
    REFERENCES `software_for_railway_transport`.`route` (`id`),
  CONSTRAINT `ticket_seat_id__fk`
    FOREIGN KEY (`id_seat`)
    REFERENCES `software_for_railway_transport`.`seat` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
