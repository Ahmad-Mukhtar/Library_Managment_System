package Classes;

import java.sql.SQLException;

public interface  Login
{
    boolean validateLogin(String Username,String Password) throws SQLException;
}
