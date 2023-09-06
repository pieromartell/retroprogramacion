drop database if exists retroprogamacion;

create database retroprogamacion;

use retroprogamacion;

create table usuario(
	idusuario int primary key auto_increment,
    username varchar(30) not null,
    password varchar(30) not null,
    estado boolean
);


create table Cliente(
	idcliente int primary key auto_increment,
    nombres varchar(40) not null,
    apellidos varchar(40) not null,
    dni char(8) not null,
    direccion varchar(40) not null,
    distrito varchar(30) not null,
    provincia varchar(30) not null,
    telefono int not null,
    correo varchar(60) not null,
    estado boolean
);

INSERT INTO `retroprogamacion`.`cliente`
(
`nombres`,
`apellidos`,
`dni`,
`direccion`,
`distrito`,
`provincia`,
`telefono`,
`correo`,
`estado`)
VALUES
("Piero ",
"Martell",
"74763061",
"Av 28 de Julio",
"Villa Maria",
"Lima",
992300722,
"piero@gmail.com",
true);
