package javaHomework.hw0923;

public class MachineGunner extends Soldier {
    private Autocannons aut;

    public MachineGunner(String name) {
        super(name);
        this.setProfession("機槍兵");  // 設定職業別
    }

    @Override
    public void setGun(AbstractGun gun) {
        System.out.println("玩家 " + name + " 選取了 " + gun.getGunName());
        
        if (gun instanceof Autocannons) {
            super.setGun(gun);
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
    public void fire(Soldier soldier) {
        System.out.println(getProfession() + " " + name + " 瞄準殺敵 " + soldier.getName());
        System.out.println(getProfession() + " " + name);
        
        if (aut != null) {
            aut.erect();
            aut.shoot();
            System.out.println("使用了 " + aut.getGunName());
            // 攻擊對方
            soldier.attack(this, aut);
        } else if (gun != null) {
            gun.shoot();
            System.out.println("使用了 " + gun.getGunName());
            // 攻擊對方
            soldier.attack(this, gun);
        }
    }
}
