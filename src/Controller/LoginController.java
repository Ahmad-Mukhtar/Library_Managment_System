package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController
{
    @FXML
    private TextField Userfield;
    @FXML
    private PasswordField Passwordfield;
    @FXML
    private Label Errorlabel;

    public void onLoginClick()
    {
        System.out.println(Userfield.getText());
        System.out.println(Passwordfield.getText());
        Errorlabel.setVisible(true);
    }

    public void onRegisterClick()
    {
        System.out.println("Welcome To Registration");
    }
}
