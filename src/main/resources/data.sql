
INSERT INTO accounts (account_id, role, name, email, password)
VALUES (1, 'admin', 'John Doe', 'johndoe@example.com', 'password1'),
       (2, 'owner', 'Jane Doe', 'janedoe@example.com', 'password2'),
       (3, 'customer', 'Bob Smith', 'bobsmith@example.com', 'password3'),
       (4, 'admin', 'Alice Johnson', 'alicejohnson@example.com', 'password4'),
       (5, 'owner', 'Tom Brown', 'tombrown@example.com', 'password5'),
       (6, 'customer', 'Samantha Lee', 'samanthalee@example.com', 'password6'),
       (7, 'admin', 'David Kim', 'davidkim@example.com', 'password7'),
       (8, 'owner', 'Emily Chen', 'emilychen@example.com', 'password8'),
       (9, 'customer', 'Michael Davis', 'michaeldavis@example.com', 'password9'),
       (10,'admin','Jessica Lee','jessicalee@example.com','password10');

INSERT INTO property (id,status, views, location, property_type, room_no, price,owner_account_id)
VALUES
       (1,'AVAILABLE', 100, 'Seattle', 'DUPLEX', 2, 2000,1),
       (2,'PENDING', 200, 'Bellevue', 'CONDO', 3, 3000,2),
       (3,'CONTINGENT', 300, 'Redmond', 'HOUSE', 4, 4000,3),
       (4,'AVAILABLE', 400, 'Kirkland', 'CONDO', 5, 5000,4),
       (5,'PENDING', 500, 'Issaquah', 'DUPLEX', 6, 6000,5);
-- --
--
-- UPDATE property
-- SET status = CASE
--                     WHEN RAND() < 0.25 THEN 'AVAILABLE'
--                     WHEN RAND() < 0.5 THEN 'PENDING'
--                     WHEN RAND() < 0.75 THEN 'CONTINGENT'
--                     ELSE 'SOLD'
--        END,
--     property_type = CASE
--                           WHEN RAND() < 0.33 THEN 'CONDO'
--                           WHEN RAND() < 0.67 THEN 'DUPLEX'
--                           ELSE 'HOUSE'
--            END;