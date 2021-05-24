package Classes.BLL;

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
}
