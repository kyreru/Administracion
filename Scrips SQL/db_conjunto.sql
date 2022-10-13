-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema conjunto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema conjunto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `conjunto` DEFAULT CHARACTER SET utf8 ;
USE `conjunto` ;

-- -----------------------------------------------------
-- Table `conjunto`.`conjunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conjunto`.`conjunto` (
  `id_conjunto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_conjunto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `conjunto`.`torre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conjunto`.`torre` (
  `id_torre` INT NOT NULL AUTO_INCREMENT,
  `conjunto_id_conjunto` INT NOT NULL,
  PRIMARY KEY (`id_torre`),
  CONSTRAINT `fk_torre_conjunto1`
    FOREIGN KEY (`conjunto_id_conjunto`)
    REFERENCES `conjunto`.`conjunto` (`id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `conjunto`.`residente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conjunto`.`residente` (
  `id_residente` INT NOT NULL,
  `primer_nombre` VARCHAR(45) NOT NULL,
  `segundo_nombre` VARCHAR(45) NULL,
  `primer_apellido` VARCHAR(45) NOT NULL,
  `segundo_apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  PRIMARY KEY (`id_residente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `conjunto`.`apartamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conjunto`.`apartamento` (
  `id_apartamento` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `mensualidad` INT NOT NULL,
  `residente_id_residente` INT NOT NULL,
  `torre_conjunto_id_conjunto` INT NOT NULL,
  PRIMARY KEY (`id_apartamento`, `residente_id_residente`, `torre_conjunto_id_conjunto`),
  INDEX `fk_apartamento_residente1_idx` (`residente_id_residente` ASC) VISIBLE,
  INDEX `fk_apartamento_torre1_idx` (`torre_conjunto_id_conjunto` ASC) VISIBLE,
  CONSTRAINT `fk_apartamento_residente1`
    FOREIGN KEY (`residente_id_residente`)
    REFERENCES `conjunto`.`residente` (`id_residente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_apartamento_torre1`
    FOREIGN KEY (`torre_conjunto_id_conjunto`)
    REFERENCES `conjunto`.`torre` (`conjunto_id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `conjunto`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `conjunto`.`factura` (
  `consecutivo` INT NOT NULL AUTO_INCREMENT,
  `periodo_facturado` DATE NOT NULL,
  `fecha_generacion` DATE NOT NULL,
  `total` INT NOT NULL,
  `apartamento_id_apartamento` INT NOT NULL,
  `apartamento_residente_id_residente` INT NOT NULL,
  `apartamento_torre_conjunto_id_conjunto` INT NOT NULL,
  PRIMARY KEY (`consecutivo`, `apartamento_id_apartamento`, `apartamento_residente_id_residente`, `apartamento_torre_conjunto_id_conjunto`),
  INDEX `fk_factura_apartamento1_idx` (`apartamento_id_apartamento` ASC, `apartamento_residente_id_residente` ASC, `apartamento_torre_conjunto_id_conjunto` ASC) VISIBLE,
  CONSTRAINT `fk_factura_apartamento1`
    FOREIGN KEY (`apartamento_id_apartamento` , `apartamento_residente_id_residente` , `apartamento_torre_conjunto_id_conjunto`)
    REFERENCES `conjunto`.`apartamento` (`id_apartamento` , `residente_id_residente` , `torre_conjunto_id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
