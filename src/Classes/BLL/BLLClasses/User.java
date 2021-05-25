package Classes.BLL.BLLClasses;


import Classes.BLL.Interfaces.IBook;
import Classes.BLL.Interfaces.IUser;
import Classes.BLL.Interfaces.IUserinfo;
import Classes.BLL.Interfaces.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class User implements IUser
{
    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private String Username;

    private String Firstname;

    private String Lastname;

    private String Password;

    private String Email;

    private String Dob;

    private Login login;

    private ArrayList<Books> booksArrayList;

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

    public ArrayList<Books> getBooksArrayList() {
        return booksArrayList;
    }

    @Override
    public void setUserinfo() throws SQLException
    {
        IUserinfo userinfo=DataAccessFactory.getUserinfoDal();

        ArrayList<String> Userinfo=userinfo.setUserinfo(Username);

        Firstname=Userinfo.get(0);

        Lastname=Userinfo.get(1);

        Dob=Userinfo.get(2);

        Password=Userinfo.get(3);

        Email=Userinfo.get(4);

    }

    @Override
    public ArrayList<Books> sortByAsc() {

        ArrayList<Books> Sortbooks=new ArrayList<>();

        for (Books b:booksArrayList) {
            Books books=new Books(b);
            Sortbooks.add(books);
        }

        Sortbooks.sort(Comparator.comparing(Books::getBookname));

        return Sortbooks;
    }

    @Override
    public ArrayList<Books> sortBydsc() {
        ArrayList<Books> Sortbooks=new ArrayList<>();

        for (Books b:booksArrayList) {
            Books books=new Books(b);
            Sortbooks.add(books);
        }

        Sortbooks.sort(Comparator.comparing(Books::getBookname).reversed());

        return Sortbooks;
    }

    @Override
    public ArrayList<Books> searchBooks(String Searchvalue)
    {
        ArrayList<Books> SearchResults=new ArrayList<>();

        for (Books b:booksArrayList) {
            Books books=new Books(b);
            if (books.getBookname().contains(Searchvalue))
            {
                SearchResults.add(books);
            }

        }
        return SearchResults;
    }

    @Override
    public ArrayList<Books> filterbyGenre(String Filtervalue) {
        ArrayList<Books> SearchResults=new ArrayList<>();

        for (Books b:booksArrayList) {
            Books books=new Books(b);
            if (books.getGenre().equals(Filtervalue))
            {
                SearchResults.add(books);
            }

        }
        return SearchResults;
    }

    @Override
    public Boolean updateProfile(String FirstName, String LastName, String PassWord, String EmaiL, String DOB) throws SQLException {


        if (FirstName.isEmpty())
        {
            FirstName=Firstname;
        }
        if (LastName.isEmpty())
        {
            LastName=Lastname;
        }

        if (PassWord.isEmpty())
        {
            PassWord=Password;
        }

       if (DOB.isEmpty())
        {
            DOB=Dob;
        }

       if (EmaiL.isEmpty())
        {
            EmaiL=Email;
        }

        Boolean status=new UpdateProfile().updateProfile(FirstName,LastName,PassWord,EmaiL,DOB,Username);

        if (status)
        {
            Firstname=FirstName;

            Lastname=LastName;

            Password=PassWord;

            Email=EmaiL;

            Dob=DOB;
        }

        return status;
    }

    @Override
    public void getAllbooks() throws SQLException {

        Books books=new Books();

        //get books from database
        booksArrayList=books.getallBooks();
    }

}
