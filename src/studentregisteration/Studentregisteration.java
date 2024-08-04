

package studentregisteration;

import java.util.*;

public class Studentregisteration {

    public static void main(String[] args) {

        faculty f=new faculty("computer and data science");


        f.add_department("Intelligent System","2459",120);
        f.add_department("cyber security ","2455",120);
        f.add_department("Information tech","2849",120);
        f.add_department("Data science","3521",120);
        f.add_department("Machine learning Engineering","9859",120);

        f.add_faculty_for_department("Intelligent System");

        f.add_instructor_for_department("Intelligent System","muhammed saad","alex","1/1/1980","00000000000",43,"11452","352515856155");
        f.add_instructor_for_department("Intelligent System","muhammed waleed","alex","1/1/1980","00000000000",43,"11452","352515856155");
        f.add_instructor_for_department("Intelligent System","amin shokry","alex","1/1/1980","00000000000",43,"11452","352515856155");
        f.add_instructor_for_department("Intelligent System","ibrahim m3roof","alex","1/1/1980","00000000000",43,"11452","352515856155");
        f.add_instructor_for_department("Intelligent System","mohamed kholef","alex","1/1/1980","00000000000",43,"11452","352515856155");

        student student1=new student("mohamed",19,"2205050","computer and data science",2023,2023,"alexandria","1/1/2000","00000000000");
        student student2=new student("meray",19,"2205060","computer and data science",2023,2023,"alexandria","1/1/2000","00000000000");
        student student3=new student("ziad",19,"2205020","computer and data science",2023,2023,"alexandria","1/1/2000","00000000000");
        student student4=new student("malak",19,"2205080","computer and data science",2023,2023,"alexandria","1/1/2000","00000000000");
        student student5=new student("elsayd",19,"2205070","computer and data science",2023,2023,"alexandria","1/1/2000","00000000000");

        courses course1=new courses(220105,"programming",2,"nobook",4);
        courses course2=new courses(220106,"propability",2,"nobook",3);
        courses course3=new courses(220107,"calculas",2,"nobook",3);
        courses course4=new courses(220108,"communications",2,"nobook",3);
        courses course5=new courses(220109,"economics",1,"nobook",2);

        course1.add_prerequisite(course2);
        course1.add_prerequisite(course3);
        course1.add_prerequisite(course4);

        classroom classroom1=new classroom("1447","A0-L1",60);
        classroom classroom2=new classroom("1448","A1-L2",60);
        classroom classroom3=new classroom("1449","A2-L3",60);
        classroom classroom4=new classroom("1450","A3-L4",60);
        classroom classroom5=new classroom("1451","A4-L1",60);

        classroom1.add_courses(course1,"sunday",4);
        classroom1.add_courses(course2,"thursday",2);
        classroom1.add_courses(course3,"tuesday",1);
        classroom1.add_courses(course4,"wednesday",4);
        classroom1.add_courses(course5,"sunday",1);

        f.add_student_for_department("Intelligent System",student1);
        f.add_student_for_department("Intelligent System",student2);
        f.add_student_for_department("Intelligent System",student3);
        f.add_student_for_department("Intelligent System",student4);
        f.add_student_for_department("Intelligent System",student5);

        f.add_courses_for_department("Intelligent System",course1);
        f.add_courses_for_department("Intelligent System",course2);
        f.add_courses_for_department("Intelligent System",course3);
        f.add_courses_for_department("Intelligent System",course4);
        f.add_courses_for_department("Intelligent System",course5);

        f.add_department_for_instructor("Intelligent System","muhammed saad","cyber security");


        student1.register_course(course2);
        student1.register_course(course3);
        student1.register_course(course4);
        student1.register_course(course1);
        student1.register_course(course5);
        student1.withdrawCourse(course3);


        student1.setDepartment("Intelligent System");
        System.out.println("********************************************************");
        course1.print_course_information();
        System.out.println("********************************************************");
        student1.print_student_information();
        System.out.println("********************************************************");
        f.print_depatments_information();
        System.out.println("********************************************************");
        f.print_faculty_information();
        System.out.println("********************************************************");
        classroom1.print_classroom_table();

      //  student1.print_student_information();





















    }
    
}
