CREATE TABLE EVENTO
(
    id BIGINT NOT NULL auto_increment primary key,
    cidade varchar(255),
    datafim DATE,
    dataini DATE,
    descricao varchar(255),
    nome varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE PESSOA
(
    id BIGINT NOT NULL auto_increment primary key,
    datanascimento DATE,
    email varchar(255),
    nome varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE EVENTO_PESSOA
(
    evento_id BIGINT NOT NULL,
    pessoa_id BIGINT NOT NULL,
    foreign key (pessoa_id) references pessoa(id),
    foreign key (evento_id) references evento(id)
);