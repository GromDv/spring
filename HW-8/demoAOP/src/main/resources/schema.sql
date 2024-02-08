DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) not null,
    password VARCHAR(255) not null,
    email VARCHAR(255) not null,
    role VARCHAR(255) not null,
    pay_account DECIMAL
);
DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) not null,
    description VARCHAR(255) not null,
    price DECIMAL,
    quantity INT
);
DROP TABLE IF EXISTS product_actions;
CREATE TABLE IF NOT EXISTS product_actions (
    id  SERIAL PRIMARY KEY,
    product_id INT not null,
    user_id INT not null,
    quantity INT not null,
    type_tr VARCHAR(100)
);
DROP TABLE IF EXISTS money_actions;
CREATE TABLE IF NOT EXISTS money_actions (
    id  SERIAL PRIMARY KEY,
    from_user_id INT not null,
    to_user_id INT not null,
    amount DECIMAL not null
);