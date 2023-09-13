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
	dnicliente int primary key,
    nombres varchar(40) not null,
    apellidos varchar(40) not null,
    direccion varchar(40) not null,
    distrito varchar(30) not null,
    provincia varchar(30) not null,
    telefono int not null,
    correo varchar(60) not null,
    estado boolean
);

create table Prestamos(
	idprestamo int primary key auto_increment,
    dnicliente int not null,
    fecha_prestamo varchar(30) not null,
    monto decimal not null,
    interes decimal not null,
    nrocuatas int not null,
    constraint foreign key (dnicliente) references Cliente(dnicliente)
);

create table Amortizaciones(
	idamortizacion int primary key auto_increment,
    idprestamo int not null,
    fecha_Vencimiento varchar(30)  null,
    mensualidad decimal not null,
    intereses decimal not null,
    capital decimal not null,
    saldo decimal not null,
    estado boolean not null,
    constraint foreign key (idprestamo) references Prestamos(idprestamo)
);



 
drop Trigger if exists InsertIntoAmortizaciones
DELIMITER // 
CREATE TRIGGER InsertIntoAmortizaciones
AFTER INSERT ON Prestamos
FOR EACH ROW
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE cuota DECIMAL(10, 2);
    DECLARE MontoPrestamo Decimal(10,2);
    DECLARE Intereses Decimal(10,2);
    DECLARE Capital decimal(10,2);
    Declare InteresSal decimal(10,2);
    declare Fecha varchar(30);
    DELETE FROM Amortizaciones WHERE idprestamo = NEW.idprestamo ;
    set Intereses = (NEW.interes/100) * NEW.monto;
    set  InteresSal =  Intereses / NEW.nrocuatas;
    set MontoPrestamo = NEW.monto + Intereses;
    set Capital = NEW.monto / NEW.nrocuatas;
    SET cuota = MontoPrestamo / NEW.nrocuatas;
    SET Fecha = NEW.fecha_prestamo;
    
    WHILE i <= NEW.nrocuatas DO
		SET Fecha = DATE_ADD(Fecha, INTERVAL 1  MONTH);
        INSERT INTO Amortizaciones (idprestamo, fecha_Vencimiento, mensualidad, intereses, capital, saldo,estado) 
        VALUES (NEW.idprestamo, Fecha, cuota, InteresSal , Capital, MontoPrestamo - (i - 1) * cuota,true);
        SET i = i + 1;
    END WHILE;
END;
//
DELIMITER ;
INSERT INTO `retroprogamacion`.`Prestamos`
(`dnicliente`,
`fecha_prestamo`,
`monto`,
`interes`,
`nrocuatas`)
VALUES
(74763061,
"2022-01-11",
1200,
30,
4);


select * from Cliente;
select * from Prestamos;
select * from Amortizaciones;


SELECT DATE_SUB(NOW(), INTERVAL 1 MONTH); 
