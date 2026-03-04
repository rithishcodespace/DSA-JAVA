# Write your MySQL query statement below
SELECT ROUND(
       COUNT(*) /
       (SELECT COUNT(DISTINCT customer_id) FROM Delivery) * 100,
       2
) AS immediate_percentage
FROM (
    SELECT customer_id
    FROM Delivery
    GROUP BY customer_id
    HAVING MIN(order_date) = MIN(customer_pref_delivery_date)
) AS t;

-- SELECT 
--     COUNT(*) /
--     (SELECT COUNT(DISTINCT customer_id) FROM Delivery) * 100
-- FROM (
--     SELECT customer_id
--     FROM Delivery
--     GROUP BY customer_id
--     HAVING MIN(order_date) = customer_pref_delivery_date
-- ) t;