package javaHomework.hw0916;

public class MaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void talk() {
        System.out.println("Male Black Human is talking");
    }

    @Override
    public void getSex() {
        System.out.println("Black Human is male");
    }
}
