-- You can use this file to load seed data into the database using SQL statements
-- ...if you also set hibernate.hbm2ddl.auto to a useful value 
-- in persistence.xml

insert into Member (id, name, email, phone_number, path) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212', 'johnsmith');
insert into Member (id, name, email, phone_number, path) values (1, 'Grace Hopper', 'grace@navy.mil', '2025551212', 'grace');
insert into Member (id, name, email, phone_number, path) values (2, 'Steve Ballmer', 'steve@microsoft.com', '2065551212', 'steve');

-- Data used for testing purposes (PostgreSQL):
-- 
--  id |     name      |       email       | phone_number |   path    
-- ----+---------------+-------------------+--------------+-----------
--   0 | John Smith    | bogus@example.com | 2125551212   | johnsmith
--   1 | Grace Hopper  | bogus@example.com | 2025551212   | grace
--   2 | Steve Ballmer | bogus@example.com | 2065551212   | steve
--   3 | Fred Foobar   | bogus@example.com | 9725556789   | fred
--   4 | Jane Doe      | bogus@example.com | 2135554321   | jane
--   5 | Alice Crypto  | bogus@example.com | 6025556473   | alice

