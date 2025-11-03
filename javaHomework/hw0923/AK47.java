package javaHomework.hw0923;

public class AK47 extends Rifle {

    public AK47() {
        super(45, 0.4);
    }

    public AK47(int gunDamage, double gunHitRate) {
        super(gunDamage, gunHitRate);
    }
    
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
    
}
