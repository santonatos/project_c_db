import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * Created by evan on 3/27/17.
 */
public class UIController {
    @FXML
    TextField AltClass;
    @FXML
    TextField AltURL;
    @FXML
    TextField CommandBox;

    public UIController(){
    }


    @FXML
    void onDefaultClick(){
        Main.dbc = new DatabaseController("org.apache.derby.jdbc.EmbeddedDriver","jdbc:derby:testDB;create=true");
        try {
            Main.dbc.registerDriver();
            Main.dbc.connect();
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
        System.out.println(Main.dbc);
        openMainWindow();
    }

    @FXML
    void onAltClick(){
        Main.dbc = new DatabaseController(AltClass.getText(),AltURL.getText());
        try {
            Main.dbc.registerDriver();
            Main.dbc.connect();
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
        System.out.println(Main.dbc);
        openMainWindow();
    }

    @FXML
    void onSubmitClick(){
        System.out.println("Sending Command");
        System.out.println(Main.dbc.send_Command(CommandBox.getText()));
    }

    void openMainWindow(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Main.stage.setTitle("Project C Database");
        Main.stage.setScene(scene);
        Main.stage.show();

    }



}
