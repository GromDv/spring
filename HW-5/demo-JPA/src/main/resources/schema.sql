DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) not null,
    status VARCHAR(50) not null,
    date_create VARCHAR(50) not null
);
