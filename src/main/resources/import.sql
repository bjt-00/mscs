--Sample input data
	
insert into eafp_db.car (manufacturer, car_model, plate_no, year, color, speed, rent_per_hour, status) values('Honda', 'Chevy', 'IA30343', 2011, 'Blue', 250, 4, 'AVAILABLE');	
insert into eafp_db.car (manufacturer, car_model, plate_no, year, color, speed, rent_per_hour, status) values('Honda', 'CRV', 'IA10340', 2016, 'Green', 200, 5, 'AVAILABLE');
insert into eafp_db.account (id,username, password, role, active) values(0,'abdul', 'abdul', 'ADMIN',1); 
insert into eafp_db.address (id,city, state, zip, address) values(0, 'Fairfield', 'Iowa', '52557', '1000 N 4th Street'); 
insert into eafp_db.user (id,address_id, account_id, phone, last_name, first_name, email) values(0,1, 1, '872 000', 'Kareem', 'Abdul', 'abdul@gmail.com'); 
insert into eafp_db.account (id,username, password, role, active) values(0,'khemroat', 'khemroat', 'USER',1); 
insert into eafp_db.address (id,city, state, zip, address) values(0, 'Fairfield', 'Iowa', '52557', '1000 N 4th Street'); 
insert into eafp_db.user (id,address_id, account_id, phone, last_name, first_name, email) values(0,2, 2, '872 000', 'Loem', 'Khemroat', 'khemroat@gmail.com'); 
insert into eafp_db.account (id,username, password, role, active) values(0,'santosh', 'santosh', 'USER',1); 
insert into eafp_db.address (id,city, state, zip, address) values(0, 'Fairfield', 'Iowa', '52557', '1000 N 4th Street'); 
insert into eafp_db.user (id,address_id, account_id, phone, last_name, first_name, email) values(0,3, 3, '872 000', 'Karki', 'Santosh', 'santosh@gmail.com'); 
