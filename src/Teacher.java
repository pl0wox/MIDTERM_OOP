import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Teacher extends Person {
    private String department, designation;
    private double teachingHours, salary;
    final double base_salary = 1200.00, OT = 325;


    public static List<Teacher> teacherList = new ArrayList<>();

    public Teacher(int ID, String Fname, String Lname, String Gender, String PhoneNum, String Address, String department, String designation, double teachingHours, double salary, double base_salary, double OT) {
        super(ID, Fname, Lname, Gender, PhoneNum, Address);
        this.department = department;
        this.designation = designation;
        this.teachingHours = teachingHours;
        this.salary = salary;
    }



    public String getDepartment() {
        return department;
    }
    public void setDepartment(){
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(){
        this.designation = designation;
    }

    public double getTeachingHours() {
        return teachingHours;
    }
    public void setTeachingHours(){
        this.teachingHours = teachingHours;
    }
    public double getTeachSalary(){
        return salary;
    }
    public void setTeachSalary(double salary){
        this.salary = salary;
    }

    static void add_teacher(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< ADD NEW TEACHER >>");
        System.out.println("====================================================\n");


        Scanner in = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Enter ID: ");
        int addID = in.nextInt();

        // Validation for Student ID
        for(int i = 0; i < teacherList.size(); i++){
            if(addID == teacherList.get(i).getID()){
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
            default:
                System.out.println("Please Enter a valid Input!");
        }


        System.out.println("Enter Designation: ");
        System.out.println("[1] Head of Faculty (HOF)");
        System.out.println("[2] Coordinator     (CO)");
        System.out.println("[3] Lecturer        (L)");

        String addDesignation = "";
        switch (Main.choice()){
            case 1:
                addDesignation = "Head of Faculty";
                break;
            case 2:
                addDesignation = "Coordinator";
                break;
            case 3:
                addDesignation = "Lecturer";
                break;
            default:
                System.out.println("Please enter a valid input!");
        }

        System.out.println("Enter no. of Teaching Hours: ");
        double addteachingHours = in.nextDouble();

        // store all inputs of user inside the constructor

        //Teacher teacherobj = new Teacher(addID,addFirstname,addLastname,addGender,addPhone,addAddress,addDepartment,addDesignation,addteachingHours, salary);

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
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        else{
            //insert here
        }
    }
    static void delete_teacher(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< DELETE TEACHER >>");
        System.out.println("====================================================\n");

        if (teacherList.size() == 0) {
            System.out.println("There are no TEACHERS registered in the database!");
            System.out.println("Returning to the Main Menu...");
            Main.sysPause();
            return;
        }
        else {
            //insert here
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
            return;
        }
        else{
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Student ID (ex. 202110139): ");
            int salary_ID = in.nextInt();



            for (int k = 0; k < teacherList.size(); k++) {
                if(salary_ID == teacherList.get(k).getID()) {

                    //double salary = ;
                    //teacherList.get(k).setTeachSalary(salary);

                    System.out.println("ID NUMBER " + salary_ID);
                    System.out.println("Salary: " + teacherList.get(k).getTeachSalary());
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
                if (teacherList.get(i).getID() != 0) {
                    System.out.println("\nTeacher ID# " + teacherList.get(i).getID() + " : " + teacherList.get(i).getFName() + " " + teacherList.get(i).getLName());
                }
            }
        }

        Main.YN_Exit();
    }
}