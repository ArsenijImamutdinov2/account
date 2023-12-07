CREATE SCHEMA IF NOT EXISTS accounts;
SET SCHEMA accounts;
CREATE TABLE beneficiary (NAME VARCHAR(100) NOT NULL, PIN NUMERIC(4) NOT NULL, VERSION NUMERIC(11));
CREATE TABLE account (
    NAME varchar(100) not null,
    NUMBER numeric(4) not null,
    AMOUNT numeric(9) not null,
    VERSION numeric(11)
);
CREATE TABLE log (
    FROM_ACCOUNT numeric(4) not null,
    TO_ACCONT numeric(4),
    AMOUNT numeric(9) not null,
    ACTION varchar(15) not null,
    VERSION numeric(11)
);