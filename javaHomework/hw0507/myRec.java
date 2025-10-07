package javaHomework.hw0507;

public class myRec
{
    private int length;
    private int width;

    public myRec()
    {
        this.length = 10;
        this.width = 5;
    }

    public myRec(int length, int width)
    {
        this.length = length;
        this.width = width;
    }

    public void show()
    {
        System.out.println("長: " + length + ", 寬: " + width);
    }

    public int getArea()
    {
        return length * width;
    }

    public void draw()
    {
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < length; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
