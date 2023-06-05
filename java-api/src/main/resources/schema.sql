DROP TABLE IF EXISTS owners;

CREATE TABLE owners (
owner_id INT NOT NULL primary key,
name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS dogs;
  
CREATE TABLE dogs (
dog_id INT NOT NULL,
name VARCHAR(250) NOT NULL,
age INT NOT NULL,
owner_id INT NOT NULL,
FOREIGN key
    (owner_id) REFERENCES owners (owner_id)
);

create view dogs_n_owners as
select o.name as Owner, d.name as Dog
from dogs as d inner join owners as o on d.owner_id = o.owner_id;
