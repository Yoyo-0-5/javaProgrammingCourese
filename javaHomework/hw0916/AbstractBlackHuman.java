package javaHomework.hw0916;

public abstract class AbstractBlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("Black");
    }

    @Override
    public void talk() {}

    @Override
    public void getSex() {}
}
