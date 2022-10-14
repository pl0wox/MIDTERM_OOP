import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {
    private int numOfModules, numOfRepeatModules;
    private double amount_paid;
    final int  ModulePrice = 525;
    final int  RepeatedModulePrice = 110;

    public static List<Student> studentList = new ArrayList<>();
    
    // hi




    //  Constructor Student
    public Student(int ID, String Fname, String Lname, String Gender, String PhoneNum, String Address, int numOfModules, int numOfRepeatModules, double amount_paid) {
        super(ID, Fname,Lname, Gender, PhoneNum , Address);
        this.numOfModules = numOfModules;
        this.numOfRepeatModules = numOfRepeatModules;
        this.amount_paid = amount_paid;
    }



    public int getNumOfModules() {
        return numOfModules;
    }
    public void setNumOfModules(int numOfModules) {
        this.numOfModules = numOfModules;
    }
    public int getRep_modules() {
        return numOfRepeatModules;
    }
    public void setRep_modules(int numOfRepeatModules) {
        this.numOfRepeatModules = numOfRepeatModules;
    }
    public double getAmount_paid() {
        return amount_paid;
    }
    public void setAmount_paid(double amount_paid) {
        this.amount_paid = amount_paid;
    }



    static void add_student(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< ADD NEW STUDENT >>");
        System.out.println("====================================================\n");


        Scanner in = new Scanner(System.in).useDelimiter("\n");
        final int  ModulePrice = 525;
        final int  RepeatedModulePrice = 110;

        System.out.print("Enter ID: ");
        int addID = in.nextInt();

        // Validation for Student ID
        for(int i = 0; i < studentList.size(); i++){
            if(addID == studentList.get(i).getID()){
                System.out.println("bobo, ID already registered!");
                return;
            }
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
        if((addModules + addRepModules) > 6){
            System.out.println("You cannot get more than 6 modules for this semester!");
            return;
        }
        else if (addRepModules > 2){
            System.out.println("You cannot take a new module if you want to take more than 2 repeated modules this semester!");
            return;
        }


        double addAmount = (ModulePrice * addModules) + (RepeatedModulePrice * addRepModules);
        System.out.print("Account Status ");

        // Inform user that1 student has been added
        System.out.println("\nSuccessfully Added Student #" + addID + " to the Database!");

        // store all inputs of user inside the constructor
        Student studentobj = new Student(addID,addFirstname,addLastname,addGender,addPhone,addAddress,addModules,addRepModules,addAmount);

        // store inside the array list
        studentList.add(studentobj);

    }

    static void update_student(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< UPDATE STUDENT >>");
        System.out.println("====================================================\n");

        Scanner in = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Enter ID: ");
        int upID = in.nextInt();

        for(int i = 0; i < studentList.size(); i++){
            if(upID == studentList.get(i).getID()){


                System.out.println("Student#" + upID);
                System.out.println("\nName: " + studentList.get(i).getFName() + " " + studentList.get(i).getLName());
                System.out.println("Gender: " + studentList.get(i).getGender());
                System.out.println("Phone Number: " + studentList.get(i).getPhoneNum());
                System.out.println("Address: " + studentList.get(i).getAddress());
                System.out.println("Number of Modules: " + studentList.get(i).getNumOfModules());
                System.out.println("Number of Repeated Modules: " + studentList.get(i).getRep_modules());

                System.out.println("====================================================");
                System.out.println("\t\t\t\t<< UPDATE  >>");
                System.out.println("====================================================\n");

                System.out.println("[1] Student Number");
                System.out.println("[2] Name");
                System.out.println("[3] Gender");
                System.out.println("[4] Phone Number");
                System.out.println("[5] Address ");
                System.out.println("[6] Number of Modules");
                System.out.println("[7] Number of Repeated Modules");




                switch(Main.choice()){
                    case 1:
                        System.out.println("====================================================");
                        System.out.println("\t\t\t\t<< UPDATE STUDENT NUMBER  >>");
                        System.out.println("====================================================\n");

                        System.out.print("Enter new Student Number (ex.202110139): ");
                        int updateID = in.nextInt();

                        for(int k = 0; k < studentList.size(); k++){
                            if (updateID == studentList.get(k).getID()){
                                System.out.println(updateID +" is already registered! please try again");
                            }
                        }
                        break;

                    case 2:
                        System.out.println("====================================================");
                        System.out.println("\t\t\t\t<< UPDATE STUDENT NAME  >>");
                        System.out.println("====================================================\n");

                        System.out.println("Enter Student Name ");

                        System.out.print("Enter First name: ");
                        String updateFName = in.next();
                        System.out.println("Enter Last name");
                        String updateLName = in.next();

                        studentList.get(i).setFName(updateFName);
                        studentList.get(i).setLName(updateLName);
                        System.out.println("\nStudent name has been updated!");
                        break;
                    case 3:
                        System.out.println("====================================================");
                        System.out.println("\t\t\t\t<< UPDATE STUDENT GENDER  >>");
                        System.out.println("====================================================\n");

                        System.out.print("");
                        break;
                    case 4:
                        System.out.println("====================================================");
                        System.out.println("\t\t\t\t<< UPDATE PHONE NUMBER  >>");
                        System.out.println("====================================================\n");

                        System.out.print("Enter your new Phone Number: ");
                        String newPhone = in.next();

                        // setter (setPhoneNum) used to update the current phone number
                        studentList.get(i).setPhoneNum(newPhone);
                        System.out.println("\nPhone Number has been updated!");
                        break;
                    case 5:
                        System.out.println("====================================================");
                        System.out.println("\t\t\t\t<< UPDATE ADDRESS  >>");
                        System.out.println("====================================================\n");

                        System.out.print("Enter your new Address: ");
                        String newAddress = in.next();

                        studentList.get(i).setAddress(newAddress);
                        System.out.println("\nAddress has been updated!");
                        break;
                    case 6:
                        System.out.println("====================================================");
                        System.out.println("\t\t\t\t<< UPDATE MODULES  >>");
                        System.out.println("====================================================\n");

                        System.out.print("Update Number Modules: ");
                        int newModules = in.nextInt();


                        // check if user still takes 6 module
                        if(newModules + studentList.get(i).getNumOfModules() > 6){
                            System.out.println("Cannot take more than 6 total modules");
                        }
                        else {
                            studentList.get(i).setNumOfModules(newModules);
                            System.out.println("\nModules Have been updated!");
                        }
                        break;

                    case 7:
                        System.out.println("====================================================");
                        System.out.println("\t\t\t\t<< UPDATE REPEATED MODULES  >>");
                        System.out.println("====================================================\n");

                        System.out.println("Update Repeated Modules: ");
                        int newRepeatedModules = in.nextInt();

                        studentList.get(i).setRep_modules(newRepeatedModules);
                        System.out.println("\n Repeated Modules have been Updated");



                }


            }
        }



    }
    static void delete_student(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< DELETE STUDENT >>");
        System.out.println("====================================================\n");

        if(studentList.size() == 0){
            System.out.println("There are no Students registered in the database!");
            return;
        }
        else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Student ID (ex. 202110139): ");
            int delID = in.nextInt();



            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getID() == delID) {
                    System.out.println(studentList.get(i).getID() + " Has been removed from the database!!");
                    studentList.remove(i);

                    if (studentList.lastIndexOf(i) == delID) {
                        System.out.println(studentList.get(i).getID() + " Has been removed from the database!!");
                        studentList.remove(i);
                    }
                    //else if (studentList.)
                }
            }
                /*
                // if last index is equal to user's ID
                else if (studentList.lastIndexOf(i) == delID) {
                    System.out.println(studentList.get(i).getID() + " Has been removed from the database!!");
                    studentList.remove(i);
                }

                 */
        }

                /*
                for(int j = 0; i < studentList.size(); j++){
                     if (studentList.get(i).getID() != delID){
                        System.out.println("Student #" + delID + " Has not been found from the database!!");
                        break;
                    }
                }

                 */


    }
}






