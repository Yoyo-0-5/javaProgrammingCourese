package javaHomework.hw0923;

public class Client {
    public static void main(String[] args) {
        System.out.println("========== 步槍兵測試 ==========");
        // 創建步槍兵使用 AK47
        Soldier soldier1 = new Riflemen("張三");
        Rifle ak47 = new AK47();
        soldier1.setGun(ak47);
        
        // 測試不同模式
        ak47.changeModel(0);
        soldier1.killeEnemy("敵人A");
        System.out.println();
        
        ak47.changeModel(1);
        soldier1.killeEnemy("敵人B");
        System.out.println();
        
        ak47.changeModel(2);
        soldier1.killeEnemy("敵人C");
        System.out.println();
        
        ak47.changeModel(3);
        soldier1.killeEnemy("敵人D");
        System.out.println();
        
        // 測試步槍兵無法使用狙擊槍
        System.out.println("--- 步槍兵嘗試使用狙擊槍 ---");
        AUG aug = new AUG();
        soldier1.setGun(aug);
        soldier1.killeEnemy("敵人E");
        System.out.println();
        
        System.out.println("========== 狙擊手測試 ==========");
        // 創建狙擊手使用 AUG
        Soldier soldier2 = new Snipper("李四");
        AUG aug2 = new AUG();
        soldier2.setGun(aug2);
        
        aug2.changeModel(0);
        soldier2.killeEnemy("敵人F");
        System.out.println();
        
        // 狙擊手也可以用 AK47
        System.out.println("--- 狙擊手使用 AK47 ---");
        Rifle ak47_2 = new AK47();
        soldier2.setGun(ak47_2);
        ak47_2.changeModel(1);
        soldier2.killeEnemy("敵人G");
        System.out.println();
        
        System.out.println("========== 機槍兵測試 ==========");
        // 創建機槍兵使用機砲
        Soldier soldier3 = new MachineGunner("王五");
        Autocannons autocannons = new Autocannons();
        soldier3.setGun(autocannons);
        
        autocannons.changeModel(0);
        soldier3.killeEnemy("敵人H");
        System.out.println();
        
        autocannons.changeModel(1);
        soldier3.killeEnemy("敵人I");
        System.out.println();
        
        // 測試機槍兵無法使用狙擊槍
        System.out.println("--- 機槍兵嘗試使用狙擊槍 ---");
        soldier3.setGun(aug2);
        soldier3.killeEnemy("敵人J");
        System.out.println();
        
        // 測試步槍兵無法使用機砲
        System.out.println("--- 步槍兵嘗試使用機砲 ---");
        soldier1.setGun(autocannons);
        soldier1.killeEnemy("敵人K");
        System.out.println();
        
        System.out.println("========== 醫護兵測試 ==========");
        // 創建醫護兵使用M1911
        MedicalSoldier medicalSoldier = new MedicalSoldier("趙六");
        M1911 m1911 = new M1911();
        medicalSoldier.setGun(m1911);
        
        medicalSoldier.killeEnemy("敵人L");
        System.out.println();
        
        // 測試醫護兵的治療功能
        System.out.println("--- 醫護兵治療功能 ---");
        medicalSoldier.healing(soldier1);
        System.out.println();
        
        // 測試醫護兵無法使用步槍
        System.out.println("--- 醫護兵嘗試使用步槍 ---");
        medicalSoldier.setGun(ak47);
        medicalSoldier.killeEnemy("敵人M");
        System.out.println();
        
        // 測試醫護兵無法使用機槍
        System.out.println("--- 醫護兵嘗試使用機槍 ---");
        MachineGun machineGun = new MachineGun();
        medicalSoldier.setGun(machineGun);
        medicalSoldier.killeEnemy("敵人N");
    }
}
