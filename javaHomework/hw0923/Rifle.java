package javaHomework.hw0923;

public class Rifle extends AbstractGun {
    protected int model;

    public Rifle() {
        super(30, 0.6);
    }

    public Rifle(int gunDamage, double gunHitRate) {
        super(gunDamage, gunHitRate);
    }

    @Override
    public void shoot() {
        if (model == 0) {
            System.out.println("步槍射擊 碰!");
        } else if (model == 1) {
            System.out.println("步槍射擊 碰!碰!碰!");
        } else if (model == 2) {
            System.out.println("步槍射擊 碰!碰!碰!碰!碰!碰!");
        } else {
            System.out.println("無法射擊");
        }
    }

    @Override
    public void fill() {
        System.out.println("填裝步槍彈夾");
    }

    @Override
    public void changeModel(int i) {
        this.model = i;
        if (model == 0) {
            System.out.println("切換至單發擊出模式");
            numberOfShoot = 1;
            gunHitRateBasedContinuousShooting = 1.0;
        } else if (model == 1) {
            System.out.println("切換至三發模式");
            numberOfShoot = 3;
            gunHitRateBasedContinuousShooting = 0.6;
        } else if (model == 2) {
            System.out.println("切換至連續射擊");
            numberOfShoot = 5;
            gunHitRateBasedContinuousShooting = 0.3;
        } else {
            System.out.println("關保險");
            numberOfShoot = 0;
        }
    }
    
    @Override
    public String getGunName() {
        return "步槍";
    }
    
}
