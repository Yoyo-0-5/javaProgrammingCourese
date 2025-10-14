package javaHomework.hw0923;

public class Autocannons extends MachineGun {
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

    public void erect() {
        System.out.println("架設機砲中...");
    }
    
    @Override
    public String getGunName() {
        return "機砲";
    }
    
    @Override
    public int getDamage() {
        return 35;  // 機砲傷害力較高
    }
}
