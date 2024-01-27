insert into users (username, password, email, role)
values ('Иванов', '1236546', 'ivan@mail.ru', 'jhgjhgjk'),
       ('Петров', '7654656', 'petr@mail.ru', 'ghfhgfh'),
       ('Сидоров', '7657655', 'sidor@mail.ru', 'poipipojkl');

insert into projects (name, description, created_date)
values ('Proj1', 'Description proj1', '2024-01-25 10:00:00'),
       ('Proj2', 'Description proj2', '2024-01-25 12:00:00'),
       ('Proj3', 'Description proj3', '2024-01-25 15:00:00');

insert into users_project (project_id, user_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (2, 1),
       (2, 3),
       (3, 2);