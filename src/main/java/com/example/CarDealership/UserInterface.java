package com.example.CarDealership;

import com.example.CarDealership.models.Vehicle;
import com.example.CarDealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private VehicleRepository vehicleRepository;

    public void makeSelection(){
        System.out.printf("""
                Please select an option:\s
                (1) See all cars
                (2) Select cars by price range
                (3) Select cars by make and model
                (4) Select cars by year range
                (5) Select cars by color
                (6) Select cars by mileage range
                (7) Select not sold cars
                (99) Exit""");
        int selection = scanner.nextInt();
        scanner.nextLine();
        displaySelection(selection);
    }

    private void displaySelection(int selection) {
        switch (selection) {
            case 1:
                System.out.println("All Vehicles:");
                List<Vehicle> vehicleList = vehicleRepository.getAllVehicles();
                vehicleList.forEach(System.out::println);
                break;
            case 2:
                System.out.println("Min price:");
                double min = scanner.nextDouble();
                System.out.println("Max price:");
                double max = scanner.nextDouble();
                List<Vehicle> vehiclesByPriceRange = vehicleRepository.getVehiclesByPriceRange(min, max);
                vehiclesByPriceRange.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Make:");
                String make = scanner.next();
                System.out.println("Model:");
                String model = scanner.next();
                List<Vehicle> vehiclesByMakeModel = vehicleRepository.getVehiclesByMakeModel(make, model);
                vehiclesByMakeModel.forEach(System.out::println);
                break;
            case 4:
                System.out.println("Min year:");
                double minYear = scanner.nextDouble();
                System.out.println("Max year:");
                double maxYear = scanner.nextDouble();
                List<Vehicle> vehiclesByAgeRange = vehicleRepository.getVehiclesByYearRange(minYear, maxYear);
                vehiclesByAgeRange.forEach(System.out::println);
                break;
            case 5:
                System.out.println("Color:");
                String color = scanner.next();
                List<Vehicle> vehiclesByColor = vehicleRepository.getVehiclesByColor(color);
                vehiclesByColor.forEach(System.out::println);
                break;
            case 6:
                System.out.println("Min mileage:");
                double minMileage = scanner.nextDouble();
                System.out.println("Max mileage:");
                double maxMileage = scanner.nextDouble();
                List<Vehicle> vehiclesByMileageRange = vehicleRepository.getVehiclesByMileageRange(minMileage, maxMileage);
                vehiclesByMileageRange.forEach(System.out::println);
                break;
            case 7:
                System.out.println("See not sold vehicles? (Type yes to see and anything else to quit)");
                String resp = scanner.next();
                if (resp.equalsIgnoreCase("yes")) {
                    List<Vehicle> vehiclesNotSold = vehicleRepository.getVehiclesNotSold();
                    vehiclesNotSold.forEach(System.out::println);
                } else System.out.println("No vehicles available. Please check again soon :)");
                break;
            case 99:
                System.out.println("Exiting...");
                System.exit(0);
        }
    }
}
