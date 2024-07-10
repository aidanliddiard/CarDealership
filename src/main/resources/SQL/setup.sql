DROP DATABASE IF EXISTS carDealership;

CREATE DATABASE carDealership;

CREATE TABLE dealerships (
    dealership_id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
    );

CREATE TABLE vehicles (
    vehicle_id SERIAL PRIMARY KEY,
    vin VARCHAR(50),
    SOLD BOOLEAN,
    color VARCHAR(50),
    make VARCHAR(50),
    model VARCHAR(50),
    year INT,
    miles INT,
    price DECIMAL(10,2)
    );

CREATE TABLE inventory (
    dealership_id INT NOT NULL,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id)
);

CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(12),
    email VARCHAR(50),
    address VARCHAR(50)
    );

CREATE TABLE sales_contracts (
    sale_id SERIAL PRIMARY KEY,
    vehicle_id INT NOT NULL,
    customer_id INT NOT NULL,
    price DECIMAL(10, 2),
    date DATE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id),
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
    );

CREATE TABLE financing (
    financing_id SERIAL PRIMARY KEY,
	sale_id INT NOT NULL,
    FOREIGN KEY (sale_id) REFERENCES sales_contracts(sale_id),
    rate DECIMAL(10, 2),
    length INT,
    down_payment DECIMAL(10, 2)
    );

INSERT INTO dealerships (name, address, phone) VALUES
('Auto World', '123 Main St', '1234567890'),
('Car Planet', '456 Elm St', '0987654321'),
('Vehicle Universe', '789 Pine St', '1122334455');

INSERT INTO vehicles (vin, sold, color, make, model, year, miles, price) VALUES
('1HGCM82633A123456', false, 'Blue', 'Toyota', 'Camry', 2018, 30000, 18000.00),
('1HGCM82633A123457', false, 'Red', 'Honda', 'Civic', 2019, 25000, 19000.00),
('1HGCM82633A123458', false, 'Black', 'Ford', 'Mustang', 2020, 5000, 25000.00);

INSERT INTO inventory (dealership_id, vehicle_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO customers (first_name, last_name, phone, email, address) VALUES
('John', 'Doe', '1234567890', 'john.doe@example.com', '123 Main St'),
('Jane', 'Smith', '0987654321', 'jane.smith@example.com', '456 Elm St'),
('Bob', 'Johnson', '1122334455', 'bob.johnson@example.com', '789 Pine St');

INSERT INTO sales_contracts (vehicle_id, customer_id, price, date) VALUES
(1, 1, 18000.00, '2021-01-01'),
(2, 2, 19000.00, '2021-02-01'),
(3, 3, 25000.00, '2021-03-01');

INSERT INTO financing (sale_id, rate, length, down_payment) VALUES
(1, 3.5, 60, 2000.00),
(2, 2.9, 48, 3000.00),
(3, 3.9, 72, 5000.00);
