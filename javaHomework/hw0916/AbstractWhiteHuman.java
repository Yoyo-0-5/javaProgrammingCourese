package javaHomework.hw0916;

public abstract class AbstractWhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("White");
    }

    @Override
    public void talk() {}

    @Override
    public void getSex() {}
}