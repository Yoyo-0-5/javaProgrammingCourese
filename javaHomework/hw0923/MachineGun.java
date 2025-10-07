package javaHomework.hw0923;

public class MachineGun extends AbstractGun {
    protected int model; // 0: 單發, 1: 連續射擊, 其他: 保險

    @Override
    public void shoot() {
        if (model == 0) {
            System.out.println("機槍射擊 碰!");
        } else if (model == 1) {
            System.out.println("機槍射擊 碰!碰!碰!碰!碰!碰!");
        } else {
            System.out.println("無法射擊");
        }
    }

    @Override
    public void fill() {
        System.out.println("填裝機槍彈夾");
    }

    public void changeModel(int i) {
        this.model = i;
        if (model == 0) {
            System.out.println("切換至單發擊出模式");
        } else if (model == 1) {
            System.out.println("切換至連續射擊");
        } else {
            System.out.println("關保險");
        }
    }
}
