package Classes.BLL.BLLClasses;

import Classes.BLL.Interfaces.*;
import Classes.DAL.DAL;

import java.sql.SQLException;

public class DataAccessFactory
{
    public static Login getLogindal() throws SQLException {

        return new DAL();
    }


    public static IRegisterUser getRegisterDal() throws SQLException {

        return new DAL();
    }

    public static IBook getBookDal() throws SQLException {

        return new DAL();
    }

    public static IUpdateProfile getProfileUpdateDal() throws SQLException {

        return new DAL();
    }

    public static IUserinfo getUserinfoDal() throws SQLException {

        return new DAL();
    }
}
