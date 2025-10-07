package javaHomework.hw0923;

public class MedicalSoldier extends Soldier {
    private M1911 m1911;

    public MedicalSoldier(String name) {
        super(name);
    }

    @Override
    public void setGun(AbstractGun gun) {
        if (gun instanceof M1911) {
            super.setGun(null);
            this.m1911 = (M1911) gun;
        } else if (gun instanceof Handgun) {
            super.setGun(gun);
            this.m1911 = null;
        } else {
            System.out.println("醫護兵無法使用手槍以外武器");
            super.setGun(null);
            this.m1911 = null;
        }
    }

    @Override
    public void killeEnemy(String name) {
        System.out.println("醫護兵開始殺敵");
        if (m1911 != null) {
            m1911.shoot();
        } else if (gun != null) {
            gun.shoot();
        }
    }

    public void healing(Soldier soldier) {
        System.out.println("醫護兵正在治療 " + soldier.getName());
        System.out.println("治療完成！");
    }
}
