CREATE TABLE usuario(ID INT PRIMARY KEY NOT NULL, 
NOMBRES TEXT NOT NULL, 
APELLIDOS TEXT NOT NULL, 
EMAIL TEXT NOT NULL, 
DESCRIPCION TEXT NOT NULL);

CREATE TABLE permiso(
ID INT PRIMARY KEY NOT NULL,
USUARIOID INT NULL, 
PERMITIDO BOOLEAN NULL, 
MODULO TEXT NULL);

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT FK_PERMISO_USUARIO FOREIGN KEY (USUARIOID) REFERENCES public.usuario(ID) NOT VALID;
	
INSERT INTO public.usuario (id, nombres, apellidos, email, descripcion) VALUES (1, 'Rocky', 'Stallone', 'rocky.stallone', 'Usuario administrador de ventas');

INSERT INTO public.permiso (id, usuarioid, modulo, permitido) VALUES (1, 1, 'VENTAS', true);