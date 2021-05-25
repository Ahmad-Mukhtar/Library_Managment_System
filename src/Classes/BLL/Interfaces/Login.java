package Classes.BLL.Interfaces;

import java.sql.SQLException;

public interface  Login
{
    boolean validateLogin(String Username,String Password,String usertype) throws SQLException;
}
