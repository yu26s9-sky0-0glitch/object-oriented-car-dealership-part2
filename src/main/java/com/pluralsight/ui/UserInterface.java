package com.pluralsight.ui;
import com.pluralsight.entities.Dealership;
import com.pluralsight.entities.DealershipFileManager;
import com.pluralsight.entities.Vehicle;

import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }

    /**
     * Displays the main menu and direct the user to desired sub menus
     */
    public void display(){
        init();
        int command;
        do{
            System.out.println("\n--- Welcome to " + dealership.getName() + " ---");
            command = Console.promptForInt("""
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type (car, truck, SUV, van)
                    7 - List ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit
                    -> """);
           switch (command){
            case 1:
               processGetByPriceRequest();
               break;
            case 2:
               proccessGetByMakeModelRequest();
               break;
            case 3:
               proccessGetByYearRequest();
               break;
            case 4:
                proccessGetByColorRequest();
                break;
            case 5:
                proccessGetByMileageRequest();
                break;
            case 6:
                proccessGetByVehicleTypeRequest();
                break;
            case 7:
                proccessGetByAllVehicleRequest();
                break;
            case 8:
                proccessGetByAddVehicleRequest();
                break;
            case 9:
                proccessGetByRemoveVehicleRequest();
                break;
            case 99:
                System.out.println("Goodbye!");
                break;
        }
        }while(command!=99);

    }

    /**
     * prompts the user for min and max price and calls getVehicleByPrice
     * send the arraylist of matched vehicles to displayVehicleRequest
     */
    private void processGetByPriceRequest() {
        int command;
        do{command=Console.promptForInt("""
                1: Proceed Price Range 
                2: Go Back
                 -> """);
            switch (command){
                case 1 :
                    double min =Console.promptForDouble("Enter the min  ");
                    double max = Console.promptForDouble("Enter the max  ");
                    displayVehicleRequest(dealership.getVehicleByPrice(min,max));
                    break;
                case 2:
                    break;}
        }while(command!=2);
    }

    /**
     * prompts the user for make and model calls the getVehicleByMakeModel
     * passes the returned arraylist into displayVehicleRequest to be displayed
     */
    private void proccessGetByMakeModelRequest() {
        int command;
        do{command=Console.promptForInt("""
                1: Proceed 
                2: Go Back
                 -> """);
            switch (command){
                case 1 :
                    String make = Console.promptForString("Enter the make of car: ");
                    String model = Console.promptForString("Enter the model of car: ");
                    displayVehicleRequest(dealership.getVehicleByMakeModel(make,model));
                    break;
                case 2:
                    break;}
        }while(command!=2);
    }
    /**
     * prompts the user for min and max Year and calls getVehicleByYear
     * send the arraylist of matched vehicles to displayVehicleRequest
     */
    private void proccessGetByYearRequest() {
        int command;
        do{command=Console.promptForInt("""
                1: Proceed Year Range 
                2: Go Back
                 -> """);
            switch (command){
                case 1 :
                    int min =Console.promptForInt("Enter the min  ");
                    int max = Console.promptForInt("Enter the max  ");
                    displayVehicleRequest(dealership.getVehicleByYear(min,max));
                    break;
                case 2:
                    break;}
        }while(command!=2);
    }
    /**
     * prompts the user for color calls the getVehicleByColor
     * passes the returned arraylist into displayVehicleRequest to be displayed
     */
    private void proccessGetByColorRequest() {
        int command;
        do{command=Console.promptForInt("""
                1: Proceed 
                2: Go Back
                 -> """);
            switch (command){
                case 1 :
                    String color = Console.promptForString("Enter the color of car: ");
                    displayVehicleRequest(dealership.getVehicleByColor(color));
                    break;
                case 2:
                    break;}
        }while(command!=2);
    }
    /**
     * prompts the user for min and max Mileage and calls getVehicleByMileage
     * send the arraylist of matched vehicles to displayVehicleRequest
     */
    private void proccessGetByMileageRequest() {
        int command;
        do{command=Console.promptForInt("""
                1: Proceed Mileage Range 
                2: Go Back
                 -> """);
            switch (command){
                case 1 :
                    int min =Console.promptForInt("Enter the min  ");
                    int max = Console.promptForInt("Enter the max  ");
                    displayVehicleRequest(dealership.getVehicleByMileage(min,max));
                    break;
                case 2:
                    break;}
        }while(command!=2);

    }
    /**
     * prompts the user for Type calls the getVehicleByVehicleType
     * passes the returned arraylist into displayVehicleRequest to be displayed
     */
    private void proccessGetByVehicleTypeRequest() {
        int command;
        do{command=Console.promptForInt("""
                1: Proceed 
                2: Go Back
                 -> """);
            switch (command){
                case 1 :
                    String type = Console.promptForString("Enter the Type of car: ");
                    displayVehicleRequest(dealership.getVehicleByType(type));
                    break;
                case 2:
                    break;}
        }while(command!=2);
    }

    /**
     * gets all the vehicles currently in the dealership
     */
    private void proccessGetByAllVehicleRequest() {
        displayVehicleRequest(dealership.getAllVehicle());
    }

    /**
     * lets user add vehicles to the dealership inventory
     */
    private void proccessGetByAddVehicleRequest() {
        int command;
        do{command=Console.promptForInt("""
                1: Proceed with Adding
                2: Go Back
                 -> """);
            switch (command){
                case 1 :
                    int vin = Console.promptForInt("Enter VIN: ");
                    int year = Console.promptForInt("Enter Year: ");
                    String make = Console.promptForString("Enter Make: ");
                    String model = Console.promptForString("Enter Model: ");
                    String type = Console.promptForString("Enter Type: ");
                    String color = Console.promptForString("Enter Color: ");
                    int miles = Console.promptForInt("Enter Mileage: ");
                    double price = Console.promptForDouble("Enter Price: ");
                    Vehicle v = new Vehicle(vin, year, make, model, type, color, miles, price);
                    dealership.addVehicle(v);
                    update();
                    System.out.println("Vehicle added successfully!");
                    break;
                case 2:
                    break;
        }}while(command!=2);
    }

    /**
     * lets user remove vehicle from dealership inventory
     */
    private void proccessGetByRemoveVehicleRequest() {
        int command;
        do{command=Console.promptForInt("""
                1: Proceed with Removing
                2: Go Back
                 -> """);
            switch (command){
                case 1 :
                    Vehicle vehicle;
                    int vin =Console.promptForInt("Enter the Vin Number  ");
                    if ((vehicle = dealership.getVehicleByVin(vin)) != null){
                        String name = vehicle.getMake() + " " +vehicle.getModel();
                        dealership.removeVehicle(vehicle);
                        System.out.println(name + " was removed");
                        update();
                        break;
                    }
                    else{
                    System.out.println("No Match Found!");
                    break;
                }
                case 2:
                    break;}
        }while(command!=2);

    }

    /**
     * initializes the dealership
     */
    private  void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    /**
     * updates the csv
     */
    private  void update(){
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(this.dealership);
    }

    /**
     * makes a table and displays the vehicle details
     * @param vehicle list of vehicles to be displayed
     */
    private void displayVehicleRequest(ArrayList<Vehicle> vehicle){
        if(!vehicle.isEmpty()){
        System.out.println("*----------------------------------------------------------------------------------------------------------------------------*");
        System.out.printf("|  %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10s|\n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("|----------------------------------------------------------------------------------------------------------------------------|");
        for(Vehicle v:vehicle){
            System.out.printf("|  %-10d ||   %-10d ||   %-10s ||   %-10s ||   %-10s ||   %-10s ||   %-10d ||   %-10.2f|\n",
                    v.getVin(),v.getYear(),v.getMake(),v.getModel(),
                    v.getVehicleType(),v.getColor(),v.getOdometer(),v.getPrice());
        }}
        else{
            System.out.println("Sorry!! No Match Found");
        }

    }
}
