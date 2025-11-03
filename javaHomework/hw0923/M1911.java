package javaHomework.hw0923;

public class M1911 extends Handgun {

    public M1911() {
        super(30, 0.8);
    }

    public M1911(int gunDamage, double gunHitRate) {
        super(gunDamage, gunHitRate);
    }

    @Override
    public void shoot() {
        System.out.println("M1911射擊 碰!");
    }
    
    @Override
    public String getGunName() {
        return "M1911手槍";
    }
    
}
