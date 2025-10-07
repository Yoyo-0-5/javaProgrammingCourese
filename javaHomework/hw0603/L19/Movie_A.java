package javaHomework.hw0603.L19;

public class Movie_A
{
    private String title = "";
    private String director = "";
    private int stock = 0;
    private double rentalFee = 0.0;

    public Movie_A(String title, String director, int stock, double rentalFee) 
    {
        setTitle(title);
        setDirector(director);
        setStock(stock);
        setRentalFee(rentalFee);
    }

    public boolean rentalMovie()
    {
        if (stock > 0)
        {
            stock--;
            System.out.println(title + " 以出租成功");
            System.out.println("剩餘庫存: " + stock + "\n");
            return true;
        }
        else
        {
            System.out.println(title + " 無庫存，無法出租\n");
            return false;
        }
    }

    public void returnMovie()
    {
        stock++;
        System.out.println(title + " 已歸還成功");
        System.out.println("剩餘庫存: " + stock + "\n");
    }

    public String getTitle()
    {
        return title;
    }

    public String getDirector()
    {
        return director;
    }

    public int getStock()
    {
        return stock;
    }

    public double getRentalFee()
    {
        return rentalFee;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public void setRentalFee(double rentalFee)
    {
        this.rentalFee = rentalFee;
    }

    public void showInfo()
    {
        System.out.println("電影名稱: " + title);
        System.out.println("導演: " + director);
        System.out.println("庫存: " + stock);
        System.out.println("租金: " + rentalFee + "\n");
    }

}
