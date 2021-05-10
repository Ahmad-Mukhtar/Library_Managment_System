package Classes;

import java.sql.*;

public class DatabaseConnection
{
    private  Connection connection;

    private PreparedStatement preparedStatement;

    private CallableStatement callableStatement;


    public DatabaseConnection(String sqlQuery,Boolean statementType) throws SQLException
    {
        try {


            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LibraryManagmentSystem;integratedSecurity=true");

            if (statementType) {
                preparedStatement = connection.prepareStatement(sqlQuery);
            } else
                callableStatement = connection.prepareCall(sqlQuery);
        }
        catch (SQLException sqlException)
        {
            System.out.println(sqlException.toString());
        }
    }
    public PreparedStatement getPreparedStatement()
    {
        if (preparedStatement!=null) {
            return preparedStatement;
        }
        else
            return null;
    }
    public CallableStatement getCallableStatement()
    {
        if (callableStatement!=null) {
            return callableStatement;
        }
        else
            return null;
    }
    public void closeConnection() throws SQLException {
        if (connection!=null)
        {
            connection.close();
        }
    }

}
