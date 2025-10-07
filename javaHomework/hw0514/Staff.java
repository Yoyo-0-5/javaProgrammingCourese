package javaHomework.hw0514;
import java.util.ArrayList;
import java.util.List;

public class Staff extends User
{
    private String staffId;
    private List<BookA> library;

    public Staff(String name, String userId, String staffId)
    {
        super(name, userId);
        this.staffId = staffId;
        this.library = new ArrayList<>();
    }

    public void setStaffId(String staffId)
    {
        this.staffId = staffId;
    }

    public String getStaffId()
    {
        return this.staffId;
    }

    public void addBook(BookA book)
    {
        library.add(book);
        System.out.println("新增書籍至館藏: " + book.getTitle());
    }

    public void showLibrary()
    {
        System.out.println("目前館內藏有書籍:");
        for (BookA book : library) {
            System.out.println("- " + book);
        }
    }
}
