
insert ignore into sec_group(groupname, groupdesc) values('ADMIN','This group contains admins.');
insert ignore into sec_group(groupname, groupdesc) values('CUSTOMER','This group contains customers.');

insert ignore into sec_user(username, password) values('admin1','admin1'); 
insert ignore into sec_user(username, password) values('admin2','admin2'); 
insert ignore into sec_user(username, password) values('customer1','customer1'); 
insert ignore into sec_user(username, password) values('customer2','customer2'); 

insert ignore into sec_user_groups(username, groupname) values('admin1','ADMIN');
insert ignore into sec_user_groups(username, groupname) values('admin2','ADMIN');
insert ignore into sec_user_groups(username, groupname) values('customer1','CUSTOMER');
insert ignore into sec_user_groups(username, groupname) values('customer2','CUSTOMER');

insert into admins(firstname, lastname,email, designation, storeLocation, username) values ('Gom', 'Sam' , 'abc@abc.com', 'Owner', 'Napervile, Chicago','admin1');
insert into customer(firstname, middlename, lastname, email, gender, username) values ('Abc', 'Def', 'Xyz', 'd@abc.com', 'Male', 'customer1');