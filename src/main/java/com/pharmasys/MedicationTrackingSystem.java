package com.pharmasys;

import com.pharmasys.models.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class MedicationTrackingSystem {
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Doctor> doctors;
    private List<Prescription> prescriptions;

    public MedicationTrackingSystem() {
        this.patients = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // feature for adding entities
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // feature to delete entities
    public void deleteDoctor(String name) {
        doctors.removeIf(doctor -> doctor.getName().equalsIgnoreCase(name));
        System.out.println("Doctor has been removed");
    }

    public void deletePatient(String name) {
        patients.removeIf(patient -> patient.getName().equalsIgnoreCase(name));
        System.out.println("Patient has been removed");
    }

    public void deleteMedication(String name) {
        medications.removeIf(med -> med.getName().equalsIgnoreCase(name));
        System.out.println("Medication has been removed");
    }

    // feature for editing entities
    public void editDoctor(String name, String newSpecialization) {
        Doctor doctor = searchDoctor(name);
        if (doctor != null) {
            doctor.setSpecialization(newSpecialization);
            System.out.println("Doctor specialization has been updated");
        } else {
            System.out.println("Doctor not found");
        }
    }

    public void editPatient(String name, int newAge) {
        Patient patient = searchPatient(name);
        if (patient != null) {
            patient.setAge(newAge);
            System.out.println("Patient details have been updated");
        } else {
            System.out.println("Patient not found");
        }
    }

    public void editMedication(String name, int newQuantity) {
        Medication medication = searchMedication(name);
        if (medication != null) {
            medication.setQuantityInStock(newQuantity);
            System.out.println("Medication quantity has been updated");
        } else {
            System.out.println("Medication not found");
        }
    }

    // search
    public Doctor searchDoctor(String name) {
        return doctors.stream().filter(d -> d.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Patient searchPatient(String name) {
        return patients.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Medication searchMedication(String name) {
        return medications.stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    // assigning patients to doctors
    public void assignPatientToDoctor(String docName, String patientName) {
        Doctor doctor = searchDoctor(docName);
        Patient patient = searchPatient(patientName);
        if (doctor != null && patient != null) {
            doctor.addPatient(patient);
            System.out.println("Patient assigned");
        } else {
            System.out.println("Error: Doctor or patient not found");
        }
    }

    // adding prescription
    public void acceptPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        prescription.getPatient().addPrescription(prescription.getId());
        prescription.getPatient().addMedication(prescription.getMedication().getName());
        System.out.println("Prescription added");
    }

    // report generation
    public void generateReport() {
        System.out.println("===== System Report =====");
        System.out.println("Doctors: " + doctors);
        System.out.println("Patients: " + patients);
        System.out.println("Medications: " + medications);
    }

    public void checkExpiredMedications() {
        System.out.println("Checking for expired medications...");
        LocalDate today = LocalDate.now();
        boolean foundExpired = false;

        for (Medication medication : medications) {
            if (medication.getExpiryDate().isBefore(today)) {
                System.out.println("Expired Medication: " + medication.getName() + " | Expiry Date: "
                        + medication.getExpiryDate());
                foundExpired = true;
            }
        }

        if (!foundExpired) {
            System.out.println("No expired medications");
        }
    }

    public void getPrescriptionsForDoctor(String doctorName) {
        System.out.println("Prescriptions for Doctor " + doctorName + ":");
        boolean found = false;
        for (Prescription presc : prescriptions) {
            if (presc.getDoctor().getName().equalsIgnoreCase(doctorName)) {
                System.out.println("Patient: " + presc.getPatient().getName() + " | Medication: "
                        + presc.getMedication().getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No prescriptions found");
        }
    }

    public void restockMedications() {
        for (Medication medication : medications) {
            int restockAmount = (int) (Math.random() * 50) + 1;
            medication.setQuantityInStock(medication.getQuantityInStock() + restockAmount);
        }
        System.out.println("All medications restocked");
    }
}
