import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Controller class for the FXML UI
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
        try {
            Main.dbc = new DatabaseController("org.apache.derby.jdbc.EmbeddedDriver","jdbc:derby:testDB;create=true");
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
        try {
            Main.dbc = new DatabaseController(AltClass.getText(),AltURL.getText());
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
        System.out.println("ENTERED: " + CommandBox.getText());
        ResultSet rs = Main.dbc.send_Command(CommandBox.getText());
        if(rs != null){
            try {
                ResultSetMetaData rsmd = rs.getMetaData();
                int number_columns = rsmd.getColumnCount();
                String columnname;
                //String table_name = rsmd.getTableName();
                //int c = 0;
                while(rs.next()){
                    int c;
                    for(c = 1;c <= number_columns;c++){
                        System.out.print("'" + rsmd.getColumnName(c) + "':" + rs.getString(c));
                    }
                    System.out.println("");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println(Main.dbc.send_Command(CommandBox.getText()));
    }

    private void openMainWindow(){
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
