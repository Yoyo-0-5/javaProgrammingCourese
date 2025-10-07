package javaHomework.hw0514;

public class Case {
    public static void main(String[] args) 
    {
        BookA book1 = new BookA("Java程式語言", "張大名", "654-33333-2");
        BookA book2 = new BookA("資料結構", "蘇大名", "5545-3533-2");

        User user = new User("小明", "user001");
        user.borrowBook(book1);
        user.borrowBook(book2);
        user.show();
        user.returnBook(book1);
        user.show();

        Staff staff = new Staff("林", "user002", "staff001");
        staff.addBook(book1);
        staff.addBook(book2);
        staff.showLibrary();
    }
}
