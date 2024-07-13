-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hipermercadovic
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hipermercadovic` ;

-- -----------------------------------------------------
-- Schema hipermercadovic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hipermercadovic` DEFAULT CHARACTER SET utf8 ;
USE `hipermercadovic` ;

-- -----------------------------------------------------
-- Table `persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `persona` ;

CREATE TABLE IF NOT EXISTS `persona` (
  `id_persona` INT(11) NOT NULL AUTO_INCREMENT,
  `num_documento` VARCHAR(1000) NOT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `tiene_facebook` TINYINT NULL,
  PRIMARY KEY (`id_persona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `apellido_persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apellido_persona` ;

CREATE TABLE IF NOT EXISTS `apellido_persona` (
  `id_apellido` INT(11) NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(800) NULL DEFAULT NULL,
  `persona_id_persona` INT(11) NOT NULL,
  PRIMARY KEY (`id_apellido`),
  CONSTRAINT `fk_apellido_persona_persona1`
    FOREIGN KEY (`persona_id_persona`)
    REFERENCES `persona` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `celular_persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celular_persona` ;

CREATE TABLE IF NOT EXISTS `celular_persona` (
  `id_celular_persona` INT(11) NOT NULL AUTO_INCREMENT,
  `numero_celular_persona` VARCHAR(45) NULL DEFAULT NULL,
  `persona_id_persona` INT(11) NOT NULL,
  PRIMARY KEY (`id_celular_persona`),
  CONSTRAINT `fk_celular_persona_persona1`
    FOREIGN KEY (`persona_id_persona`)
    REFERENCES `persona` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rol_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rol_usuario` ;

CREATE TABLE IF NOT EXISTS `rol_usuario` (
  `id_rol_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `persona_id_persona` INT(11) NOT NULL,
  PRIMARY KEY (`id_rol_usuario`),
  CONSTRAINT `fk_rol_usuario_persona1`
    FOREIGN KEY (`persona_id_persona`)
    REFERENCES `persona` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usuario_empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario_empleado` ;

CREATE TABLE IF NOT EXISTS `usuario_empleado` (
  `id_usuario_empleado` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_contratacion` DATE NULL DEFAULT NULL,
  `rol_usuario_id_rol_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario_empleado`),
  CONSTRAINT `fk_usuario_empleado_rol_usuario1`
    FOREIGN KEY (`rol_usuario_id_rol_usuario`)
    REFERENCES `rol_usuario` (`id_rol_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `domicilio_entrega`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `domicilio_entrega` ;

CREATE TABLE IF NOT EXISTS `domicilio_entrega` (
  `id_direccion_persona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_calle` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  `numero_casa` INT(11) NULL DEFAULT NULL,
  `nombre_edificio` VARCHAR(100) NULL DEFAULT NULL,
  `numero_piso` INT(11) NULL DEFAULT NULL,
  `numero_departamento` INT(11) NULL DEFAULT NULL,
  `descripcion` VARCHAR(500) NULL DEFAULT NULL,
  `persona_id_persona` INT(11) NOT NULL,
  `domicilio_entrega` VARCHAR(300) NULL,
  PRIMARY KEY (`id_direccion_persona`),
  CONSTRAINT `fk_direccion_persona_persona1`
    FOREIGN KEY (`persona_id_persona`)
    REFERENCES `persona` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usuario_cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario_cliente` ;

CREATE TABLE IF NOT EXISTS `usuario_cliente` (
  `id_usuario_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `rol_usuario_id_rol_usuario` INT(11) NOT NULL,
  `domicilio_entrega_id_direccion_persona` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario_cliente`),
  CONSTRAINT `fk_usuario_cliente_rol_usuario1`
    FOREIGN KEY (`rol_usuario_id_rol_usuario`)
    REFERENCES `rol_usuario` (`id_rol_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_cliente_domicilio_entrega1`
    FOREIGN KEY (`domicilio_entrega_id_direccion_persona`)
    REFERENCES `domicilio_entrega` (`id_direccion_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `factura` ;

CREATE TABLE IF NOT EXISTS `factura` (
  `id_factura` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_factura` DATE NULL DEFAULT NULL,
  `id_usuario_cliente` INT(11) NULL DEFAULT NULL,
  `usuario_empleado_id_usuario_empleado` INT(11) NOT NULL,
  PRIMARY KEY (`id_factura`),
  CONSTRAINT `fk_factura_usuario_empleado1`
    FOREIGN KEY (`usuario_empleado_id_usuario_empleado`)
    REFERENCES `usuario_empleado` (`id_usuario_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_usuario_cliente`
    FOREIGN KEY (`id_usuario_cliente`)
    REFERENCES `usuario_cliente` (`id_usuario_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `detalle_factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `detalle_factura` ;

CREATE TABLE IF NOT EXISTS `detalle_factura` (
  `id_detalle_factura` INT(11) NOT NULL AUTO_INCREMENT,
  `id_producto` INT(11) NULL DEFAULT NULL,
  `cantidad_producto` INT(11) NULL DEFAULT NULL,
  `total_precio_productos` FLOAT NULL DEFAULT NULL,
  `id_factura` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_detalle_factura`),
  CONSTRAINT `id_factura`
    FOREIGN KEY (`id_factura`)
    REFERENCES `factura` (`id_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_producto`
	FOREIGN KEY (`id_Producto`)
	REFERENCES `producto` (`id_producto`)
	ON DELETE NO ACTION
 	ON UPDATE NO ACTION)

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `nombre_persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nombre_persona` ;

CREATE TABLE IF NOT EXISTS `nombre_persona` (
  `id_nombre` INT(11) NOT NULL AUTO_INCREMENT,
  `id_persona` INT(11) NULL DEFAULT NULL,
  `nombre` VARCHAR(1500) NULL DEFAULT NULL,
  PRIMARY KEY (`id_nombre`),
  CONSTRAINT `id_persona`
    FOREIGN KEY (`id_persona`)
    REFERENCES `persona` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tipo_documento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tipo_documento` ;

CREATE TABLE IF NOT EXISTS `tipo_documento` (
  `id_tipo_documento` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_documento` VARCHAR(500) NULL DEFAULT NULL,
  `persona_id_persona` INT(11) NOT NULL,
  PRIMARY KEY (`id_tipo_documento`),
  CONSTRAINT `fk_tipo_documento_persona1`
    FOREIGN KEY (`persona_id_persona`)
    REFERENCES `persona` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario` ;

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `contraseña_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `rol_usuario_id_rol_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `fk_usuario_rol_usuario1`
    FOREIGN KEY (`rol_usuario_id_rol_usuario`)
    REFERENCES `rol_usuario` (`id_rol_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usuario_proovedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usuario_proovedor` ;

CREATE TABLE IF NOT EXISTS `usuario_proovedor` (
  `id_ususario_proveedor` INT(11) NOT NULL AUTO_INCREMENT,
  `num_cuenta` VARCHAR(45) NULL DEFAULT NULL,
  `id_factura` INT(11) NULL DEFAULT NULL,
  `id_rol_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_ususario_proveedor`),
  CONSTRAINT `id_rol_usuario`
    FOREIGN KEY (`id_rol_usuario`)
    REFERENCES `rol_usuario` (`id_rol_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `facebook_persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facebook_persona` ;

CREATE TABLE IF NOT EXISTS `facebook_persona` (
  `id_facebook_persona` INT NOT NULL AUTO_INCREMENT,
  `id_persona` INT NOT NULL,
  `url_facebook_persona` TEXT(1000) NULL,
  `persona_id_persona` INT(11) NOT NULL,
  PRIMARY KEY (`id_facebook_persona`),
  CONSTRAINT `fk_facebook_persona_persona1`
    FOREIGN KEY (`persona_id_persona`)
    REFERENCES `persona` (`id_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `producto` ;

CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `producto_nombre` VARCHAR(45) NULL,
  `producto_descripcion` VARCHAR(1000) NULL,
  `producto_precio` DOUBLE NULL,
  `producto_cantidad_stock` INT NULL,
  `producto_marca` VARCHAR(45) NULL,
  `producto_modelo` VARCHAR(45) NULL,
  `producto_peso` DECIMAL NULL,
  `producto_fecha_fabricacion` DATE NULL,
  `detalle_factura_id_detalle_factura` INT(11)DEFAULT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- Agrego datos
-- Iniciar transacción
START TRANSACTION;

-- Insertar datos en la tabla persona
INSERT INTO persona (num_documento, fecha_nacimiento, tiene_facebook) VALUES ('123456789', '1990-01-01', 1);
INSERT INTO persona (num_documento, fecha_nacimiento, tiene_facebook) VALUES ('987654321', '1985-05-15', 0);

-- Insertar datos en la tabla apellido_persona
INSERT INTO apellido_persona (apellido, persona_id_persona) VALUES ('Gomez', 1);
INSERT INTO apellido_persona (apellido, persona_id_persona) VALUES ('Perez', 2);

-- Insertar datos en la tabla celular_persona
INSERT INTO celular_persona (numero_celular_persona, persona_id_persona) VALUES ('555-1234', 1);
INSERT INTO celular_persona (numero_celular_persona, persona_id_persona) VALUES ('555-5678', 2);

-- Insertar datos en la tabla rol_usuario
INSERT INTO rol_usuario (nombre_rol_usuario, persona_id_persona) VALUES ('Admin', 1);
INSERT INTO rol_usuario (nombre_rol_usuario, persona_id_persona) VALUES ('Cliente', 2);

-- Insertar datos en la tabla usuario_empleado
INSERT INTO usuario_empleado (fecha_contratacion, rol_usuario_id_rol_usuario) VALUES ('2020-01-01', 1);

-- Insertar datos en la tabla domicilio_entrega
INSERT INTO domicilio_entrega (nombre_calle, numero_casa, nombre_edificio, numero_piso, numero_departamento, descripcion, persona_id_persona, domicilio_entrega) VALUES ('Calle Falsa', 123, 'Edificio A', 2, 3, 'Departamento con vista al parque', 2, 'Entrega mañana');

-- Insertar datos en la tabla usuario_cliente
INSERT INTO usuario_cliente (rol_usuario_id_rol_usuario, domicilio_entrega_id_direccion_persona) VALUES (2, 1);

-- Insertar datos en la tabla factura
INSERT INTO factura (fecha_factura, id_usuario_cliente, usuario_empleado_id_usuario_empleado) VALUES ('2024-01-01', 1, 1);

-- Insertar datos en la tabla detalle_factura
INSERT INTO detalle_factura (id_producto, cantidad_producto, total_precio_productos, id_factura) VALUES (1, 2, 100.00, 1);

-- Insertar datos en la tabla nombre_persona
INSERT INTO nombre_persona (id_persona, nombre) VALUES (1, 'Juan');
INSERT INTO nombre_persona (id_persona, nombre) VALUES (2, 'Maria');

-- Insertar datos en la tabla tipo_documento
INSERT INTO tipo_documento (tipo_documento, persona_id_persona) VALUES ('DNI', 1);
INSERT INTO tipo_documento (tipo_documento, persona_id_persona) VALUES ('Pasaporte', 2);

-- Insertar datos en la tabla usuario
INSERT INTO usuario (nombre_usuario, contraseña_usuario, rol_usuario_id_rol_usuario) VALUES ('admin', 'admin123', 1);
INSERT INTO usuario (nombre_usuario, contraseña_usuario, rol_usuario_id_rol_usuario) VALUES ('cliente', 'cliente123', 2);

-- Insertar datos en la tabla usuario_proovedor
INSERT INTO usuario_proovedor (num_cuenta, id_rol_usuario) VALUES ('123456', 1);

-- Insertar datos en la tabla facebook_persona
INSERT INTO facebook_persona (id_persona, url_facebook_persona, persona_id_persona) VALUES (1, 'http://facebook.com/juan', 1);

-- Insertar datos en la tabla producto
INSERT INTO producto (producto_nombre, producto_descripcion, producto_precio, producto_cantidad_stock, producto_marca, producto_modelo, producto_peso, producto_fecha_fabricacion) VALUES ('Producto A', 'Descripcion A', 50.00, 100, 'Marca A', 'Modelo A', 1.5, '2023-01-01');

-- Confirmar transacción
COMMIT;

SELECT * FROM producto;
/*
-- PRUEBAS
SELECT * FROM rol_usuario;
INSERT INTO usuario (nombre_usuario, contraseña_usuario,rol_usuario_id_rol_usuario)
VALUES ("pedro","picapiedradijoasi1",1);
SELECT * FROM usuario;
DELETE FROM usuario WHERE id_usuario = 3;





SELECT *
FROM persona p
INNER JOIN apellido_persona ap ON p.id_persona = ap.persona_id_persona;
*/