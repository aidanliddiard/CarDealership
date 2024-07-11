package com.example.CarDealership;

import com.example.CarDealership.models.Dealership;
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
    private UserInterface userInterface;

    public static void main(String[] args) {
        SpringApplication.run(CarDealershipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("All Dealerships:");
        List<Dealership> dealershipList = dealershipRepository.getAllDealerships();
        dealershipList.forEach(System.out::println);

        do userInterface.makeSelection(); while (true);
    }

}
