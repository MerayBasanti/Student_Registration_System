
package studentregisteration;
import java.io.*;
import java.util.ArrayList;

class courses implements Serializable {//subclass
    private int course_id;
    private  String name;
    private int term;
    private String textBook;
    private  int noOfStudent_in_course=0;
    private int creditHours;
    private int course_capacity=50;
    private ArrayList<student>registered_student=new ArrayList<>();
    private ArrayList<department> departments=new ArrayList<>();
    private ArrayList<instructor> instructors=new ArrayList<>();
    private ArrayList<courses> prerequisite_courses=new ArrayList<>();
    private ArrayList<classroom> classrooms=new ArrayList<>();
    courses(){}

    public courses(int course_id,String name,int term,String textBook, int creditHours) {
          this.term=term;
        this.textBook = textBook;
        this.creditHours = creditHours;
        this.name=name;
     
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getTextBook() {
        return textBook;
    }

    public void setTextBook(String textBook) {
        this.textBook = textBook;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
    public void add_student(student student){
        if (student.isRegistered())
        registered_student.add(student);
        else System.out.println("STUDENT DID NOT REGISTER THE COURSE YET");
    }

    public int getNoOfStudent_in_course() {
        return noOfStudent_in_course;
    }

    public void setNoOfStudent_in_course(int noOfStudent_in_course) {
        this.noOfStudent_in_course = noOfStudent_in_course;
    }

    public int getCourse_capacity() {
        return course_capacity;
    }

    public void setCourse_capacity(int course_capacity) {
        this.course_capacity = course_capacity;
    }

    public void delete_student(student student){
        if (student.isRegistered()!=true)
        registered_student.remove(student);
           else System.out.println("STUDENT DID NOT WITHDRAW THE COURSE YET");

    }

    public void add_department(department department){
        departments.add(department);
    }
    public void delete_department(department department){
        registered_student.remove(department);
    }

    public void add_instructor(instructor instructor){
        instructors.add(instructor);
    }
    public void delete_instructor(instructor instructor){
        registered_student.remove(instructor);
    }
    public void add_prerequisite(courses courses){
        prerequisite_courses.add(courses);
    }
    public void delete_prerequisite(courses courses){
        registered_student.remove(courses);
    }
    public void add_classroom(classroom classroom){
        classrooms.add(classroom);
    }
    public void delete_classroom(classroom classroom){
        classrooms.remove(classroom);
    }

    public int get_capacity(){
        for(classroom classroom:classrooms){
           course_capacity+= classroom.getCapacity();
        }
        return course_capacity;

    }

    public int get_noOF_Registered_student() {
         for (student student:registered_student){
             noOfStudent_in_course++;
         }
         return noOfStudent_in_course;
    }

    public void print_instructor(){
        for (instructor instructor:instructors)
        instructor.print_instructor_information();
    }

    public void print_registered_student(){
        for (student student:registered_student)
            student.print_student_information();
    }
    public void print_department(){
        for (department department:departments)
             department.print_department_information();
    }
    public void print_prequisite(){
        for (courses courses:prerequisite_courses)
            courses.print_course_information();
    }

    public void print_classrooms(){
        for(classroom classroom:classrooms)
            System.out.println(classroom);
    }

    public ArrayList<courses> getPrerequisite_courses() {
        return prerequisite_courses;
    }


    public void print_course_information() {
        System.out.println("Name: " + getName());

        System.out.println("ID: " + getCourse_id());
        System.out.println("Term: " + term);
        System.out.println("Textbook: " + textBook);
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("Capacity: " +course_capacity );
        System.out.println("Number Of Students: " + noOfStudent_in_course);
        System.out.println("Registered Students:");
        for (student student : registered_student) {
            System.out.println(student.getName());
        }
        System.out.println("Departments:");
        for (department department : departments) {
            System.out.println(department.getName());
        }
        System.out.println("Instructors:");
        for (instructor instructor : instructors) {
            System.out.println(instructor.getName());
        }
        System.out.println("Prerequisite courses:");
        for (courses courses : prerequisite_courses) {
            System.out.println(courses.getName());
        }
     System.out.println("Classrooms:");
        for (classroom classroom : classrooms) {
        System.out.println(classroom.getClassroom_id());
    }}



    /*public void writeData(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(this);
            System.out.println("Successfully wrote course data to file: " + filename);
            System.out.println("Course information:");
            this.print_course_information();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static courses readData(String filename) {
        courses c = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            c = (courses) inputStream.readObject();
            System.out.println("Successfully read course data from file: " + filename);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }*/

}


