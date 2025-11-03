package javaHomework.hw0923;

public class Handgun extends AbstractGun {
    private int model;

    public Handgun() {
        super(30, 0.8);
    }

    public Handgun(int gunDamage, double gunHitRate) {
        super(gunDamage, gunHitRate);
    }
    
    @Override
    public void shoot() {
        if (model == 0) {
            System.out.println("短槍射擊 碰!");
            
        } else {
            System.out.println("無法射擊，保險已關閉");
        }
    }

    @Override
    public void fill() {
        System.out.println("填裝短槍彈夾");
    }
    
    @Override
    public void changeModel(int i) {
        this.model = i;
        if (i == 0) {
            System.out.println("開保險，可以射擊");
            numberOfShoot = 1;
            gunHitRateBasedContinuousShooting = 1.0;
        } else {
            System.out.println("關保險");
            numberOfShoot = 0;
        }
    }
    
    @Override
    public String getGunName() {
        return "短槍";
    }
    
}
