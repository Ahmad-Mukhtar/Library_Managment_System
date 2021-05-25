package Classes.BLL.BLLClasses;

import java.sql.SQLException;

public class Register
{
    private Classes.BLL.Interfaces.IRegisterUser IRegisterUser;

    public Register() throws SQLException {
        IRegisterUser =DataAccessFactory.getRegisterDal();
    }

    public Boolean registerUser(String Password,String Dob,String Email,String Firstname,String Lastname,String Username,String Gender) throws SQLException {
        return  IRegisterUser.registerUser(Password,Dob,Email,Firstname,Lastname,Username,Gender);
    }

    public Boolean checkusername(String Username) throws SQLException
    {
        return  IRegisterUser.checkUsername(Username);
    }
}
