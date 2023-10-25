# Microservices Demo

# Containers yang dibutuhkan

- Kafka
- Zookeeper
- RabbitMQ
- Zipkin
- Postgres
- pgadmin

# Services
- API-Gateway
- Clients
- Config-Server
- Customer-Service
- Eureka-Server
- Fraud-Service
- Notification-Service
- RabbitMQ


```bash
-- Retrieve all rows where the 'name' column starts with 'John':
SELECT * FROM employees WHERE name LIKE 'John%';

-- Retrieve all rows where the 'email' column contains 'example.com':
SELECT * FROM users WHERE email LIKE '%example.com%';

-- Retrieve all rows where the 'code' column has 'A' as the second character:
SELECT * FROM products WHERE code LIKE '_A%';

-- Retrieve all rows where the 'city' column starts with 'New' and is followed by any character:
SELECT * FROM locations WHERE city LIKE 'New_';

-- Retrieve all rows where the 'category' column starts with a vowel:
SELECT * FROM items WHERE category LIKE '[aeiou]%';

-- Retrieve all rows where the 'code' column starts with an uppercase letter:
SELECT * FROM products WHERE code LIKE '[A-Z]%';
```