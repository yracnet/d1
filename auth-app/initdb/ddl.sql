CREATE TABLE usuario(ID INT PRIMARY KEY NOT NULL, 
NOMBRES TEXT NOT NULL, 
APELLIDOS TEXT NOT NULL, 
EMAIL TEXT NOT NULL, 
DESCRIPCION TEXT NOT NULL);

CREATE TABLE modulo(
ID INT PRIMARY KEY NOT NULL,
CODIGO TEXT NULL, 
NOMBRE TEXT NULL);

CREATE TABLE permiso(
ID INT PRIMARY KEY NOT NULL,
USUARIOID INT NULL, 
PERMITIDO BOOLEAN NULL, 
MODULO TEXT NULL,
MODULOID INT NULL);

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT FK_PERMISO_USUARIO FOREIGN KEY (USUARIOID) REFERENCES public.usuario(ID) NOT VALID;

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT FK_PERMISO_MODULO FOREIGN KEY (MODULOID) REFERENCES public.modulo(ID) NOT VALID;
	
INSERT INTO public.usuario (id, nombres, apellidos, email, descripcion) VALUES (1, 'Willyams', 'Yujra', 'willyams.yujra@greenfoft.bo', 'Usuario administrador');
INSERT INTO public.usuario (id, nombres, apellidos, email, descripcion) VALUES (2, 'Ivan', 'Ulo', 'ivan.ulo@greenfoft.bo', 'Usuario administrador');
INSERT INTO public.usuario (id, nombres, apellidos, email, descripcion) VALUES (3, 'Cristhian', 'Cadario ', 'cristhian.cadario@greenfoft.bo', 'Usuario administrador');
INSERT INTO public.usuario (id, nombres, apellidos, email, descripcion) VALUES (4, 'Rimberth', 'Villca', 'rimberth.villca@greenfoft.bo', 'Usuario administrador');

INSERT INTO public.modulo (id, codigo, nombre) VALUES (1, 'cliente', 'Gestión de clientes');
INSERT INTO public.modulo (id, codigo, nombre) VALUES (2, 'cuenta', 'Gestión de cuentas');
INSERT INTO public.modulo (id, codigo, nombre) VALUES (3, 'transferencia', 'Transferencias');
INSERT INTO public.modulo (id, codigo, nombre) VALUES (4, 'prestamo', 'Préstamos');
INSERT INTO public.modulo (id, codigo, nombre) VALUES (5, 'banca_en_linea', 'Banca en línea');

INSERT INTO public.permiso (id, usuarioid, modulo, permitido, moduloid) VALUES (1, 1, 'Gestión de clientes', true, 1);


