CREATE TABLE customer (
  id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   nome VARCHAR(255) NOT NULL,
   sobrenome VARCHAR(255),
   email VARCHAR(255) NOT NULL,
   CONSTRAINT pk_customer PRIMARY KEY (id)
);