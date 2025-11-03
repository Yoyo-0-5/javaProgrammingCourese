package javaHomework.hw1014;

public class CustomException extends Exception {

    int number;

    public CustomException(int number) {
        this.number = number;
    }

    public String getMessage() {
        return "錯誤 請輸入 1-3 的數字";
    }
}
