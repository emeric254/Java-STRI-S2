DROP TABLE IF EXISTS appareil;
DROP TABLE IF EXISTS interface;
DROP TABLE IF EXISTS firmware;
DROP TABLE IF EXISTS os;
DROP TABLE IF EXISTS salle;
DROP TABLE IF EXISTS local;

CREATE table local 
(
	id integer NOT NULL PRIMARY KEY,
	nom varchar(1024) NOT NULL,
	lieuLocal varchar(1024) NOT NULL
);

CREATE TABLE salle
(
	id integer NOT NULL PRIMARY KEY,
	nom varchar(1024) NOT NULL,
	idLocal integer NOT NULL,
	CONSTRAINT FK_SA_LO FOREIGN KEY (idLocal) REFERENCES local(id)
);


CREATE TABLE os
(
	id integer NOT NULL PRIMARY KEY,
	nom varchar(1024) NOT NULL,
	version varchar(1024) NOT NULL
);

CREATE TABLE firmware 
(
	id integer NOT NULL PRIMARY KEY,
	nom varchar(1024) NOT NULL,
	version varchar(1024) NOT NULL
);

CREATE TABLE interface
(
	id integer NOT NULL PRIMARY KEY,
	adresseMAC integer NOT NULL,
	nom varchar(1024) NOT NULL,
	idFirmware integer NOT NULL,
	CONSTRAINT FK_INT_FIR FOREIGN KEY (idFirmware) REFERENCES firmware(id)
);

CREATE TABLE appareil
(
	id integer NOT NULL PRIMARY KEY,
	nom varchar(1024) NOT NULL,
	marque varchar(1024) NOT NULL,
	etat boolean NOT NULL,
	type varchar(1024) DEFAULT NULL,
	idSalle integer NOT NULL,
	idOs integer NOT NULL,
	idInterface integer NOT NULL,
	idSwitch integer DEFAULT NULL,
	modele varchar(1024) NOT NULL,
	CONSTRAINT FK_TER_SA FOREIGN KEY (idSalle) REFERENCES salle(id),
	CONSTRAINT FK_TER_OS FOREIGN KEY (idOs) REFERENCES os(id),
	CONSTRAINT FK_TER_IN FOREIGN KEY (idInterface) REFERENCES interface(id),
	CONSTRAINT FK_TER_SW FOREIGN KEY (idSwitch) REFERENCES appareil(id)
);
