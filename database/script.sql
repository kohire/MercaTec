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


CREATE PROCEDURE getNextIDUser()
 SELECT AUTO_INCREMENT
 FROM information_schema.TABLES
 WHERE TABLE_SCHEMA = "Mercatec"
 AND TABLE_NAME = "Usuario";
 

 call getNextIdUser();
