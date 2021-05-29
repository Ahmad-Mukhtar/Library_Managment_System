package Classes.BLL.Interfaces;

import Classes.BLL.BLLClasses.History;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IHistory
{
    boolean AddtoHistory(int Bookid,String Username) throws SQLException;
    ArrayList<History> getHistoryBooks(String Username) throws SQLException;
}
