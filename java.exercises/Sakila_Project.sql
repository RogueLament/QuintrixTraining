-- Create a new branch called f-sql
-- Create a file called Sakila_Project.sql

-- Sakila Database

-- Write a SQL statement for each of the following. 

-- 1. Get 10 cities in descending alphabetical order.
SELECT * FROM CITY ORDER BY city DESC
LIMIT 10;

-- 2. Get all films with "airplane" in the title.
SELECT * FROM film 
WHERE title LIKE '%airplane%';

-- 3. Get the highest payment amount.
SELECT MAX(amount) FROM payment;

-- 4. Get the number of records in the customer table for store id #1.
SELECT COUNT(store_id) FROM customer
WHERE store_id=1;

-- 5. Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"
SELECT payment.* FROM payment JOIN customer ON payment.customer_id = customer.customer_id 
WHERE customer.email = 'NANCY.THOMAS@sakilacustomer.org';

-- 6. Use a View to get the film info for actor Bob Fawcett.
-- original answer I had for this question
/*
CREATE VIEW bob_fawcett
AS SELECT f.*
FROM actor a 
JOIN film_actor fa ON fa.actor_id = a.actor_id
JOIN film f ON fa.film_id = f.film_id
WHERE fa.actor_id = (SELECT actor_id FROM actor WHERE first_name = "Bob" AND last_name = "Fawcett");
*/

-- real answer
SELECT film_info FROM actor_info WHERE first_name = "Bob" AND last_name = "Fawcett";

-- 7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 
-- original answer I made before finding the included stored procedures, it works and I couldn't find a way to use the stored procedures
DELIMITER $$
CREATE PROCEDURE SelectTitleAndStore(IN title char(30),IN store_id INT)
BEGIN
	SELECT i.* FROM inventory i
	JOIN film f ON i.film_id = f.film_id
	WHERE f.title = title AND i.store_id = store_id;
END $$
DELIMITER ;

CALL SelectTitleAndStore("Alien Center", 2);

-- Tried to use one of the include store procedures but none of them return an inventory id or anything I could use to find an inventory id
/*
CALL film_in_stock((SELECT film_id FROM film WHERE title = "Alien Center"), 2, @ac);
SELECT @ac;
*/
-- 8. Insert a new store. Ensure that you use TRANSACTION. (This one is possible but its tough! Pay attention to constraints and the order that you are inserting data.) 
START TRANSACTION;
INSERT INTO address(address, district, city_id, postal_code, Phone, location)
VALUES ("55 Fake Lane", "Mxico", 365, 75149, 5555555555,POINT(0,0));
INSERT INTO staff(first_name, last_name, address_id, email, store_id, active, username)
VALUES ("Test", "Manager", (SELECT MAX(address_id) FROM address), "Test.Manager@sakilastaff.com", 1, 1, "Test");
INSERT INTO address(address, district, city_id, postal_code, Phone, location)
VALUES ("56 Fake Lane", "Mxico", 365, 75149, 5555555556,POINT(0,0));
INSERT INTO store(manager_staff_id, address_id)
VALUES((SELECT MAX(staff_id) FROM staff), (SELECT MAX(address_id) FROM address));
UPDATE staff
SET store_id = (SELECT MAX(store_id) FROM store)
WHERE first_name = "Test"
ORDER BY staff_id DESC
LIMIT 1;
COMMIT;

-- 9. Update the timestamp to the current date/time for the new store you entered in the previous question. 
UPDATE store set last_update = CURRENT_TIMESTAMP
WHERE store_id > 2;

-- 10. Delete the new store. 
START TRANSACTION;
UPDATE staff
SET active = 0
WHERE first_name = "Test"
ORDER BY staff_id DESC
LIMIT 1;
SET foreign_key_checks = 0;
DELETE FROM store WHERE store_id > 2;
SET foreign_key_checks = 1;
COMMIT;

-- 11. Using one SQL statement, get how many films are there in each rating category.
SELECT category_id, COUNT(*) FROM film_category GROUP BY category_id;

-- 12. Get (in order) the first and last names of the 3 customers who have spent the most, along with how much they have paid overall.
SELECT c.first_name, c.last_name, SUM(p.amount) a FROM payment p 
JOIN customer c ON p.customer_id = c.customer_id 
GROUP BY p.customer_id 
ORDER BY a DESC
LIMIT 3;

-- 13. Get all movies rented by the customer who spent the most. (Hint: This will either require nested queries, or more than two joins. one approach is much shorter than the other.)
SELECT f.title FROM customer_list c
JOIN rental r ON c.ID = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film_list f ON i.film_id = f.FID
WHERE c.ID = (
	SELECT c.ID FROM customer_list c 
    JOIN payment p ON c.ID = p.customer_id
	GROUP BY p.customer_id 
	ORDER BY SUM(amount) DESC
	LIMIT 1
    )
ORDER BY f.title;

-- 14. Get the first and last names of all customers who spent more than $150, along with how much they spent.
SELECT c.name, SUM(amount) a FROM payment p 
JOIN customer_list c ON p.customer_id = c.ID
GROUP BY p.customer_id
HAVING SUM(amount) >= 150
ORDER BY a DESC;

-- Do not hard code IDs.

-- https://dev.mysql.com/doc/sakila/en/sakila-introduction.html

-- Schema Diagram:
-- https://www.jooq.org/sakila#:~:text=The%20Sakila%20database%20is%20a,films%2C%20stores%2C%20and%20rentals.