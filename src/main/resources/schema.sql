create schema hibernate;

create table hibernate.persons
(
    name           varchar(255),
    surname        varchar(255),
    age            int          not null,
    phone_number   varchar(255) not null,
    city_of_living varchar(255) default 'Russia',
    primary key (name, surname, age)
);

insert into hibernate.persons (name, surname, age, phone_number, city_of_living)
VALUES ('Иван', 'Петров', 27, +65764989, 'Moscow'),
       ('Николай', 'Шишкин', 65, +69879007, 'Irkutsk'),
       ('Каземир', 'Зорин', 33, +18684855, 'Vladimir');