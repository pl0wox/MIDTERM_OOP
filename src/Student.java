import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {
    private int numOfModules, numOfRepeatModules;
    private double amount_paid, total_amount, balance, dep_amount;
    private static final int ModulePrice = 525, RepeatedModulePrice = 110;

    public static List<Student> studentList = new ArrayList<>();

    //  Constructor Student
    public Student(int ID, String Fname, String Lname, String Gender, String PhoneNum, String Address, int numOfModules, int numOfRepeatModules, double amount_paid, double total_amount, double balance) {
        super(ID, Fname, Lname, Gender, PhoneNum, Address);
        this.numOfModules = numOfModules;
        this.numOfRepeatModules = numOfRepeatModules;
        this.amount_paid = amount_paid;
        this.total_amount = total_amount;
        this.balance = balance;
    }

    public int getNumOfModules() {  return numOfModules;  }
    public void setNumOfModules(int numOfModules) {  this.numOfModules = numOfModules;  }

    public int getRep_modules() {  return numOfRepeatModules;  }
    public void setRep_modules(int numOfRepeatModules) {  this.numOfRepeatModules = numOfRepeatModules;  }


    public double getAmount_paid() {  return amount_paid;  }
    public void setAmount_paid(double amount_paid) {  this.amount_paid = amount_paid;  }

    public double getTotal(){  return total_amount;  }
    public void setTotal(){  this.total_amount = total_amount;  }
    public double getBalance(){  return balance;  }
    public double setBalance(double balance){  this.balance = balance; return 0; }

    public double getDep_amount() {  return dep_amount;  }
    public void setDep_amount(double dep_amount) {  this.dep_amount = dep_amount;  }


    static void add_student() {
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< ADD NEW STUDENT >>");
        System.out.println("====================================================\n");

        Scanner in = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Enter ID: ");

        // Initalize addID variable to zero to only accept integer values
        int addID = 0;

        // Validation for Student ID
        if(in.hasNextInt()){
            addID = in.nextInt();
            for (int i = 0; i < studentList.size(); i++) {
                if (addID == studentList.get(i).getID()) {
                    System.out.println("ID is already registered!");
                    Main.sysPause();
                    return;
                }
            }
        }
        else {
            System.out.println("Please enter a valid input!");
            Main.sysPause();
            return;
        }

        System.out.print("Enter First Name: ");
        String addFirstname = in.next();

        System.out.print("Enter Last Name: ");
        String addLastname = in.next();

        System.out.print("Enter Gender: ");
        String addGender = in.next();

        System.out.print("Enter Phone Number: ");
        String addPhone = in.next();

        System.out.print("Enter Address: ");
        String addAddress = in.next();

        System.out.print("Enter Number of Modules: ");
        int addModules = in.nextInt();

        System.out.print("Enter Number of Repeated Modules: ");
        int addRepModules = in.nextInt();

        // Constraint the user to only input less than or equal than 6 modules
        if ((addModules + addRepModules) > 6) {
            System.out.println("You cannot get more than 6 modules for this semester!");
            return;
        } else if (addModules !=0 && addRepModules > 2) {
            System.out.println("You cannot take a new module if you want to take more than 2 repeated modules this semester!");
            return;
        }

        double total_amount = (ModulePrice * addModules) + (RepeatedModulePrice * addRepModules);
        System.out.println("Total: " + total_amount);

        System.out.print("Enter Amount Paid: ");
        double addAmount = in.nextDouble();

        if(addAmount > total_amount){
            System.out.println("Cannot pay more than " + total_amount);
            Main.sysPause();
            return;
        }

        double balance = total_amount - addAmount;

        System.out.print("\n\t\t\t\t   Account Status ");
        // Inform user that 1 student has been added
        System.out.println("\nSuccessfully Added Student #" + addID + " to the Database!");

        // store all inputs of user inside the constructor
        Student studentobj = new Student(addID, addFirstname, addLastname, addGender, addPhone, addAddress, addModules, addRepModules, addAmount, total_amount, balance);

        // store inside the array list
        studentList.add(studentobj);

    }
    static void update_student() {
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< UPDATE STUDENT >>");
        System.out.println("====================================================\n");

        if (studentList.size() == 0) {
            System.out.println("There are no Students registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
        }
        else {
            Scanner in = new Scanner(System.in).useDelimiter("\n");

            System.out.print("Enter ID: ");
            int upID = in.nextInt();

            for (int i = 0; i < studentList.size(); i++) {
                if (upID == studentList.get(i).getID()) {
                    System.out.println("Student#" + upID);
                    System.out.println("\nName: " + studentList.get(i).getFName() + " " + studentList.get(i).getLName());
                    System.out.println("Gender: " + studentList.get(i).getGender());
                    System.out.println("Phone Number: " + studentList.get(i).getPhoneNum());
                    System.out.println("Address: " + studentList.get(i).getAddress());
                    System.out.println("Number of Modules: " + studentList.get(i).getNumOfModules());
                    System.out.println("Number of Repeated Modules: " + studentList.get(i).getRep_modules());

                    System.out.println("====================================================");
                    System.out.println("\t\t\t\t\t<< UPDATE >>");
                    System.out.println("====================================================\n");

                    System.out.println("[1] Student Number");
                    System.out.println("[2] Name");
                    System.out.println("[3] Gender");
                    System.out.println("[4] Phone Number");
                    System.out.println("[5] Address ");
                    System.out.println("[6] Number of Modules");
                    System.out.println("[7] Number of Repeated Modules");
                    System.out.println("[8] Cancel");


                    switch (Main.choice()) {
                        case 1:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t<< UPDATE STUDENT NUMBER >>");
                            System.out.println("====================================================\n");

                            System.out.print("Enter new Student Number (ex.202110139): ");
                            int updateID = in.nextInt();

                            for (int k = 0; k < studentList.size(); k++) {
                                if (updateID == studentList.get(k).getID()) {
                                    System.out.println(updateID + " is already registered! please try again");
                                    Main.sysPause();
                                    return;
                                }
                            }

                            studentList.get(i).setID(updateID);
                            System.out.println("\nStudent ID has been updated!");
                            Main.sysPause();
                            break;

                        case 2:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t  << UPDATE STUDENT NAME >>");
                            System.out.println("====================================================\n");

                            System.out.println("Enter Student Name ");

                            System.out.print("Enter First name: ");
                            String updateFName = in.next();
                            System.out.print("Enter Last name");
                            String updateLName = in.next();

                            studentList.get(i).setFName(updateFName);
                            studentList.get(i).setLName(updateLName);
                            System.out.println("\nStudent name has been updated!");
                            break;

                        case 3:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t << UPDATE STUDENT GENDER >>");
                            System.out.println("====================================================\n");

                            System.out.printf("Enter Gender: ");
                            String updateGender = in.next();

                            studentList.get(i).setGender(updateGender);
                            System.out.printf("\nStudent's Gender has been updated!");
                            Main.sysPause();
                            break;

                        case 4:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t  << UPDATE PHONE NUMBER >>");
                            System.out.println("====================================================\n");

                            System.out.print("Enter your new Phone Number: ");
                            String updatePhone = in.next();

                            // setter (setPhoneNum) used to update the current phone number
                            studentList.get(i).setPhoneNum(updatePhone);
                            System.out.println("\nPhone Number has been updated!");
                            Main.sysPause();
                            break;

                        case 5:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE ADDRESS >>");
                            System.out.println("====================================================\n");

                            System.out.print("Enter your new Address: ");
                            String newAddress = in.next();

                            studentList.get(i).setAddress(newAddress);
                            System.out.println("\nAddress has been updated!");
                            Main.sysPause();
                            break;

                        case 6:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE MODULES >>");
                            System.out.println("====================================================\n");

                            System.out.print("Update Number Modules: ");
                            int updateModules = in.nextInt();

                            // check if user still takes 6 module
                            if (updateModules + studentList.get(i).numOfRepeatModules > 6) {
                                System.out.println("Cannot take more than 6 total modules");
                                Main.sysPause();
                                return;
                            } else {
                                studentList.get(i).setNumOfModules(updateModules);
                                System.out.println("\nModules Have been updated!");
                                Main.sysPause();
                            }
                            break;

                        case 7:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t<< UPDATE REPEATED MODULES >>");
                            System.out.println("====================================================\n");

                            System.out.println("Update Repeated Modules: ");
                            int updateRepeatedModules = in.nextInt();

                            // check if user still takes 6 module
                            if(studentList.get(i).numOfModules !=0 && updateRepeatedModules > 2){
                                System.out.println("Cannot take more than 2 repeated modules!");
                                Main.sysPause();
                                return;
                            }
                            else if((updateRepeatedModules + studentList.get(i).numOfModules) > 6){
                                System.out.println("Cannot take more than 6 total modules!");
                                Main.sysPause();
                                return;
                            }
                            else{
                                studentList.get(i).setRep_modules(updateRepeatedModules);
                                System.out.println("\n Repeated Modules have been Updated");
                                Main.sysPause();
                            }
                            break;

                        case 8:
                            System.out.println("\nReturning to the Main Menu...");
                            Main.sysPause();
                            break;
                        default:
                            System.out.println("Invalid Input! \n Exiting Program...");
                            Main.sysPause();
                            System.exit(0);

                    }
                }
            }
        }
    }

    static void delete_student() {
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< DELETE STUDENT >>");
        System.out.println("====================================================\n");


        if (studentList.size() == 0) {
            System.out.println("There are no Students registered in the database!");
            Main.sysPause();
        }
        else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Student ID (ex. 202110139): ");
            int delID = in.nextInt();

            for (int j = 0; j < studentList.size(); j++) {
                if (studentList.get(j).getID() != delID) {
                    System.out.println(delID + " does not exist in the database!");
                    Main.sysPause();
                    return;
                }
            }

            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getID() == delID) {
                    System.out.println(studentList.get(i).getID() + " has been removed from the database!!");
                    studentList.remove(i);


                    if (studentList.lastIndexOf(i) == delID) {
                        System.out.println(studentList.get(i).getID() + " has been removed from the database!!");
                        studentList.remove(i);
                    }
                }
            }
        }
    }
    static void show_balance() {
        System.out.println("====================================================");
        System.out.println("\t\t\t<< SHOW REMAINING BALANCE >>");
        System.out.println("====================================================\n");

        if (studentList.size() == 0) {
            System.out.println("There are no Students registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
        }
        else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Student ID (ex. 202110139): ");
            int bal_ID = in.nextInt();

            for (int i = 0; i < studentList.size(); i++) {
                if (bal_ID == studentList.get(i).getID()) {
                    System.out.println("Student#" + bal_ID);
                    System.out.println("\nRemaining Balance: " + studentList.get(i).getBalance());
                    Main.YN_Exit();
                }
            }
        }

    }
    static void deposit(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t  << FEE DEPOSIT >>");
        System.out.println("====================================================\n");

        if(studentList.size() == 0){
            System.out.println("There are no STUDENTS registered in the database!");
            Main.sysPause();
        }
        else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Student ID (ex. 202110139): ");
            int deposit_ID = in.nextInt();

            for (int j = 0; j < studentList.size(); j++) {
                if (studentList.get(j).getID() != deposit_ID) {
                    System.out.println(deposit_ID + " does not exist in the database!");
                    Main.sysPause();
                    return;
                }
            }

            System.out.print("Enter amount: ");
            int dep_amount = in.nextInt();
            System.out.println("Payment Successfully Posted!");

            for (int i = 0; i < studentList.size(); i++) {
                if (deposit_ID == studentList.get(i).getID()) {
                    double y = studentList.get(i).getBalance();
                    double updatedDeposit = y - dep_amount;
                    studentList.get(i).setBalance(updatedDeposit);
                    System.out.println("Your new balance is " + studentList.get(i).getBalance());
                }
            }

            System.out.println("Returning to Main Menu...");
            Main.sysPause();
        }
    }
    static void showZero(){
        System.out.println("====================================================");
        System.out.println("\t\t  << STUDENTS WITH ZERO BALANCE >>");
        System.out.println("====================================================\n");

        if (studentList.size() == 0) {
            System.out.println("There are no Students registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
            return;
        }
        else {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getBalance() == 0) {
                    System.out.println("\nStudent# " + studentList.get(i).getID() + " : " + studentList.get(i).getFName() + studentList.get(i).getLName());
                }
            }
        }
        Main.YN_Exit();
    }
    static void showNonZero(){
        System.out.println("====================================================");
        System.out.println("\t\t\t << STUDENTS WITH BALANCE >>");
        System.out.println("====================================================\n");

        if (studentList.size() == 0) {
            System.out.println("There are no Students registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
            return;
        }
        else {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getBalance() != 0) {
                    System.out.println("\nStudent# " + studentList.get(i).getID() + " : " + studentList.get(i).getFName() + " " + studentList.get(i).getLName());
                }
            }
        }
        Main.YN_Exit();
    }
}
