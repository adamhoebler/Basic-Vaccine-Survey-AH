package doctor_project;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Surgery {

    int[] patientNumber = new int[100];
    String[] patientName = new String[100];
    String[] doctorName = new String[100];
    String[] surgeryType = new String[100];
    double[] surgeryCost = new double[100];
    int count = -1;

    void start_program() {
        String newLine;
        try {
            BufferedReader surgery_file = new BufferedReader(new FileReader("src/doctor_project/surgery.txt"));
            while ((newLine = surgery_file.readLine()) != null) {
                StringTokenizer delimiter = new StringTokenizer(newLine, "#");
                count = count + 1;
                patientNumber[count] = Integer.parseInt(delimiter.nextToken());
                patientName[count] = delimiter.nextToken();
                doctorName[count] = delimiter.nextToken();
                surgeryType[count] = delimiter.nextToken();
                surgeryCost[count] = Double.parseDouble(delimiter.nextToken());
            }
            surgery_file.close();


        } catch (IOException error) {
            System.out.println("Error on file read: " + error);
        }


    }//end start_program
//******************************************************************************

    int menu() {
        int selection;
        String value;
        String output = "HOSPITAL REPORT MENU" + "\n" +
                "==================" + "\n" +
                "1. Print all information" + "\n" +
                "2. All surgeries for a specific Doctor" + "\n" +
                "3. All surgeries of a specific type" + "\n" +
                "4. Fees Paid to each Doctor" + "\n" +
                "5. Average fee per type" + "\n" +
                "6. Exit" + "\n" +
                "Enter your selection > ";

        value = JOptionPane.showInputDialog(null,
                output, "Input Data", JOptionPane.QUESTION_MESSAGE);
        selection = Integer.parseInt(value);
        return selection;
    }//end menu
//******************************************************************************

    void print_doctor_surgery() {
        String inputDoctorName;
        inputDoctorName = JOptionPane.showInputDialog(null,
                "Please enter the doctor's last name: ", "Input Data", JOptionPane.QUESTION_MESSAGE);
        System.out.println("=========== Printing All Surgeries Performed By: " + inputDoctorName + " ===========\n");
        for (int a = 0; a <= count; a++) {
            if (inputDoctorName.equals(doctorName[a])) {

                System.out.println("Patient: " + patientNumber[a] + " " + patientName[a] + " " + doctorName[a] + " " + surgeryType[a] + " " + "$" + surgeryCost[a] + "\n");

            }

        }
    }
//******************************************************************************

    void print_all() {
        System.out.println("=========== Printing All Stored Information ===========\n");
        for (int i = 0; i <= count; i++) {
            System.out.println("Patient: " + patientNumber[i] + " " + patientName[i] + " " + doctorName[i] + " " + surgeryType[i] + " " + "$" + surgeryCost[i] + "\n");

        }
    }

    //******************************************************************************
    void print_surgery_specific_type() {
        String inputSurgeryType;
        inputSurgeryType = JOptionPane.showInputDialog(null,
                "Please enter the surgery type (heart, hip, knee): ", "Input Data", JOptionPane.QUESTION_MESSAGE);

        System.out.println("=========== Printing All Surgeries of Type: " + inputSurgeryType + " ===========\n");
        for (int b = 0; b <= count; b++) {
            if (inputSurgeryType.equals(surgeryType[b])) {
                System.out.println("Patient: " + patientNumber[b] + " " + patientName[b] + " " + doctorName[b] + " " + surgeryType[b] + " " + "$" + surgeryCost[b] + "\n");
            }
        }

    }

    //******************************************************************************
    void print_all_fees() {
        double atkinsAmount = 0;
        double smithAmount = 0;
        double jonesAmount = 0;
        for (int c = 0; c <= count; c++) {
            if (doctorName[c].equals("Atkins")) {
                atkinsAmount += surgeryCost[c];
            }
            if (doctorName[c].equals("Smith")) {
                smithAmount += surgeryCost[c];
            }
            if (doctorName[c].equals("Jones")) {
                jonesAmount += surgeryCost[c];
            }
        }
        System.out.println("=========== Printing All Fees by Doctor ===========\n");
        System.out.println("Dr. Atkins Total: $" + atkinsAmount + "\n");
        System.out.println("Dr. Smith Total: $" + smithAmount + "\n");
        System.out.println("Dr. Jones Total: $" + jonesAmount + "\n");
    }

    //******************************************************************************
    void new_report() {
        int kneeCount = 0;
        int hipCount = 0;
        int heartCount = 0;
        double kneeTotal = 0;
        double hipTotal = 0;
        double hearTotal = 0;

        for (int d = 0; d <= count; d++) {
            if (surgeryType[d].equals("knee")) {
                kneeTotal += surgeryCost[d];
                kneeCount++;
            }
            if (surgeryType[d].equals("hip")) {
                hipTotal += surgeryCost[d];
                hipCount++;
            }
            if (surgeryType[d].equals("heart")) {
                hearTotal += surgeryCost[d];
                heartCount++;
            }
        }
        System.out.println("=========== Printing Average Fee by Surgery Type ===========\n");
        System.out.println("Knee Average Fee: $" + kneeTotal / kneeCount + "\n");
        System.out.println("Hip Average Fee: $" + hipTotal / hipCount + "\n");
        System.out.println("Heart Average Fee: $" + hearTotal / heartCount + "\n");
    }
//******************************************************************************
}
