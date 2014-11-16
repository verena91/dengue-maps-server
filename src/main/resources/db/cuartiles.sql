-- DISTRITOS
create table cuartiles_por_distrito (
	id int,
	departamento character varying,
	distrito character varying,
	cuartil_uno character varying,
	cuartil_dos character varying,
	cuartil_tres character varying,
	tipo character varying
);

COPY cuartiles_por_distrito (id, departamento, distrito, cuartil_uno, cuartil_dos, cuartil_tres, tipo) 
FROM '/home/verena/dengue-maps-server/src/main/resources/db/cuartiles_por_distrito.csv' 
DELIMITER ';' CSV HEADER;

ALTER TABLE public.cuartiles_por_distrito OWNER TO postgres;

ALTER TABLE ONLY cuartiles_por_distrito
    ADD CONSTRAINT cuartiles_por_distrito_pkey PRIMARY KEY (id);


-- BARRIOS
create table cuartiles_por_barrio (
	id int,
	barrio character varying,
	area character varying,
	cuartil_uno character varying,
	cuartil_dos character varying,
	cuartil_tres character varying
);

COPY cuartiles_por_barrio (id, barrio, area, cuartil_uno, cuartil_dos, cuartil_tres) 
FROM '/home/verena/dengue-maps-server/src/main/resources/db/cuartiles_por_barrio.csv' 
DELIMITER ';' CSV HEADER;

ALTER TABLE public.cuartiles_por_barrio OWNER TO postgres;

ALTER TABLE ONLY cuartiles_por_barrio
    ADD CONSTRAINT cuartiles_por_barrio_pkey PRIMARY KEY (id);
