package javaHomework.hw0923;

public class Client {
    public static void main(String[] args) {

        Soldier a = new MachineGunner("玩家A");
        Soldier b = new MedicalSoldier("Computer");
        
        System.out.println("玩家" + a.getName() + " 選擇" + 
                         a.getProfession() + "角色加入戰場!!");
        System.out.println("玩家" + b.getName() + " 選擇" + 
                         b.getProfession() + "角色加入戰場!!");
        System.out.println();

        AbstractGun gunA = new GunFactory().generateGun(Autocannons.class);
        a.setGun(gunA);
        
        AbstractGun gunB = new GunFactory().generateGun(M1911.class);
        b.setGun(gunB);
        System.out.println();
        
        a.changeModel(1);
        b.changeModel(0);
        System.out.println();

        a.killeEnemy(b);
        
        if (!a.getSurvival() || !b.getSurvival()) {
            System.out.println("遊戲結束!!");
            if (b.getSurvival()) {
                System.out.println(a.getName() + " 獲勝！!");
            } else {
                System.out.println(b.getName() + " 獲勝！!");
            }
        }
        
    }
}
