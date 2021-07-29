package Controller;

import Classes.BLL.BLLClasses.*;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController  implements Initializable {

    @FXML
    private ImageView closeIcon;
    @FXML
    private TextField SearchField;
    @FXML
    private GridPane Gridpane;
    @FXML
    private Pane Scrollpane;

    @FXML
    private Label NotifcationLabel;

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
    private AnchorPane ReserveBookspane;

    @FXML
    private AnchorPane Penaltypane;

    @FXML
    private TextField Bookidfield;

    @FXML
    private Label PenlaltyLabel;

    @FXML
    private AnchorPane UserpanelPane;

    @FXML
    private GridPane ViewIssuedGridpane;

    @FXML
    private AnchorPane Viewsreservededbookspane;

    @FXML
    private GridPane ViewreserveGridpane;

    @FXML
    private Label UserpanelLabel;

    @FXML
    private MenuButton Categorybutton;

    @FXML
    private TextField EditFirstname;

    @FXML
    private TextField EditLastname;

    @FXML
    private TextField EditPassword;

    @FXML
    private TextField EditEmail;

    @FXML
    private TextField Reservefield;

    @FXML
    private DatePicker EditDob;

    @FXML
    private TextField Renewfield;

    @FXML
    private TextField ReturnField;

    @FXML
    private AnchorPane NotFoundPane;

    @FXML
    private AnchorPane issuebooksonbtn;

    @FXML
    private ImageView bookimgfield;

    @FXML
    private AnchorPane Viewdetailspane;

    @FXML
    private ImageView detailimagefield;

    @FXML
    private Label detailbookid;

    @FXML
    private Label detailbookname;

    @FXML
    private Label detailgenre;

    @FXML
    private Label detailstock;

    @FXML
    private Label detailauthorname;

    @FXML
    private Label detailpublishername;

    @FXML
    private Label detailbookdescription;

    @FXML
    private Button favbtn;

    @FXML
    private TextField  Issueidfeild;

    private User user;

    private ScrollPane DynamicscrollPane;

    //Issue Book
    @FXML
    private void issueBook() throws SQLException {
        if (Bookidfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Book Id");
        } else {
            int result = user.issueABook(Integer.parseInt(Bookidfield.getText()));

            if (result == 0) {
                JOptionPane.showMessageDialog(null, "You Have already Issued this Book");

            } else if (result == 1) {

                JOptionPane.showMessageDialog(null, "Book Issued SuccessFully");


            } else if (result == 2) {
                JOptionPane.showMessageDialog(null, "Some Error Occured During Issuing the Book");

            } else if (result == 3) {
                JOptionPane.showMessageDialog(null, "Invalid BookId");


            } else if (result == 4) {
                JOptionPane.showMessageDialog(null, "You Have already Issued 3 Books You cannot Issue More Books");

            } else if (result == 5) {
                JOptionPane.showMessageDialog(null, "Book Out of Stock");

            }
        }
    }

    @FXML
    private void onbtnissue() throws SQLException {
        if (Issueidfeild.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Book Id");
        } else {
            int result = user.issueABook(Integer.parseInt(Issueidfeild.getText()));

            if (result == 0) {
                JOptionPane.showMessageDialog(null, "You Have already Issued this Book");

            } else if (result == 1) {

                JOptionPane.showMessageDialog(null, "Book Issued SuccessFully");


            } else if (result == 2) {
                JOptionPane.showMessageDialog(null, "Some Error Occured During Issuing the Book");

            } else if (result == 3) {
                JOptionPane.showMessageDialog(null, "Invalid BookId");


            } else if (result == 4) {
                JOptionPane.showMessageDialog(null, "You Have already Issued 3 Books You cannot Issue More Books");

            } else if (result == 5) {
                JOptionPane.showMessageDialog(null, "Book Out of Stock");

            }
        }
    }

    //Renew Book
    @FXML
    private void renewBook() throws SQLException, ParseException {
        if (Renewfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Book Id");
        }
        else {
            int result = user.renewBook(Integer.parseInt(Renewfield.getText()));

            if (result == 0) {
                JOptionPane.showMessageDialog(null, "Book Renewed Successfully");

            } else if (result == 1) {

                JOptionPane.showMessageDialog(null, "Some Error Occurred While Renewing");

            }
            else if (result == 2) {

                JOptionPane.showMessageDialog(null, "Book is not Issued");

            }
        }
    }

    //ReserveBook
    @FXML
    private void reserveBook() throws SQLException {
        if (Reservefield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Book Id");
        } else {
            int result = user.reserveABook(Integer.parseInt(Reservefield.getText()));

            if (result == 0) {
                JOptionPane.showMessageDialog(null, "You Have already Reserved this Book");

            } else if (result == 1) {

                JOptionPane.showMessageDialog(null, "Book Reserved SuccessFully");


            } else if (result == 2) {
                JOptionPane.showMessageDialog(null, "Some Error Occured During Reserving the Book");

            } else if (result == 3) {
                JOptionPane.showMessageDialog(null, "Invalid BookId");


            } else if (result == 4) {
                JOptionPane.showMessageDialog(null, "You Have already Reserved 3 Books You cannot Reserve More Books");

            } else if (result == 5) {
                JOptionPane.showMessageDialog(null, "Book Out of Stock");

            }
            else if (result == 6) {
                JOptionPane.showMessageDialog(null, "This Book is Already Issued");

            }
        }

    }

    @FXML
     private void ReturnBook() throws SQLException {
        if (ReturnField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Enter Book Id");
        }

        else
        {
           if(user.returnABook(Integer.parseInt(ReturnField.getText())))
           {
               JOptionPane.showMessageDialog(null,"Book Returned SuccessFully");
           }

           else
           {
               JOptionPane.showMessageDialog(null,"Book Does not Exist  or is not Issued");

           }
        }

    }
    //Event For Filter By Genre
    EventHandler<ActionEvent> event = new EventHandler<>() {
        public void handle(ActionEvent e) {
            String Filtervalue = "";
            if (((CheckMenuItem) e.getSource()).isSelected()) {
                Filtervalue = ((CheckMenuItem) e.getSource()).getText();
                if (Filtervalue.equals("All")) {
                    showBooks();
                } else {
                    disableAllpanes();
                    DynamicscrollPane = createScrollpane(user.filterbyGenre(Filtervalue));
                    DynamicscrollPane.setVisible(true);
                    UserpanelPane.getChildren().add(DynamicscrollPane);
                }

            }
            if (!Filtervalue.isEmpty()) {
                for (int i = 0; i < Categorybutton.getItems().size(); i++) {

                    if (!Categorybutton.getItems().get(i).getText().equals(Filtervalue)) {
                        CheckMenuItem checkMenuItem = (CheckMenuItem) Categorybutton.getItems().get(i);
                        checkMenuItem.setSelected(false);
                    }
                }
            }
        }
    };

    //Sort by Ascending order Window
    @FXML
    private void sortByAsc() {
        disableAllpanes();
        DynamicscrollPane = createScrollpane(user.sortByAsc());
        DynamicscrollPane.setVisible(true);
        UserpanelPane.getChildren().add(DynamicscrollPane);
    }

    //Sort by Descending order Window
    @FXML
    private void sortByDesc() {
        disableAllpanes();

        DynamicscrollPane = createScrollpane(user.sortBydsc());

        DynamicscrollPane.setVisible(true);

        UserpanelPane.getChildren().add(DynamicscrollPane);
    }

    //Open Edit profile Window
    @FXML
    private void openEditWindow() {
        disableAllpanes();
        EditFirstname.clear();
        EditLastname.clear();
        EditEmail.clear();
        EditPassword.clear();
        EditDob.getEditor().clear();
        Editprofilepane.setVisible(true);
    }

    //Create a Scroll pane for displaying books for various sections
    private ScrollPane createScrollpane(ArrayList<Books> books) {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefWidth(1090);
        scrollPane.setPrefHeight(745);
        scrollPane.setLayoutX(276);
        scrollPane.setLayoutY(65);
        Pane pane = new Pane();
        pane.setStyle("-fx-background-image: url(\"Images/bgimage.jpg\");-fx-background-size: 100%;");
        pane.setPrefHeight(743);
        pane.setPrefWidth(1184);

        pane.setLayoutX(0);
        pane.setLayoutY(0);

        GridPane gridPane = new GridPane();
        gridPane.getRowConstraints().addAll(Gridpane.getRowConstraints());
        gridPane.getColumnConstraints().addAll(Gridpane.getColumnConstraints());
        gridPane.setPrefHeight(670);
        gridPane.setPrefWidth(1090);
        gridPane.setLayoutX(-2);
        gridPane.setLayoutY(72);

        try {
            int i = 0;
            int ri = 0;
            int ci = 0;

            while (i < books.size()) {
                File F = new File(books.get(i).getBookImageLink());
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
                            pane.setPrefHeight(Scrollpane.getPrefHeight() + 190);
                            gridPane.setPrefHeight(Gridpane.getPrefHeight() + 190);
                            gridPane.addRow(Gridpane.getRowCount());
                            gridPane.getRowConstraints().add(new RowConstraints());
                            gridPane.getRowConstraints().get(Gridpane.getRowCount() - 1).setPrefHeight(250);
                        }
                    }
                }


                Button btn = new Button("Issue Book");
                Button btn1 = new Button("View Details");
                GridPane.setHalignment(demoimj, HPos.CENTER);
                GridPane.setHalignment(btn, HPos.CENTER);
                GridPane.setHalignment(btn1, HPos.CENTER);
                GridPane.setMargin(demoimj, new Insets(-50, 0, 0, 0));
                GridPane.setMargin(btn, new Insets(170, 0, 0, 0));
                GridPane.setMargin(btn1, new Insets(255, 0, 0, 0));
                gridPane.setVgap(40);
                btn.setAccessibleText(String.valueOf(books.get(i).getId()));
                btn.setFont(Searchbutton.getFont());
                btn.setStyle("-fx-background-color: #762b00;-fx-cursor:Hand;");
                btn.setTextFill(Color.WHITE);
                btn1.setAccessibleText(String.valueOf(books.get(i).getId()));
                btn1.setFont(Searchbutton.getFont());
                btn1.setStyle("-fx-background-color: #762b00;-fx-cursor:Hand;");
                btn1.setTextFill(Color.WHITE);
                btn.setOnAction(e -> {
                    disableAllpanes();

                    Books books1 = user.getbook(Integer.parseInt(btn.getAccessibleText()));

                    Issueidfeild.setText(btn.getAccessibleText());
                    File file = new File(books1.getBookImageLink());
                    FileInputStream finputStream = null;
                    try {
                        finputStream = new FileInputStream(file);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    assert finputStream != null;
                    Image image1 = new Image(finputStream);
                    bookimgfield.setImage(image1);
                    issuebooksonbtn.setVisible(true);

                });

                btn1.setOnAction(event -> {
                    disableAllpanes();
                    Books books1 = user.getbook(Integer.parseInt(btn1.getAccessibleText()));
                    File file1 = new File(books1.getBookImageLink());
                    FileInputStream fileInputStream = null;
                    try {
                        fileInputStream = new FileInputStream(file1);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    assert fileInputStream != null;
                    Image image1 = new Image(fileInputStream);
                    detailimagefield.setImage(image1);
                    detailbookid.setText("Book ID:  " + books1.getId());
                    detailbookname.setText("Book Name:  " + books1.getBookname());
                    detailgenre.setText("Genre:  " + books1.getGenre());
                    detailstock.setText("CurrentStock: " + books1.getCurrentStock());
                    detailauthorname.setText("Author Name:  " + books1.getAuthorname());
                    detailpublishername.setText("Publisher Name:  " + books1.getPublishername());
                    detailbookdescription.setText("Book Description:  " + books1.getBookDescription());

                    favbtn.setAccessibleText(btn1.getAccessibleText());
                    if (user.checkFavouriteBook(Integer.parseInt(btn1.getAccessibleText()))) {
                        favbtn.setText("Remove From Favourites");
                    } else {
                        favbtn.setText("Add to Favourites");
                    }
                    Viewdetailspane.setVisible(true);

                });

                gridPane.add(demoimj, ci, ri);
                gridPane.add(btn, ci, ri);
                gridPane.add(btn1, ci, ri);
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

    private ScrollPane CreateHistorypane(ArrayList<History> books)
    {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefWidth(1090);
        scrollPane.setPrefHeight(745);
        scrollPane.setLayoutX(276);
        scrollPane.setLayoutY(65);
        Pane pane = new Pane();
        pane.setStyle("-fx-background-image: url(\"Images/bgimage.jpg\");-fx-background-size: 100%;");
        pane.setPrefHeight(743);
        pane.setPrefWidth(1184);

        pane.setLayoutX(0);
        pane.setLayoutY(0);

        GridPane gridPane = new GridPane();
        gridPane.getRowConstraints().addAll(Gridpane.getRowConstraints());
        gridPane.getColumnConstraints().addAll(Gridpane.getColumnConstraints());
        gridPane.setPrefHeight(670);
        gridPane.setPrefWidth(1090);
        gridPane.setLayoutX(-2);
        gridPane.setLayoutY(72);

        try {
            int i = 0;
            int ri = 0;
            int ci = 0;

            while (i < books.size()) {

                File F = new File(user.getbook(books.get(i).getBookid()).getBookImageLink());
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
                            pane.setPrefHeight(Scrollpane.getPrefHeight() + 190);
                            gridPane.setPrefHeight(Gridpane.getPrefHeight() + 190);
                            gridPane.addRow(Gridpane.getRowCount());
                            gridPane.getRowConstraints().add(new RowConstraints());
                            gridPane.getRowConstraints().get(Gridpane.getRowCount() - 1).setPrefHeight(250);
                        }
                    }
                }

                Label Bookname = new Label(user.getbook(books.get(i).getBookid()).getBookname());
                Bookname.setStyle("-fx-background-color:  #762b00");
                GridPane.setHalignment(demoimj, HPos.CENTER);
                GridPane.setMargin(demoimj, new Insets(-50, 0, 0, 0));
                GridPane.setHalignment(Bookname, HPos.CENTER);
                GridPane.setMargin(Bookname, new Insets(170, 0, 0, 0));
                gridPane.setVgap(40);
                Bookname.setFont(UserpanelLabel.getFont());
                Bookname.setTextFill(UserpanelLabel.getTextFill());
                gridPane.add(demoimj, ci, ri);
                gridPane.add(Bookname, ci, ri);

                i++;
                ci++;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
            pane.getChildren().add(gridPane);

            scrollPane.setContent(pane);


            return scrollPane;
    }

    private ScrollPane CreateFavouritespane(ArrayList<Favourites> books)
    {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefWidth(1090);
        scrollPane.setPrefHeight(745);
        scrollPane.setLayoutX(276);
        scrollPane.setLayoutY(65);
        Pane pane = new Pane();
        pane.setStyle("-fx-background-image: url(\"Images/bgimage.jpg\");-fx-background-size: 100%;");
        pane.setPrefHeight(743);
        pane.setPrefWidth(1184);

        pane.setLayoutX(0);
        pane.setLayoutY(0);

        GridPane gridPane = new GridPane();
        gridPane.getRowConstraints().addAll(Gridpane.getRowConstraints());
        gridPane.getColumnConstraints().addAll(Gridpane.getColumnConstraints());
        gridPane.setPrefHeight(670);
        gridPane.setPrefWidth(1090);
        gridPane.setLayoutX(-2);
        gridPane.setLayoutY(72);

        try {
            int i = 0;
            int ri = 0;
            int ci = 0;

            while (i < books.size()) {

                File F = new File(user.getbook(books.get(i).getBookid()).getBookImageLink());
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
                            pane.setPrefHeight(Scrollpane.getPrefHeight() + 190);
                            gridPane.setPrefHeight(Gridpane.getPrefHeight() + 190);
                            gridPane.addRow(Gridpane.getRowCount());
                            gridPane.getRowConstraints().add(new RowConstraints());
                            gridPane.getRowConstraints().get(Gridpane.getRowCount() - 1).setPrefHeight(250);
                        }
                    }
                }

                Button fbtn = new Button("Remove From Favourites");
                fbtn.setAccessibleText(String.valueOf(books.get(i).getBookid()));
                fbtn.setFont(Searchbutton.getFont());
                fbtn.setStyle("-fx-background-color: #762b00;-fx-cursor:Hand;");
                fbtn.setTextFill(Color.WHITE);
                fbtn.setOnAction(event -> {
                    try {

                        if (fbtn.getText().equals("Remove From Favourites"))
                        {
                            favbtn.setText("Remove From Favourites");

                            fbtn.setText("Add to Favourites");


                        }
                        else
                        {
                            favbtn.setText("Add to Favourites");

                            fbtn.setText("Remove From Favourites");
                        }

                        favbtn.setAccessibleText(fbtn.getAccessibleText());

                        handleFavourites();

                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                });
                GridPane.setHalignment(demoimj, HPos.CENTER);
                GridPane.setMargin(demoimj, new Insets(-50, 0, 0, 0));
                GridPane.setHalignment(fbtn, HPos.CENTER);
                GridPane.setMargin(fbtn, new Insets(170, 0, 0, 0));
                gridPane.setVgap(40);
                gridPane.add(demoimj, ci, ri);
                gridPane.add(fbtn, ci, ri);
                i++;
                ci++;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        pane.getChildren().add(gridPane);

        scrollPane.setContent(pane);


        return scrollPane;
    }

    @FXML
    private void handleFavourites() throws SQLException {


        if (favbtn.getText().equals("Add to Favourites")) {
            if (user.AddtoFavourites(Integer.parseInt(favbtn.getAccessibleText()))) {

                favbtn.setText("Remove From Favourites");
            } else {
                JOptionPane.showMessageDialog(null, "Some Error Occurred");

            }
        }
        else
        {
            if (user.RemoveFromFavourites(Integer.parseInt(favbtn.getAccessibleText()))) {

                favbtn.setText("Add to Favourites");
            } else {
                JOptionPane.showMessageDialog(null, "Some Error Occurred");

            }
        }
    }
    //show ReservedBooks
    @FXML
    private void openViewreservedbookswindow() {


        disableAllpanes();
        ViewreserveGridpane.getChildren().clear();
        Viewsreservededbookspane.setVisible(true);
        try {
            int i = 0;

            ArrayList<ReserveBook> reserveBooks = user.getReservedBooks();

            while (i < reserveBooks.size()) {

                File F = new File(user.getbook(reserveBooks.get(i).getBookid()).getBookImageLink());
                FileInputStream input = new FileInputStream(F);
                Image imj = new Image(input);
                ImageView demoimj = new ImageView(imj);
                demoimj.setPreserveRatio(false);
                demoimj.setFitWidth(130);
                demoimj.setFitHeight(178);

                Button reserveissuebtn = new Button("Issue Book");

                reserveissuebtn.setAccessibleText(String.valueOf(reserveBooks.get(i).getBookid()));
                reserveissuebtn.setFont(Searchbutton.getFont());
                reserveissuebtn.setStyle("-fx-background-color: #762b00;-fx-cursor:Hand;");
                reserveissuebtn.setTextFill(Color.WHITE);

                reserveissuebtn.setOnAction(e -> {
                    Issueidfeild.setText(reserveissuebtn.getAccessibleText());
                    try {
                        onbtnissue();
                        user.returnReserveBook(Integer.parseInt(reserveissuebtn.getAccessibleText()));
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }

                });

                String[] date = reserveBooks.get(i).getDueDate().split(" ");

                String duedate = date[1] + " " + date[2] + " " + date[5];

                Label Duedate = new Label("Due date: " + duedate);
                // Duedate.setFont(UserpanelLabel.getFont());
                Duedate.setTextFill(UserpanelLabel.getTextFill());
                GridPane.setHalignment(demoimj, HPos.CENTER);
                GridPane.setHalignment(reserveissuebtn, HPos.CENTER);
                GridPane.setHalignment(Duedate, HPos.CENTER);
                GridPane.setMargin(demoimj, new Insets(-50, 0, 0, 0));
                GridPane.setMargin(reserveissuebtn, new Insets(170, 0, 0, 0));
                GridPane.setMargin(Duedate, new Insets(255, 0, 0, 0));

                ViewreserveGridpane.setHgap(130);
                ViewreserveGridpane.add(demoimj, i, 0);
                ViewreserveGridpane.add(reserveissuebtn, i, 0);
                ViewreserveGridpane.add(Duedate, i, 0);
                i++;
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Show Isuued Books
    @FXML
    private void openViewissuedbooksWindow() {

        disableAllpanes();

       ViewIssuedGridpane.getChildren().clear();

        Viewsissuedbookspane.setVisible(true);
        try {
            int i = 0;

            ArrayList<IssueBook> issueBooks = user.getIssuedBooks();

            while (i < issueBooks.size()) {

                File F = new File(user.getbook(issueBooks.get(i).getBookid()).getBookImageLink());
                FileInputStream input = new FileInputStream(F);
                Image imj = new Image(input);
                ImageView demoimj = new ImageView(imj);
                demoimj.setPreserveRatio(false);
                demoimj.setFitWidth(130);
                demoimj.setFitHeight(178);

                String[] date = issueBooks.get(i).getDueDate().split(" ");

                String duedate = date[1] + " " + date[2] + " " + date[5];

                Label Duedate = new Label("Due date: " + duedate);

                Duedate.setTextFill(UserpanelLabel.getTextFill());
                GridPane.setHalignment(demoimj, HPos.CENTER);
                GridPane.setHalignment(Duedate, HPos.CENTER);
                GridPane.setMargin(demoimj, new Insets(-50, 0, 0, 0));
                GridPane.setMargin(Duedate, new Insets(170, 0, 0, 0));

                ViewIssuedGridpane.setHgap(130);
                ViewIssuedGridpane.add(demoimj, i, 0);
                ViewIssuedGridpane.add(Duedate, i, 0);

                i++;
            }
        }
        catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //Restrict text Field to numeric Only
    @FXML
    private void restrictNumeric()
    {
        Bookidfield.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                Bookidfield.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Issueidfeild.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                Bookidfield.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Reservefield.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                Reservefield.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Renewfield.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                Renewfield.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        ReturnField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                ReturnField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    private void penaltyPrice()
    {

        int price =user.getPenaltyPrice();
        if(price>0) {
            PenlaltyLabel.setStyle("-fx-text-fill: #721c24;-fx-background-color: #f8d7da;");

            PenlaltyLabel.setText("Please Pay Your Fine of RS " + price);
        }
    }

    //Search the Book
    @FXML
    private void searchBook()
    {
        String Searchvalue=SearchField.getText();

        disableAllpanes();
        if(user.searchBooks(Searchvalue).size()!=0) {
            DynamicscrollPane = createScrollpane(user.searchBooks(Searchvalue));

            DynamicscrollPane.setVisible(true);

            UserpanelPane.getChildren().add(DynamicscrollPane);
        }
        else
        {
            NotFoundPane.setVisible(true);
        }

    }
    //Sign Out User
    @FXML
    private void signOut()
    {
        Stage stage=(Stage) UserpanelPane.getScene().getWindow();

        stage.close();

        Parent root;
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

    //Validate EmailField
    private Boolean validateEmail(String emailStr) {
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(emailStr);

        return matcher.matches();

    }

    @FXML
    private void openReservebookwindow()
    {
        disableAllpanes();
        Reservefield.clear();
        ReserveBookspane.setVisible(true);
    }

    //Open Renew Books Window
    @FXML
    private void openRenewbookWindow()
    {
        disableAllpanes();
        Renewfield.clear();
        Renewbookpane.setVisible(true);
    }
    //Open Return Books Window
    @FXML
    private void openReturntWindow()
    {
        disableAllpanes();
        ReturnField.clear();
        Returnbookpane.setVisible(true);
    }
    //Open History Books Window
    @FXML
    private void openHistoryWindow()
    {
        disableAllpanes();
        DynamicscrollPane=CreateHistorypane(user.getHistoryBooks());
        DynamicscrollPane.setVisible(true);
        UserpanelPane.getChildren().add(DynamicscrollPane);
    }
    //Open Favourites Window
    @FXML
    private void openFavouritesWindow()
    {

        disableAllpanes();
        DynamicscrollPane=CreateFavouritespane(user.getFavouriteBooks());
        DynamicscrollPane.setVisible(true);
        UserpanelPane.getChildren().add(DynamicscrollPane);

    }
    //Open Penalty Books Window
    @FXML
    private void openPenaltyWindow()
    {

        disableAllpanes();
        penaltyPrice();
        Penaltypane.setVisible(true);
    }
    //Open Issue Books Window
    @FXML
    private void openIssuebookswindow()
    {
        disableAllpanes();
        Bookidfield.clear();
        Issuebooksepane.setVisible(true);
    }
    //Show all Books
    @FXML
    private void showBooks()
    {
        disableAllpanes();
        NotifcationLabel.setText(String.valueOf(user.getBooksArrayList().size()));
        DynamicscrollPane=createScrollpane(user.getBooksArrayList());
        DynamicscrollPane.setVisible(true);
        UserpanelPane.getChildren().add(DynamicscrollPane);

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

        Editprofilepane.setVisible(false);
        Issuebooksepane.setVisible(false);
        Viewsissuedbookspane.setVisible(false);
        Viewsreservededbookspane.setVisible(false);
         Renewbookpane.setVisible(false);
         Returnbookpane.setVisible(false);
        Penaltypane.setVisible(false);
        ReserveBookspane.setVisible(false);
        NotFoundPane.setVisible(false);
        issuebooksonbtn.setVisible(false);
        Viewdetailspane.setVisible(false);
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

            searchBook();
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

    @FXML
    private void updateProfile() throws SQLException {

        if (EditFirstname.getText().isEmpty() && EditLastname.getText().isEmpty() && EditPassword.getText().isEmpty() && EditEmail.getText().isEmpty() && EditDob.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Atleast one Field Should be Filled");
        } else {

            boolean check = true;
            if (!EditEmail.getText().isEmpty()) {
                if (!validateEmail(EditEmail.getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid Email");
                    check=false;
                }
            }
            if (check) {
                String newDob;
                if (EditDob.getValue() == null) {
                    newDob = "";

                } else {
                    newDob = EditDob.getValue().toString();
                }
                Boolean result = user.updateProfile(EditFirstname.getText(), EditLastname.getText(), EditPassword.getText(), EditEmail.getText(), newDob);

                if (result) {
                    JOptionPane.showMessageDialog(null, "Profile Updated Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Profile Could not be Updated due to Some Error");

                }
            }
        }
    }

    //Load Books From Database and Display them
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File myObj = new File("username.txt");

        if (myObj.exists()) {
            Scanner myReader;
            try {

                myReader = new Scanner(myObj);

                String data = myReader.nextLine();

                myReader.close();

                user=new User(data);

                myObj.delete();



                showBooks();

                checkCategory();

            }
            catch (FileNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"User not Found Due to some Error");

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
