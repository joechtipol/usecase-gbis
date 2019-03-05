DROP TABLE clients IF EXISTS;
DROP TABLE accounts IF EXISTS;
DROP TABLE operations IF EXISTS;




CREATE TABLE client (
  id         INTEGER PRIMARY KEY,
  login VARCHAR(30),
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
  amount  NUMERIC(50),
  date_operation  DATE

);