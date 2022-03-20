use CustomerRelationshipManagement;

drop table Customer;
create Table customer( id int primary key AUTO_INCREMENT,FirstName varchar(50),LastName varchar(50),Email varchar(50));

insert into Customer (FirstName,LastName,Email) values ("Nagaraj","KM","nagrajkm3@gmail.com");
insert into Customer (FirstName,LastName,Email) values ("Akshaya","KA","akshayka95@gmail.com");


select * from Customer;




