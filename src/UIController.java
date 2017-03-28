import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * Created by evan on 3/27/17.
 */
public class UIController {
    DatabaseController dbc;
    @FXML
    TextField AltClass;
    @FXML
    TextField AltURL;
    @FXML
    TextField CommandBox;

    public UIController(){
        dbc = Main.dbc;
    }


    @FXML
    void onDefaultClick(){
        dbc = new DatabaseController("org.apache.derby.jdbc.EmbeddedDriver","jdbc:derby:testDB;create=true");
        try {
            dbc.registerDriver();
            dbc.connect();
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
        System.out.println(dbc);
        openMainWindow();
    }

    @FXML
    void onAltClick(){
        dbc = new DatabaseController(AltClass.getText(),AltURL.getText());
        try {
            dbc.registerDriver();
            dbc.connect();
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
        System.out.println(dbc);
        openMainWindow();
    }

    @FXML
    void onSubmitClick(){
        System.out.println("Sending Command");
        System.out.println(dbc.send_Command(CommandBox.getText()));
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
