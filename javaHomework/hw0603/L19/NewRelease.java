package javaHomework.hw0603.L19;

public class NewRelease extends Movie_A
{
    private int rentalPeriod = 0;

    public NewRelease(String title, String director, int stock, double rentalFee, int rentalPeriod) 
    {
        super(title, director, stock, rentalFee);
        setRentalPeriod(rentalPeriod);
    }

    public void extnedRentalPeriod(int additionalDays) 
    {
        rentalPeriod = rentalPeriod + additionalDays;
        System.out.println(getTitle() + " 的租借期限已延長");
        System.out.println("新的租借期限為: " + rentalPeriod + " 天\n");
    }

    public int getRentalPeriod() 
    {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) 
    {
        this.rentalPeriod = rentalPeriod;
    }
}
