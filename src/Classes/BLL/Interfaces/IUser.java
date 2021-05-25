package Classes.BLL.Interfaces;

import Classes.BLL.BLLClasses.Books;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUser
{
    void getAllbooks() throws SQLException;

    void setUsername(String username);

    void setUserinfo() throws SQLException;

    String getUsername();

    ArrayList<Books> getBooksArrayList();

    ArrayList<Books> sortByAsc();

    ArrayList<Books> sortBydsc();

    ArrayList<Books> searchBooks(String Searchvalue);

    ArrayList<Books> filterbyGenre(String Filtervalue);

    Boolean updateProfile(String Firstname,String Lastname,String Password,String Email,String Dob) throws SQLException;

}
