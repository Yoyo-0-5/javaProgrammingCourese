package javaHomework.hw0923;

public class Riflemen extends Soldier {
    public Riflemen(String name) {
        super(name);
        this.setProfession("步槍兵");  // 設定職業別
    }

    @Override
    public void setGun(AbstractGun gun) {
        System.out.println("玩家 " + name + " 選取了 " + gun.getGunName());
        
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
    public void killeEnemy(Soldier soldier) {
        if (gun != null) {
            System.out.println(getProfession() + " " + name + " 瞄準殺敵 " + soldier.getName());
            System.out.println(getProfession() + " " + name);
            gun.shoot();
            System.out.print("使用了 " + gun.getGunName());
            // 攻擊對方
            soldier.attack(this, gun);
        }
    }
}
