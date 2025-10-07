package javaHomework.hw0603.L18;

public class Engineer extends Employee {
    private String skillDescription;

    public Engineer(String employeeId, String name, String position, double salary, String skillDescription) {
        super(employeeId, name, position, salary);
        this.skillDescription = skillDescription;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("專屬技能: " + skillDescription);
    }
}
