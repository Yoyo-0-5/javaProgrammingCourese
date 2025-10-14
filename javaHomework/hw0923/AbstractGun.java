package javaHomework.hw0923;

public abstract class AbstractGun {
    public abstract void shoot();
    public abstract void fill();
    
    // 新增：獲得槍枝名稱
    public abstract String getGunName();
    
    // 新增：更改射擊模式
    public abstract void changeModel(int i);
    
    // 新增：獲得槍枝傷害力
    public abstract int getDamage();
}
