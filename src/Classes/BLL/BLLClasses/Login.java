package Classes.BLL.BLLClasses;

import Classes.BLL.Interfaces.ILogin;

import java.sql.SQLException;

public class Login
{
    private ILogin login;

    public Login() throws SQLException
    {
        login=DataAccessFactory.getLogindal();
    }
    public boolean Login(String Username, String Password,String usertype) throws SQLException {

        return login.validateLogin(Username,Password,usertype);

    }

}
