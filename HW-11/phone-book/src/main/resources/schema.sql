DROP TABLE IF EXISTS abonents;
CREATE TABLE IF NOT EXISTS abonents (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null,
    phone LONG not null,
    address VARCHAR(255) not null
);
