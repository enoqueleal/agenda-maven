CREATE TABLE pessoas (
	id	INT NOT	NULL AUTO_INCREMENT,
	nome			VARCHAR(255),
	data_nascimento	DATE,
	id_endereco		INT,
	id_contato		INT,
	PRIMARY KEY 	(id)
);

CREATE TABLE enderecos (
	id	INT NOT	NULL AUTO_INCREMENT,
	logradouro		VARCHAR(255),
	cep				VARCHAR(255),
	PRIMARY KEY 	(id)
);

CREATE TABLE contatos (
	id	INT NOT	NULL AUTO_INCREMENT,
	email			VARCHAR(255),
	telefone		VARCHAR(255),
	PRIMARY KEY 	(id)
);

ALTER TABLE pessoas ADD CONSTRAINT id_endereco FOREIGN KEY (id_endereco) REFERENCES enderecos (id);
ALTER TABLE pessoas ADD CONSTRAINT id_contato FOREIGN KEY (id_contato) REFERENCES contatos (id);