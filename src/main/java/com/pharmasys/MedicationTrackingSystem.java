package com.pharmasys;

import com.pharmasys.models.*;
import java.util.ArrayList;
import java.util.List;

public class MedicationTrackingSystem {
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Doctor> doctors;

    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.doctors = new ArrayList<>();
    }

    // add doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // add patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // add medication
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // doctor search
    public Doctor searchDoctor(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    // patient search
    public Patient searchPatient(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // medication search
    public Medication searchMedication(String name) {
        for (Medication m : medications) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    // adding patient to list for dr
    public void assignPatientToDoctor(String doctorName, String patientName) {
        Doctor doctor = searchDoctor(doctorName);
        Patient patient = searchPatient(patientName);
        if (doctor != null && patient != null) {
            doctor.addPatient(patient);
        }
    }

    //  prescription
    public void acceptPrescription(Prescription prescription) {
        Patient patient = prescription.getPatient();
        Medication medication = prescription.getMedication();
        patient.addPrescription(prescription.getId());
        patient.addMedication(medication.getName());
    }

    // display
    public void generateReport() {
        System.out.println("Doctors: " + doctors);
        System.out.println("Patients: " + patients);
        System.out.println("Medications: " + medications);
    }
}
