package javaHomework.hw0916;

public class Example {
    public Example() {
        MaleBlackHuman maleBlackHuman = new MaleBlackHuman();
        FemaleBlackHuman femaleBlackHuman = new FemaleBlackHuman();
        MaleWhiteHuman maleWhiteHuman = new MaleWhiteHuman();
        FemaleWhiteHuman femaleWhiteHuman = new FemaleWhiteHuman();

        HumanRun(maleBlackHuman);
        HumanRun(femaleBlackHuman);
        HumanRun(maleWhiteHuman);
        HumanRun(femaleWhiteHuman);
    }

    private void HumanRun(Human human) {
        human.getColor();
        human.talk();
        human.getSex();
        System.out.println("--------------");
    }

    public static void main(String[] args) {
        new Example();
    }
}
