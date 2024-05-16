
import java.util.Date;

public class Borrowing {
    private int id, bookid, number;
    private String sid, name, title, status;
    private Date due;
    public Borrowing(int id, String sid, String name, int bookid, String title, int number, Date due,String status) {
        this.id = id;
        this.bookid = bookid;
        this.number = number;
        this.sid = sid;
        this.name = name;
        this.title = title;
        this.due = due;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public int getBookid() {
        return bookid;
    }
    public int getNumber() {
        return number;
    }

    public String getSid() {
        return sid;
    }
    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
    public String getStatus() {
        return status;
    }
    public Date getDue() {
        return due;
    }
}
