package com.pluralsight.entities;

public class LeaseContract extends Contract {
    private double originalPrice;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double originalPrice) {
        super(date, customerName, customerEmail, vehicleSold);
        this.originalPrice = getVehicleSold().getPrice();;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getExpectedEndingValue() {
        return this.originalPrice * 0.5;
    }


    public double getLeaseFee() {
        return this.originalPrice*0.07;
    }

    @Override
    public double getTotalPrice() {
        return (this.originalPrice - getExpectedEndingValue()) + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        double annualRate = 0.04;
        double monthlyRate = annualRate / 12;
        int months = 36;

        double loanAmount = getTotalPrice();
        return (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);
    }
}
