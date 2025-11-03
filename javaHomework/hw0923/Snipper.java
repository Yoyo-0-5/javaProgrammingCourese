package javaHomework.hw0923;

public class Snipper extends Soldier {
    private AUG aug;

    public Snipper(String name) {
        super(name);
        this.setProfession("狙擊手");  // 設定職業別
    }

    @Override
    public void setGun(AbstractGun gun) {
        System.out.println("玩家 " + name + " 選取了 " + gun.getGunName());
        
        if (gun instanceof AUG) {
            super.setGun(gun);
            this.aug = (AUG) gun;
        } else if (gun instanceof Cannon) {
            System.out.println("狙擊手無法使用機砲");
            super.setGun(null);
            this.aug = null;
        } else if (gun instanceof Autocannons) {
            System.out.println("狙擊手無法使用機砲");
            super.setGun(null);
            this.aug = null;
        } else {
            super.setGun(gun);
            this.aug = null;
        }
    }

    @Override
    public void fire(Soldier soldier) {
        System.out.println(getProfession() + " " + name + " 瞄準殺敵 " + soldier.getName());
        System.out.println(getProfession() + " " + name + " zoom in 和 zoom out");
        
        if (aug != null) {
            aug.zoomOut();
            aug.shoot();
            // 攻擊對方
            soldier.attack(this, aug);
        } else if (gun != null) {
            gun.shoot();
            // 攻擊對方
            soldier.attack(this, gun);
        }
    }
}
