package javaHomework.hw0603.L19;

public class Case19 {
    public Case19() {
        NewRelease n = new NewRelease("復仇者聯盟", "羅素兄弟", 5, 120.0, 3);
        n.showInfo();
        n.rentalMovie();
        n.extnedRentalPeriod(5);
        n.rentalMovie();
        Classic c = new Classic("教父", "法蘭西斯", 10, 100.0, 0.3);
        c.showInfo();
        c.rentalMovie();
        c.getDiscountFee();
        c.returnMovie();
    }
    public static void main(String[] args) {
        new Case19();
    }
}
