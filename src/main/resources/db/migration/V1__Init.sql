-- -----------------------------------------------------
-- Table `epdb`.`RESOURCE_FILE
-- -----------------------------------------------------
DROP TABLE IF EXISTS `epdb`.`RESOURCE_FILE` ;

CREATE  TABLE IF NOT EXISTS `epdb`.`RESOURCE_FILE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NOT NULL ,
  `IMAGE` MEDIUMBLOB NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;