drop database if exists OnlineBookSystem;

create database OnlineBookSystem;

use OnlineBookSystem;

create table USER_ACCOUNT (

	`id` int primary key auto_increment,
    `username` varchar(20) not null unique,
    `password` varchar(20) not null,
    `email` varchar(200)
);

insert into USER_ACCOUNT ( username,password,email) values ('admin', 'admin', 'admin@admin.com');

