create table Emp_77(
id number(10),
name varchar(15),
ssnNo number(10)primary key,
address varchar(15),
salary number(7,2)
);
select * from Emp_77;
drop table Emp_77;
 

insert into Emp_77 values(1,'mani',77,'kulti',7700.00);
insert into Emp_77 values(2,'kani',88,'tvm',8000.00);
insert into Emp_77 values(3,'bani',99,'college',9000.00);