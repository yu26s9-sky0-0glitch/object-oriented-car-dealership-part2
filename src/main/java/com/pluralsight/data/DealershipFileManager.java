package com.pluralsight.data;
import com.pluralsight.entities.Dealership;
import com.pluralsight.entities.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class DealershipFileManager {
    /**
     * reads the csv and loads it into dealership
     * @return dealership object
     */
    public Dealership getDealership() {

        Dealership dealership = null;
        try {
            FileReader fr = new FileReader("data/inventory.csv");
            BufferedReader bf = new BufferedReader(fr);
            String headline = bf.readLine();
            String[] headParts = headline.split("\\|");
            dealership = new Dealership(headParts[0], headParts[1], headParts[2]);
            String line;
            while ((line = bf.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);
                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(v);

            }
            bf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dealership;
    }

    /**
     * gets all vehicle and rewrites the csv
     * @param dealership accepts the dealership inventory
     */
    public void saveDealership(Dealership dealership){
        try{
        FileWriter fw = new FileWriter("data/inventory.csv");
            String header = String.format("%s|%s|%s\n",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone());
            fw.write(header);
        for (Vehicle v:dealership.getAllVehicle()){
            String line = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                    v.getVin(),v.getYear(),v.getMake(),v.getModel(),v.getVehicleType(),v.getColor(),v.getOdometer(),v.getPrice());
            fw.write(line);
        }
        fw.close();
        }catch (Exception e){
            System.out.println("Could not save the dealership to the file: "+ e.getMessage());
        }
    }
}
