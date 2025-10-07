package javaHomework.hw0521.L14;

public class GraduateStudent extends Student {
    private String researchField;
    private String adviser;

    public GraduateStudent(String name, String studentId, String researchField, String adviser) {
        super(name, studentId);
        this.researchField = researchField;
        this.adviser = adviser;
    }

    public String getResearchField() {
        return researchField;
    }

    public String getAdviser() {
        return adviser;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("研究方向: " + researchField);
        System.out.println("指導教授: " + adviser);
    }
}
