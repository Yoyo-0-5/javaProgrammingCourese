package javaHomework.hw0923;

public class Medic extends Soldier {
    public Medic(String name) {
        super(name);
    }

    @Override
    public void setGun(AbstractGun gun) {
        if (gun instanceof Rifle) {
            System.out.println("醫護兵無法使用步槍");
            super.setGun(null);
        } else if (gun instanceof MachineGun) {
            System.out.println("醫護兵無法使用機槍");
            super.setGun(null);
        } else {
            super.setGun(gun);
        }
    }

    @Override
    public void killeEnemy(String name) {
        if (gun != null) {
            System.out.println("醫護兵開始殺敵");
            gun.shoot();
        }
    }

    public void heal(String targetName) {
        System.out.println("醫護兵正在治療 " + targetName);
        System.out.println("治療完成！");
    }
}
