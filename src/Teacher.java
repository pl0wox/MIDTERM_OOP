import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Teacher extends Person {
    private String department, designation;
    private double teachingHours;

    public static List<Teacher> teacherList = new ArrayList<>();

    public Teacher(int ID, String Fname, String Lname, String Gender, String PhoneNum, String Address, String department, String designation, double teachingHours) {
        super(ID, Fname, Lname, Gender, PhoneNum, Address);
        this.department = department;
        this.designation = designation;
        this.teachingHours = teachingHours;
    }

    static void add_teacher(){
        System.out.println("====================================================");
        System.out.println("\t\t\t\t<< ADD NEW TEACHER >>"); //weh
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


        System.out.println("Enter Designation ");
        System.out.println("[1] Head of Faculty (HOF)");
        System.out.println("[2] Coordinator     (CO)");
        System.out.println("[3] Lecturer        (L)");

        String addDesignation = "";
        switch (Main.choice()){
            case 1:
                addDesignation = "Head of Faculty";
                break;
            case 2:
                addDesignation = "Cooorinator";
                break;
            case 3:
                addDesignation = "Lecturer";
                break;
            default:
                System.out.println("Please Enter a valid Input!");
        }

        System.out.println("Enter no. of Teaching Hours: ");
        double addteachingHours = in.nextDouble();
        
        // store all inputs of user inside the constructor
       Teacher teacherobj = new Teacher(addID,addFirstname,addLastname,addGender,addPhone,addAddress,addDepartment,addDesignation,addteachingHours);

        // store inside the array list
        teacherList.add(teacherobj);

    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public double getTeachingHours() {
        return teachingHours;
    }
}
