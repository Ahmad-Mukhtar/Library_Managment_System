package Classes.BLL.Interfaces;

import Classes.BLL.BLLClasses.Books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IBook
{
    ArrayList<Books> getBooks() throws SQLException;
}
