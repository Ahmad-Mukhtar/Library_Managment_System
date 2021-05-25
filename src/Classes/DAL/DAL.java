package Classes.DAL;

import Classes.BLL.BLLClasses.Books;
import Classes.BLL.Interfaces.*;

import java.sql.*;
import java.util.ArrayList;

public class DAL implements Login, IRegisterUser, IBook, IUpdateProfile, IUserinfo {

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

    @Override
    public ArrayList<Books> getBooks() throws SQLException
    {
        ArrayList<Books> booksArrayList=new ArrayList<>();

        Books books;

        if(connection.isClosed())
        {
            connection= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LibraryManagmentSystem;integratedSecurity=true");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from bookinfo");

        ResultSet resultSet = preparedStatement.executeQuery();

        int index=0;

        while (resultSet.next())
        {

            books=new Books();

            books.setId(resultSet.getInt("bookid"));

            books.setGenre(resultSet.getString("Genre"));

            books.setBookname(resultSet.getString("Bookname"));

            books.setBookDescription(resultSet.getString("BookDescription"));

            books.setCurrentStock(resultSet.getInt("CurrentStock"));

            books.setBookImageLink(resultSet.getString("Bookimagelink"));

            books.setAuthorname(resultSet.getString("Authorname"));

            books.setPublishername(resultSet.getString("Publishername"));

            booksArrayList.add(index,books);

            index++;
        }

        preparedStatement.close();

        connection.close();

        return booksArrayList;
    }

    @Override
    public Boolean updateProfile(String Firstname, String Lastname, String Password, String Email, String Dob,String username) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("Update  Member set Firstname=?,Lastname=?,memberpassword=?,email=?,Dob=? where username=?");

        preparedStatement.setString(1, Firstname);

        preparedStatement.setString(2, Lastname);

        preparedStatement.setString(3, Password);

        preparedStatement.setString(4, Email);

        preparedStatement.setString(5, Dob);

        preparedStatement.setString(6, username);

       int Result=preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();

        return Result > 0;
    }

    @Override
    public ArrayList<String> setUserinfo(String Username) throws SQLException {

        ArrayList<String> Userinfo=new ArrayList<>();

        if(connection.isClosed())
        {
            connection= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LibraryManagmentSystem;integratedSecurity=true");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from Member where username=?");

        preparedStatement.setString(1,Username );

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next())
        {
            Userinfo.add(0,resultSet.getString("Firstname"));
            Userinfo.add(1,resultSet.getString("Lastname"));
            Userinfo.add(2,resultSet.getString("Dob"));
            Userinfo.add(3,resultSet.getString("memberpassword"));
            Userinfo.add(4,resultSet.getString("email"));
        }

        preparedStatement.close();

        connection.close();

        return Userinfo;
    }
}