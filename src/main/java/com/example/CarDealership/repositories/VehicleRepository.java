package com.example.CarDealership.repositories;

import com.example.CarDealership.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    @Autowired
    private DataSource dataSource;

    public List<Vehicle> getAllVehicles() {
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                vehicles.add(mapRowToVehicles(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByPriceRange(double min, double max) {
        String query = "SELECT * FROM vehicles WHERE price >= ? AND price <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, min);
            ps.setDouble(2, max);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(mapRowToVehicles(rs));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesBMakeModel(String make, String model) {
        String query = "SELECT * FROM vehicles WHERE LOWER(vehicles.make) = ? AND LOWER(vehicles.model) = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, make.toLowerCase());
            ps.setString(2, model.toLowerCase());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(mapRowToVehicles(rs));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    private Vehicle mapRowToVehicles(ResultSet rs) throws SQLException {
        int vehicleId = rs.getInt("vehicle_id");
        String vin = rs.getString("vin");
        Boolean sold = rs.getBoolean("sold");
        String color = rs.getString("color");
        String make = rs.getString("make");
        String model = rs.getString("model");
        int year = rs.getInt("year");
        int miles = rs.getInt("miles");
        double price = rs.getDouble("price");
        Vehicle v = new Vehicle(vehicleId, vin, sold, color, make, model, year, miles, price);
        return v;
    }
}
