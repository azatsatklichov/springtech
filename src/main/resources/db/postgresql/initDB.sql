
--ALTER TABLE book DROP CONSTRAINT pk_book;
--DROP TABLE book;

CREATE TABLE IF NOT EXISTS book (
  id SERIAL,
  name VARCHAR, 
  CONSTRAINT pk_book PRIMARY KEY (id)
);
 
 
--ALTER TABLE "user" DROP CONSTRAINT pk_user;
--DROP TABLE "user";

CREATE TABLE IF NOT EXISTS "user" (
  id SERIAL,
  name VARCHAR, 
  email VARCHAR, 
  CONSTRAINT pk_user PRIMARY KEY (id)
);
