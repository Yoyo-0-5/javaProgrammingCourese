package javaHomework.hw0514;

public class Case13 {
    public static void main(String[] args)
    {
        Animal human = new Animal("人類", 22, "男", "肉食");
        System.out.println("--- Animal 區 ---");
        human.feed();
        human.move();
        human.displayInformation();

        Mammal tiger = new Mammal("老虎", 3, "雄性", "肉食", "橘黑相間");
        System.out.println("\n--- 哺乳類區 ---");
        tiger.feed();
        tiger.move();
        tiger.displayInformation();

        Bird parrot = new Bird("鸚鵡", 1, "雌", "飼料", 0.5);
        System.out.println("\n--- 鳥群類區 ---");
        parrot.feed();
        parrot.move();
        parrot.displayInformation();
    }
}
