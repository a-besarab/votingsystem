DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM restaurants;
DELETE
FROM dishes;
DELETE
FROM votes;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password, role)
VALUES ('User', 'user@yandex.ru', 'password', 'ROLE_USER'),
       ('Admin', 'admin@gmail.com', 'admin', 'ROLE_ADMIN');
-- User 100000
-- Admin 100001

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001);
-- ('ROLE_USER', 100001);

INSERT INTO restaurants(name, address, phone)
VALUES ('tuesday', 'address_tuesday', +7222),
       ('wednesday', 'address_wednesday', +7333),
       ('thursday', 'address_thursday', +7444),
       ('friday', 'address_friday', +7555);
-- tuesday 100002
-- wednesday 100003
-- thursday 100004
-- friday 100005

INSERT INTO dishes (name, price, restaurant_id, date)
VALUES ('cola1', 500, 100002, '2019-04-8'),
       ('chips1', 600, 100002, '2019-04-8'),
       ('coffee1', 800, 100003, '2019-04-8'),
       ('cake1', 900, 100003, '2019-04-8'),
       ('cola2', 550, 100004, '2019-04-9'),
       ('chips2', 650, 100004, '2019-04-9'),
       ('coffee2', 750, 100005, '2019-04-9'),
       ('cake2', 850, 100005, '2019-04-9'),
       ('cola3', 950, 100002, '2019-04-10'),
       ('chips3', 650, 100002, '2019-04-10'),
       ('coffee3', 750, 100003, '2019-04-10'),
       ('cake3', 350, 100003, '2019-04-10'),
       ('cola4', 336, 100004, '2019-04-11'),
       ('chips4', 250, 100004, '2019-04-11'),
       ('coffee4', 960, 100005, '2019-04-11'),
       ('cake4', 660, 100005, '2019-04-11');

INSERT INTO votes (date, user_id, restaurant_id)
VALUES ('2019-04-8', 100000, 100002),
       ('2019-04-8', 100001, 100002),
       ('2019-04-9', 100000, 100004),
       ('2019-04-9', 100001, 100005),
       ('2019-04-10', 100000, 100003),
       ('2019-04-10', 100001, 100003),
       ('2019-04-11', 100000, 100004),
       ('2019-04-11', 100001, 100005);