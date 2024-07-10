package com.example.CarDealership.models;

public class Vehicle {
    private int vehicle_id;
    private String vin;
    private Boolean sold;
    private String color;
    private String make;
    private String model;
    private int year;
    private int miles;
    private double price;

    public Vehicle(int vehicle_id, String vin, Boolean sold, String color, String make, String model, int year, int miles, double price) {
        this.vehicle_id = vehicle_id;
        this.vin = vin;
        this.sold = sold;
        this.color = color;
        this.make = make;
        this.model = model;
        this.year = year;
        this.miles = miles;
        this.price = price;
    }

    @Override
    public String toString() {
        return (this.vehicle_id + ", " +
                this.vin + ", " +
                this.sold + ", " +
                this.color + ", " +
                this.make + ", " +
                this.model + ", " +
                this.year + ", " +
                this.miles + ", " +
                this.price);
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
