use spring_formation;

CREATE TABLE student
(
age int,
`name` VARCHAR(255),
id int
);

ALTER TABLE student ADD CONSTRAINT PRIMARY KEY(id);

alter table student auto_increment = 1, modify id int auto_increment;

SELECT * FROM student;