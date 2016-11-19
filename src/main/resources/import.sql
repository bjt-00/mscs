--Sample input data
-- create table car (id bigint not null auto_increment, color varchar(255), 
--manufacturer varchar(255), model varchar(255), plate_no varchar(255), speed integer not null, status smallint not null, 
--year integer not null, primary key (id))
	
insert into test.car (manufacturer, car_model, plate_no, year, color, speed, status)
	values('Honda', 'Chevy', 'IA30343', 2011, 'Blue', 250, 0); 
	
insert into test.car (manufacturer, car_model, plate_no, year, color, speed, status)
	values('Honda', 'CRV', 'IA30343', 2016, 'Blue', 250, 0); 