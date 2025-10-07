package javaHomework.hw0603.L18;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private List<Employee> subordinates;

    public Manager(String employeeId, String name, String position, double salary) {
        super(employeeId, name, position, salary);
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
        System.out.println(employee.getName() + " 已加入 " + getName() + " 的下屬名單");
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void showSubordinates() {
        System.out.println(getName() + " 的下屬員工:");
        for (Employee e : subordinates) {
            e.showInformation();
            System.out.println("--------------------");
        }
    }
}
