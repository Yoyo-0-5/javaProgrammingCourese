package javaHomework.hw0521.L14;

public class ManagementSystem {
    public static void main(String[] args) {
        
        Student s1 = new Student("小明", "S123456");
        GraduateStudent s2 = new GraduateStudent("小華", "G987654", "人工智慧", "Lin");

        
        Course course = new Course("資料結構", "CS001");
        course.addStudent(s1);
        course.addStudent(s2);

        
        s1.addGrade("CS001", 90);
        s2.addGrade("CS001", 77);

        
        System.out.println("====================");
        System.out.println("課程資訊:");
        course.printInfo();

        
        System.out.println("====================");
        System.out.println("學生成績資訊:");
        s1.printInfo();
        System.out.println("--------------------");
        s2.printInfo();
    }
}
