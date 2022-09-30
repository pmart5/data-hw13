create schema if not exists homework;

create table if not exists homework.customers (
                           id int primary key auto_increment,
                           name varchar(30) not null,
                           surname varchar(50) not null,
                           age int check (age > 0),
                           phone_number varchar(15)
);

create table if not exists homework.orders (
                        id int primary key auto_increment,
                        date datetime not null default now(),
                        customer_id int not null,
                        product_name varchar(255),
                        amount int,
                        foreign key (customer_id) references customers (id),
                        index (customer_id)
);