CREATE TABLE student(
sid int,
name varchar(255),
password varchar(255),
PRIMARY KEY(sid)
);

CREATE TABLE book(
bookid int,
title varchar(255),
author varchar(255),
number int,
PRIMARY KEY(bookid)
);

CREATE TABLE borrowing(
id int AUTO_INCREMENT,
sid int,
name varchar(255),
bookid int,
title varchar(255),
number int,
due DATE
status varchar(255),
PRIMARY KEY(id),
FOREIGN KEY(sid) REFERENCES student(sid),
FOREIGN KEY(bookid) REFERENCES book(bookid)
);

INSERT INTO book VALUES (1,"Zen and the Art of Motorcycle Maintenance","Robert M. Pirsig"), (2,"Watership Down","Richard Adams")
