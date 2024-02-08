insert into users (username, password, email, role, pay_account)
values ('admin', '654654654', 'store@store.ru', 'SHOP', 0),
       ('Иванов', '1236546', 'ivan@mail.ru', 'customer', 1000),
       ('Петров', '7654656', 'petr@mail.ru', 'customer', 2000),
       ('Сидоров', '7657655', 'sidor@mail.ru', 'customer',3000);

insert into products (title, description, price, quantity)
values ('Prod1', 'Description1', 50, 100),
       ('Prod2', 'Description2', 150, 100),
       ('Prod3', 'Description3', 500, 100);

insert into product_actions (product_id, user_id, quantity, type_tr)
values (1, 1, 100, 'stock');

