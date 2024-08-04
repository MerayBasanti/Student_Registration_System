/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentregisteration;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;


public class department implements Serializable {
    private String name;
    private int id;
    private int noOfStudent_of_department=0;
    private int capacity;
    private ArrayList<courses>course;
    private ArrayList<student>students;
    private ArrayList<faculty> list_of_faculties;


    department(){};

    public department(String name, int id, int capacity) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void print_department_information(){
        System.out.println( "Name: "+getName());
        System.out.println("Id: "+getId());
        System.out.println("Capacity: "+getCapacity());
        System.out.println("Number Of Students: "+getNoOfStudent());
        for (student student:students){
            System.out.println(student.getName()+student.getId());
        }
        for (courses courses:course){
            System.out.println(courses.getName()+courses.getCourse_id());
        }
        for (faculty faculty:list_of_faculties){
            System.out.println(faculty.getFaculty_name());
        }
    }

    public void writeData(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static department readData(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (department) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }}
