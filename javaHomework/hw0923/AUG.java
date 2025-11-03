package javaHomework.hw0923;

public class AUG extends Rifle {

    public AUG() {
        super(100, 0.1);
    }
    public AUG(int gunDamage, double gunHitRate) {
        super(gunDamage, gunHitRate);
    }

    @Override
    public void shoot() {
        if (model == 0) {
            System.out.println("狙擊槍射擊 碰!");
        } else {
            System.out.println("無法射擊");
        }
    }

    @Override
    public void changeModel(int i) {
        this.model = i;
        if (model == 0) {
            System.out.println("切換至單擊發模式");
            numberOfShoot = 1;
            gunHitRateBasedContinuousShooting = 1.0;
        } else {
            System.out.println("關保險");
            numberOfShoot = 0;
        }
    }

    public void zoomOut() {
        System.out.println("透過望遠鏡來查看敵人");
    }
    
    @Override
    public String getGunName() {
        return "狙擊槍";
    }
    
}
