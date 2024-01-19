CREATE TABLE IF NOT EXISTS userTable (
    id IDENTITY NOT NULL PRIMARY KEY,
    userName varchar(50) NOT NULL,
    userAge int NOT NULL,
    userEmail varchar(50) NOT NULL
);