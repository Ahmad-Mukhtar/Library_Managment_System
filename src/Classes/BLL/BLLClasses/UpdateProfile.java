package Classes.BLL.BLLClasses;

import Classes.BLL.Interfaces.IUpdateProfile;

import java.sql.SQLException;

public class UpdateProfile
{
    private IUpdateProfile updateProfile;

    public UpdateProfile() throws SQLException {
        updateProfile=DataAccessFactory.getProfileUpdateDal();
    }

    public Boolean updateProfile(String Firstname, String Lastname, String Password, String Email, String Dob,String username) throws SQLException {

        return updateProfile.updateProfile(Firstname,Lastname,Password,Email,Dob,username);
    }
}
