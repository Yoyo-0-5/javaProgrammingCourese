package javaHomework.hw0923;

public class Snipper extends Soldier {
    private AUG aug;

    public Snipper(String name) {
        super(name);
    }

    @Override
    public void setGun(AbstractGun gun) {
        if (gun instanceof AUG) {
            super.setGun(null);
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
    public void killeEnemy(String name) {
        System.out.println("狙擊手開始殺敵");
        if (aug != null) {
            aug.zoomOut();
            aug.shoot();
        } else if (gun != null) {
            gun.shoot();
        }
    }
}
