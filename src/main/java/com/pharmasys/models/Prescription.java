package com.pharmasys.models;

import java.time.LocalDate;

public class Prescription {
    private String id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate prescriptionExpiry;

    public Prescription(String id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiry = LocalDate.now().plusYears(1); // Default expiry: 1 year from now
    }

    // get
    public String getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public LocalDate getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    public String toString() {
        return "Prescription ID: " + id +
                " | Doctor: " + doctor.getName() +
                " | Patient: " + patient.getName() +
                " | Medication: " + medication.getName() +
                " | Expiry: " + prescriptionExpiry;
    }
}
