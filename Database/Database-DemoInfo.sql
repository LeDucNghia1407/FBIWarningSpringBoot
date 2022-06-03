use basicorder1;
insert into `DrugSupplier`
values ('S1','Europe','Europe' );

insert into `Drug`
values('D1',	'S1',	'Panadol',	'2019-02-02',	'2019-02-12',	'bar',	10 ),
('D2',	'S1',	'Vitamin C',	'2019-02-03',	'2019-03-12',	'bar',	20 ),
('D3',	'S1',	'Stomach',	'2019-05-05',	'2020-05-03',	'bar',	50 );

insert into `DrugStore`
values('DS1',	'S1',	'Earth','VGU' ),
('DS2',	'S1',	'Moon',	'VGU' );

insert into `Store`
values('St1',	'D1',	'DS1',	'2020-06-07',	30 ),
('St2',	'D2',	'DS1',	'2020-06-07',	80 ),
('St3',	'D3',	'DS1',	'2020-06-07',	35 ),
('St4',	'D1',	'DS2',	'2020-06-07',	15 ),
('St5',	'D2',	'DS2',	'2020-06-07',	50 ),
('St6',	'D3',	'DS2',	'2020-06-07',	25 );

insert into `Manager`
values('M1','DS1'),
('M2','DS2');

insert into `Employee`
values('E1',	'DS1',	Null,	'cat1',	'cat1gmail.com',	201,	0,	500 ),
('E2',	'DS1',	Null,	'cat2',	'cat2gmail.com',	202,	0,	500 ),
('E3',	'DS2',	Null,	'cat3',	'cat3gmail.com',	203,	0,	500 ),
('E4',	'DS1',	'M1',	'cat4',	'cat4gmail.com',	204,	1,	2000 ),
('E5',	'DS2',	'M2',	'cat5',	'cat5gmail.com',	205,	1,	2000 );

insert into `Login`
values(	'L1',	'E1',	'PS1'	 ),
(	'L2',	'E2',	'PS2'	 ),
(	'L3',	'E3',	'PS3'	 ),
(	'L4',	'E4',	'PS4'	 ),
(	'L5',	'E5',	'PS5'	 );

insert into `Client`
values(	'C1',	'E1'	 ),
(	'C2',	'E3'	 ),
(	'C3',	'E2'	 ),
(	'C4',	'E2'	 ),
(	'C5',	'E1'	 );

insert into `Order`
values(	'O1',	'C1',	'D1',	'2019-10-10',	38	 ),
(	'O2',	'C1',	'D2',	'2019-10-10',	38	 ),
(	'O3',	'C1',	'D3',	'2019-10-10',	25	 ),
(	'O4',	'C2',	'D1',	'2019-10-10',	30	 ),
(	'O5',	'C2',	'D2',	'2019-10-10',	36	 ),
(	'O6',	'C2',	'D3',	'2019-10-10',	30	 ),
(	'O7',	'C3',	'D1',	'2019-10-10',	29	 ),
(	'O8',	'C3',	'D2',	'2019-10-10',	28	 ),
(	'O9',	'C3',	'D3',	'2019-10-10',	25	 ),
(	'O10',	'C4',	'D1',	'2019-10-10',	22	 ),
(	'O11',	'C4',	'D2',	'2019-10-10',	39	 ),
(	'O12',	'C4',	'D3',	'2019-10-10',	33	 ),
(	'O13',	'C5',	'D1',	'2019-10-10',	21	 ),
(	'O14',	'C5',	'D2',	'2019-10-10',	30	 ),
(	'O15',	'C5',	'D3',	'2019-10-10',	22	 );
