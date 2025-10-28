package javaHomework.hw0923;

public abstract class AbstractGun {

    private double gunHitRate;

    private double gunHitRateBasedContinuousShooting;

    private int gunDamage;

    private int numberOfShoot;

    public AbstractGun(int gunDamage, double gunHitRate) {
        this.gunDamage = gunDamage;
        this.gunHitRate = gunHitRate;
         
    }

    public void setGunHitRateBasedContinuousShooting(double n) {
        gunHitRateBasedContinuousShooting = n;
    }

    public void setNmberOfShoot(int n) {
        numberOfShoot = n;
    }

    public int getNmberOfShoot() {
        return numberOfShoot;
    }

    public abstract void shoot();

    public abstract void fill();
    
    public abstract String getGunName();
    
    public abstract void changeModel(int i);
    
    public abstract int getDamage();

    

    

}
