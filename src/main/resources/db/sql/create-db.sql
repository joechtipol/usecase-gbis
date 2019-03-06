DROP TABLE client IF EXISTS;
DROP TABLE account IF EXISTS;
DROP TABLE operation IF EXISTS;




CREATE TABLE client (
  id         INTEGER PRIMARY KEY,
  username VARCHAR(30),
  password  VARCHAR(50),
  email  VARCHAR(50)
);

CREATE TABLE account (
  id         INTEGER PRIMARY KEY,
  id_client  INTEGER,
  account_number VARCHAR(30),
  balance  NUMERIC(50)
);



CREATE TABLE operation (
  id         INTEGER PRIMARY KEY,
  id_account INTEGER,
  type_operation VARCHAR(1),
  amount  NUMERIC(50),
  date_operation  DATE

);