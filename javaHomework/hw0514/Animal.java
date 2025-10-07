package javaHomework.hw0514;

public class Animal
{
    protected String species;
    protected int age;
    protected String gender;
    protected String diet;

    public Animal(String species, int age, String gender, String diet)
    {
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.diet = diet;
    }

    public void displayInformation()
    {
        System.out.println("種類: " + species);
        System.out.println("年齡: " + age);
        System.out.println("性別: " + gender);
        System.out.println("飲食習慣: " + diet);
    }

    public void feed()
    {
        System.out.println(species + " 正在吃 " + diet);
    }

    public void move()
    {
        System.out.println(species + " 正在移動");
    }
}
