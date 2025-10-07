package javaHomework.hw0923;

public class Riflemen extends Soldier {
    public Riflemen(String name) {
        super(name);
    }

    @Override
    public void setGun(AbstractGun gun) {
        if (gun instanceof AUG) {
            System.out.println("步槍兵無法使用狙擊槍");
            super.setGun(null);
        } else if (gun instanceof Cannon) {
            System.out.println("步槍兵無法使用機砲");
            super.setGun(null);
        } else if (gun instanceof Autocannons) {
            System.out.println("步槍兵無法使用機砲");
            super.setGun(null);
        } else {
            super.setGun(gun);
        }
    }

    @Override
    public void killeEnemy(String name) {
        if (gun != null) {
            System.out.println("步槍兵開始殺敵");
            gun.shoot();
        }
    }
}
