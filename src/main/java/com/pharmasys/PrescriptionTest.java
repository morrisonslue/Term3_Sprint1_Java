package com.pharmasys;

import com.pharmasys.models.*;

public class PrescriptionTest {
    public static void main(String[] args) {
        Doctor doc = new Doctor("C002", "Dr. Hamburger", 59, "987-654-3210", "GP");
        Patient pat = new Patient("S002", "Steve Morrison", 27, "123-123-1234");
        Medication med = new Medication("M002", "Tylenol", 25.0, 300);

        Prescription presc = new Prescription("RX001", doc, pat, med);
        System.out.println(presc);
    }
}