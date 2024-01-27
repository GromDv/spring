DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) not null,
    password VARCHAR(255) not null,
    email VARCHAR(255) not null,
    role VARCHAR(255) not null
);
DROP TABLE IF EXISTS projects;
CREATE TABLE IF NOT EXISTS projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) not null,
    description VARCHAR(255) not null,
    created_date timestamp    not null
);
DROP TABLE IF EXISTS users_project;
CREATE TABLE IF NOT EXISTS users_project (
    id  SERIAL PRIMARY KEY,
    project_id INT not null,
    user_id INT not null
);
