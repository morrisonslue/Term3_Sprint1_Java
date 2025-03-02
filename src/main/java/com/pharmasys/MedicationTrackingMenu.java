package com.pharmasys;

import com.pharmasys.models.*;
import java.util.Scanner;

public class MedicationTrackingMenu {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Welcome To The Pharmacy Med Tracking System =====");
            System.out.println("What would you like to do? ");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication");
            System.out.println("4: Delete a Patient, Doctor, or Medication");
            System.out.println("5: Edit a Patient, Doctor, or Medication");
            System.out.println("6: Search for a Patient, Doctor, or Medication");
            System.out.println("7: Process A Prescription");
            System.out.println("8: Assign Patient to Doctor");
            System.out.println("9: Generate Full System Report");
            System.out.println("10: Check Expired Medications");
            System.out.println("11: Print All Prescriptions for a Specific Doctor");
            System.out.println("12: Restock Medications");
            System.out.println("13: Exit");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addPatient(scanner, system);
                    break;
                case 2:
                    addDoctor(scanner, system);
                    break;
                case 3:
                    addMedication(scanner, system);
                    break;
                case 4:
                    deleteEntry(scanner, system);
                    break;
                case 5:
                    editEntry(scanner, system);
                    break;
                case 6:
                    searchSystem(scanner, system);
                    break;
                case 7:
                    processPrescription(scanner, system);
                    break;
                case 8:
                    assignPatientToDoctor(scanner, system);
                    break;
                case 9:
                    system.generateReport();
                    break;
                case 10:
                    checkExpiredMeds(system);
                    break;
                case 11:
                    printPrescriptionsForDoctor(scanner, system);
                    break;
                case 12:
                    restockMedications(scanner, system);
                    break;
                case 13:
                    exit = true;
                    System.out.println("Exiting the system");
                    break;
                default:
                    System.out.println("Selection invalid - try again");
            }
        }
        scanner.close();
    }

    private static void addPatient(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter the Patient's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        system.addPatient(new Patient(id, name, age, phone));
        System.out.println("Patient added");
    }

    private static void addDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Doctor's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        system.addDoctor(new Doctor(id, name, age, phone, specialization));
        System.out.println("Doctor added");
    }

    private static void addMedication(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Medication ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name of the Medication: ");
        String name = scanner.nextLine();
        System.out.print("Enter Dose: ");
        double dose = scanner.nextDouble();
        System.out.print("Enter Quantity in Stock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        system.addMedication(new Medication(id, name, dose, quantity));
        System.out.println("Medication added");
    }

    private static void deleteEntry(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("Delete: 1) Patient  2) Doctor  3) Medication");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name to Delete: ");
        String name = scanner.nextLine();

        switch (choice) {
            case 1:
                system.deletePatient(name);
                break;
            case 2:
                system.deleteDoctor(name);
                break;
            case 3:
                system.deleteMedication(name);
                break;
            default:
                System.out.println("Selection invalid");
        }
    }

    private static void editEntry(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("Edit: 1) Patient  2) Doctor  3) Medication");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter New Age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                system.editPatient(name, newAge);
                break;
            case 2:
                System.out.print("Enter New Specialization: ");
                String specialization = scanner.nextLine();
                system.editDoctor(name, specialization);
                break;
            case 3:
                System.out.print("Enter New Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                system.editMedication(name, quantity);
                break;
            default:
                System.out.println("Selection invalid");
        }
    }

    private static void searchSystem(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("Search for: 1) Patient  2) Doctor  3) Medication");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        switch (choice) {
            case 1:
                Patient patient = system.searchPatient(name);
                System.out.println(patient != null ? patient : "Patient not found");
                break;
            case 2:
                Doctor doctor = system.searchDoctor(name);
                System.out.println(doctor != null ? doctor : "Doctor not found");
                break;
            case 3:
                Medication medication = system.searchMedication(name);
                System.out.println(medication != null ? medication : "Medication not found");
                break;
            default:
                System.out.println("Selection invalid");
        }
    }

    private static void processPrescription(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Prescription ID: ");
        String prescId = scanner.nextLine();
        System.out.print("Enter Doctor's Name: ");
        String docName = scanner.nextLine();
        System.out.print("Enter Patient's Name: ");
        String patName = scanner.nextLine();
        System.out.print("Enter Name of Medication: ");
        String medName = scanner.nextLine();

        Doctor doctor = system.searchDoctor(docName);
        Patient patient = system.searchPatient(patName);
        Medication medication = system.searchMedication(medName);

        if (doctor != null && patient != null && medication != null) {
            system.acceptPrescription(new Prescription(prescId, doctor, patient, medication));
            System.out.println("Prescription has been processed");
        } else {
            System.out.println("Error: Unable to find entry/entries");
        }
    }

    private static void assignPatientToDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor's Name: ");
        String docName = scanner.nextLine();
        System.out.print("Enter Patient's Name: ");
        String patientName = scanner.nextLine();

        system.assignPatientToDoctor(docName, patientName);
    }

    private static void checkExpiredMeds(MedicationTrackingSystem system) {
        system.checkExpiredMedications();
    }

    private static void printPrescriptionsForDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor's Name: ");
        String docName = scanner.nextLine();
        system.getPrescriptionsForDoctor(docName);
    }

    private static void restockMedications(Scanner scanner, MedicationTrackingSystem system) {
        system.restockMedications();
    }
}
