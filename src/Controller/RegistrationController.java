package Controller;

import Classes.BLL.BLLClasses.Register;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import javax.swing.*;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationController {

    @FXML
    TextField Firstname;
    @FXML
    TextField Lastname;
    @FXML
    TextField Username;
    @FXML
    TextField Password;
    @FXML
    TextField Email;
    @FXML
    DatePicker Dob;
    @FXML
    RadioButton Male;
    @FXML
    RadioButton Female;
    @FXML
    Circle circle1;
    @FXML
    Circle circle2;
    @FXML
    Circle circle3;
    @FXML
    Circle circle4;
    @FXML
    Hyperlink Loginlink;
    @FXML
    AnchorPane RegisterFrame;

    private Register register;

    public RegistrationController() throws SQLException {

        register = new Register();
    }

    public void registerButtonClick() throws SQLException {


        if (Firstname.getText().isEmpty() || Lastname.getText().isEmpty() || Username.getText().isEmpty() || Email.getText().isEmpty() || Password.getText().isEmpty() || Dob.getValue() == null || !Male.isSelected() && !Female.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("All Fields Are Required");
            alert.showAndWait();
        } else {
            if (!validateEmail(Email.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Invalid Email");
                alert.showAndWait();
            } else {
                if (checkUsername(Username.getText())) {
                    playTransition();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Username Already Taken");
                    alert.showAndWait();
                }
            }

        }

    }

    //Validate EmailField
    public Boolean validateEmail(String emailStr) {
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(emailStr);

        return matcher.matches();

    }

    //Check if the Username is not already taken
    public Boolean checkUsername(String Username) throws SQLException {
        return register.checkusername(Username);
    }

    //Play loading Transition and validate Registration
    public void playTransition() {


        Loginlink.setDisable(true);

        double DefaultCircle1value = circle1.getLayoutX();

        double DefaultCircle2value = circle2.getLayoutX();

        double DefaultCircle3value = circle3.getLayoutX();

        double DefaultCircle4value = circle4.getLayoutX();


        circle1.setVisible(true);

        circle2.setVisible(true);

        circle3.setVisible(true);

        circle4.setVisible(true);


        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), circle1);

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(1), circle2);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1), circle3);

        TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(1), circle4);


        translateTransition.setByX(80);

        translateTransition.setCycleCount(6);

        translateTransition.setAutoReverse(true);

        translateTransition.play();

        translateTransition1.setByX(80);

        translateTransition1.setCycleCount(6);

        translateTransition1.setAutoReverse(true);

        translateTransition1.play();

        translateTransition2.setByX(80);

        translateTransition2.setCycleCount(6);

        translateTransition2.setAutoReverse(true);

        translateTransition2.play();

        translateTransition3.setByX(80);

        translateTransition3.setCycleCount(6);

        translateTransition3.setAutoReverse(true);

        translateTransition3.play();

        translateTransition.setOnFinished(e -> {

            circle1.setLayoutX(DefaultCircle1value);

            circle2.setLayoutX(DefaultCircle2value);

            circle3.setLayoutX(DefaultCircle3value);

            circle4.setLayoutX(DefaultCircle4value);

            circle1.setVisible(false);

            circle2.setVisible(false);

            circle3.setVisible(false);

            circle4.setVisible(false);

            try {
                if (registerUser()) {
                    Stage stage = (Stage) RegisterFrame.getScene().getWindow();

                    stage.close();


                    JOptionPane.showMessageDialog(null, "Registered Successfully Login to Continue");

                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));

                        Stage stage1 = new Stage();

                        stage1.initStyle(StageStyle.UNDECORATED);

                        stage1.setScene(new Scene(root, 600, 420));

                        stage1.show();

                    } catch (Exception exception) {
                        Loginlink.setDisable(false);

                        System.out.println(exception.toString());
                    }
                } else {
                    Loginlink.setDisable(false);
                    JOptionPane.showMessageDialog(null, "Some Problem Occurred While Registering");
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });


    }

    //On click Already a user to go to Login Screen
    public void alreadyAUser() {

        Stage stage = (Stage) RegisterFrame.getScene().getWindow();

        stage.close();

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));

            Stage stage1 = new Stage();

            stage1.initStyle(StageStyle.UNDECORATED);

            stage1.setScene(new Scene(root, 600, 420));

            stage1.show();
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }

    }

    //Register A User By validating the information
    public Boolean registerUser() throws SQLException {

        String Gender="Male";

        if (Female.isSelected())
        {
            Gender="Female";
        }

        return register.registerUser(Password.getText(),Dob.getValue().toString(),Email.getText(),Firstname.getText(),Lastname.getText(),Username.getText(),Gender);
    }

}
