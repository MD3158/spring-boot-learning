CREATE TABLE student
(
    id              BIGINT       NOT NULL,
    name            VARCHAR(255) NULL,
    passport_number VARCHAR(255) NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);
insert into student
values(10001,'Ranga', 'E1234567');

insert into student
values(10002,'Ravi', 'A1234568');