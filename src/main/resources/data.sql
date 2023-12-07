insert into beneficiary (NAME, PIN, VERSION) values
('Foo', 6789, 0),
('Boo', 7891, 0),
('Jack', 1234, 0),
('Chloe', 2345, 0),
('Kim', 3456, 0),
('David', 4567, 0),
('Michelle', 5678, 0);

insert into account (NAME, NUMBER, AMOUNT) values
('Foo', 1111, 100),
('Foo', 2222, 200);

insert into log (FROM_ACCOUNT, TO_ACCONT, AMOUNT, ACTION) values
(1111, null, 400, 'deposit'),
(1111, null, 100, 'withdraw'),
(1111, 2222, 200, 'withdraw');