/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentregisteration;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;


public class department  {
    private String name;
    private String id;
    private int noOfStudent_of_department=0;
    private int capacity;
    private  ArrayList<courses>course=new ArrayList<>();
    private  ArrayList<student>students=new ArrayList<>();
    private ArrayList<instructor>instructors=new ArrayList<>();
    private ArrayList<faculty> list_of_faculties=new ArrayList<>();


    department(){};

    public department(String name, String id, int capacity) {
        this.name = name;
        this.id = id;
        this.capacity = capacity;

      
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNoOfStudent() {
        return noOfStudent_of_department++ ;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent_of_department = noOfStudent;
    }

    public int getCapacity() {
        for (courses courses:course)
            capacity+=courses.get_capacity();
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }



    public void add_course(courses newcourse){

        course.add(newcourse);
        newcourse.add_department(this);
    }
    public void get_department_courses(){
        for (courses courses:course){
            courses.print_course_information();
        }
    }
 public void add_student(student newstudent){
        if(capacity>students.size()) {
            students.add(newstudent);
            noOfStudent_of_department++;
        }else
            System.out.println("THE DEPARTMENT REACHED THE MAXIMUM NUMBER OF REGISTERED STUDENTS");
 }
    public void get_department_students(){
        for (student student:students){
            student.print_student_information();
        }

    }

    public void add_instructor(String name, String address, String date_ofbirth, String telephon_number, int age, String id, department departmentOfInstructor,String instructor_id){
        instructor instructor=new instructor(name,address,date_ofbirth,telephon_number,age,id,this,instructor_id);
        instructors.add(instructor);
    }
    public void print_instructor_information(){
        for (instructor instructor:instructors){
            instructor.print_instructor_information();
        }
    }
    public void add_department_for_instructor(String indtructor_name,department department){
        for (instructor instructor:instructors){
            if (instructor.getName().equalsIgnoreCase(indtructor_name))
                instructor.add_department(department);
        }
    }
    public void getList_of_faculties() {
        for (faculty faculty:list_of_faculties)
        System.out.println( faculty.getFaculty_name());
    }

    public void add_faculties(faculty faculty) {
        list_of_faculties.add(faculty);
    }

    public void print_department_information(){
        System.out.println( "Name: "+getName());
        System.out.println("Id: "+getId());
        System.out.println("Capacity: "+capacity);
        System.out.println("Number Of Students: "+getNoOfStudent());
        for (student student:students){
            System.out.println(student.getName()+"    "+student.getId());
        }
        for (courses courses:course){
            System.out.println(courses.getName()+"    "+courses.getCourse_id());
        }
        for (faculty faculty:list_of_faculties){
            System.out.println(faculty.getFaculty_name());
        }
    }


    }
