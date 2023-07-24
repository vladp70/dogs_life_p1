DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS owner;

create table owners
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(30) NOT NULL
);

create table dogs
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(30) NOT NULL,
    age int,
    owner_id int NOT NULL,
    FOREIGN key(owner_id) REFERENCES owners (id)
);