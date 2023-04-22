-- Active: 1667546791847@@127.0.0.1@3306@ebsystem

use ebsystem;

-- Create table
create table login(
    meter_no varchar(20),
    username varchar(20),
    name varchar(30),
    password varchar(20),
    user varchar(20)
);

select * from login;

drop table login;