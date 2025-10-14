package javaHomework.hw0923;

public abstract class Soldier {
    protected AbstractGun gun;
    protected String name;  // 改為 protected，讓子類別可以直接存取
    private boolean survival = false;  // 是否陣亡（預設為未陣亡）
    private String profession = "";    // 職業別
    private int hp;                    // 血量

    public Soldier(String name) {
        this.name = name;
        this.hp = 100;  // 初始血量 100
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
    
    // 獲得職業別
    public String getProfession() {
        return profession;
    }
    
    // 設定職業別（讓子類別可以設定）
    protected void setProfession(String profession) {
        this.profession = profession;
    }
    
    // 獲得存活狀態
    public boolean getSurvival() {
        return survival;
    }
    
    // 獲得血量
    public int getHp() {
        return hp;
    }
    
    // 更改槍枝射擊模式
    public void changeModel(int i) {
        gun.changeModel(i);
        System.out.println(name + " 射擊模式更改");
    }
    
    // 攻擊其他士兵
    public void attack(Soldier soldier, AbstractGun gun) {
        // 顯示攻擊者和被攻擊者
        System.out.println(this.name + " 受到來自 " + soldier.getName() + 
                         " 的 " + gun.getDamage() + " 點傷害");
        
        // 扣除血量
        this.hp -= gun.getDamage();
        
        // 判斷是否陣亡
        if (this.hp <= 0) {
            this.hp = 0;
            this.survival = true;  // 已陣亡
        } else {
            System.out.println(this.name + " 剩下 " + this.hp + " 點血量");
            // 如果還有血量，可以反擊
            if (this.hp > 0) {
                this.killeEnemy(soldier);
            }
        }
    }
    
    // 抽象方法：擊殺敵人（由子類別實作）
    public abstract void killeEnemy(Soldier soldier);
}
