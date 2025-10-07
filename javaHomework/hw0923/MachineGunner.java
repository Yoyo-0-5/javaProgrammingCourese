package javaHomework.hw0923;

public class MachineGunner extends Soldier {
    private Autocannons aut;

    public MachineGunner(String name) {
        super(name);
    }

    @Override
    public void setGun(AbstractGun gun) {
        if (gun instanceof Autocannons) {
            super.setGun(null);
            this.aut = (Autocannons) gun;
        } else if (gun instanceof AUG) {
            System.out.println("機槍兵無法使用狙擊槍");
            super.setGun(null);
            this.aut = null;
        } else if (gun instanceof Rifle) {
            System.out.println("機槍兵無法使用步槍");
            super.setGun(null);
            this.aut = null;
        } else {
            super.setGun(gun);
            this.aut = null;
        }
    }

    @Override
    public void killeEnemy(String name) {
        System.out.println("機槍兵開始殺敵");
        if (aut != null) {
            aut.erect();
            aut.shoot();
        } else if (gun != null) {
            gun.shoot();
        }
    }
}
