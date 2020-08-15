-- sudo mysql_secure_installation utility
-- CREATE USER 'user1'@'localhost' IDENTIFIED BY 'Mysql123';
-- GRANT ALL PRIVILEGES ON *.* TO 'user1'@'localhost' WITH GRANT OPTION;
-- FLUSH PRIVILEGES;

create database movie_rest_service;
use movie_rest_service;

-- ##########################################################################
-- movie info
create table movie_info(
   movie_id INT,
   movie_name VARCHAR(20),
   movie_description VARCHAR(20),
   release_date DATE,
   create_date DATE,
   update_date DATE,
   PRIMARY KEY ( movie_id )
);

-- sample data
insert into movie_info values(79, "DDLJ", "SRK Movie", "1990-05-01", "1990-06-09", "1990-08-11");
insert into movie_info values(9, "RHTDM", "Madhavan Movie", "1999-05-01", "1999-06-09", "1999-08-11");
insert into movie_info values(99, "KKR", "Ola Movie", "2002-05-01", "2002-06-09", "2002-08-11");

-- over all data
select * from MovieInfo;

-- ##########################################################################
-- user data
create table user(
   user VARCHAR(20),
   password VARCHAR(20),
   roles VARCHAR(20),
   PRIMARY KEY ( user )
);

-- sample data
insert into user values("arnab", "passwd1", "admin");
insert into user values("gaurav", "passwd2", "user");
