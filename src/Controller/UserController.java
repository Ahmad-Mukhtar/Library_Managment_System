package Controller;

import Classes.User;
import com.sun.javafx.beans.event.AbstractNotifyListener;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    @FXML
    private AnchorPane Editprofilepane;
    @FXML
    private AnchorPane Issuebooksepane;

    @FXML
    private AnchorPane Viewsissuedbookspane;

    @FXML
    private AnchorPane Renewbookpane;

    @FXML
    private AnchorPane Returnbookpane;

    @FXML
    private AnchorPane Historypane;

    @FXML
    private AnchorPane Favouritespane;

    @FXML
    private AnchorPane Penaltypane;

    @FXML
    private MenuButton Notificationslist;

    @FXML
    private TextField Bookidfield;

    @FXML
    private Label PenlaltyLabel;

    @FXML
    private AnchorPane UserpanelPane;

    @FXML
    private GridPane ViewIssuedGridpane;

    @FXML
    private Label UserpanelLabel;

    private User user;

    private ScrollPane DynamicscrollPane;



    public void onisue()
    {
        //TODO
        //Issue Book


    }

    @FXML
    private void sortByAsc()
    {
        disableAllpanes();
         DynamicscrollPane=createScrollpane();
        DynamicscrollPane.setVisible(true);
        UserpanelPane.getChildren().add(DynamicscrollPane);
    }
    @FXML
    private void sortByDesc()
    {
        disableAllpanes();
        DynamicscrollPane=createScrollpane();
        DynamicscrollPane.setVisible(true);
        UserpanelPane.getChildren().add(DynamicscrollPane);
    }
    @FXML
    private void openEditWindow()
    {
        disableAllpanes();
        Editprofilepane.setVisible(true);
    }

    private ScrollPane createScrollpane()
    {
        //TODO add parameters for list of books
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefWidth(1090);
        scrollPane.setPrefHeight(745);
        scrollPane.setLayoutX(276);
        scrollPane.setLayoutY(65);
        Pane pane=new Pane();
        pane.setStyle("-fx-background-image: url(\"Images/bgimage.jpg\");-fx-background-size: 100%;");
        pane.setPrefHeight(743);
        pane.setPrefWidth(1184);

        pane.setLayoutX(0);
        pane.setLayoutY(0);

        GridPane gridPane=new GridPane();
        gridPane.getRowConstraints().addAll(Gridpane.getRowConstraints());
        gridPane.getColumnConstraints().addAll(Gridpane.getColumnConstraints());
        gridPane.setPrefHeight(Gridpane.getPrefHeight());
        gridPane.setPrefWidth(Gridpane.getPrefWidth());
        gridPane.setLayoutX(Gridpane.getLayoutX());
        gridPane.setLayoutY(Gridpane.getLayoutY());


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

                gridPane.setVgap(40);
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
                            pane.setPrefHeight(Scrollpane.getPrefHeight() + 190);
                            gridPane.setPrefHeight(Gridpane.getPrefHeight() + 190);
                            gridPane.addRow(Gridpane.getRowCount());
                            gridPane.getRowConstraints().add(new RowConstraints());
                            gridPane.getRowConstraints().get(Gridpane.getRowCount() - 1).setPrefHeight(250);
                        }
                    }
                }




                gridPane.add(demoimj, ci, ri);
                gridPane.add(btn, ci, ri);
                gridPane.add(btn1,ci,ri);
                i++;
                ci++;
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        pane.getChildren().add(gridPane);

        scrollPane.setContent(pane);


        return scrollPane;
    }

    //Show Isuued Books
    @FXML
    private void openViewissuedbooksWindow()
    {
        //TODO Cleaning and Connection
        disableAllpanes();
        Viewsissuedbookspane.setVisible(true);
        try {
            int i=0;
            while(i<1) {
                File F=new File("src/Images/1.jpg");
                FileInputStream input = new FileInputStream(F);
                Image imj = new Image(input);
                ImageView demoimj = new ImageView(imj);
                demoimj.setPreserveRatio(false);
                demoimj.setFitWidth(130);
                demoimj.setFitHeight(178);
                Label Bookname = new Label("The Hobbit");
                Bookname.setFont(UserpanelLabel.getFont());
                Bookname.setTextFill(UserpanelLabel.getTextFill());
                GridPane.setHalignment(demoimj, HPos.CENTER);
                GridPane.setHalignment(Bookname, HPos.CENTER);
                GridPane.setMargin(demoimj, new Insets(-50, 0, 0, 0));
                GridPane.setMargin(Bookname, new Insets(170, 0, 0, 0));
                ViewIssuedGridpane.setHgap(130);




                ViewIssuedGridpane.add(demoimj, i, 0);
                ViewIssuedGridpane.add(Bookname, i, 0);
                i++;
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void restrictNumeric()
    {
        Bookidfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    Bookidfield.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
    @FXML
    private void penaltyPrice(int Price)
    {

        PenlaltyLabel.setStyle("-fx-text-fill: #721c24;-fx-background-color: #f8d7da;");

        PenlaltyLabel.setText("Please Pay Your Fine of RS "+Price);
    }
    //Sign Out User
    @FXML
    private void signOut()
    {
        Stage stage=(Stage) UserpanelPane.getScene().getWindow();

        stage.close();

        Parent root=null;
        try
        {
            root= FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));

            Stage stage1=new Stage();

            stage1.initStyle(StageStyle.UNDECORATED);

            stage1.setScene(new Scene(root, 600, 420));

            stage1.show();
        }
        catch (Exception exception)
        {
            System.out.println(exception.toString());
        }
    }

    //Display Notifications if any
    @FXML
    private void onNoificationsclick()
    {
        NotifcationLabel.setVisible(false);
       // Notificationslist.setVisible(true);
       // Notificationslist.getItems().add(new MenuItem("Demo"));
        Notificationslist.fire();
    }
    @FXML
    private void openRenewbookWindow()
    {
        disableAllpanes();
        Renewbookpane.setVisible(true);
    }
    @FXML
    private void openReturntWindow()
    {
        disableAllpanes();
        Returnbookpane.setVisible(true);
    }
    @FXML
    private void openHistoryWindow()
    {
        disableAllpanes();
        Historypane.setVisible(true);
    }
    @FXML
    private void openFavouritesWindow()
    {
        disableAllpanes();
        Favouritespane.setVisible(true);
    }


    @FXML
    private void openPenaltyWindow()
    {
        disableAllpanes();
        Penaltypane.setVisible(true);
    }

    @FXML
    private void openBookswindow()
    {
        disableAllpanes();
        Scrollpane.setVisible(true);
        showBooks();
    }
    @FXML
    private void openIssuebookswindow()
    {
        disableAllpanes();
        Issuebooksepane.setVisible(true);
    }
    private void showBooks()
    {
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

    private void disableAllpanes()
    {
        Scrollpane.setVisible(false);
        Editprofilepane.setVisible(false);
        Issuebooksepane.setVisible(false);
        Viewsissuedbookspane.setVisible(false);
         Renewbookpane.setVisible(false);
         Returnbookpane.setVisible(false);
        Historypane.setVisible(false);
        Favouritespane.setVisible(false);
        Penaltypane.setVisible(false);
        if(DynamicscrollPane!=null) {
            DynamicscrollPane.setVisible(false);
        }

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

        showBooks();

    }

    //OnClose button Click
    @FXML
    private void mouseonclose()
    {
        System.exit(0);
    }



}
