-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into product(id, productName, description, unitPrice, active, version) values(1,'Product 1', 'Description 1', 5.00, true, 1);
insert into product(id, productName, description, unitPrice, active, version) values(2,'Product 2', 'Description 2', 10.00, true, 1);
insert into product(id, productName, description, unitPrice, active, version) values(3,'Product 3', 'Description 3', 15.00, true, 1);

insert into third_party(id, thirdPartyName, city) values(1,'Partener 1', 'Bucuresti');
insert into third_party(id, thirdPartyName, city) values(2,'Partener 2', 'Constanta');
insert into third_party(id, thirdPartyName, city) values(3,'Partener 3', 'Arad');

insert into stock_movement(id, product_id, operationDate, noOfUnits, operationType, third_party_id, version) values(1,1,'2023-04-26',10,1,1,1);
insert into stock_movement(id, product_id, operationDate, noOfUnits, operationType, third_party_id, version) values(2,1,'2023-04-27',5,2,1,1);
insert into stock_movement(id, product_id, operationDate, noOfUnits, operationType, third_party_id, version) values(3,1,'2023-04-28',10,1,1,1);

insert into stock_movement(id, product_id, operationDate, noOfUnits, operationType, third_party_id, version) values(4,2,'2023-04-15',10,1,1,1);
insert into stock_movement(id, product_id, operationDate, noOfUnits, operationType, third_party_id, version) values(5,2,'2023-04-16',10,1,1,1);

insert into stock_movement(id, product_id, operationDate, noOfUnits, operationType, third_party_id, version) values(6,3,'2023-04-09',10,1,1,1);
insert into stock_movement(id, product_id, operationDate, noOfUnits, operationType, third_party_id, version) values(7,3,'2023-04-10',5,2,1,1);