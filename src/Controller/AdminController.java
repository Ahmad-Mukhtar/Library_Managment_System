package Controller;

import Classes.BLL.BLLClasses.Admin;
import Classes.BLL.BLLClasses.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AdminController implements Initializable {

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
    private Button AddbooksButton;

    @FXML
    private Button DeleteBooksbutton;

    @FXML
    private Button Updatebooksbutton;

    @FXML
    private Button Editprofilebutton;

    @FXML
    private Button Signoutbutton;

    @FXML
    private Button Searchbutton;

    @FXML
    private Label NotifcationLabel;

    @FXML
    private MenuButton Notificationslist;

    @FXML
    private AnchorPane AdminpanelPane;

    @FXML
    private AnchorPane Editprofilepane;

    @FXML
    private AnchorPane AddBookPane;

    @FXML
    private AnchorPane DeleteBookPane;

    @FXML
    private Label AdminpanelLabel;

    @FXML
    private AnchorPane NotFoundPane;

    @FXML
    private Label Filenamelabel;

    @FXML
    private MenuButton Categorybutton;

    @FXML
    private Label Addbooklabel;

    @FXML
    private ImageView Addbookimage;

    @FXML
    private Button Addbookbtn;

    private Admin admin;



    //TODO Handle Filtering
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            String Filtervalue = "";
            if (((CheckMenuItem) e.getSource()).isSelected()) {
                Filtervalue = ((CheckMenuItem) e.getSource()).getText();
                System.out.println(Filtervalue);

            }
            if(!Filtervalue.isEmpty()) {
                for (int i = 0; i < Categorybutton.getItems().size(); i++) {

                    if (!Categorybutton.getItems().get(i).getText().equals(Filtervalue))
                    {
                        CheckMenuItem checkMenuItem=(CheckMenuItem)Categorybutton.getItems().get(i);
                        checkMenuItem.setSelected(false);
                    }
                }
            }
        }
    };

    //Restrict text Field to numeric Only
   /*
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
    }*/


    //TODO implement Search
    @FXML
    private void searchBook()
    {
        String Searchvalue=SearchField.getText();
        System.out.println(Searchvalue);
        getBooksfromdatabase(true,false);
    }
    //Sign Out User
    @FXML
    private void signOut()
    {
        Stage stage=(Stage) AdminpanelPane.getScene().getWindow();

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
        Notificationslist.fire();
    }

    //Show all Books
    @FXML
    private void showBooks()
    {
        disableAllpanes();
        Scrollpane.setVisible(true);
        getBooksfromdatabase(false,false);

    }

    private void getBooksfromdatabase(Boolean Search,Boolean Filter)
    {
        try {
            int i=0;
            int ri=0;
            int ci=0;

            if(Search)
            {
                System.out.println("Search");
                disableAllpanes();
                NotFoundPane.setVisible(true);

            }
            else if (Filter)
            {
                System.out.println("Filter");
            }
            else {
                while (i < 7) {
                    File F = new File("src/Images/1.jpg");
                    FileInputStream input = new FileInputStream(F);
                    Image imj = new Image(input);
                    ImageView demoimj = new ImageView(imj);
                    demoimj.setPreserveRatio(false);
                    demoimj.setFitWidth(130);
                    demoimj.setFitHeight(178);

                    if (i != 0) {
                        if (i % 5 == 0) {
                            ci = 0;
                            ri++;
                            if (i > 9) {
                                Scrollpane.setPrefHeight(Scrollpane.getPrefHeight() + 190);
                                Gridpane.setPrefHeight(Gridpane.getPrefHeight() + 190);
                                Gridpane.addRow(Gridpane.getRowCount());
                                Gridpane.getRowConstraints().add(new RowConstraints());
                                Gridpane.getRowConstraints().get(Gridpane.getRowCount() - 1).setPrefHeight(250);
                            }
                        }
                    }

                    Button btn1 = new Button("View Details" + i);
                    GridPane.setHalignment(demoimj, HPos.CENTER);
                    GridPane.setHalignment(btn1, HPos.CENTER);
                    GridPane.setMargin(demoimj, new Insets(-50, 0, 0, 0));
                    GridPane.setMargin(btn1, new Insets(180, 0, 0, 0));
                    Gridpane.setVgap(40);
                    btn1.setAccessibleText("View" + i);
                    btn1.setAccessibleText(String.valueOf(i));
                    btn1.setFont(Searchbutton.getFont());
                    btn1.setStyle("-fx-background-color:  #76001c;-fx-cursor:Hand;");
                    btn1.setTextFill(Color.WHITE);
                    btn1.setOnAction(event -> {
                        System.out.println(btn1.getAccessibleText());
                    });

                    Gridpane.add(demoimj, ci, ri);
                    Gridpane.add(btn1, ci, ri);
                    i++;
                    ci++;
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void checkCategory()
    {
        for (int i = 0; i <Categorybutton.getItems().size() ; i++) {
            Categorybutton.getItems().get(i).setOnAction(event);
        }

    }

    //Disable all Visible Layouts
    private void disableAllpanes()
    {
            //TODO
        Scrollpane.setVisible(false);
        Editprofilepane.setVisible(false);
        NotFoundPane.setVisible(false);
        AddBookPane.setVisible(false);
        DeleteBookPane.setVisible(false);

    }

    //TODO implement Search
    //If user Presses Enter On Search Field
    @FXML
    private void OnSearch(KeyEvent keyEvent)
    {
        if(keyEvent.getCode().toString().equals("ENTER"))
        {

            System.out.println(SearchField.getText());
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
            Viewbooksbutton.setStyle("-fx-cursor: hand;-fx-background-color:    #76001c;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (AddbooksButton.isHover()) {
            AddbooksButton.setStyle("-fx-cursor: hand;-fx-background-color:    #76001c;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (DeleteBooksbutton.isHover()) {
            DeleteBooksbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #76001c;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Editprofilebutton.isHover()) {
            Editprofilebutton.setStyle("-fx-cursor: hand;-fx-background-color:  #76001c;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Updatebooksbutton.isHover()) {
            Updatebooksbutton.setStyle("-fx-cursor: hand;-fx-background-color: #76001c;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }

        if (Signoutbutton.isHover()) {
            Signoutbutton.setStyle("-fx-cursor: hand;-fx-background-color:  #76001c;-fx-scale-x: 1.1;-fx-scale-y: 1.1;-fx-scale-z: 1.1;");
        }
    }
    //Reverts Side Bar Buttons Style etc after Hovering Over
    @FXML
    private void revertButtonStyle()
    {
        Viewbooksbutton.setStyle("-fx-background-color:   #762b00;");

        AddbooksButton.setStyle("-fx-background-color:  #762b00;");

        DeleteBooksbutton.setStyle("-fx-background-color:   #762b00;");

        Updatebooksbutton.setStyle("-fx-background-color:   #762b00;");

        Signoutbutton.setStyle("-fx-background-color:   #762b00;");

        Editprofilebutton.setStyle("-fx-background-color:   #762b00;");
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
    @FXML
    private void  openEditWindow()
    {
        disableAllpanes();
        Editprofilepane.setVisible(true);
    }

    @FXML
    private void  openAddbookswindow() throws FileNotFoundException
    {
        disableAllpanes();
        File F = new File("src/Images/addbook.png");
        FileInputStream input = new FileInputStream(F);
        Image image = new Image(input);
        Addbookimage.setImage(image);
        Addbookbtn.setText("Add Book");
        Addbooklabel.setText("Add Book");
        Addbooklabel.setLayoutX(Addbooklabel.getLayoutX()+20);
        AddBookPane.setVisible(true);
    }

    @FXML
    private void selectFile() throws IOException {
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("png files","*.png"),
                new FileChooser.ExtensionFilter("jpg files","*.jpg"));

        File Selectedfile=fileChooser.showOpenDialog(AdminpanelPane.getScene().getWindow());

        if(Selectedfile!=null) {
            //  String path="src/Images/";

            //  Files.copy(Selectedfile.toPath(),new File(path+Selectedfile.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);

            Filenamelabel.setText(Selectedfile.getName());
        }


    }

    @FXML
    private void  openDeletebooksWindow()
    {
        disableAllpanes();

        DeleteBookPane.setVisible(true);
    }

    @FXML
    private void openUpdatebooksWindow() throws FileNotFoundException {
        disableAllpanes();
        File F = new File("src/Images/upimg.png");
        FileInputStream input = new FileInputStream(F);
        Image image = new Image(input);
        Addbookimage.setImage(image);
        Addbookbtn.setText("Update Book");
        Addbooklabel.setText("Update Book");
        Addbooklabel.setLayoutX(Addbooklabel.getLayoutX()-20);
        AddBookPane.setVisible(true);
    }

    //Load Books From Database and Display them
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        File myObj = new File("adminname.txt");

        if (myObj.exists()) {
            Scanner myReader;
            try {

                myReader = new Scanner(myObj);

                String data = myReader.nextLine();

                myReader.close();

                admin=new Admin(data);

                myObj.delete();

                showBooks();

                checkCategory();

            }
            catch (FileNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Admin not Found Due to some Error");

            signOut();
        }

    }
    //OnClose button Click
    @FXML
    private void mouseonclose()
    {
        System.exit(0);
    }

}

