CREATE TABLE pessoas (
	id	BIGINT NOT	NULL AUTO_INCREMENT,
	nome			VARCHAR(255),
	dataNascimento	DATE,
	PRIMARY KEY 	(id)
);

CREATE TABLE enderecos (
	id	BIGINT NOT	NULL AUTO_INCREMENT,
	logradouro		VARCHAR(255),
	cep				VARCHAR(255),
	PRIMARY KEY 	(id)
);

CREATE TABLE contatos (
	id	BIGINT NOT	NULL AUTO_INCREMENT,
	email			VARCHAR(255),
	telefone		VARCHAR(255),
	PRIMARY KEY 	(id)
);