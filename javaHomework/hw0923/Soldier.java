package javaHomework.hw0923;

public abstract class Soldier {
    protected AbstractGun gun;
    private String name;

    public Soldier(String name) {
        this.name = name;
    }

    public void setGun(AbstractGun gun) {
        this.gun = gun;
    }

    public String getName() {
        return name;
    }

    public void killeEnemy(String name) {
        System.out.println("士兵開始殺敵");
        if (gun != null) {
            gun.shoot();
        }
    }
}
