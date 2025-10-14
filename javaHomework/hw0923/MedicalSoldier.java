package javaHomework.hw0923;

public class MedicalSoldier extends Soldier {
    private M1911 m1911;

    public MedicalSoldier(String name) {
        super(name);
        this.setProfession("醫護兵");  // 設定職業別
    }

    @Override
    public void setGun(AbstractGun gun) {
        System.out.println("玩家 " + name + " 選取了 " + gun.getGunName());
        
        if (gun instanceof M1911) {
            super.setGun(gun);
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
    public void killeEnemy(Soldier soldier) {
        System.out.println(getProfession() + " " + name + " 攻擊 " + soldier.getName());
        
        if (m1911 != null) {
            m1911.shoot();
            System.out.print("使用了 " + m1911.getGunName());
            // 攻擊對方
            soldier.attack(this, m1911);
        } else if (gun != null) {
            gun.shoot();
            System.out.print("使用了 " + gun.getGunName());
            // 攻擊對方
            soldier.attack(this, gun);
        }
    }

    public void healing(Soldier soldier) {
        System.out.println("醫護兵正在治療 " + soldier.getName());
        System.out.println("治療完成！");
    }
}
