package com.pluralsight.entities;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();

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

    /**
     * sorts the vehicle to be within the price range
     * @param min the start of price range
     * @param max the end of price range
     * @return arraylist of qualified vehicles
     */
    public ArrayList<Vehicle> getVehicleByPrice (double min,double max){
        ArrayList<Vehicle> matched = new ArrayList<>();
        for(Vehicle v:inventory){
            if (v.getPrice()>=min && v.getPrice()<=max){
                matched.add(v);
            }
        }
        return matched;
    }

    /**
     * finds the vehicle with requested make and model
     * @param make make of the car
     * @param model model of car
     * @return arraylist of matched vehicles
     */
     public ArrayList<Vehicle> getVehicleByMakeModel(String make,String model){
         ArrayList<Vehicle> matched = new ArrayList<>();
         for(Vehicle v:inventory){
             if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                 matched.add(v);
             }
         }
         return matched;
    }
    /**
     * sorts the vehicle to be within the Year range
     * @param min the start of year range
     * @param max the end of year range
     * @return arraylist of qualified vehicles
     */
     public ArrayList<Vehicle> getVehicleByYear(int min,int max){
         ArrayList<Vehicle> matched = new ArrayList<>();
         for(Vehicle v:inventory){
             if (v.getYear()>=min && v.getYear()<=max){
                 matched.add(v);
             }
         }
         return matched;
    }
    /**
     * finds the vehicle with requested color
     * @param color the color of the car
     * @return arraylist of matched vehicles
     */
     public ArrayList<Vehicle> getVehicleByColor(String color){
         ArrayList<Vehicle> matched = new ArrayList<>();
         for(Vehicle v:inventory){
             if (v.getColor().equalsIgnoreCase(color)){
                 matched.add(v);
             }
         }
         return matched;
    }
    /**
     * sorts the vehicle to be within the Mileage range
     * @param min the start of Mileage range
     * @param max the end of Mileage range
     * @return arraylist of qualified vehicles
     */
     public ArrayList<Vehicle> getVehicleByMileage(int min,int max){
         ArrayList<Vehicle> matched = new ArrayList<>();
         for(Vehicle v:inventory){
             if (v.getOdometer()>=min && v.getOdometer()<=max){
                 matched.add(v);
             }
         }
         return matched;
    }

    /**
     * finds the vehicle with requested Vehicle Type
     * @param vehicleType the type of the car(SUV, Truck,etc...)
     * @return arraylist of matched vehicles
     */
    public ArrayList<Vehicle> getVehicleByType(String vehicleType){
        ArrayList<Vehicle> matched = new ArrayList<>();
        for(Vehicle v: inventory){
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)){
                matched.add(v);
            }
        }
        return matched;
    }

    public ArrayList<Vehicle> getAllVehicle(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    public Vehicle getVehicleByVin(int vin) {
        Vehicle matched = null;
        for(Vehicle v:inventory){
            if (v.getVin()==vin){
                matched = v;
            }
        }

        return matched;
    }
}
