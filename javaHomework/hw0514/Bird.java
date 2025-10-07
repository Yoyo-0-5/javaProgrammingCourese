package javaHomework.hw0514;

public class Bird extends Animal
{
    private double wingSpan;

    public Bird(String species, int age, String gender, String diet, double wingSpan)
    {
        super(species, age, gender, diet);
        this.wingSpan = wingSpan;
    }

    @Override
    public void displayInformation()
    {
        super.displayInformation();
        System.out.println("翼展: " + wingSpan + " 公尺");
    }
}
