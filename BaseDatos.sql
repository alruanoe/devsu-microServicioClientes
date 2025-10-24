-- ===========================================================
--SECHEMA: dbTest
-- Autor: Ana Luisa Ruano Espina
-- Descripcion: Script de creacion de tablas 
-- ============================================================

--1 crear usuario (opcional si ya existe no se crea)
--ejecutar con usuario con privilegios (system)

CREATE USER DB_REM IDENTIFIED BY DB_REM1;
GRANT CONNECT, RESOURCE TO DB_REM;
ALTER USER DB_REM QUOTA UNLIMITED ON USERS;

--Cambiar al nuevo esquema

ALTER SESSION SET CURRENT_SCHEMA=DB_REM;

/**
Tabla persona
**/
CREATE TABLE PERSONA(
"id_persona" NUMBER(10),
"nombre" VARCHAR2(250),
"genero" VARCHAR2(10),
"edad" NUMBER(3),
"identificacion" VARCHAR2(100),
"direccion" VARCHAR2(250),
"telefono" VARCHAR2(50),
PRIMARY KEY ("id_persona")
);

CREATE SEQUENCE "PERSONA_SQ" MINVALUE 1 MAXVALUE 99999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER CYCLE;
CREATE PUBLIC SYNONYM PERSONA FOR PERSONA;
CREATE PUBLIC SYNONYM PERSONA_SQ FOR PERSONA_SQ;


/**
Tabla Cliente
**/
CREATE TABLE CLIENTE(
"identificador" NUMBER(10),
"id_persona" NUMBER(10),
"id_cliente" VARCHAR2(50) UNIQUE NOT NULL,
"contrasena" VARCHAR2(250),
"estado" CHAR(1) DEFAULT '1',
PRIMARY KEY ("identificador"),
CONSTRAINT "FK_PERSONA" FOREIGN KEY ("id_persona") REFERENCES PERSONA("id_persona") ENABLE
);

CREATE SEQUENCE "CLIENTE_SQ" MINVALUE 1 MAXVALUE 99999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER CYCLE;
CREATE PUBLIC SYNONYM CLIENTE FOR CLIENTE;
CREATE PUBLIC SYNONYM CLIENTE_SQ FOR CLIENTE_SQ;

/**
Tabla cuenta
**/
CREATE TABLE CUENTA(
"numero_cuenta" VARCHAR2(50),
"tipo_cuenta" VARCHAR2(50) NOT NULL,
"saldo_inicial" NUMBER(18,2) NOT NULL,
"saldo_actual" NUMBER(18,2) NOT NULL,
"id_cliente" VARCHAR2(50),
"estado" CHAR(1) DEFAULT '1',
PRIMARY KEY ("numero_cuenta"),
CONSTRAINT "FK_CLIENTE" FOREIGN KEY ("id_cliente") REFERENCES CLIENTE("id_cliente") ENABLE
);

CREATE PUBLIC SYNONYM CUENTA FOR CUENTA;



/**
Tabla movimiento
**/

CREATE TABLE MOVIMIENTO(
"id_movimiento" NUMBER,
"fecha" DATE DEFAULT SYSDATE,
"tipo_movimiento" VARCHAR2(50) NOT NULL,
"numero_cuenta" VARCHAR2(50),
"valor" NUMBER(18,2) NOT NULL,
"saldo" NUMBER(18,2) NOT NULL,
PRIMARY KEY ("id_movimiento"),
CONSTRAINT "FK_CUENTA" FOREIGN KEY ("numero_cuenta") REFERENCES CUENTA("numero_cuenta") ENABLE
);

CREATE PUBLIC SYNONYM MOVIMIENTO FOR MOVIMIENTO;

CREATE SEQUENCE "MOVIMIENTO_SQ" MINVALUE 1 MAXVALUE 99999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER CYCLE;

CREATE PUBLIC SYNONYM MOVIMIENTO_SQ FOR MOVIMIENTO_SQ;