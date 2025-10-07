package javaHomework.hw0507;

public class testMyRec {
    public static void main(String[] args) 
    {
        myRec rec1 = new myRec();
        rec1.show();
        System.out.println("面積: " + rec1.getArea());
        rec1.draw();
        System.out.println();

        myRec rec2 = new myRec(7, 3);
        rec2.show();
        System.out.println("面積: " + rec2.getArea());
        rec2.draw();
    }
}
