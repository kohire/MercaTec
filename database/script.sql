create database mercatec;
use mercatec;

CREATE TABLE Usuario (
	idUsuario INT(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    usuario VARCHAR(20) NOT NULL,
    contraseña TEXT NOT NULL,
    tipo VARCHAR(20) NOT NULL, -- Si es profesor, alumno...
    correo VARCHAR(40) NOT NULL,
    estado TINYINT(1) NOT NULL -- Indica si está activa o inactiva la cuenta.
);
/* contraseña equivalente a 1234 */
INSERT INTO Usuario(idUsuario, nombre, usuario, contraseña, tipo, correo, estado) VALUES 
(NULL, 'Aideé Alvarez', 'Aidee', '81dc9bdb52d04dc20036dbd8313ed055', 'Alumno', '15240528@itleon.edu.mx', 1);

INSERT INTO Usuario(idUsuario, nombre, usuario, contraseña, tipo, correo, estado) VALUES 
(NULL, 'Yahir Saldivar', 'Admin', '81dc9bdb52d04dc20036dbd8313ed055', 'Administrador', '15240528@itleon.edu.mx', 1);
SELECT * FROM Usuario;

CREATE TABLE Tarjeta(
	idTarjeta INT(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombrePro VARCHAR(25) NOT NULL,
    numTarjeta INT(5) NOT NULL,
    fechaVence DATE NOT NULL,
    tipo VARCHAR(15) NOT NULL -- Crédito o débito.
);

CREATE TABLE Productos(
	idProducto INT(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idUsuario INT(5) NOT NULL, -- Id del usuario que desea vender un producto.
    nombreProd VARCHAR(30) NOT NULL,
    imagenProd LONGBLOB NOT NULL, -- imagen del producto guardado como un blob.
    descripcion VARCHAR(70), 
    precio INT NOT NULL,
    existencia INT NOT NULL, -- Existencia de las unidades actuales.
    unidades INT NOT NULL	-- Unidades iniciales del producto.
);

CREATE TABLE Reporte(
	idReporte INT(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idUsuario INT(5) NOT NULL,
    idProducto INT(5) NOT NULL,
    motivo VARCHAR(20) NOT NULL,
    descripcion TEXT(500) 
);
CREATE TABLE Comentarios(
	idComentario INT(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idUsuario INT(5) NOT NULL,
    idProducto INT(5) NOT NULL,
    comentario VARCHAR(100) NOT NULL,
    puntuacion INT(5)
);

CREATE TABLE Carrito(
	idCarrito INT(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idUsuario INT(5) NOT NULL
);
INSERT INTO Carrito(idCarrito,idUsuario) VALUES (NULL, 1);
INSERT INTO Carrito(idCarrito,idUsuario) VALUES (NULL, 2);
CREATE TABLE Productos_Carrito(
	id int primary key not null auto_increment,
	idCarrito INT(5) NOT NULL,
    idProducto INT(5) NOT NULL
);

CREATE TABLE Compra(
	idCompra INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idCarrito INT(5) NOT NULL,
    fecha DATE NOT NULL,
    pago VARCHAR(10) NOT NULL
);

CREATE TABLE usuario_tarjeta (
idUsuario INT(5),
idTarjeta INT(5)
);

/* CLAVES FORÁNEAS USUARIO_TARJETA*/
ALTER TABLE usuario_tarjeta add foreign key (idUsuario) references Usuario(idUsuario);
ALTER TABLE usuario_tarjeta add foreign key (idTarjeta) references Tarjeta(idTarjeta);
/* CLAVES FORÁNEAS REPORTE*/
ALTER TABLE Reporte add foreign key (idUsuario) references Usuario(idUsuario);
ALTER TABLE Reporte add foreign key (idProducto) references Productos(idProducto);
/* CLAVES FORÁNEAS COMENTARIOS*/
ALTER TABLE Comentarios add foreign key (idUsuario) references Usuario(idUsuario);
ALTER TABLE Comentarios add foreign key (idProducto) references Productos(idProducto);
/* CLAVE FORÁNEA DE CARRITO y PRODUCTOS_CARRITO*/
ALTER TABLE Carrito add foreign key (idUsuario) references Usuario(idUsuario);
ALTER TABLE Productos_Carrito add foreign key (idCarrito) references Carrito(idCarrito);
ALTER TABLE Productos_Carrito add foreign key (idProducto) references Productos(idProducto);
/* CLAVES FORÁNEAS DE COMPRA */
ALTER TABLE Compra add foreign key (idCarrito) references Carrito(idCarrito);
/* CLAVE FORÁNEA A PRODUCTOS*/
ALTER TABLE Productos add foreign key (idUsuario) references Usuario(idUsuario);

-- INICIO DE PROCEDIMIENTOS ALMACENADOS.
CREATE PROCEDURE getNextIDUser()
 SELECT AUTO_INCREMENT
 FROM information_schema.TABLES
 WHERE TABLE_SCHEMA = "Mercatec"
 AND TABLE_NAME = "Usuario";

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.getUsuario$$
CREATE PROCEDURE mercatec.getUsuario
		(IN a VARCHAR(30), b TEXT)
BEGIN
SELECT idUsuario, tipo FROM Usuario WHERE usuario = a AND contraseña = b AND estado = 1;
END $$
DELIMITER ; 



DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.getNameUser$$
CREATE PROCEDURE mercatec.getNameUser
		(IN id TINYINT)
BEGIN
SELECT nombre FROM Usuario WHERE idUsuario = id;
END $$
DELIMITER ; 

-- No se usa este (getUsers).
DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.getUsers$$
CREATE PROCEDURE mercatec.getUsers
		(IN aux VARCHAR(40))
BEGIN
SET @consulta = CONCAT('SELECT * FROM Usuario WHERE estado = 1 AND
		nombre LIKE ''%',aux,'%'' OR usuario LIKE ''%',aux,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.insertUser$$
CREATE PROCEDURE mercatec.insertUser
		(IN  nombre VARCHAR(50),
			 usuario VARCHAR(20),
			 contraseña TEXT,
			 tipo VARCHAR(20),
		 	 correo VARCHAR(40),
			 estado TINYINT(1))
BEGIN
INSERT INTO Usuario(nombre, usuario, contraseña, tipo, correo, estado) VALUES 
					(nombre, usuario, contraseña, tipo, correo, estado);
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.deleteUser$$
CREATE PROCEDURE mercatec.deleteUser
		(IN id TINYINT)
BEGIN
DELETE FROM Usuario WHERE idUsuario = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.deleteTheirProducts$$
CREATE PROCEDURE mercatec.deleteTheirProducts
		(IN id TINYINT)
BEGIN
DELETE FROM Productos WHERE idUsuario = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.deleteTheirComments$$
CREATE PROCEDURE mercatec.deleteTheirComments
		(IN id TINYINT)
BEGIN
DELETE FROM Comentarios WHERE idUsuario = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.insertReport$$
CREATE PROCEDURE mercatec.insertReport
		(IN idUsuario INT(5),
			idProducto INT(5),
			motivo VARCHAR(20),
			descripcion TEXT(500))
BEGIN
INSERT INTO Reporte(idUsuario, idProducto, motivo, descripcion) VALUES 
					(idUsuario, idProducto, motivo, descripcion);
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.deleteReport$$
CREATE PROCEDURE mercatec.deleteReport
		(IN id TINYINT)
BEGIN
DELETE FROM Reporte WHERE idReporte = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.selectReport$$
CREATE PROCEDURE mercatec.selectReport
		(IN id TINYINT)
BEGIN
SELECT * FROM Reporte WHERE idReporte = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.deleteSameReports$$
CREATE PROCEDURE mercatec.deleteSameReports
		(IN id TINYINT)
BEGIN
DELETE FROM Reporte WHERE idProducto = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.deleteUserCar$$
CREATE PROCEDURE mercatec.deleteUserCar
		(IN id TINYINT)
BEGIN
DELETE FROM Carrito WHERE idCarrito = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.insertUserCar$$
CREATE PROCEDURE mercatec.insertUserCar
		(IN idUsuario TINYINT)
BEGIN
INSERT INTO Carrito(idUsuario) VALUES (idUsuario);
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.getUserCar$$
CREATE PROCEDURE mercatec.getUserCar
		(IN id TINYINT)
BEGIN
SELECT idCarrito FROM Carrito WHERE idUsuario = id;
END $$
DELIMITER ; 


DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.selectProduct$$
CREATE PROCEDURE mercatec.selectProduct
		(IN id TINYINT)
BEGIN
SELECT * FROM Productos WHERE idProducto = id;
END $$
DELIMITER ; 


DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.selectCarrito$$
CREATE PROCEDURE mercatec.selectCarrito
		(IN id TINYINT)
BEGIN
SELECT  productos_carrito.id,productos.idProducto, productos.nombreProd, 
		productos.imagenProd, productos.descripcion, productos.precio, 
        productos.existencia, productos.unidades
        FROM Productos_Carrito INNER JOIN carrito 
        ON carrito.idCarrito = productos_carrito.idCarrito INNER JOIN usuario 
		ON carrito.idUsuario = usuario.idUsuario INNER JOIN productos
		ON Productos_Carrito.idProducto = productos.idProducto
        WHERE usuario.idUsuario = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.insertProductCarrito$$
CREATE PROCEDURE mercatec.insertProductCarrito
		(IN idCarrito TINYINT, idProducto TINYINT)
BEGIN
INSERT INTO productos_carrito(idCarrito, idProducto)
						VALUES (idCarrito, idProducto);
END $$
DELIMITER ; 

select * from productos_carrito;

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.deleteProductCarrito$$
CREATE PROCEDURE mercatec.deleteProductCarrito
		(IN idPC TINYINT)
BEGIN
DELETE FROM productos_carrito WHERE id = idPC;
END $$
DELIMITER ; 


DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.insertProduct$$
CREATE PROCEDURE mercatec.insertProduct
		(IN idUsuario INT(5),
			nombreProd VARCHAR(30),
			imagenProd LONGBLOB, 
			descripcion VARCHAR(70), 
			precio INT,
			existencia INT,
			unidades INT)
BEGIN
INSERT INTO Productos (idUsuario,nombreProd,imagenProd,descripcion, 
						precio, existencia, unidades) VALUES
                        (idUsuario,nombreProd,imagenProd,descripcion, 
						precio, existencia, unidades);
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.deleteProduct$$
CREATE PROCEDURE mercatec.deleteProduct
		(IN id TINYINT)
BEGIN
DELETE FROM Productos WHERE idProducto = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.updateProduct$$
CREATE PROCEDURE mercatec.updateProduct
		(IN 
			nombreProd VARCHAR(30),
			imagenProd LONGBLOB, 
			descripcion VARCHAR(70), 
			precio INT,
			existencia INT,
			unidades INT,
            id TINYINT)
BEGIN
UPDATE Productos SET 
					nombreProd  = nombreProd,
					imagenProd  = imagenProd,
					descripcion = descripcion, 
					precio      = precio,
					existencia  = existencia,
					unidades = unidades
				  WHERE idProducto = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.showUserProduct$$
CREATE PROCEDURE mercatec.showUserProduct
		(IN id TINYINT)
BEGIN
SELECT * FROM Usuario WHERE idUsuario = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.getComments$$
CREATE PROCEDURE mercatec.getComments
		(IN id TINYINT)
BEGIN
SELECT comentario,idUsuario FROM Comentarios WHERE idProducto = id;
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.insertComment$$
CREATE PROCEDURE mercatec.insertComment
		(IN idUsuario INT(5),idProducto INT(5),comentario VARCHAR(100))
BEGIN
INSERT INTO Comentarios (idUsuario, idProducto, comentario) VALUES
                       (idUsuario, idProducto, comentario);
END $$
DELIMITER ; 

DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.wasBoughtByCustomer$$
CREATE PROCEDURE mercatec.wasBoughtByCustomer
		(IN idUsuario TINYINT,  idProducto TINYINT)
BEGIN
SELECT  productos_carrito.idProducto
                    FROM carrito INNER JOIN productos_carrito
                    ON carrito.idCarrito = productos_carrito.idCarrito 
                    WHERE carrito.idUsuario = idUsuario
                    AND  productos_carrito.idProducto = idProducto;
END $$
DELIMITER ; 



DELIMITER $$
DROP PROCEDURE IF EXISTS mercatec.selectCarritoAux$$
CREATE PROCEDURE mercatec.selectCarritoAux
		(IN idUsuario TINYINT)
BEGIN
SELECT idCarrito FROM carrito WHERE idUsuario = idUsuario;
END $$
DELIMITER ; 





