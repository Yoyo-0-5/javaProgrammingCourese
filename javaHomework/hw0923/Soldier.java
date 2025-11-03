package javaHomework.hw0923;

public abstract class Soldier {
    protected AbstractGun gun;
    protected String name;
    private boolean survival = false;
    private String profession = "";
    private double hp;      

    public Soldier(String name) {
        this.name = name;
        this.hp = 100; 
    }
    
    public Soldier(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void setGun(AbstractGun gun) {
        this.gun = gun;
    }

    public String getName() {
        return name;
    }
    
    public String getProfession() {
        return profession;
    }
    
    protected void setProfession(String profession) {
        this.profession = profession;
    }
    
    public boolean getSurvival() {
        return survival;
    }
    
    public double getHp() {
        return hp;
    }
    
    public void changeModel(int i) {
        gun.changeModel(i);
        System.out.println(name + " 射擊模式更改");
    }
    
    public void attack(Soldier soldier, AbstractGun gun) {
        if(gun == null) {
            System.out.println(this.name + " 沒有武器，無法攻擊");
            return;
        }
        
        
        System.out.println("==============================");
        double damage = gun.getDamage();
        this.hp -= damage;
        System.out.println("==============================");
        System.out.println(this.name + " 受到來自 " + soldier.getName() + " 的 " + damage + " 點傷害");
        if (this.hp <= 0) {
            this.hp = 0;
            this.survival = true;  // 已陣亡
        } else {
            System.out.println(this.name + " 剩下 " + this.hp + " 點血量" + "\n");
            if (this.hp > 0) {
                this.fire(soldier);
            }
        }
    }
    
    public void killeEnemy(Soldier soldier) {
        if (gun.getNmberOfShoot() > 0) {
            fire(soldier);
        } else {
            soldier.attack(this, null);
        }
    }

    public abstract void fire(Soldier soldier);

}
