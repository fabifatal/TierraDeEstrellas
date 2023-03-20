CREATE SCHEMA script_proyecto_integrador;

USE script_proyecto_integrador;

CREATE TABLE Usuario(
usuario_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_usuario VARCHAR(30),
apodo VARCHAR(15),
edad INTEGER,
sexo CHAR,
contraseña VARCHAR(15),
correo VARCHAR(40)
);

CREATE TABLE Avance_Usuario(
avance_usuario_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
fecha_inicio DATE,
fecha_termino DATE, 
puntuacion INTEGER,
respuesta VARCHAR(200),
usuario_id INTEGER NOT NULL,
desafio_id INTEGER NOT NULL
FOREIGN KEY (desafio_id) REFERENCES Desafio (desafio_id),
FOREIGN KEY (usuario_id) REFERENCES Usuario (usuario_id)
);

CREATE TABLE Nivel(
nivel_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
tiempo INTEGER,
telescopio_id INTEGER NOT NULL,
FOREIGN KEY (telescopio_id) REFERENCES Telescopio (telescopio_id)
);

CREATE TABLE Telescopio (
telescopio_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_telescopio VARCHAR(30),
descripcion VARCHAR(100)
);

CREATE TABLE Dialogo (
dialogo_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_dialogo VARCHAR(30),
descripcion VARCHAR(200),
telescopio_id INTEGER NOT NULL,
desafio_id INTEGER NOT NULL,
FOREIGN KEY (telescopio_id) REFERENCES Telescopio (telescopio_id),
FOREIGN KEY (desafio_id) REFERENCES Desafio (desafio_id)
);

CREATE TABLE Info_Inicial (
info_inicial_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
noticias VARCHAR(1000),
mision VARCHAR(1000),
vision VARCHAR(1000), 
registrate VARCHAR(50),
contacto VARCHAR(50),
novedades VARCHAR(1000)
);

CREATE TABLE Desafio (
desafio_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
objeto_celeste VARCHAR(50),
coordenadas_correctas VARCHAR(50),
coordenadas_usuario VARCHAR(50),
nivel_id INTEGER NOT NULL,
FOREIGN KEY (nivel_id) REFERENCES Nivel (nivel_id)
);

CREATE TABLE Avance_Desafio (
avance_desafio_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
avance_usuario_id INTEGER NOT NULL,
desafio_id INTEGER NOT NULL,
FOREIGN KEY (avance_usuario_id) REFERENCES Avance_Usuario (avance_usuario_id),
FOREIGN KEY (desafio_id) REFERENCES Desafio (desafio_id)
);
