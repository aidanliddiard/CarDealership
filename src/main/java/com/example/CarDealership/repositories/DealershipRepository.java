package com.example.CarDealership.repositories;

import com.example.CarDealership.models.Dealership;
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
public class DealershipRepository {

    @Autowired
    private DataSource dataSource;

    public List<Dealership> getAllDealerships(){
        String query = "SELECT * FROM dealerships";
        List<Dealership> dealerships = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                dealerships.add(mapRowToDealership(rs));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return dealerships;
    }

    private Dealership mapRowToDealership(ResultSet rs) throws SQLException {
        int dealershipId = rs.getInt("dealership_id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        Dealership d = new Dealership(dealershipId, name, address, phone);
        return d;
    }
}
