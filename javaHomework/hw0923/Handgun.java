package javaHomework.hw0923;

public class Handgun extends AbstractGun {
    @Override
    public void shoot() {
        System.out.println("短槍射擊 碰!");
    }

    @Override
    public void fill() {
        System.out.println("填裝短槍彈夾");
    }
}
