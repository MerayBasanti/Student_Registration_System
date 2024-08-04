 
package studentregisteration;
import java.util.*;
import java.io.*;

public class student extends person  {
    private int enrolled_year;
    private int enrolled_semster;
    private ArrayList<courses> taken_courses = new ArrayList<>();
    private int credit_hours;
    private department department;
    private String faculty;
    private ArrayList<courses> semester_courses = new ArrayList<>();
    private boolean registered;
    private int min_credit_hours=11;
    private int max_credit_hours=20;


    student() {
        studentregisteration.faculty.students.add(this);
    }

    ;

    public student(String name, int age, String id,String faculty, int enrolled_year, int enrolled_semster, String address,
                   String date_ofbirth, String telephon_number) {

        super(name, address, date_ofbirth, telephon_number, age, id);
        this.enrolled_year = enrolled_year;
        this.enrolled_semster = enrolled_semster;
        this.faculty=faculty;
        studentregisteration.faculty.students.add(this);

    }

    public String getFaculty() {

        return faculty;
    }

    public void setFaculty(String faculty) {
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



    public int getCredit_hours() {
        for (courses courses : semester_courses) {
            credit_hours+=courses.getCreditHours();
        }
        return credit_hours;
    }


    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public department getDepartment() {
        return department;
    }

    public void setDepartment( String department) {
        for (department department1: studentregisteration.faculty.departments){
            if (department1.getName().equalsIgnoreCase(department)){
                if (department1.getNoOfStudent() < department1.getCapacity()) {
                    department1.add_student(this);
                    this.department = department1;
                } else System.out.println("DEPARTMENT HAS REACHED THE MAXIMUM NUMBER OF STUDENT");
            }
        }

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

        if (taken_courses.containsAll(coursename.getPrerequisite_courses())
                && coursename.get_noOF_Registered_student() < coursename.get_capacity()
                &&credit_hours<=(max_credit_hours-coursename.getCreditHours())) {

            semester_courses.add(coursename);
            taken_courses.add(coursename);
            registered = true;
            coursename.add_student(this);
        } else System.out.println("YOU DID NOT COMPLETE THE PREREQUISITES OF THE COURSE, SO YOU CAN NOT REGISTER IT.");
    }

    public void withdrawCourse(courses coursename) {
        if (semester_courses.contains(coursename)
        &&credit_hours>=(min_credit_hours+coursename.getCreditHours()))
        semester_courses.remove(coursename);
        taken_courses.remove(coursename);
        registered = false;

    }

    public void print_student_information() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("ID: " + getId());
        System.out.println("Faculty Of: "+faculty);
        System.out.println("Enrolled Year: " + enrolled_year);
        System.out.println("Enrolled Semester: " + enrolled_semster);
        System.out.println("Credit Hours: " + getCredit_hours());
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








}








   

