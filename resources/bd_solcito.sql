
/*creating db solcito_caliente*/
create database empleados_asc;  
use empleados_asc; 


/*creating tables*/ 

create table empleado (
	idEmpleado int not null auto_increment, 
    identificacion varchar(17) unique, 
    nombre varchar(20), 
    apellido1 varchar(20),
    apellido2 varchar(20) null,  
	constraint PK_Empleado PRIMARY KEY (idEmpleado)
);  

create table salarioDiario(
	idSalarioDiario int not null auto_increment, 
    fecha date not null, 
    montoDiario decimal(7,2), 
    idEmpleado int, 
    constraint PK_Salario_Diario primary key (idSalarioDiario),
    constraint FK_Salario_Diario_Empleado foreign key(idEmpleado) references empleado(idEmpleado)
	on delete no action
    on update cascade 
); 

create table reporteSalarial(
	idReporte int not null auto_increment, 
    idEmpleado int, 
    salarioNeto decimal (10,2), -- calculado de los salarios diarios del rango de fechas seleccionado
    ccss decimal (7,2) not null, 
    herramienta decimal (7,2) default 0, 
	transporte decimal (7,2) default 0, 
    refrescos decimal (7,2) default 0,
    adelantos decimal (7,2) default 0,
    salarioTotal decimal (10,2) not null,
    fechaReporte date not null, 
    fechaInicial date not null, -- para buscar en los salrios diarios de esa fecha 
    fechaFinal date not null,  -- para buscar en los salarios diarios de esa fecha 
    constraint PK_Reporte_Salarial primary key (idReporte), 
    constraint FK_Reporte_Salarial_Empleado foreign key(idEmpleado) references empleado(idEmpleado)
    on delete no action 
    on update cascade 
);

 
