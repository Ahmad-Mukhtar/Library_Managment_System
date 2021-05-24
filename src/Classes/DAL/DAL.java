package Classes.DAL;

import Classes.BLL.Login;
import Classes.BLL.IRegisterUser;

import java.sql.*;

public class DAL implements Login, IRegisterUser {

    private Connection connection;

    public DAL() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LibraryManagmentSystem;integratedSecurity=true");
        } catch (SQLException sqlException) {
            System.out.println(sqlException.toString());
        }
    }

    @Override
    public boolean validateLogin(String Username, String Password, String Usertype) throws SQLException {

        if (Usertype.equals("User")) {
            CallableStatement callableStatement = connection.prepareCall("{call signin(?,?,?)}");

            callableStatement.setString(1, Username);

            callableStatement.setString(2, Password);

            callableStatement.registerOutParameter(3, Types.INTEGER);

            callableStatement.execute();

            int Result = callableStatement.getInt(3);

            callableStatement.close();

            if (Result==1) {
                connection.close();
            }

            return Result == 1;

        } else {
            CallableStatement callableStatement = connection.prepareCall("{call adminsignin(?,?,?)}");

            callableStatement.setString(1, Username);

            callableStatement.setString(2, Password);

            callableStatement.registerOutParameter(3, Types.INTEGER);

            callableStatement.execute();

            int Result = callableStatement.getInt(3);

            callableStatement.close();

            if (Result==1) {
                connection.close();
            }

            return Result == 1;
        }

    }

    @Override
    public Boolean checkUsername(String Username) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("select *from Member where username=?");

        preparedStatement.setString(1, Username);

        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            return false;
        }
        preparedStatement.close();

        return true;
    }

    @Override
    public Boolean registerUser(String Password, String Dob, String Email, String Firstname, String Lastname, String Username, String Gender) throws SQLException {

        try {
            CallableStatement callableStatement = connection.prepareCall("{call signup(?,?,?,?,?,?,?)}");

            callableStatement.setString(1, Password);

            callableStatement.setString(2, Dob);

            callableStatement.setString(3, Email);

            callableStatement.setString(4, Firstname);

            callableStatement.setString(5, Lastname);

            callableStatement.setString(6, Username);

            callableStatement.setString(7, Gender);

            callableStatement.execute();

            callableStatement.close();

            connection.close();

            return true;

        } catch (SQLException exception) {
            System.out.println(exception.toString());

            return false;
        } finally {
            if (connection != null)
                connection.close();
        }

    }
}