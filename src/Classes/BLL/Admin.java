package Classes.BLL;

import Classes.DAL.DAL;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Admin
{

    private Login login;

    public Admin() throws SQLException
    {
        login=DataAccessFactory.getLogindal();
    }
    public boolean Login(String Username, String Password) throws SQLException {

        return login.validateLogin(Username, Password, "Admin");
    }

}
