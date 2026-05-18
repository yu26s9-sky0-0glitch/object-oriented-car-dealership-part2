package com.pluralsight.data;

import com.pluralsight.entities.Contract;
import com.pluralsight.entities.LeaseContract;
import com.pluralsight.entities.SalesContract;
import com.pluralsight.entities.Vehicle;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager {
    public void saveContract(Contract contract){
        try {
            FileWriter fw = new FileWriter("data/contracts.csv",true);
            BufferedWriter bfw = new BufferedWriter(fw);
                Vehicle v = contract.getVehicleSold();
                String date = contract.getDate();
                String customerName = contract.getCustomerName();
                String customerEmail = contract.getCustomerEmail();
                String vin = String.valueOf(v.getVin());
                String year = String.valueOf(v.getYear());
                String make = v.getMake();
                String model = v.getModel();
                String vehicleType= v.getVehicleType();
                String color =v.getColor();
                String odometer = String.valueOf(v.getOdometer());
                String vehiclePrice = String.valueOf(v.getPrice());
                String line = "";
            if(contract instanceof SalesContract){
                SalesContract sales = (SalesContract) contract;
                //todo ask how to handle two type of header
                //bfw.write("CONTRACT_TYPE|DATE|CUSTOMER_NAME|CUSTOMER_EMAIL|VIN|YEAR|MAKE|MODEL|VEHICLE_TYPE|COLOR|ODOMETER|VEHICLE_PRICE|SALES_TAX|RECORDING_FEE|PROCESSING_FEE|TOTAL_PRICE|FINANCE_OPTION|MONTHLY_PAYMENT");
                String salesTax = String.valueOf((sales.getSalesTaxPercent())*100);
                String recordingFee = String.valueOf(sales.getRecordingFee());
                String processingFee = String.valueOf(sales.getProcessingFee());
                String totalPrice = String.valueOf(sales.getTotalPrice());
                String financeOption = (sales.isFinance())?("Yes"):("No");
                String monthyPayment = String.valueOf(sales.getMonthlyPayment());
                line = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s%%|%s|%s|%s|%s|%s|\n","SALE",
                        date,customerName,customerEmail,vin,year,make,model,vehicleType,color,odometer,
                        vehiclePrice,salesTax,recordingFee,processingFee,totalPrice,financeOption,monthyPayment);

            } else if (contract instanceof LeaseContract) {
               // bfw.write("CONTRACT_TYPE|DATE|CUSTOMER_NAME|CUSTOMER_EMAIL|VIN|YEAR|MAKE|MODEL|VEHICLE_TYPE|COLOR|ODOMETER|VEHICLE_PRICE|EXPECTED_ENDING_VALUE|LEASE_FEE|FINANCE_OPTION|MONTHLY_PAYMENT");
                LeaseContract lease = (LeaseContract) contract;
                String expectedEndingFee = String.valueOf(lease.getExpectedEndingValue());
                String leaseFee = String.valueOf(lease.getLeaseFee());
                String totalPrice = String.valueOf(lease.getTotalPrice());
                String monthlyPayment = String.valueOf(lease.getMonthlyPayment());
                line = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n","LEASE",
                        date,customerName,customerEmail,vin,year,make,model,vehicleType,color,odometer,
                        vehiclePrice,expectedEndingFee,leaseFee,totalPrice,monthlyPayment);
            }
            bfw.write(line);
            bfw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
