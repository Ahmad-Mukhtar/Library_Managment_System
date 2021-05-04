package Classes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Views/UserPanel.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.initStyle(StageStyle.UNDECORATED);
       // primaryStage.setScene(new Scene(root, 600, 420));
        primaryStage.setScene(new Scene(root, 1366, 810));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}

