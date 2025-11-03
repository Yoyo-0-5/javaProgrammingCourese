package javaHomework.hw0923;

public class MachineGun extends AbstractGun {
    protected int model;

    public MachineGun() {
        super(50, 0.1);
    }

    public MachineGun(int gunDamage, double gunHitRate) {
        super(gunDamage, gunHitRate);
    }

    @Override
    public void shoot() {
        if (model == 0) {
            System.out.println("機槍射擊 碰!");
        } else if (model == 1) {
            System.out.println("機槍射擊 碰!碰!碰!碰!碰!碰!");
        } else {
            System.out.println("無法射擊");
        }
    }

    @Override
    public void fill() {
        System.out.println("填裝機槍彈夾");
    }

    @Override
    public void changeModel(int i) {
        this.model = i;
        if (model == 0) {
            System.out.println("切換至單發擊出模式");
            numberOfShoot = 1;
            gunHitRateBasedContinuousShooting = 1.0;
        } else if (model == 1) {
            System.out.println("切換至連續射擊");
            numberOfShoot = 10;
            gunHitRateBasedContinuousShooting = 0.1;
        } else {
            System.out.println("關保險");
            numberOfShoot = 0;
        }
    }
    
    @Override
    public String getGunName() {
        return "機槍";
    }
    
}
