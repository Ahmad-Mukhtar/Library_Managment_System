package Controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController  implements Initializable
{


    @FXML
    private ImageView closeIcon;
    @FXML
    private TextField SearchField;

   @FXML
   private GridPane Gridpane;
   @FXML
   private Pane Scrollpane;

    @FXML
    private Button Viewbooksbutton;

    @FXML
    private Button Viewissuedbutton;

    @FXML
    private Button IssuebooksButton;

    @FXML
    private Button Editprofilebutton;

    @FXML
    private Button Historybutton;

    @FXML
    private Button Returnbookbutton;

    @FXML
    private Button Renewbookbutton;

    @FXML
    private Button Penaltybutton;

    @FXML
    private Button Favouritesbutton;

    @FXML
    private Button Signoutbutton;

    @FXML
    private MenuButton Reservebookbutton;

    @FXML
    private MenuButton Sortbutton;

    @FXML
    private Button Searchbutton;

    @FXML
    private Label NotifcationLabel;

    @FXML
    private FontAwesomeIcon Helpicon;




    public void onisue()
    {
        //TODO
        //Issue Book

    }

    //If user Presses Enter On Search Field
    @FXML
    private void OnSearch(KeyEvent keyEvent)
    {
        if(keyEvent.getCode().toString().equals("ENTER"))
        {
            System.out.println("Enter Pressed");
        }

    }

    //Onclick help icon
    @FXML
    private void onHelpclicked()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("Please Refer to Mannual For Help");

        alert.showAndWait();
    }


    //Sets Side Bar Buttons Style etc On Hovering Over
    @FXML
    private void setButtonstyle() {

        if (Viewbooksbutton.isHover()) {
            Viewbooksbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Viewissuedbutton.isHover()) {
            Viewissuedbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (IssuebooksButton.isHover()) {
            IssuebooksButton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Editprofilebutton.isHover()) {
            Editprofilebutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Sortbutton.isHover()) {
            Sortbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Reservebookbutton.isHover()) {
            Reservebookbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Signoutbutton.isHover()) {
            Signoutbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Renewbookbutton.isHover()) {
            Renewbookbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Returnbookbutton.isHover()) {
            Returnbookbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Favouritesbutton.isHover()) {
            Favouritesbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Penaltybutton.isHover()) {
            Penaltybutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Historybutton.isHover()) {
            Historybutton.setStyle("-fx-cursor: hand;-fx-background-color:  #762b00;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

    }

    //Reverts Side Bar Buttons Style etc after Hovering Over
    @FXML
    private void revertButtonStyle()
    {

            Viewbooksbutton.setStyle("-fx-background-color:  #8b4513;");

            Viewissuedbutton.setStyle("-fx-background-color:  #8b4513;");

            IssuebooksButton.setStyle("-fx-background-color:  #8b4513;");

            Reservebookbutton.setStyle("-fx-background-color:  #8b4513;");

            Signoutbutton.setStyle("-fx-background-color:  #8b4513;");

            Penaltybutton.setStyle("-fx-background-color:  #8b4513;");

            Renewbookbutton.setStyle("-fx-background-color:  #8b4513;");

            Returnbookbutton.setStyle("-fx-background-color:  #8b4513;");

            Editprofilebutton.setStyle("-fx-background-color:  #8b4513;");

            Sortbutton.setStyle("-fx-background-color:  #8b4513;");

            Historybutton.setStyle("-fx-background-color:  #8b4513;");

            Favouritesbutton.setStyle("-fx-background-color:  #8b4513;");

    }

    //Set style of close Button
    @FXML
    private void setCloseIconStyle()
    {
        closeIcon.setStyle("-fx-cursor: hand;-fx-scale-x: 1.2;-fx-scale-y: 1.2;-fx-scale-z: 1.2;");
    }

    //Revert Style of Close Button
    @FXML
    private void revertCloseIconStyle()
    {
        closeIcon.setStyle("-fx-scale-x: 1.0;-fx-scale-y: 1.0;-fx-scale-z: 1.0;");
    }

    //Load Books From Database and Display them
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            int i=0;
            int ri=0;
            int ci=0;
            while(i<7) {
                File F=new File("src/Images/1.jpg");
                FileInputStream input = new FileInputStream(F);
                Image imj = new Image(input);
                ImageView demoimj = new ImageView(imj);
                demoimj.setPreserveRatio(false);
                demoimj.setFitWidth(130);
                demoimj.setFitHeight(178);
                Button btn = new Button("Issue Book"+i);
                Button btn1 = new Button("View Details"+i);
                GridPane.setHalignment(demoimj, HPos.CENTER);
                GridPane.setHalignment(btn, HPos.CENTER);
                GridPane.setHalignment(btn1, HPos.CENTER);
                GridPane.setMargin(demoimj, new Insets(-50, 0, 0, 0));
                GridPane.setMargin(btn, new Insets(170, 0, 0, 0));
                GridPane.setMargin(btn1, new Insets(255, 0, 0, 0));

                Gridpane.setVgap(40);
                btn.setAccessibleText(String.valueOf(i));
                btn.setFont(Searchbutton.getFont());
                btn.setStyle("-fx-background-color: #762b00;-fx-cursor:Hand;");
                btn.setTextFill(Color.WHITE);
                btn1.setAccessibleText("View"+ i);
                btn1.setAccessibleText(String.valueOf(i));
                btn1.setFont(Searchbutton.getFont());
                btn1.setStyle("-fx-background-color: #762b00;-fx-cursor:Hand;");
                btn1.setTextFill(Color.WHITE);

                btn.setOnAction(e -> {
                    System.out.println(btn.getAccessibleText());
                });
                btn1.setOnAction(event -> {
                    System.out.println(btn1.getAccessibleText());
                });
                if(i!=0) {
                    if (i % 5 == 0) {
                        ci = 0;
                        ri++;
                        if(i>9) {
                            Scrollpane.setPrefHeight(Scrollpane.getPrefHeight() + 190);
                            Gridpane.setPrefHeight(Gridpane.getPrefHeight() + 190);
                            Gridpane.addRow(Gridpane.getRowCount());
                            Gridpane.getRowConstraints().add(new RowConstraints());
                            Gridpane.getRowConstraints().get(Gridpane.getRowCount() - 1).setPrefHeight(250);
                        }
                    }
                }




                Gridpane.add(demoimj, ci, ri);
                Gridpane.add(btn, ci, ri);
                Gridpane.add(btn1,ci,ri);
                i++;
                ci++;
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    //OnClose button Click
    @FXML
    private void mouseonclose()
    {
        System.exit(0);
    }



}
