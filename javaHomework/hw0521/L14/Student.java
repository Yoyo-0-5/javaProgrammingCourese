package javaHomework.hw0521.L14;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String studentId;
    private Map<String, Double> transcript;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.transcript = new HashMap<>();
    }

    public void addGrade(String courseCode, double grade) {
        transcript.put(courseCode, grade);
    }

    public void updateGrade(String courseCode, double grade) {
        if (transcript.containsKey(courseCode)) {
            transcript.put(courseCode, grade);
        } else {
            System.out.println("成績單當中找不到該課程代碼: " + courseCode);
        }
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public Map<String, Double> getTranscript() {
        return transcript;
    }

    public void printInfo() {
        System.out.println("學生姓名: " + name);
        System.out.println("學號: " + studentId);
        System.out.println("成績單:");
        for (Map.Entry<String, Double> entry : transcript.entrySet()) {
            System.out.println("課程代碼: " + entry.getKey() + ", 成績: " + entry.getValue());
        }
    }
}
