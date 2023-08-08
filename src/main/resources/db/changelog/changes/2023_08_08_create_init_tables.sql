create table users(
    id SERIAL PRIMARY KEY,
    birth_year date,
    created_at timestamp,
    email varchar(255),
    first_phone varchar(255),
    full_name varchar(255),
    password varchar(255),
    second_phone varchar(255)
);