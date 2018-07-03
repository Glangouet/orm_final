insert INTO COMPTE_BANCAIRE values('FR7630001007941234567890185','Azerty', 'BOUSFRPP', true);
insert INTO COMPTE_BANCAIRE values('FR7630004000031234567890143','toto', 'BOUSFRPP', false);
insert INTO COMPTE_BANCAIRE values('FR7630006000011234567890189','toto', 'HSBCFRPP', false);

insert into CLIENT  (idClient) values (1);
insert into CLIENT  (idClient) values (2);

insert INTO ASSURANCE (idAssurance, typeAssurance) values (1, 'Auto');

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      values (1,
              (SELECT idAssurance from ASSURANCE where typeAssurance='Auto'));

INSERT INTO COMPTE_CLIENT (idClient, iban) VALUES (1,'FR7630001007941234567890185');

INSERT INTO PERSONNE_MORALE (idClient, siren, companyName) VALUES (1, '0000', 'DIALO-HOME');

INSERT INTO PERSONNE_PHYSIQUE (idClient, firstName, lastname, birthDate) VALUES (1, 'Guillaume', 'Langouet', '2012-12-10');

INSERT INTO CONTACT (idContact, contactType, val) VALUES (1, 'PHONE', '0781858640');