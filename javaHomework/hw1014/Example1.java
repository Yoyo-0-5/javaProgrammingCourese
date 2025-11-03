package javaHomework.hw1014;

public class Example1 {

    public Example1() {
        String num1 = "123a";
        if(isInt(num1)) {
            System.out.println(num1 + " 是數值");
        } else {
            System.out.println(num1 + " 不是數值");
        }
    }

    private boolean isInt(String value) {

        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static void main(String[] args) {
        new Example1();
    }
}
