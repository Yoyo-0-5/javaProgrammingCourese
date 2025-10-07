package javaHomework.hw0507;

public class GoldenRetriever extends Dog
{
    public GoldenRetriever()
    {
        this("流浪狗", "金色", 5);
    }

    public GoldenRetriever(String theName, String theColor, int theAge)
    {
        super(theName, theColor, theAge);
    }

    public void smile()
    {
        System.out.println(">_0");
    }

    @Override
    public void bark()
    {
        System.out.println("嗚~");
    }

    @Override
    public String toString()
    {
        return "我是一隻獵犬！";
    }

    public static void main(String[] args) 
    {
        GoldenRetriever g = new GoldenRetriever();
        System.out.println(g.name + " " + g.color + " " + g.age);
        g.bark();
        g.smile();
        g.toString();
    }
}

