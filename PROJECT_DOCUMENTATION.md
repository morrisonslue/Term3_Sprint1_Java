PharmaSys - Project Documentation

1. User Documentation

1.1 About The App

PharmaSys is a Java-based pharmacy management system designed for tracking patients, doctors, medications, and prescriptions. It allows users to add, search, update, and manage healthcare data, ensuring prescriptions and medication stock tracking.

This project was built as part of a college mid-term sprint assignment, focusing on object-oriented programming.

1.2 Class Overview & Associations

PharmaSys is structured using the following classes:

Person.java (Super Class) - Parent class for Patient.java and Doctor.java

Patient.java - Represents a patient and maintains a list of medications and prescriptions

Doctor.java - Represents a doctor and keeps track of patients assigned to said doctor

Medication.java - Stores details of each medication

Prescription.java - Links a doctor, patient, and medication with an expiry date

MedicationTrackingSystem.java - The core of the system, responsible for storing and managing

MedicationTrackingMenu.java - The console menu, allowing user interaction

1.3 How to Start the Application

Prerequisites:

Java 17+ installed on your system

Git installed if cloning from GitHub

Steps to Run the Application:

Clone the repository if it is not already downloaded:

git clone https://github.com/morrisonslue/Term3_Sprint1_Java.git
cd Term3_Sprint1_Java

Compile the code:

javac -d bin -cp bin src/main/java/com/pharmasys/models/_.java
javac -d bin -cp bin src/main/java/com/pharmasys/MedicationTrackingSystem.java
javac -d bin -cp bin src/main/java/com/pharmasys/_.java

Run the program:

java -cp bin com.pharmasys.MedicationTrackingMenu

2. Development Documentation

2.1 Source Code

Term3_Sprint1_Java/
│-- bin/ # Compiled .class files
│-- src/
│ ├── main/java/com/pharmasys/
│ │ ├── Main.java # Entry
│ │ ├── MedicationTrackingMenu.java # Console menu
│ │ ├── MedicationTrackingSystem.java # Main logic
| | |── PrescriptionTest.java # Test file
│ │ ├── models/
│ │ │ ├── Person.java
│ │ │ ├── Patient.java
│ │ │ ├── Doctor.java
│ │ │ ├── Medication.java
│ │ │ ├── Prescription.java
│-- README.md # Project overview
│-- LICENSE # License details
│-- PROJECT_DOCUMENTATION.md # You are here

2.2 Build and Compilation Process

The project is compiled and run using javac and java commands. The following process is used:

Compile models first:

javac -d bin -cp bin src/main/java/com/pharmasys/models/\*.java

Compile the core system:

javac -d bin -cp bin src/main/java/com/pharmasys/MedicationTrackingSystem.java

Compile user interface and the main classes:

javac -d bin -cp bin src/main/java/com/pharmasys/\*.java

2.3 Javadocs & Development Standards

The project follows basic Java coding conventions:

Javadoc comments are used for methods

Descriptive variable names for readability

Consistent indentation and formatting

To generate Javadocs:

javadoc -d docs -sourcepath src/main/java -subpackages com.pharmasys

2.4 Potential Database Design

The following is a conceptual diagram if this were to be implemented with SQL:

[ Doctor ] ------< [ Prescription ] >------ [ Patient ]
|
v
[ Medication ]

Entities:

Doctor (DoctorID, Name, Specialization)

Patient (PatientID, Name, Age, PhoneNumber)

Medication (MedID, Name, Dose, Quantity, ExpiryDate)

Prescription (PrescriptionID, DoctorID, PatientID, MedID, ExpiryDate)

2.5 Getting the Source Code

To download or clone the repository:

git clone https://github.com/morrisonslue/Term3_Sprint1_Java.git

3. Deployment Documentation

3.1 System Requirements

Operating System: Windows / Mac / Linux

Java Version: 17+

3.2 Installation

Download the latest release from GitHub

Ensure Java is installed (java -version in terminal)

Compile and run the project (see Section 2.2)

3.3 Running the Application

java -cp bin com.pharmasys.MedicationTrackingMenu

This will launch the interactive menu for managing pharmacy records.

3.4 Troubleshooting

Compilation Errors: Ensure all .java files are compiled properly

Class Not Found: Make sure the bin/ folder exists and has compiled .class files

Java Not Recognized: Install Java 17+ and check system PATH settings

Final Notes

PharmaSys was developed as a learning exercise, but it successfully models a real-world pharmacy system. Future improvements could include database integration, a GUI interface, and enhanced error handling.

Authors

Chris Morrison & Stephen Morrison, SD12
