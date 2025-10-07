package javaHomework.hw0916;

public class MaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void talk() {
        System.out.println("Male White Human is talking");
    }

    @Override
    public void getSex() {
        System.out.println("White Human is male");
    }
}
