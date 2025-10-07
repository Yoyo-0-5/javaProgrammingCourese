package javaHomework.hw0603.L18;

public class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        setEmployeeId(employeeId);
        setName(name);
        setPosition(position);
        setSalary(salary);
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    public double calculateBonus() {
        double bonus = salary * 1.5;
        System.out.println(name + " 的年終獎金為: " + bonus);
        return bonus;
    }

    public void updateInfo(String name, String position, double salary) {
        setName(name);
        setPosition(position);
        setSalary(salary);
        System.out.println("員工資訊已更新: " + this.name + ", " + this.position + ", 薪水: " + this.salary);
    }

    public void showInformation() {
        System.out.println("員工ID: " + getEmployeeId());
        System.out.println("姓名: " + getName());
        System.out.println("職位: " + getPosition());
        System.out.println("薪水: " + getSalary());
    }
}
