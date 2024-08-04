package studentregisteration;

import java.util.ArrayList;
import java.util.Arrays;


public class classroom {

    private String classroom_id;
    private String location;
    private int  capacity_of_classroom;

    ArrayList<courses>courses_list =new ArrayList<courses>();

    Object [][] table_of_courses=new Object[6][5];


    public classroom() {faculty.classrooms.add(this);
    }

    public classroom(String classroom_id,String location,int capacity_of_classroom) {
        this.classroom_id = classroom_id;
        this.capacity_of_classroom=capacity_of_classroom;
        this.location=location;
        faculty.classrooms.add(this);
    }

    public String getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(String classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity_of_classroom;
        }


    public void setCapacity(int capacity) {
        this.capacity_of_classroom = capacity;
    }



            public void add_courses(courses courses, String day, int period) {
                int dayIndex = -1;
                if (day.equalsIgnoreCase("sunday")) {
                    dayIndex = 1;
                } else if (day.equalsIgnoreCase("monday")) {
                    dayIndex = 2;
                } else if (day.equalsIgnoreCase("tuesday")) {
                    dayIndex = 3;
                } else if (day.equalsIgnoreCase("wednesday")) {
                    dayIndex = 4;
                } else if (day.equalsIgnoreCase("thursday")) {
                    dayIndex = 5;
                }

                if (dayIndex != -1 && period < 5 && table_of_courses[dayIndex][period] == null) {
                    table_of_courses[dayIndex][period] = courses.getName();
                    courses_list.add(courses);
                    courses.add_classroom(this);
                    print_classroom_table();

                } else {
                    System.out.println("YOUR PERIOD INPUT IS OUT OF BOUNDS, INPUT VALUE THAT IS LESS THAN 5");
                }
            }


    public void delete_course(courses courses) {
        boolean found = false;
        for (int i = 1; i < 6; i++) { // days
            for (int j = 1; j < 5; j++) { // periods
                if (table_of_courses[i][j] != null && table_of_courses[i][j].equals(courses.getName())) {
                    table_of_courses[i][j] = null;
                    courses_list.remove(courses.getName());
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("COURSE DOES NOT EXIST !!!!");
        }
        print_classroom_table();
    }



        public void print_classroom_table(){
        System.out.println("********************************************************************************************");

        table_of_courses[0][1]="1st period";    table_of_courses[0][0]="DAY/PERIOD";    table_of_courses[1][0]="SUNDAY";
        table_of_courses[0][2]="2nd period";    table_of_courses[2][0]="MONDAY";        table_of_courses[5][0]="THURSDAY";
        table_of_courses[0][3]="3rd period";    table_of_courses[3][0]="TUESDAY";
        table_of_courses[0][4]="4th period";    table_of_courses[4][0]="WEDNESDAY";

            for (int i = 0; i < table_of_courses.length; i++) {
                for (int j = 0; j < table_of_courses[1].length; j++) {

                    System.out.printf("%-20s", table_of_courses[i][j]);


                }
                System.out.println();
            }System.out.println("********************************************************************************************");

        }



    public void print_classroom_information() {
        System.out.println("Id: "+classroom_id);
        System.out.println("Capacity: "+capacity_of_classroom);
        System.out.println("Location: "+location);
        System.out.println("Course List: ");
        for (courses course:courses_list){
            System.out.println(course.getName()+"    "+course.getCreditHours());
        }
        System.out.println("TABLE OF THE CLASSROOM");
        print_classroom_table();

    }
}



























