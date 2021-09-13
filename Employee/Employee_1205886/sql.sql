create table employee_1291704(
id number(5),
name varchar2(15),
designation varchar2(15),
ssnNo number(5)primary key,
age number(5),
salary number(7,2)
);


create table account_1291704(
no number(5)primary key,
type varchar2(15),
balance number(7,2),
ssnNo references employee_1291704(ssnNo));

select * from employee_1291704;
select * from account_1291704;
drop table employee_1291704;
drop table account_1291704;



insert into employee_1291704 values(1,'sima','asee',44,23,8000.00);
insert into employee_1291704 values(2,'mima','see',84,33,9000.00);

insert into account_1291704 values(11,'savings',8000.00,44);
insert into account_1291704 values(12,'current',8000.00,44);
insert into account_1291704 values(13,'current',8000.00,84);





)