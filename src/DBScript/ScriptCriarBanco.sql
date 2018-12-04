CREATE DATABASE vendasimples
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


CREATE TABLE public.mercadoria
(
    id SERIAL NOT NULL PRIMARY KEY,
    codigo character varying(8) NOT NULL,
    descricao character varying(20) NOT NULL,
    valor real NOT NULL,
    ativo char(3) NOT NULL
)

CREATE TABLE public.pessoa
(
    id SERIAL NOT NULL PRIMARY KEY,
    razaosocial character varying(50) NOT NULL,
    datanascimento date not null,
    cpfcnpj character varying(20) NOT NULL,
    tipopessoa char(10) NOT NULL,
    ativo char(3) NOT NULL
)

CREATE TABLE public.venda
(
    id SERIAL NOT NULL PRIMARY KEY,
    idPessoa int not null,
    idMercadoria int not null,
    quantidade int not null,
    valorUnitario real not null,
    valorTotal real not null,
    situacao character varying(15),
    dataCadastro date not null,
    dataVenda date,
    dataCancelamento date,
    FOREIGN KEY (idPessoa) REFERENCES pessoa (id),
    FOREIGN KEY (idMercadoria) REFERENCES mercadoria (id)
)