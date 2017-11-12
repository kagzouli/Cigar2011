use cigardb;

DROP table IF EXISTS category;
CREATE TABLE category(
   idcategory integer NOT NULL AUTO_INCREMENT,
   libelleCategorie varchar(100) NOT NULL,
   description varchar(512) NULL,
   PRIMARY KEY(idcategory));
   
DROP TABLE IF EXISTS cigar;
CREATE  TABLE cigar(
   idcigar integer NOT NULL AUTO_INCREMENT,
   cigarLabel varchar(100) NOT NULL,
   idcategory integer NOT NULL,
   description varchar(512) NULL,
   creationDate timestamp NOT NULL,
   amount float NOT NULL,
   leftCigar INTEGER NOT NULL,
   PRIMARY KEY(idcigar),
   Foreign Key (idcategory) references category(idcategory));
