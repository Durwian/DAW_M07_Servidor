CREATE TABLE articles(codi VARCHAR(100) PRIMARY KEY NOT NULL,
                  numeroUnitats INTEGER NOT NULL,
                  numeroVendes  INTEGER NOT NULL,
                  titol VARCHAR(250) NOT NULL,
                  descripcio VARCHAR(250) NOT NULL);

INSERT INTO articles (codi, numeroUnitats, numeroVendes, titol, descripcio) VALUES ('0', 20, 0, 'Article0', 'Descripcio0');
INSERT INTO articles (codi, numeroUnitats, numeroVendes, titol, descripcio) VALUES ('1', 10, 0, 'Article1', 'Descripcio1');
INSERT INTO articles (codi, numeroUnitats, numeroVendes, titol, descripcio) VALUES ('2', 5, 0, 'Article2', 'Descripcio2');
INSERT INTO articles (codi, numeroUnitats, numeroVendes, titol, descripcio) VALUES ('3', 12, 0, 'Article3', 'Descripcio3');
INSERT INTO articles (codi, numeroUnitats, numeroVendes, titol, descripcio) VALUES ('4', 5, 0, 'Article4', 'Descripcio4');
INSERT INTO articles (codi, numeroUnitats, numeroVendes, titol, descripcio) VALUES ('5', 10, 0, 'Article5', 'Descripcio5');

