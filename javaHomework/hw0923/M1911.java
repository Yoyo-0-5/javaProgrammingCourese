package javaHomework.hw0923;

public class M1911 extends Handgun {
    @Override
    public void shoot() {
        System.out.println("M1911射擊 碰!");
    }
    
    @Override
    public String getGunName() {
        return "M1911手槍";
    }
    
    @Override
    public int getDamage() {
        return 15;  // 繼承手槍的傷害力
    }
}
