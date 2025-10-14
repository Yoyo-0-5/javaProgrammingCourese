package javaHomework.hw0923;

public class AK47 extends Rifle {
    @Override
    public void shoot() {
        if (model == 0) {
            System.out.println("AK47射擊 碰!");
        } else if (model == 1) {
            System.out.println("AK47射擊 碰!碰!碰!");
        } else if (model == 2) {
            System.out.println("AK47射擊 碰!碰!碰!碰!碰!碰!");
        } else {
            System.out.println("無法射擊");
        }
    }
    
    @Override
    public String getGunName() {
        return "AK47步槍";
    }
    
    @Override
    public int getDamage() {
        return 28;
    }
}
