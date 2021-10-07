package doctor_project;


public class Main {

    public static void main(String[] args) {

        int selection;

        Surgery surgeryObject = new Surgery();


        surgeryObject.start_program();
        selection = surgeryObject.menu();
        while (selection != 6) {
            if (selection == 1)
                surgeryObject.print_all();
            else if (selection == 2)
                surgeryObject.print_doctor_surgery();
            else if (selection == 3)
                surgeryObject.print_surgery_specific_type();
            else if (selection == 4)
                surgeryObject.print_all_fees();
            else if (selection == 5)
                surgeryObject.new_report();
            selection = surgeryObject.menu();
        }//end of while loop
    }

}
    //******************************************************************************




