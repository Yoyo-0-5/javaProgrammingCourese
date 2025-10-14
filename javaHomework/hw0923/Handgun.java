package javaHomework.hw0923;

public class Handgun extends AbstractGun {
    private int model;  // 全域變數，控制槍枝模式
    
    @Override
    public void shoot() {
        // 判斷保險狀態
        if (model == 0) {
            System.out.println("短槍射擊 碰!");
        } else {
            System.out.println("無法射擊，保險已關閉");
        }
    }

    @Override
    public void fill() {
        System.out.println("填裝短槍彈夾");
    }
    
    @Override
    public void changeModel(int i) {
        this.model = i;
        if (i == 0) {
            System.out.println("開保險，可以射擊");
        } else {
            System.out.println("關保險");
        }
    }
    
    @Override
    public String getGunName() {
        return "短槍";
    }
    
    @Override
    public int getDamage() {
        return 15;
    }
}
