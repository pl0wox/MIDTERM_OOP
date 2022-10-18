import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Teacher extends Person {
    private String department, designation;
    private double teachingHours, net_salary, ot_salary;
    private static final double base_salary=1200.00, OT=325, ha=0.1, ma=0.03, ta=0.05;
    public static List<Teacher> teacherList = new ArrayList<>();

    public Teacher(int ID, String Fname, String Lname, String Gender, String PhoneNum, String Address, String department, String designation, double teachingHours, double ot_salary) {
        super(ID, Fname, Lname, Gender, PhoneNum, Address);
        this.department = department;
        this.designation = designation;
        this.teachingHours = teachingHours;
        this.ot_salary = ot_salary;
    }



    public double getot_salary(){ return ot_salary;}
    public void setot_salary(double ot_salary){  this.ot_salary = ot_salary;  }

    public String getDepartment() {  return department;  }
    public void setDepartment(String department){  this.department = department;  }

    public String getDesignation() {  return designation;  }
    public void setDesignation(String designation){  this.designation = designation;  }

    public double getTeachingHours() {  return teachingHours;  }
    public void setTeachingHours(double teachingHours){  this.teachingHours = teachingHours;  }
    public double getSalary(){  return net_salary;  }
    public void setSalary(double net_salary){  this.net_salary = net_salary;  }

    static void add_teacher(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< ADD NEW TEACHER >>");
        System.out.println("====================================================\n");

        Scanner in = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Enter ID: ");
        int addID = in.nextInt();

        // Validation for Teacher ID
        for(int i = 0; i < teacherList.size(); i++){
            if(addID == teacherList.get(i).getID()){
                System.out.println("ID already registered!");
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

        System.out.println("Enter Department: ");
        System.out.println("[1] Business");
        System.out.println("[2] Computing");

        String addDepartment = "";
        switch (Main.choice()){
            case 1:
                addDepartment = "Business";
                break;
            case 2:
                addDepartment = "Computing";
                break;
            default:
                System.out.println("Please Enter a valid Input!");
        }

        System.out.println("\nEnter Designation: ");
        System.out.println("[1] Head of Faculty (HOF)");
        System.out.println("[2] Coordinator     (CO)");
        System.out.println("[3] Lecturer        (L)");

        String addDesignation = "";

        double addteachingHours = 0.00;
        double addot_salary = 0;
        switch (Main.choice()){
            case 1:
                addDesignation = "Head of Faculty";
                System.out.print("Enter no. of teaching hours: ");
                addteachingHours = in.nextDouble();
                if(addteachingHours < 8){
                    System.out.println("Minimum requirement not met!");
                    Main.sysPause();
                    return;
                }
                else{
                    addot_salary = OT * (addteachingHours-8);
                }
                break;
            case 2:
                addDesignation = "Coordinator";
                System.out.print("Enter no. of teaching hours:");
                addteachingHours = in.nextDouble();
                if(addteachingHours < 13){
                    System.out.println("Minimum requirement not met!");
                    Main.sysPause();
                    return;
                }
                else{
                    addot_salary = OT *(addteachingHours-13);
                }
                break;
            case 3:
                addDesignation = "Lecturer";
                System.out.print("Enter no. of teaching hours:");

                addteachingHours = in.nextDouble();
                if(addteachingHours < 18){
                    System.out.println("Minimum requirement not met!");
                    Main.sysPause();
                    return;
                }
                else{
                    addot_salary = OT *(addteachingHours-18);

                }
                break;
            default:
                System.out.println("Please enter a valid input!");
        }

        // store all inputs of user inside the constructor

        Teacher teacherobj = new Teacher(addID,addFirstname,addLastname,addGender,addPhone,addAddress,addDepartment,addDesignation,addteachingHours, addot_salary);

        // store inside the array list
        teacherList.add(teacherobj);

    }
    static void update_teacher(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< UPDATE TEACHER >>");
        System.out.println("====================================================\n");

        if (teacherList.size() == 0) {
            System.out.println("There are no TEACHERS registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
        }
        else{
            Scanner in = new Scanner(System.in).useDelimiter("\n");

            System.out.print("Enter ID: ");
            int upID = in.nextInt();

            for(int i = 0; i < teacherList.size(); i++){
                if(upID == teacherList.get(i).getID()){

                    System.out.println("ID#" + upID);
                    System.out.println("\nName: " + teacherList.get(i).getFName() + " " + teacherList.get(i).getLName());
                    System.out.println("Gender: " + teacherList.get(i).getGender());
                    System.out.println("Phone Number: " + teacherList.get(i).getPhoneNum());
                    System.out.println("Address: " + teacherList.get(i).getAddress());
                    System.out.println("Department: " + teacherList.get(i).getDepartment());
                    System.out.println("Designation: " + teacherList.get(i).getDesignation());
                    System.out.println("TeachingHours: " + teacherList.get(i).getTeachingHours());

                    System.out.println("====================================================");
                    System.out.println("\t\t\t\t<< UPDATE  >>");
                    System.out.println("====================================================\n");

                    System.out.println("[1] Teacher Id");
                    System.out.println("[2] Name");
                    System.out.println("[3] Gender");
                    System.out.println("[4] Phone Number");
                    System.out.println("[5] Address ");
                    System.out.println("[6] Department");
                    System.out.println("[7] Designation");
                    System.out.println("[8] TeachingHours");

                    switch(Main.choice()) {
                        case 1:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE TEACHER ID  >>");
                            System.out.println("====================================================\n");

                            System.out.print("Enter new Teacher Id (ex.202110139): ");
                            int updateID = in.nextInt();

                            for (int k = 0; k < teacherList.size(); k++) {
                                if (updateID == teacherList.get(k).getID()) {
                                    System.out.println(updateID + " is already registered! please try again");
                                    Main.sysPause();
                                }
                            }

                            teacherList.get(i).setID(updateID);
                            System.out.println("\nTeacher ID has been updated!");
                            Main.sysPause();
                            break;

                        case 2:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE TEACHER NAME  >>");
                            System.out.println("====================================================\n");

                            System.out.println("Enter Teacher Name ");

                            System.out.print("Enter First name: ");
                            String updateFName = in.next();
                            System.out.println("Enter Last name");
                            String updateLName = in.next();

                            teacherList.get(i).setFName(updateFName);
                            teacherList.get(i).setLName(updateLName);
                            System.out.println("\nTeacher name has been updated!");
                            Main.sysPause();
                            break;
                        case 3:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE TEACHER GENDER  >>");
                            System.out.println("====================================================\n");

                            System.out.println("Enter Gender");
                            String updateGender = in.next();

                            teacherList.get(i).setGender(updateGender);
                            System.out.println("\nGender has been updated!");
                            Main.sysPause();
                            break;
                        case 4:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE PHONE NUMBER  >>");
                            System.out.println("====================================================\n");

                            System.out.print("Enter your new Phone Number: ");
                            String updatePhone = in.next();

                            // setter (setPhoneNum) used to update the current phone number
                            teacherList.get(i).setPhoneNum(updatePhone);
                            System.out.println("\nPhone Number has been updated!");
                            Main.sysPause();
                            break;
                        case 5:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE ADDRESS  >>");
                            System.out.println("====================================================\n");

                            System.out.print("Enter your new Address: ");
                            String updateAddress = in.next();

                            teacherList.get(i).setAddress(updateAddress);
                            System.out.println("\nAddress has been updated!");
                            Main.sysPause();
                            break;
                        case 6:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE DEPARTMENT  >>");
                            System.out.println("====================================================\n");

                            System.out.println("[1] Business");
                            System.out.println("[2] Computing");
                            System.out.print("Enter your new Department: ");
                            String updateDepartment = in.next();

                            teacherList.get(i).setDepartment(updateDepartment);
                            System.out.println("\nDepartment has been updated!");
                            Main.sysPause();
                            break;
                        case 7:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE DESIGNATION  >>");
                            System.out.println("====================================================\n");

                            System.out.println("Enter your new Designation: ");
                            System.out.println("[1] Head of Faculty (HOF)");
                            System.out.println("[2] Coordinator     (CO)");
                            System.out.println("[3] Lecturer        (L)");
                            String updateDesignation = in.next();

                            teacherList.get(i).setDesignation(updateDesignation);
                            System.out.println("\nDesignation has been updated!");
                            Main.sysPause();
                            break;
                        case 8:
                            System.out.println("====================================================");
                            System.out.println("\t\t\t\t<< UPDATE TEACHING HOURS  >>");
                            System.out.println("====================================================\n");

                            System.out.println("Update Teaching Hours: ");
                            double updateTeachingHours = in.nextDouble();

                            teacherList.get(i).setTeachingHours(updateTeachingHours);
                            System.out.println("\nTeachingHours has been updated!");
                            Main.sysPause();
                            break;
                    }
                }
            }
        }
    }

    static void delete_teacher() {
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< DELETE TEACHER >>");
        System.out.println("====================================================\n");

        if (teacherList.size() == 0) {
            System.out.println("There are no TEACHERS registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
            return;
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Teacher ID (ex. 202110139): ");
            int delID = in.nextInt();

            for (int i = 0; i < teacherList.size(); i++) {
                if (teacherList.get(i).getID() == delID) {
                    System.out.println(teacherList.get(i).getID() + " Has been removed from the database!!");
                    teacherList.remove(i);

                    if (teacherList.lastIndexOf(i) == delID) {
                        System.out.println(teacherList.get(i).getID() + " Has been removed from the database!!");
                        teacherList.remove(i);
                    }
                }
            }
        }
    }
    static void salary(){

        System.out.println("====================================================");
        System.out.println("\t\t\t   << SALARY CALCULATOR >>");
        System.out.println("====================================================\n");

        if (teacherList.size() == 0) {
            System.out.println("There are no TEACHERS registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
        }
        else{
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Teacher ID (ex. 202110139): ");
            int salary_ID = in.nextInt();

            for (int k = 0; k < teacherList.size(); k++) {

                if(salary_ID == teacherList.get(k).getID()) {

                    // computation
                    double total_salary, net_salary;

                    total_salary = (base_salary) + (OT);
                    double HA = total_salary * ha;
                    double MA = total_salary * ma;
                    double TA = total_salary * ta;
                    net_salary = teacherList.get(k).getot_salary() + HA + MA + TA;

                    teacherList.get(k).setSalary(net_salary);

                    System.out.println("\nID NUMBER " + salary_ID);
                    System.out.println("Salary: " + teacherList.get(k).getSalary());
                    Main.YN_Exit();
                }
                else{
                    System.out.println("ID not found!");
                    Main.sysPause();
                }
                return;
            }

        }
    }

    static void display(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< TEACHERS INDEX >>");
        System.out.println("====================================================\n");

        if (teacherList.size() == 0) {
            System.out.println("There are no TEACHERS registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
            return;
        }
        else{
            System.out.println("\tID\tTEACHER NAME");
            for (int i = 0; i < teacherList.size(); i++) {
                System.out.println("\nTeacher ID# " + teacherList.get(i).getID() + " : " + teacherList.get(i).getFName() + " " + teacherList.get(i).getLName() + " | " + teacherList.get(i).getDepartment() + " - " + teacherList.get(i).getDesignation());
            }
            Main.YN_Exit();
        }
    }
}
