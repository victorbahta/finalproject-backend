
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

-- INSERT INTO property (id,location, views, location, property_type, room_no, price,owner_account_id)
-- VALUES
--        (1,'AVAILABLE', 100, 'Seattle', 'DUPLEX', 2, 2000,1),
--        (2,'AVAILABLE', 200, 'Bellevue', 'CONDO', 3, 3000,2),
--        (3,'AVAILABLE', 300, 'Redmond', 'HOUSE', 4, 4000,3),
--        (4,'AVAILABLE', 400, 'Kirkland', 'CONDO', 5, 5000,4),
--        (5,'AVAILABLE', 500, 'Issaquah', 'DUPLEX', 6, 6000,5);
--        (6,'AVAILABLE', 600, 'Sammamish', 'Condo', 7, 7000),
--        (7,'AVAILABLE', 700, 'Bothell', 'House', 8, 8000),
--        (8,'AVAILABLE', 800, 'Renton', 'Townhouse', 9, 9000),
--        (9,'AVAILABLE', 900, 'Tacoma', 'Apartment',10,10000),
--        (10,'AVAILABLE',1000,'Kent','Condo',11,11000),
--        (11,'AVAILABLE',1100,'Auburn','House',12,12000),
--        (12,'AVAILABLE',1200,'Federal Way','Townhouse',13,13000),
--        (12,'AVAILABLE',1300,'Everett','Apartment',14,14000),
--        (14,'AVAILABLE',1400,'Lynnwood','Condo',15,15000),
--        (15,'AVAILABLE',1500,'Mill Creek','House',16,16000),
--        (16,'AVAILABLE',1600,'Woodinville','Townhouse',17,17000),
--        (17,'AVAILABLE',1700,'Shoreline','Apartment',18,18000),
--        (18,'AVAILABLE',1800,'Edmonds','Condo',19,19000),
--        (19,'AVAILABLE',1900,'Mountlake Terrace ','House ',20,20000);

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