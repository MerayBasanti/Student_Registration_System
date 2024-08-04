/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentregisteration;


import java.util.ArrayList;

public class instructor extends person {
    private ArrayList<department>  departments_list;
    private department DepartmentOfInstructor;
    private String id;
    instructor() {faculty.instructors.add(this);
    }

    public instructor(String name, String address, String date_ofbirth, String telephon_number, int age, String id, department departmentOfInstructor,String instructor_id) {
        super(name, address, date_ofbirth, telephon_number, age, id);
        this.DepartmentOfInstructor=departmentOfInstructor;
        this.id=instructor_id;
        faculty.instructors.add(this);
    }

    public  void set_instructor_main_department(department D) {
        this.DepartmentOfInstructor = D;
    }

    public department get_instructor_main_department() {
        return DepartmentOfInstructor;
    }
    public void add_department(department d){
        departments_list.add(d);
    }

    public void getDepartments_list() {
        for (department department:departments_list)
        department.print_department_information();
    }


    public void print_instructor_information() {
        System.out.println(super.name+super.id+super.age+super.telephon_number);
        System.out.println( "Department Of Instructor: "+get_instructor_main_department());
        System.out.println("Instructor Id: "+id);
        System.out.println("Department List: ");
        for (department department:departments_list){
            System.out.println(department.getName());
        }
    }
}
