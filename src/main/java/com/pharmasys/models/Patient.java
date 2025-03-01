package com.pharmasys.models;

import java.util.ArrayList;
import java.util.List;


public class Patient extends Person {
    private List<String> medications;
    private List<String> prescriptions;

    // constructor
    public Patient() {
        super();
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public Patient(String id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // medication
    public void addMedication(String medication) {
        medications.add(medication);
    }

    // prescription
    public void addPrescription(String prescription) {
        prescriptions.add(prescription);
    }

    // get the lists
    public List<String> getMedications() {
        return medications;
    }

    public List<String> getPrescriptions() {
        return prescriptions;
    }

    // toString method
    public String toString() {
        return super.toString() + " | Medications: " + medications + " | Prescriptions: " + prescriptions;
    }
}
