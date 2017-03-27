import javafx.fxml.FXML;
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
        }
        System.out.println(dbc);
        openMainWindow();
    }

    @FXML
    void onSubmitClick(){
        dbc.send_Command(CommandBox.getText());
    }

    void openMainWindow(){

    }



}
