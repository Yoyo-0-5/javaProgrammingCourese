package javaHomework.hw0923;

public class Medic extends Soldier {
    public Medic(String name) {
        super(name);
        this.setProfession("醫護兵");  // 設定職業別
    }

    @Override
    public void setGun(AbstractGun gun) {
        System.out.println("玩家 " + name + " 選取了 " + gun.getGunName());
        
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
    public void killeEnemy(Soldier soldier) {
        if (gun != null) {
            System.out.println(getProfession() + " " + name + " 攻擊 " + soldier.getName());
            gun.shoot();
            System.out.print("使用了 " + gun.getGunName());
            // 攻擊對方
            soldier.attack(this, gun);
        }
    }

    public void heal(String targetName) {
        System.out.println("醫護兵正在治療 " + targetName);
        System.out.println("治療完成！");
    }
}
