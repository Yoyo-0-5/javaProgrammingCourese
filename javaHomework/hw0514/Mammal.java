package javaHomework.hw0514;

public class Mammal extends Animal 
{
    private String furColor;

    public Mammal(String species, int age, String gender, String diet, String furColor)
    {
        super(species, age, gender, diet);
        this.furColor = furColor;
    }

    @Override
    public void displayInformation()
    {
        super.displayInformation();
        System.out.println("毛色: " + furColor);
    }
}
