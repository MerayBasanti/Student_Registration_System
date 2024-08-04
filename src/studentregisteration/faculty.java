package studentregisteration;

import java.util.ArrayList;

public class faculty {

    private String faculty_name;
    private int capacity_faculty;
    public static ArrayList<department> departments=new ArrayList<department>();
    public static ArrayList<student> students=new ArrayList<student>();
    public static ArrayList<instructor>instructors=new ArrayList<>();
    public static ArrayList<classroom>classrooms=new ArrayList<classroom>();

    public faculty() {
    }


    public faculty(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public void getDepartments() {
        for (department department:departments){
            department.print_department_information();
        }
    }


    public void getStudents() {
        for (student student:students){
            student.print_student_information();
        }
    }

    public void setStudents(ArrayList<student> students) {
        this.students = students;
    }



    public void getClassrooms() {
       for (classroom classroom:classrooms){
           classroom.print_classroom_information();
       }


    }

    public void setClassrooms(ArrayList<classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public int get_capacity(){
        for (classroom classroom:classrooms){
           capacity_faculty+= classroom.getCapacity();
        }
        return capacity_faculty;
    }

    public void add_classroom(classroom classroom){
            classrooms.add(classroom);

    }


    public void add_department(String name, String id, int capacity){
        department department1=new department(name,id,capacity);
        departments.add(department1);
    }
    public void add_student_for_department(String department_name,student student){
        for (department department:departments){
            if (department.getName().equalsIgnoreCase(department_name)){
                department.add_student(student);
            }
        }
    }
    public void add_courses_for_department(String department_name,courses courses){
        for (department department:departments){
            if (department.getName().equalsIgnoreCase(department_name)){
                department.add_course(courses);
            }
        }

    }
    public void add_faculty_for_department(String department){
        for (studentregisteration.department department1:departments){
            if (department1.getName().equalsIgnoreCase(department))
            department1.add_faculties(this);
        }
    }
    public void add_instructor_for_department(String department_name,String name, String address, String date_ofbirth, String telephon_number, int age, String id,String instructor_id ){
           for (department department2:departments)
            if (department2.getName().equalsIgnoreCase(department_name)){
                department2.add_instructor(name,address,date_ofbirth,telephon_number,age,id,department2,instructor_id);
            }
        }

    public void add_department_for_instructor(String department_name,String indtructor_name,String department){
        for (studentregisteration.department department1:departments){
            if (department1.getName().equalsIgnoreCase(department_name)){
                for (studentregisteration.department department2:departments){
                    if (department2.getName().equalsIgnoreCase(department))
                department1.add_department_for_instructor(indtructor_name,department2);
            }}
        }
    }

    public void add_student(student student){
        if(student.isRegistered()&&departments.contains(student.getDepartment()))
            students.add(student);
    }

    public void delete_student(student student){
        if (departments.contains(student.getDepartment())&& students.contains(student))
            students.remove(student);
        else System.out.println("STUDENT IS NOT FOUND IN THIS FACULTY");
    }

public void print_depatments_information(){
        for (department department:departments){
            department.print_department_information();
        }
}

    public void print_faculty_information() {
        System.out.println("Faculty Name: " + faculty_name);
        System.out.println("Capacity Of Faculty: " + get_capacity());
        System.out.println("Departments: ");
        for (department department : departments) {
            System.out.println(department.getName());
        }

        System.out.println("Instructors: ");
        for (instructor instructor : instructors) {
            System.out.println(instructor.getName() +"    "+ instructor.getId());
        }
        System.out.println("Students: ");
        for (student student : students) {
            System.out.println(student.getName() +"    "+ student.getId());
        }
        System.out.println("Classrooms: ");
        for (classroom classroom : classrooms) {
            System.out.println(classroom.getClassroom_id() +"    "+ classroom.getLocation());

        }
    }}
