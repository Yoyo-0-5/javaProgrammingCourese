package javaHomework.hw0923;

import java.util.Random;

public abstract class AbstractGun {

    public double gunHitRate;

    public double gunHitRateBasedContinuousShooting;

    public int gunDamage;

    public int numberOfShoot;

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
    
    public double getGunHitRate() {
        Random rand = new Random();
        return gunHitRate + rand.nextDouble() * (1 - gunHitRate);
    }

    public double getDamage() {
        double damage = 0.0;
        double totalDamage = 0.0;

        System.out.println(getGunName() + "命中率：" + gunHitRate + " 射擊次數：" + numberOfShoot + " 連續命中率：" + gunHitRateBasedContinuousShooting);
        
        for (int i = 0; i < numberOfShoot; i++) {
            double HitRate = getGunHitRate();
            damage = gunDamage * HitRate * gunHitRateBasedContinuousShooting;
            totalDamage += damage;

            System.out.println("第 " + (i + 1) + " 攻擊命中率：" + HitRate + " 傷害：" + damage);
        }
        return totalDamage;
    }

    

}
