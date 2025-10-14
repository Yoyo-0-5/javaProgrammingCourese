package javaHomework.hw0923;

public class Cannon extends MachineGun {
    @Override
    public void shoot() {
        if (model == 0) {
            System.out.println("機砲射擊 碰!");
        } else if (model == 1) {
            System.out.println("機砲射擊 碰!碰!碰!碰!碰!碰!");
        } else {
            System.out.println("無法射擊");
        }
    }
    
    @Override
    public String getGunName() {
        return "砲";
    }
    
    @Override
    public int getDamage() {
        return 30;
    }
}
