create table departamento (
	id int,
	departamento_codigo character varying,
	departamento_descripcion character varying
)

create table distrito (
	id int,
	codigo character varying,
	distrito_codigo character varying,
	distrito_descripcion character varying,
	departamento_codigo character varying,
	departamento_descripcion character varying,
	cantidad_man int
)

create table distrito (
	id int,
	codigo character varying,
	distrito_codigo character varying,
	distrito_descripcion character varying,
	departamento_codigo character varying,
	departamento_descripcion character varying,
	cantidad_man int
)

create table barrio (
	id int,
	codigo character varying,
	area character varying,
	barrio_codigo character varying,
	barrio_descripcion character varying,
	departamento_codigo character varying,
	distrito_codigo character varying,
	departamento_descripcion character varying,
	distrito_descripcion character varying,
	cantidad_viv character varying
)

/* Cambiar por el path correcto */

COPY departamento (id, departamento_codigo, departamento_descripcion) 
FROM '/home/desa2/workspace/denguemaps/src/main/resources/db/departamentos.csv' 
DELIMITER ';' CSV HEADER;

COPY distrito (id,codigo, distrito_codigo, distrito_descripcion, departamento_codigo, departamento_descripcion, cantidad_man) 
FROM '/home/desa2/workspace/denguemaps/src/main/resources/db/distritos.csv' 
DELIMITER ';' CSV HEADER;

COPY barrio (id, departamento_codigo, distrito_codigo, departamento_descripcion, distrito_descripcion, area, barrio_codigo, barrio_descripcion, cantidad_viv, codigo) 
FROM '/home/desa2/workspace/denguemaps/src/main/resources/db/barrios.csv' 
DELIMITER ';' CSV HEADER;

ALTER TABLE public.departamento OWNER TO postgres;
ALTER TABLE public.distrito OWNER TO postgres;
ALTER TABLE public.barrio OWNER TO postgres;

ALTER TABLE ONLY departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id);

ALTER TABLE ONLY distrito
    ADD CONSTRAINT distrito_pkey PRIMARY KEY (id);

ALTER TABLE ONLY barrio
    ADD CONSTRAINT barrio_pkey PRIMARY KEY (id);