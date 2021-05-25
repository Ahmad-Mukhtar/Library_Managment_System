package Classes.BLL.BLLClasses;

import Classes.BLL.Interfaces.IBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Books
{


    private int id;

    private String Bookname;

    private String Genre;

    private String BookDescription;

    private int CurrentStock;

    private String BookImageLink;

    private String Authorname;

    private String Publishername;

    private IBook books;



    public Books() throws SQLException {
        books=DataAccessFactory.getBookDal();
    }

    public Books(Books books)
    {
        this.id=books.id;
        this.Bookname=books.Bookname;
        this.Genre=books.Genre;
        this.BookDescription=books.Genre;
        this.CurrentStock=books.CurrentStock;
        this.BookImageLink=books.BookImageLink;
        this.Authorname=books.Authorname;
        this.Publishername=books.Publishername;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setBookDescription(String bookDescription) {
        BookDescription = bookDescription;
    }

    public void setCurrentStock(int currentStock) {
        CurrentStock = currentStock;
    }

    public void setBookImageLink(String bookImageLink) {
        BookImageLink = bookImageLink;
    }

    public void setAuthorname(String authorname) {
        Authorname = authorname;
    }

    public void setPublishername(String publishername) {
        Publishername = publishername;
    }

    public int getId() {
        return id;
    }

    public String getBookname() {
        return Bookname;
    }

    public String getGenre() {
        return Genre;
    }

    public String getBookDescription() {
        return BookDescription;
    }

    public int getCurrentStock() {
        return CurrentStock;
    }

    public String getBookImageLink() {
        return BookImageLink;
    }

    public String getAuthorname() {
        return Authorname;
    }

    public String getPublishername() {
        return Publishername;
    }

    public ArrayList<Books> getallBooks() throws SQLException
    {
        return books.getBooks();
    }

}
