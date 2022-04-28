CREATE DATABASE JDBC1;
USE JDBC1;

CREATE TABLE Students (
	Id VARCHAR(5),
    Nombre VARCHAR (50),
    Ciudad VARCHAR (50),
    Telefono VARCHAR(9),
    FechaNacmto DATE,
    DegreeCode INT,
    PRIMARY KEY (Id));
    
CREATE TABLE Degree (
	CodDegree INT,
    Titulo VARCHAR (50),
    Horas INT,
    PRIMARY KEY (CodDegree));
    
ALTER TABLE Students ADD FOREIGN KEY (DegreeCode) REFERENCES Degree(CodDegree);
