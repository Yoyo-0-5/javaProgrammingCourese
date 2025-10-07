package javaHomework.hw0514;

public class BookA
{
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed = false;

    public BookA()
    {
        this.title = "";
        this.author = "";
        this.ISBN = "";
        this.isBorrowed = false;
    }

    public BookA(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.ISBN = "";
        this.isBorrowed = false;
    }

    public BookA(String title, String author, String ISBN)
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public String getISBN()
    {
        return this.ISBN;
    }

    public void setBorrowed(boolean status)
    {
        this.isBorrowed = status;
    }

    public boolean isBorrowed()
    {
        return this.isBorrowed;
    }

    public void borrow() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }

    @Override
    public String toString() {
        return "書名: " + title + ", 作者: " + author + ", ISBN: " + ISBN + ", 借閱狀態: " + (isBorrowed ? "已借出" : "可借閱");
    }
}
