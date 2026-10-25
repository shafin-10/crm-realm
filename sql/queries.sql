-- Database: PostgreSQL
-- Assumption: The leads table contains id, name, email, and score columns.
-- Priority: HOT (80-100), WARM (50-79), COLD (0-49).

-- Retrieve all HOT leads
SELECT *
FROM leads
WHERE score >= 80;

/*
Count the number of leads
in each priority group.
*/
SELECT
    CASE
        WHEN score >= 80 THEN 'HOT'
        WHEN score >= 50 THEN 'WARM'
        ELSE 'COLD'
    END AS priority,
    COUNT(*) AS total
FROM leads
GROUP BY priority;