package com.example.CarDealership;

import com.example.CarDealership.models.Dealership;
import com.example.CarDealership.models.Vehicle;
import com.example.CarDealership.repositories.DealershipRepository;
import com.example.CarDealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CarDealershipApplication implements CommandLineRunner {

	@Autowired
	private DealershipRepository dealershipRepository;
	@Autowired
	private VehicleRepository vehicleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("All Dealerships:");
		List<Dealership> dealershipList = dealershipRepository.getAllDealerships();
		dealershipList.forEach(System.out::println);

		System.out.println("All Vehicles:");
		List<Vehicle> vehicleList = vehicleRepository.getAllVehicles();
		vehicleList.forEach(System.out::println);

		System.out.println("Min price:");
		double min = scanner.nextDouble();
		System.out.println("Max price:");
		double max = scanner.nextDouble();
		List<Vehicle> vehiclesByPriceRange = vehicleRepository.getVehiclesByPriceRange(min, max);
		vehiclesByPriceRange.forEach(System.out::println);

		System.out.println("Make:");
		String make = scanner.next();
		System.out.println("Model:");
		String model  = scanner.next();
		List<Vehicle> vehiclesByMakeModel = vehicleRepository.getVehiclesBMakeModel(make, model);
		vehiclesByMakeModel.forEach(System.out::println);

	}

}
