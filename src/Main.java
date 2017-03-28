import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

/**
 * Created by evan on 3/25/17.
 * Main Execution Entry Point
 */
public class Main extends Application{
    public static Stage stage;
    public static DatabaseController dbc = null;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage _stage){
        stage = _stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("DBSelectWindow.fxml"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setTitle("Project C Database");
        stage.setScene(scene);
        stage.show();
    }
}
