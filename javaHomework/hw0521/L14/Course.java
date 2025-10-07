package javaHomework.hw0521.L14;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private List<Student> students;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printInfo() {
        System.out.println("課程名稱: " + courseName);
        System.out.println("課程代碼: " + courseCode);
        System.out.println("學生名單:");
        for (Student s : students) {
            System.out.println("- 學生姓名: " + s.getName() + ", 學號: " + s.getStudentId());
        }
    }
}
