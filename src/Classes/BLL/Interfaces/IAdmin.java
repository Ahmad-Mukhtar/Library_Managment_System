package Classes.BLL.Interfaces;

public interface IAdmin
{
    boolean changePassword(String Username,String Password);
    boolean addBook(int Bookid,String Bookname,String BookDescription,String Bookimglink,String Genre,int CurrentStock,String Authorname,String Publishername);
    boolean removeBook(int Bookid);
    boolean updateBook(int Bookid,String Bookname,String BookDescription,String Bookimglink,String Genre,int CurrentStock,String Authorname,String Publishername);
}
