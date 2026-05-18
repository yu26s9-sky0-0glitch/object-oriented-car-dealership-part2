package com.pluralsight.entities;

public  class SalesContract extends Contract {
    private final double salesTaxPercent = 0.05;
    private final int recordingFee = 100;
    private final double processingFee;
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {

        super(date, customerName, customerEmail, vehicleSold);
        this.processingFee = validateProcessingFee();
        this.finance = finance;
    }

    /**
     * customize processing fee to car value;
     * @return customized processing fee
     */
    private double validateProcessingFee() {
        Vehicle vehicle = getVehicleSold();
        if(vehicle.getPrice() < 10000){
            return 295;
        }
        else{
            return 495;
        }
    }
    //todo
    //ask if i should create setters for my final fields
    public double getSalesTaxPercent() {
        return salesTaxPercent;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    /**
     * calculates everything and gets the final price
     * @return calculated price
     */
    @Override
    public double getTotalPrice() {
        double vehiclePrice = getVehicleSold().getPrice();
        return vehiclePrice + (vehiclePrice*salesTaxPercent) +processingFee+ recordingFee;
    }

    /**
     * if financed calculates the monthly payment else returns 0
     * @return either 0 or monthly amount
     */
    @Override
    public double getMonthlyPayment() {
        //todo
        //ask if this is how we should calculate it with Amortization Formula
        // or just simple interest
        if (!finance) {
            return 0;
        }

        double totalPrice = getTotalPrice();
        double annualRate;
        int months;

        if (getVehicleSold().getPrice() >= 10000) {
            annualRate = 0.0425;
            months = 48;
        } else {
            annualRate = 0.0525;
            months = 24;
        }

        double monthlyRate = annualRate / 12;

        return (totalPrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}
