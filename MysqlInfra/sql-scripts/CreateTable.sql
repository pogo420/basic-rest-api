create table movie_info (
   movie_id INT,
   movie_name VARCHAR(20),
   movie_description VARCHAR(20),
   release_date DATE,
   create_date DATE,
   update_date DATE,
   PRIMARY KEY ( movie_id )
);

create table user (
   user VARCHAR(20),
   password VARCHAR(20),
   roles VARCHAR(20),
   PRIMARY KEY ( user )
);

