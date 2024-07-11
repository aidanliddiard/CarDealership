package com.example.CarDealership.models;

public class Dealership {
    private int dealershipId;
    private String name;
    private String address;
    private String phone;

    public Dealership(int dealershipId, String name, String address, String phone) {
        this.dealershipId = dealershipId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("\u001b[38;5;124m\nDealership:\u001b[0m %d," +
                "\u001b[38;5;162m\nName:\u001b[0m %s" +
                "\u001b[38;5;169m\nAddress:\u001b[0m %s" +
                "\u001b[38;5;218m\nPhone:\u001b[0m %s",
                this.dealershipId, this.name, this. address, this.phone);
    }
}
