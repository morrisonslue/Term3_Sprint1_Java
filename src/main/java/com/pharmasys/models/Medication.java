package com.pharmasys.models;

import java.time.LocalDate;
import java.util.Random;

public class Medication {
    private String id;
    private String name;
    private double dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(String id, String name, double dose, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate();
    }

    // random expiry date generator
    private LocalDate generateRandomExpiryDate() {
        Random rand = new Random();
        int yearsOffset = rand.nextInt(5) - 2; // Between -2 to +2 years
        return LocalDate.now().plusYears(yearsOffset);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDose() {
        return dose;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String toString() {
        return "Medication: " + name + " | Dose: " + dose + " | Quantity: " + quantityInStock + " | Expiry: " + expiryDate;
    }
}