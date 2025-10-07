package javaHomework.hw0603.L19;

public class Classic extends Movie_A
{
    private double discountRate = 0.0;

    public Classic(String title, String director, int stock, double rentalFee, double discountRate) 
    {
        super(title, director, stock, rentalFee);
        setDiscountRate(discountRate);
    }

    public double getDiscountRate() 
    {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) 
    {
        this.discountRate = discountRate;
    }

    public double getDiscountFee()
    {
        double discountFee = getRentalFee() * (1 - discountRate);
        System.out.println(getTitle() + " 的折扣費用為: " + discountFee + "\n");
        return discountFee; 
    }
}
