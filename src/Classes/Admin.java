package Classes;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Admin  implements Login
{
    @Override
    public boolean validateLogin(String Username, String Password) throws SQLException {
        DatabaseConnection databaseConnection=new DatabaseConnection("{call adminsignin(?,?,?)}",false);

        CallableStatement callableStatement=databaseConnection.getCallableStatement();

        callableStatement.setString(1,Username);

        callableStatement.setString(2,Password);

        callableStatement.registerOutParameter(3, Types.INTEGER);

        callableStatement.execute();

        int Result=callableStatement.getInt(3);

        callableStatement.close();

        databaseConnection.closeConnection();

        return Result == 1;
    }

}
