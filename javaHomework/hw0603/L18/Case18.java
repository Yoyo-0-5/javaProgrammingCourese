package javaHomework.hw0603.L18;

public class Case18 {
    public static void main(String[] args) {
        // 建立基礎員工
        Employee emp1 = new Employee("11001", "林", "老師", 65000);
        emp1.showInformation();
        double bonus = emp1.calculateBonus();
        System.out.println(emp1.getName() + " 的年終獎金: " + bonus);
        emp1.updateInfo("王", "組長", 75000);
        emp1.showInformation();

        // 建立經理與下屬
        Manager mgr = new Manager("M001", "小明", "經理", 65000);
        Employee emp2 = new Employee("11002", "楊", "工程師", 85000);
        mgr.addSubordinate(emp1);
        mgr.addSubordinate(emp2);
        mgr.showSubordinates();

        // 建立工程師
        Engineer eng = new Engineer("E001", "小華", "資深工程師", 90000, "Java, Python, 系統設計");
        eng.showInformation();
    }
}
