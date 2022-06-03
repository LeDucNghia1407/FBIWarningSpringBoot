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
-- Table `basicorder1`.`drugsupplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`drugsupplier` (
  `drugSupplierID` VARCHAR(10) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`drugSupplierID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`drugstore`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`drugstore` (
  `drugStoreID` VARCHAR(10) NOT NULL,
  `drugSupplierID` VARCHAR(10) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`drugStoreID`),
  INDEX `fk_Drug Store_Drug Supplier1_idx` (`drugSupplierID` ASC) VISIBLE,
  CONSTRAINT `fk_Drug Store_Drug Supplier1`
    FOREIGN KEY (`drugSupplierID`)
    REFERENCES `basicorder1`.`drugsupplier` (`drugSupplierID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`manager` (
  `managerID` VARCHAR(45) NOT NULL,
  `drugStoreID` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`managerID`),
  INDEX `fk_table1_drug store1_idx` (`drugStoreID` ASC) VISIBLE,
  CONSTRAINT `fk_table1_drug store1`
    FOREIGN KEY (`drugStoreID`)
    REFERENCES `basicorder1`.`drugstore` (`drugStoreID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`employee` (
  `employeeID` VARCHAR(10) NOT NULL,
  `drugStoreID` VARCHAR(10) NOT NULL,
  `managerBy` VARCHAR(10) NULL DEFAULT NULL,
  `name` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `permission` INT NOT NULL,
  `salary` INT NOT NULL,
  PRIMARY KEY (`employeeID`),
  INDEX `fk_Employee_Drug Store1_idx` (`drugStoreID` ASC) VISIBLE,
  INDEX `fk_employee_Manager1_idx` (`managerBy` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Drug Store1`
    FOREIGN KEY (`drugStoreID`)
    REFERENCES `basicorder1`.`drugstore` (`drugStoreID`),
  CONSTRAINT `fk_employee_Manager1`
    FOREIGN KEY (`managerBy`)
    REFERENCES `basicorder1`.`manager` (`managerID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`client` (
  `clientID` VARCHAR(10) NOT NULL,
  `employeeID` VARCHAR(10) NOT NULL,
  `id` BIGINT NOT NULL,
  PRIMARY KEY (`clientID`),
  INDEX `fk_Client_Employee1_idx` (`employeeID` ASC) VISIBLE,
  CONSTRAINT `fk_Client_Employee1`
    FOREIGN KEY (`employeeID`)
    REFERENCES `basicorder1`.`employee` (`employeeID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`drug`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`drug` (
  `drugID` VARCHAR(10) NOT NULL,
  `drugsupplierID` VARCHAR(10) NOT NULL,
  `drugName` VARCHAR(20) NOT NULL,
  `manufacturingDate` VARCHAR(25) NOT NULL,
  `expiredDate` VARCHAR(25) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`drugID`),
  INDEX `fk_Drug_Drug Supplier1_idx` (`drugsupplierID` ASC) VISIBLE,
  CONSTRAINT `fk_Drug_Drug Supplier1`
    FOREIGN KEY (`drugsupplierID`)
    REFERENCES `basicorder1`.`drugsupplier` (`drugSupplierID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`login` (
  `loginID` VARCHAR(10) NOT NULL,
  `employeeID` VARCHAR(10) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`loginID`),
  INDEX `fk_Login_employee1_idx` (`employeeID` ASC) VISIBLE,
  CONSTRAINT `fk_Login_employee1`
    FOREIGN KEY (`employeeID`)
    REFERENCES `basicorder1`.`employee` (`employeeID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`order` (
  `orderID` VARCHAR(10) NOT NULL,
  `clientID` VARCHAR(10) NOT NULL,
  `drugID` VARCHAR(10) NOT NULL,
  `time` DATE NOT NULL,
  `drugQuantity` INT NOT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `fk_Client_has_Drug_Drug1_idx` (`drugID` ASC) VISIBLE,
  INDEX `fk_Client_has_Drug_Client1_idx` (`clientID` ASC) VISIBLE,
  CONSTRAINT `fk_Client_has_Drug_Client1`
    FOREIGN KEY (`clientID`)
    REFERENCES `basicorder1`.`client` (`clientID`),
  CONSTRAINT `fk_Client_has_Drug_Drug1`
    FOREIGN KEY (`drugID`)
    REFERENCES `basicorder1`.`drug` (`drugID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basicorder1`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basicorder1`.`store` (
  `storeID` VARCHAR(10) NOT NULL,
  `drugID` VARCHAR(10) NOT NULL,
  `drugStoreID` VARCHAR(10) NOT NULL,
  `storeTime` DATE NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`storeID`),
  INDEX `fk_Store_drug store1_idx` (`drugStoreID` ASC) VISIBLE,
  INDEX `fk_Store_drug1_idx` (`drugID` ASC) VISIBLE,
  CONSTRAINT `fk_Store_drug store1`
    FOREIGN KEY (`drugStoreID`)
    REFERENCES `basicorder1`.`drugstore` (`drugStoreID`),
  CONSTRAINT `fk_Store_drug1`
    FOREIGN KEY (`drugID`)
    REFERENCES `basicorder1`.`drug` (`drugID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
