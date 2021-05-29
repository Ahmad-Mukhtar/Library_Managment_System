package Classes.BLL.BLLClasses;

import Classes.BLL.Interfaces.IAdmin;

import java.sql.SQLException;

public class Admin
{

    private  String Adminname;

    private IAdmin iAdmin;


    public Admin(String adminname) throws SQLException
    {
        iAdmin=DataAccessFactory.getAdmindal();

        this.Adminname=adminname;
    }

    public String getAdminname() {
        return Adminname;
    }

    public void setAdminname(String adminname) {
        Adminname = adminname;
    }



}
