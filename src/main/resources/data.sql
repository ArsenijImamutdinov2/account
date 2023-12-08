insert into beneficiary ("NAME", PIN) values
('Foo', 6789),
('Boo', 7891),
('Jack', 1234),
('Chloe', 2345),
('Kim', 3456),
('David', 4567),
('Michelle', 5678);

insert into account ("NAME", "NUMBER", AMOUNT) values
('Foo', 1111, 100),
('Foo', 2222, 200),
('Boo', 333, 300);

insert into log (FROM_ACCOUNT, TO_ACCONT, AMOUNT, ACTION) values
(1111, null, 400, 'DEPOSIT'),
(1111, null, 100, 'WITHDRAW'),
(1111, 2222, 200, 'TRANSFER');