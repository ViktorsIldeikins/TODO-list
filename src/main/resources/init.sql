CREATE TABLE IF Not EXISTS Tasks
(
    id int(10) NOT NULL AUTO_INCREMENT,
    person varchar(100) NOT NULL,
    task VARCHAR (100) NOT NULL,
    amountOfCoffeeCups int(10) DEFAULT 0,
    usedCoffeeCups int(10) DEFAULT 0,
    PRIMARY KEY (id)
);
