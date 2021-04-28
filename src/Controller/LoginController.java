package Controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class LoginController
{
    @FXML
    private TextField Userfield;

    @FXML
    private PasswordField Passwordfield;

    @FXML
    private Label Errorlabel;

    @FXML private Circle circle1;

    @FXML private Circle circle2;

    @FXML private Circle circle3;

    @FXML private Label Loadinglabel;

    @FXML private Hyperlink Loginadmin;

    @FXML private Hyperlink Registerlink;

    @FXML private Label NotRegisteredLabel;


    public void onLoginClick()
    {
        System.out.println(Userfield.getText());
        System.out.println(Passwordfield.getText());
        //Errorlabel.setVisible(true);

        if(Userfield.getPromptText().equals("Username"))
        {
            System.out.println("User");
        }
        else if (Userfield.getPromptText().equals("AdminUsername"))
        {
            System.out.println("Admin");

        }



    }

    public void playTransition()
    {
        double DefaultCircle1value=circle1.getLayoutX();

        double DefaultCircle2value=circle2.getLayoutX();

        double DefaultCircle3value=circle3.getLayoutX();



        circle1.setVisible(true);

        circle2.setVisible(true);

        circle3.setVisible(true);

        Loadinglabel.setVisible(true);

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(1),circle1);

        TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(1),circle2);

        TranslateTransition translateTransition2=new TranslateTransition(Duration.seconds(1),circle3);


        translateTransition.setByX(40);

        translateTransition.setCycleCount(6);

        translateTransition.setAutoReverse(true);

        translateTransition.play();

        translateTransition1.setByX(40);

        translateTransition1.setCycleCount(6);

        translateTransition1.setAutoReverse(true);

        translateTransition1.play();

        translateTransition2.setByX(40);

        translateTransition2.setCycleCount(6);

        translateTransition2.setAutoReverse(true);

        translateTransition2.play();

        translateTransition.setOnFinished(e->{
            circle1.setLayoutX(DefaultCircle1value);

            circle2.setLayoutX(DefaultCircle2value);

            circle3.setLayoutX(DefaultCircle3value);

            circle1.setVisible(false);

            circle2.setVisible(false);

            circle3.setVisible(false);

            System.out.println("Finished");
        });

    }

    public void onRegisterClick()
    {
        System.out.println("Welcome To Registration");
    }

    public void onLoginAsAdminClick()
    {
        if (Loginadmin.getText().equals("Login As User"))
        {
           setLoginUser();
        }
        else if (Loginadmin.getText().equals("Login As Admin"))
        {
            setLoginadmin();
        }


    }

    public void setLoginadmin() {
        Userfield.clear();

        Userfield.setPromptText("AdminUsername");

        Passwordfield.clear();

        NotRegisteredLabel.setVisible(false);

        Registerlink.setVisible(false);

        Loginadmin.setText("Login As User");

        Loginadmin.setLayoutX(Loginadmin.getLayoutX()+10);

        Loginadmin.setLayoutY(Loginadmin.getLayoutY()-40);
    }

    public void setLoginUser()
    {
        Userfield.clear();

        Userfield.setPromptText("Username");

        Passwordfield.clear();

        NotRegisteredLabel.setVisible(true);

        Registerlink.setVisible(true);

        Loginadmin.setText("Login As Admin");

        Loginadmin.setLayoutX(Loginadmin.getLayoutX()-10);

        Loginadmin.setLayoutY(Loginadmin.getLayoutY()+40);
    }
}
