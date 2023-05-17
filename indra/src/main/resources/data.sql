INSERT INTO brand (id, name) VALUES (1, 'ZARA');

INSERT INTO product (id) VALUES (35455);

INSERT INTO price_rate (id) VALUES (1);
INSERT INTO price_rate (id) VALUES (2);
INSERT INTO price_rate (id) VALUES (3);
INSERT INTO price_rate (id) VALUES (4);


INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, 1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (2, 1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (3, 1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO price (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (4, 1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 4, 35455, 1, 38.95, 'EUR');
