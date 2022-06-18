INSERT INTO USER_TBL(USER_ID, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL_ADDRESS, DATE_OF_BIRTH, USER_NAME, PASSWORD, ENABLED) VALUES (1, 'David', 'Solomon', '12 City Street Nashua, NH 03063', 'dsol@gmail.com', '1984-05-24', 'dsol', '$2a$10$VqzDJ0XCIkcT3.K9YkYrt.yji1WeYyiFWpIJOjnu5U6clg39qKZ1G', true);
INSERT INTO USER_TBL(USER_ID, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL_ADDRESS, DATE_OF_BIRTH, USER_NAME, PASSWORD,ENABLED) VALUES (2, 'Becky', 'Solomon', '12 City Street Nashua, NH 03063', 'bsol@gmail.com', '1984-05-24', 'bsol', '$2a$10$AVO0bJcV3TdX6d0A9b03YOTSmow.sZmmBueDQHjR7YXtqrPP8MJXK', true);

INSERT INTO ROLE_TBL(ROLE_ID, ROLE_NAME) VALUES (1, 'admin');
INSERT INTO ROLE_TBL(ROLE_ID, ROLE_NAME) VALUES (2, 'user');

INSERT INTO USER_ROLE_TBL(USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO USER_ROLE_TBL(USER_ID, ROLE_ID) VALUES (2, 2);

INSERT INTO ACCOUNT_TBL(ACCOUNT_ID, ACCOUNT_NUMBER, ACCOUNT_NAME, USER_ID, FUNDS_AVAILABLE) VALUES (1, 'BSOL-1', 'BOA Account', 2, 1000.00);

INSERT INTO MEDICINE_TBL(MEDICINE_ID, MEDICINE_NAME, MANUFACTURER, USES, PRICE, DISCOUNT, QUANTITY, EXPIRATION_DATE) VALUES (1, 'Amoxicillin', 'Bristol-Myers', 'Infection Control', 500.00, '0.00', 200, '2023-09-01');
INSERT INTO MEDICINE_TBL(MEDICINE_ID, MEDICINE_NAME, MANUFACTURER, USES, PRICE, DISCOUNT, QUANTITY, EXPIRATION_DATE) VALUES (2, 'Advil', 'AbbotLabs', 'Pain Management', 20.00, '0.00', 200, '2025-01-01');
INSERT INTO MEDICINE_TBL(MEDICINE_ID, MEDICINE_NAME, MANUFACTURER, USES, PRICE, DISCOUNT, QUANTITY, EXPIRATION_DATE) VALUES (3, 'Enresto', 'Novartis', 'Heart Failure', 50.00, '0.00', 200, '2023-09-01');
INSERT INTO MEDICINE_TBL(MEDICINE_ID, MEDICINE_NAME, MANUFACTURER, USES, PRICE, DISCOUNT, QUANTITY, EXPIRATION_DATE) VALUES (4, 'Tylenol', 'Johnson and Johnson', 'Pain Management', 50.00, '0.00', 500, '2023-10-01');

INSERT INTO ORDER_TBL(ORDER_ID, ORDER_NUMBER, USER_ID, MEDICINE_ID, ORDER_QTY, TOTAL, STATUS) VALUES (1, '30001', 2, 1, 3, 1500.00, 'Ordered');
INSERT INTO ORDER_TBL(ORDER_ID, ORDER_NUMBER, USER_ID, MEDICINE_ID, ORDER_QTY, TOTAL, STATUS) VALUES (2, '30002', 2, 2, 4, 80.00, 'Shipped');
INSERT INTO ORDER_TBL(ORDER_ID, ORDER_NUMBER, USER_ID, MEDICINE_ID, ORDER_QTY, TOTAL, STATUS) VALUES (3, '30003', 2, 3, 1, 50.00, 'Delivered');

INSERT INTO CART_TBL(CART_ID, MEDICINE_ID, USER_ID, QUANTITY_ORDERED) VALUES (1001, 1, 2, 3);



