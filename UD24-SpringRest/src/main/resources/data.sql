DROP table IF EXISTS trabajo;


create table Empleados(
    id int auto_increment,
    nombre varchar(250),
    trabajo varchar(250),
    salario int
);
insert into Empleados(nombre,trabajo,salario) values('Marc','Programador',13000);
insert into Empleados(nombre,trabajo,salario) values('Manolo','Analista',18000);