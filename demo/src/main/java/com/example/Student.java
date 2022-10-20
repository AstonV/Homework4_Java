package com.example;

import java.text.Collator;
import java.util.Comparator;
import java.util.LinkedList;

public class Student {
    private String firstName, lastName, major, department;
    private int age;
    private float GPA;
    private LinkedList<Course> course;
    final String ORDER = "MTWTFSS"; // date order mon,tues,...,sun
    final String ORDERTUETHUWED = "UEH"; // special order for tuesday wednesday thursday

    public Student(){
        super();
    }

    public Student(String firstName, String lastName, String major, String department, int age, float GPA, LinkedList<Course> course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.department = department;
        this.age = age;
        this.GPA = GPA;
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public LinkedList<Course> getCourse() {
        return course;
    }

    public void setCourse(LinkedList<Course> course) {
        this.course = course;
    }

    public boolean addCourse(Course courses) {
        return course.add(courses);
    }

    public boolean removeCourse(Course courses) {
        return course.remove(courses);
    }

    public LinkedList<Course> sortCourses(boolean ascending, String attribute) {
        attribute = attribute.trim().toLowerCase().replaceAll("\\s+", "");
        Comparator<Course> courseNameComparator = new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return Collator.getInstance().compare(o1.getCourseName(), o2.getCourseName());
            }
        };
        Comparator<Course> courseDesComparator = new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return Collator.getInstance().compare(o1.getCourseDescription(), o2.getCourseDescription());
            }
        };
        Comparator<Course> courseDepartmentComparator = new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return Collator.getInstance().compare(o1.getDepartment(), o2.getDepartment());
            }
        };
        Comparator<Course> courseTimeComparator = new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return Collator.getInstance().compare(o1.getCourseTime(), o2.getCourseTime());
            }
        };
        Comparator<Course> courseDateComparator = new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                //return Collator.getInstance().compare(o1.getCourseTime(), o2.getCourseTime());
                int pos1 = 0;
                int pos2 = 0;
                for (int i = 0; i < Math.min(o1.getCourseDate().length(), o2.getCourseDate().length()) && pos1 == pos2; i++) {
                    pos1 = ORDER.indexOf(o1.getCourseDate().toUpperCase().charAt(i));
                    pos2 = ORDER.indexOf(o2.getCourseDate().toUpperCase().charAt(i));
                    //Check if the day of the week is tue thu wed? value 1 is T and value 2 is W
                    if (((pos1 == 1 && pos2 == 2) || (pos2 == 1 && pos1 == 2))) {
                        pos1 = ORDERTUETHUWED.indexOf(o1.getCourseDate().toUpperCase().charAt(i + 1)); //Check next char for special case
                        pos2 = ORDERTUETHUWED.indexOf(o2.getCourseDate().toUpperCase().charAt(i + 1));
                    }

                }
                if (pos1 == pos2 && o1.getCourseDate().length() != o2.getCourseDate().length()) {
                    return o1.getCourseDate().length() - o2.getCourseDate().length();
                }
                return pos1 - pos2;
            }
        };

        if (attribute.equalsIgnoreCase("coursename")) {
            if (ascending) course.sort(courseNameComparator);
            else course.sort(courseNameComparator.reversed());
        } else if (attribute.equalsIgnoreCase("coursedescription")) {
            if (ascending) course.sort(courseDesComparator);
            else course.sort(courseDesComparator.reversed());
        } else if (attribute.equalsIgnoreCase("department")) {
            if (ascending) course.sort(courseDepartmentComparator);
            else course.sort(courseDepartmentComparator.reversed());
        } else if (attribute.equalsIgnoreCase("timethecoursestarts")) {
            if (ascending) course.sort(courseTimeComparator);
            else course.sort(courseTimeComparator.reversed());
        } else if (attribute.equalsIgnoreCase("weekdaythecourseisheldon")) {
            if (ascending) course.sort(courseDateComparator);
            else course.sort(courseDateComparator.reversed());
        }
        return course;
    }
}
