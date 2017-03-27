import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by evan on 3/26/17.
 */
public class UIController {
    @FXML TextField s_id_box;
    @FXML TextField s_name_box;
    DatabaseEditor dbe;

    public UIController(){
        this.dbe = Main.dbe;
    }

    @FXML
    void deleteServiceButton(){
        if (s_id_box.getText().length() > 0){
            dbe.remove_Service(Integer.parseInt(s_id_box.getText()));
        }
        else if (s_name_box.getText().length() > 0){
            dbe.remove_Service(s_name_box.getText());
        }
        else {
            System.out.println("No Data, Not Querying");
        }
    }

    @FXML
    void addServiceButton(){
        if (s_id_box.getText().length() > 0 && s_name_box.getText().length() > 0) {
            System.out.println("Sending Command");
            dbe.add_Service(Integer.parseInt(s_id_box.getText()), s_name_box.getText());
        }
        else {
            System.out.println("No Data, Not Querying");
        }
    }

}
