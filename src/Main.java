import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        menu_ST(); // display Student or Teacher menu
        menu(choice());
    }


    static void sysPause(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    static void YN_Exit(){
        Scanner in = new Scanner(System.in);
        System.out.print("Back to Main Menu? [Y/N]");
        String x = in.next();

        if (x.contains("Y") || x.contains("y")){
            System.out.println("\nReturning to the Main Menu...");
            Main.sysPause();
            Main.menu_ST();
            Main.menu(Main.choice());
        }
        else if (x.contains("N") || x.contains("n")){
            System.out.println("\nThank you for using our program! Bouncing...");
            Main.sysPause();
            System.exit(0);
        }
        // needs testing
        else {
            System.out.println("\nInvalid Input!");
            Main.sysPause();
        }
    }
    static void menu_ST(){
        System.out.println("====================================================");
        System.out.println("\t\t\t   << ABC COLLEGE INC. >>");      // tab = 4 spaces
        System.out.println("====================================================\n");
        System.out.println("Are you a: ");
        System.out.println("[1] Student");
        System.out.println("[2] Teacher");
        System.out.println("\n[0] Exit Program");
        System.out.println("\n====================================================\n");
    }
    static void menu_student(){
        System.out.println("\n====================================================");
        System.out.println("\t\t\t\t\t<< STUDENT >>");      // tab = 4 spaces
        System.out.println("====================================================\n");
        System.out.println("[1] Add new Student");
        System.out.println("[2] Update Student");
        System.out.println("[3] Delete Student");
        System.out.println("[4] Show Remaining Balance");
        System.out.println("[5] Fee Deposit");
        System.out.println("[6] Display Students with Zero Balance");
        System.out.println("[7] Display all Students with Non-Zero Balance");
        System.out.println("[8] Go back to Main Menu\n");
    }
    static void menu_teacher(){
        System.out.println("\n====================================================");
        System.out.println("\t\t\t\t\t<< TEACHER >>");      // tab = 4 spaces
        System.out.println("====================================================\n");
        System.out.println("[1] Add new Teacher");
        System.out.println("[2] Update Teacher");
        System.out.println("[3] Delete Teacher");
        System.out.println("[4] Calculate salary of Teacher");
        System.out.println("[5] Show all Teachers");
        System.out.println("[6] Go back to Main Menu");
    }

    static int choice(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your choice: ");
        int choice = in.nextInt();
        //in.close();
        return choice;
    }


    static void menu(int c){
        boolean running = true;
        while (running) {
            switch (c) {
                case 1: // student menu
                    menu_student();
                    stud(choice());
                    break;
                case 2: // teacher menu
                    menu_teacher();
                    teach(choice());
                    break;
                case 0: // program exit
                    System.out.println("Thank you for using our program! Exiting now...");
                    Main.sysPause();
                    System.exit(0);
                default:
                    System.out.println("\nOops... wrong input!");
                    sysPause();

                    running = false;
                    break;
            }
        }
    }
    static void stud(int c){
        switch (c){
            case 1:
                // add student
                Student.add_student();
                break;
            case 2:
                // update student
                Student.update_student();
                break;
            case 3:
                // delete student
                Student.delete_student();
                break;
            case 4:
                // show balance
                Student.show_balance();
                break;
            case 5:
                // fee deposit
                Student.deposit();
                break;
            case 6:
                // display zero bal
                Student.showZero();
                break;
            case 7:
                // display non zero
                Student.showNonZero();
                break;
            case 8:
                // return to Main Menu
                menu_ST();
                menu(choice());
                break;
            default:
                System.out.println("Invalid input!");
                sysPause();
                break;
        }
    }
    static void teach(int c){
        switch (c){
            case 1:
                // add
                Teacher.add_teacher();
                break;
            case 2:
                // update
                Teacher.update_teacher();
                break;
            case 3:
                // delete
                Teacher.delete_teacher();
                break;
            case 4:
                // salary calculator
                Teacher.salary();
                break;
            case 5:
                // display all
                Teacher.display();
                break;
            case 6:
                // returns to menu_ST
                menu_ST();
                menu(choice());
                break;
            default:
                System.out.println("Invalid input!");
                Main.sysPause();
                break;
        }
    }
}
