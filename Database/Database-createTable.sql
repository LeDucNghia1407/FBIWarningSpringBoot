-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema basicorder1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema basicorder1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `basicorder1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `basicorder1` ;

-- -----------------------------------------------------
-- Table `basicorder1`.`drug supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`drug supplier` (
  `Drug Supplier ID` VARCHAR(10) NOT NULL,
  `Name` VARCHAR(20) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Drug Supplier ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`drug store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`drug store` (
  `Drug Store ID` VARCHAR(10) NOT NULL,
  `Drug Supplier ID` VARCHAR(10) NOT NULL,
  `Name` VARCHAR(20) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Drug Store ID`),
  INDEX `fk_Drug Store_Drug Supplier1_idx` (`Drug Supplier ID` ASC) VISIBLE,
  CONSTRAINT `fk_Drug Store_Drug Supplier1`
    FOREIGN KEY (`Drug Supplier ID`)
    REFERENCES `basicorder1`.`drug supplier` (`Drug Supplier ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`Manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`Manager` (
  `Manager ID` VARCHAR(45) NOT NULL,
  `Drug Store ID` VARCHAR(10) NOT NULL,
  INDEX `fk_table1_drug store1_idx` (`Drug Store ID` ASC) VISIBLE,
  PRIMARY KEY (`Manager ID`),
  CONSTRAINT `fk_table1_drug store1`
    FOREIGN KEY (`Drug Store ID`)
    REFERENCES `basicorder1`.`drug store` (`Drug Store ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `basicorder1`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`employee` (
  `Employee ID` VARCHAR(10) NOT NULL,
  `Drug Store ID` VARCHAR(10) NOT NULL,
  `Manager ID` VARCHAR(45) NULL,
  `Name` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(20) NOT NULL,
  `Permission` INT NOT NULL,
  `Salary` INT NOT NULL,
  PRIMARY KEY (`Employee ID`),
  INDEX `fk_Employee_Drug Store1_idx` (`Drug Store ID` ASC) VISIBLE,
  INDEX `fk_employee_Manager1_idx` (`Manager ID` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Drug Store1`
    FOREIGN KEY (`Drug Store ID`)
    REFERENCES `basicorder1`.`drug store` (`Drug Store ID`),
  CONSTRAINT `fk_employee_Manager1`
    FOREIGN KEY (`Manager ID`)
    REFERENCES `basicorder1`.`Manager` (`Manager ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`client` (
  `Client ID` VARCHAR(10) NOT NULL,
  `Employee ID` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Client ID`),
  INDEX `fk_Client_Employee1_idx` (`Employee ID` ASC) VISIBLE,
  CONSTRAINT `fk_Client_Employee1`
    FOREIGN KEY (`Employee ID`)
    REFERENCES `basicorder1`.`employee` (`Employee ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`drug`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`drug` (
  `Drug ID` VARCHAR(10) NOT NULL,
  `Drug Supplier ID` VARCHAR(10) NOT NULL,
  `Drug Name` VARCHAR(20) NOT NULL,
  `Manufacturing Date` VARCHAR(25) NOT NULL,
  `Expired Date` VARCHAR(25) NOT NULL,
  `Type` VARCHAR(20) NOT NULL,
  `Price (USD)` INT NOT NULL,
  PRIMARY KEY (`Drug ID`),
  INDEX `fk_Drug_Drug Supplier1_idx` (`Drug Supplier ID` ASC) VISIBLE,
  CONSTRAINT `fk_Drug_Drug Supplier1`
    FOREIGN KEY (`Drug Supplier ID`)
    REFERENCES `basicorder1`.`drug supplier` (`Drug Supplier ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`login` (
  `Login ID` VARCHAR(10) NOT NULL,
  `Employee ID` VARCHAR(10) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Login ID`),
  INDEX `fk_Login_employee1_idx` (`Employee ID` ASC) VISIBLE,
  CONSTRAINT `fk_Login_employee1`
    FOREIGN KEY (`Employee ID`)
    REFERENCES `basicorder1`.`employee` (`Employee ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`order` (
  `Order ID` VARCHAR(10) NOT NULL,
  `Client ID` VARCHAR(10) NOT NULL,
  `Drug ID` VARCHAR(10) NOT NULL,
  `Time` VARCHAR(25) NOT NULL,
  `Drug Quantity` INT NOT NULL,
  PRIMARY KEY (`Order ID`),
  INDEX `fk_Client_has_Drug_Drug1_idx` (`Drug ID` ASC) VISIBLE,
  INDEX `fk_Client_has_Drug_Client1_idx` (`Client ID` ASC) VISIBLE,
  CONSTRAINT `fk_Client_has_Drug_Client1`
    FOREIGN KEY (`Client ID`)
    REFERENCES `basicorder1`.`client` (`Client ID`),
  CONSTRAINT `fk_Client_has_Drug_Drug1`
    FOREIGN KEY (`Drug ID`)
    REFERENCES `basicorder1`.`drug` (`Drug ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`store` (
  `Store ID` VARCHAR(10) NOT NULL,
  `Drug ID` VARCHAR(10) NOT NULL,
  `Drug Store ID` VARCHAR(10) NOT NULL,
  `Store Time` VARCHAR(45) NOT NULL,
  `Quantity` INT NOT NULL,
  PRIMARY KEY (`Store ID`),
  INDEX `fk_Store_drug store1_idx` (`Drug Store ID` ASC) VISIBLE,
  INDEX `fk_Store_drug1_idx` (`Drug ID` ASC) VISIBLE,
  CONSTRAINT `fk_Store_drug store1`
    FOREIGN KEY (`Drug Store ID`)
    REFERENCES `basicorder1`.`drug store` (`Drug Store ID`),
  CONSTRAINT `fk_Store_drug1`
    FOREIGN KEY (`Drug ID`)
    REFERENCES `basicorder1`.`drug` (`Drug ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
