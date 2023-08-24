create database employeemanagementsystem;

show databases;



create table login(username varchar(20) ,password varchar(20));

insert into login values('admin','12345');
select * from login;

create table employee(name varchar(20), fname varchar(20), dob varchar(30), salary varchar(20), address varchar(100), phonenumber varchar(20), email varchar(20), education varchar(20), designaniton varchar(20), aadhar varchar(20), empId varchar(15)); 

show tables;

select * from employee;

execute sp_rename 'employeemanagementsystem.designaniton','designation','column';

exec sp_rename 'employee.designaniton','designation','column';