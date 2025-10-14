package javaHomework.hw0923;

public class Rifle extends AbstractGun {
    protected int model; // 0: 單發, 1: 三連發, 2: 連續射擊, 其他: 保險

    @Override
    public void shoot() {
        if (model == 0) {
            System.out.println("步槍射擊 碰!");
        } else if (model == 1) {
            System.out.println("步槍射擊 碰!碰!碰!");
        } else if (model == 2) {
            System.out.println("步槍射擊 碰!碰!碰!碰!碰!碰!");
        } else {
            System.out.println("無法射擊");
        }
    }

    @Override
    public void fill() {
        System.out.println("填裝步槍彈夾");
    }

    @Override
    public void changeModel(int i) {
        this.model = i;
        if (model == 0) {
            System.out.println("切換至單發擊出模式");
        } else if (model == 1) {
            System.out.println("切換至三發模式");
        } else if (model == 2) {
            System.out.println("切換至連續射擊");
        } else {
            System.out.println("關保險");
        }
    }
    
    @Override
    public String getGunName() {
        return "步槍";
    }
    
    @Override
    public int getDamage() {
        return 25;
    }
}
