CREATE SCHEMA IF NOT EXISTS accounts;
SET SCHEMA accounts;
CREATE TABLE beneficiary (
    "NAME" VARCHAR(100) NOT NULL,
    PIN NUMERIC(4) NOT NULL,
    VERSION NUMERIC(11),
    primary key ("NAME")
);
CREATE TABLE account (
    "NAME" varchar(100) not null,
    "NUMBER" numeric(4) not null,
    AMOUNT numeric(9) not null,
    VERSION numeric(11),
    primary key ("NUMBER"),
    foreign key ("NAME") references beneficiary("NAME")
);
CREATE TABLE log (
    "ID" IDENTITY  not null,
    FROM_ACCOUNT numeric(4),
    TO_ACCONT numeric(4),
    AMOUNT numeric(9) not null,
    "ACTION" varchar(15) check ("ACTION" in ('DEPOSIT', 'WITHDRAW', 'TRANSFER')) not null,
    VERSION numeric(11),
    primary key ("ID"),
    foreign key (FROM_ACCOUNT) references account("NUMBER"),
    foreign key (TO_ACCONT) references account("NUMBER")
);