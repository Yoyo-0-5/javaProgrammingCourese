package javaHomework.hw1014;

public class Example2 {

    String account = "";
    String password = "456";

    public Example2() {
        boolean flag = true;

        while(flag) {
            try {
                boolean isLogin = check();
                if(isLogin) {
                    System.out.println("登入成功");
                } else {
                    System.out.println("帳號或密碼錯誤");
                }
                flag = false;
            } catch (Exception e) {
                e.printStackTrace();
                account = "123";
                password = "456";
            }
        }
        
        System.out.println("程式執行結束");
    }

    public boolean check() throws Exception {
        if(account.equals("") || password.equals("")) {
            throw new Exception("帳號密碼不可為空白");
        }
        if(account.equals("123") && password.equals("456")) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        new Example2();
    }
}
