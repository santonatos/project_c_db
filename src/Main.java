import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by evan on 3/25/17.
 * Main Execution Entry Point
 */
public class Main extends Application{
    public static DatabaseController dbc = null;
    public static DatabaseEditor dbe = null;
    /**
     * Main entry point of the application, testing grounds for the time being
     * @param args Command line args
     */
    public static void main(String[] args){
        dbc = new DatabaseController("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@oracle.wpi.edu:1521:orcl");
        dbe = new DatabaseEditor(dbc);
        try {
            dbc.registerDriver();
            dbc.connect("elduffy","Formula23");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(dbc);
        launch(args);
    }


    @Override
    public void start(Stage stage){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(root);

        stage.setTitle("Project C Database");
        stage.setScene(scene);
        stage.show();
    }

}
