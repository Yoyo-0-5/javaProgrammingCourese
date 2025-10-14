package javaHomework.hw0923;

public class Client {
    public static void main(String[] args) {

        Soldier a = new Riflemen("玩家A");
        Soldier b = new Snipper("Computer");
        
        System.out.println("玩家" + a.getName() + " 選擇" + 
                         a.getProfession() + "角色加入戰場!!");
        System.out.println("玩家" + b.getName() + " 選擇" + 
                         b.getProfession() + "角色加入戰場!!");
        System.out.println();
        
        Rifle gunA = new AK47();
        a.setGun(gunA);
        
        Rifle gunB = new AUG();
        b.setGun(gunB);
        System.out.println();
        
        a.changeModel(0);
        b.changeModel(0);

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
