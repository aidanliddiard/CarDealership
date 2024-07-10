SELECT * FROM dealerships;

SELECT *
FROM vehicles
JOIN inventory ON vehicles.vehicle_id = inventory.vehicle_id
JOIN dealerships ON inventory.dealership_id = dealerships.dealership_id
WHERE dealerships.dealership_id = 3;

SELECT * FROM vehicles WHERE vin = '1HGCM82633A123457';

SELECT *
FROM dealerships
JOIN inventory ON dealerships.dealership_id = inventory.dealership_id
JOIN vehicles ON inventory.vehicle_id = vehicles.vehicle_id
WHERE vehicles.make = 'Honda';

SELECT *
FROM sales_contracts
JOIN inventory ON sales_contracts.vehicle_id = inventory.vehicle_id
WHERE date BETWEEN '2021-01-01' AND '2021-02-01';