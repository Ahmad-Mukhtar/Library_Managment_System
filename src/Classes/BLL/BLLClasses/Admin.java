package Classes.BLL.BLLClasses;

import Classes.BLL.Interfaces.Login;

import java.sql.SQLException;

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
