package Classes.BLL.BLLClasses;

import Classes.BLL.Interfaces.IPenalty;

import java.sql.SQLException;

public class Penalty
{
    private int price;

    private  String username;

    private IPenalty iPenalty;

    public Penalty(String Username) throws SQLException {
        iPenalty=DataAccessFactory.getPenaltydal();
        this.price=iPenalty.getPenalty(Username);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean SetPenalty(int noofdays,String Username) throws SQLException {

            int penanltyprice = noofdays * 10;
            if(this.price<penanltyprice) {
                this.setPrice(penanltyprice);
                return iPenalty.setPenalty(penanltyprice, Username);
            }
            return true;

    }

}
