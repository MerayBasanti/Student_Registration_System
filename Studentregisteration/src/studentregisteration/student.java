 
package studentregisteration;
import java.util.*;
import java.io.*;

public class student extends person implements Serializable/**/ {//subclass
    private int enrolled_year;
    private int enrolled_semster;
    private ArrayList<courses> taken_courses = new ArrayList<>();
    private int credit_hours;
    private department department;
    private faculty faculty;
    private ArrayList<courses> semester_courses = new ArrayList<>();
    private boolean registered;


    student() {
    }

    ;

    public student(String name, int age, int id,faculty faculty, int enrolled_year, int enrolled_semster, int credit_hours, String address,
                   String date_ofbirth, String telephon_number) {

        super(name, address, date_ofbirth, telephon_number, age, id);
        this.enrolled_year = enrolled_year;
        this.enrolled_semster = enrolled_semster;
        this.credit_hours = credit_hours;

    }

    public studentregisteration.faculty getFaculty() {

        return faculty;
    }

    public void setFaculty(studentregisteration.faculty faculty) {
        this.faculty = faculty;
    }

    public int getEnrolled_year() {
        return enrolled_year;
    }

    public void setEnrolled_year(int enrolled_year) {
        this.enrolled_year = enrolled_year;
    }

    public int getEnrolled_semster() {
        return enrolled_semster;
    }

    public void setEnrolled_semster(int enrolled_semster) {
        this.enrolled_semster = enrolled_semster;
    }

    public void getTaken_courses() {
        for (int i = 0; i < taken_courses.size(); i++) {
            System.out.println(taken_courses.get(i));
        }
    }

    public void addCourse(courses course) {
        taken_courses.add(course);
        semester_courses.add(course);
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public department getDepartment() {
        return department;
    }

    public void setDepartment(department department) {
        if (department.getNoOfStudent() < department.getCapacity())
            this.department = department;
        else System.out.println("DEPARTMENT HAS REACHED THE MAXIMUM NUMBER OF STUDENT");
    }

    public void getSemester_courses() {
        for (courses courses : semester_courses) {
            courses.print_course_information();
        }
    }

    public boolean isRegistered() {
        return registered;
    }

    public void register_course(courses coursename) {

        if (taken_courses.containsAll(coursename.getPrerequisite_courses()) && coursename.get_noOF_Registered_student() < coursename.get_capacity()) {

            semester_courses.add(coursename);
            taken_courses.add(coursename);
            registered = true;
        } else System.out.println("YOU DID NOT COMPLETE THE PREREQUISITES OF THE COURSE, SO YOU CAN NOT REGISTER IT.");
    }

    public void withdrawCourse(courses coursename) {
        semester_courses.remove(coursename);
        taken_courses.remove(coursename);
        registered = false;

    }

    public void print_student_information() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("ID: " + getId());
        System.out.println("Faculty Of: "+faculty.getFaculty_name());
        System.out.println("Enrolled Year: " + enrolled_year);
        System.out.println("Enrolled Semester: " + enrolled_semster);
        System.out.println("Credit Hours: " + credit_hours);
        System.out.println("Registered: " + registered);
        System.out.println("Department: " + (department != null ? department.getName() : "N/A"));
        System.out.println("Taken Courses:");
        for (courses course : taken_courses) {
            System.out.println(course.getName());
        }
        System.out.println("Semester Courses:");
        for (courses course : semester_courses) {
            System.out.println(course.getName());
        }
    }






   /* public void writeData(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            // Print the student information before writing to the file
            System.out.println("Writing student data to file: " + filename);
            System.out.println("Name: " + getName());
            System.out.println("Age: " + getAge());
            System.out.println("ID: " + getId());
            System.out.println("Enrolled Year: " + enrolled_year);
            System.out.println("Enrolled Semester: " + enrolled_semster);
            System.out.println("Credit Hours: " + credit_hours);
            System.out.println("Registered: " + registered);
            System.out.println("Department: " + (department != null ? department.getName() : "N/A"));
            System.out.println("Taken Courses:");
            for (courses course : taken_courses) {
                System.out.println(course.getName());
            }
            System.out.println("Semester Courses:");
            for (courses course : semester_courses) {
                System.out.println(course.getName());
            }

            // Write the student object to the file
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static student readData(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (student) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }*/

}








   

