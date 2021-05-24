package Classes.BLL;


import java.sql.SQLException;


public class User
{
    private String Username;

    private Login login;

    public User() throws SQLException {

        login=DataAccessFactory.getLogindal();
    }

    public boolean Login(String Username, String Password) throws SQLException {

        return login.validateLogin(Username,Password,"User");

    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUsername() {
        return Username;
    }


}
