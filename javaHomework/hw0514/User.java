package javaHomework.hw0514;
import java.util.ArrayList;
import java.util.List;

public class User
{
    protected String name;
    protected String userId;
    protected List<BookA> borrowedBooks;

    public User()
    {
        this.name = "";
        this.userId = "";
        this.borrowedBooks = new ArrayList<>();
    }

    public User(String name, String userId)
    {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void borrowBook(BookA book)
    {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            borrowedBooks.add(book);
            System.out.println(name + " 借閱了 " + book.getTitle());
        } else {
            System.out.println("此書已被借出: " + book.getTitle());
        }
    }

    public void returnBook(BookA book)
    {
        if (borrowedBooks.contains(book)) {
            book.setBorrowed(false);
            borrowedBooks.remove(book);
            System.out.println(name + " 歸還了 " + book.getTitle());
        } else {
            System.out.println("此書 " + book.getTitle() + " 不在你的借閱清單中");
        }
    }

    public void show()
    {
        System.out.println(name + " 借閱的書籍有:");
        for (BookA book : borrowedBooks) {
            System.out.println("- " + book);
        }
    }
}
