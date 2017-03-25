package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
/**
 * Created by evan on 3/23/17.
 */
public class Main_Sample extends Application{
    static Connection conn = null;
    static Statement stmt = null;

    /**
     * Program main
     * @param args Command Line Args
     */
    public static void main(String[] args){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        }
        catch (ClassNotFoundException e){
            System.out.println("CLASS NOT FOUND, CHECK DRIVER");
            e.printStackTrace();
            return;
        }
        System.out.println("Driver good");
        try {
            conn = DriverManager.getConnection("jdbc:derby:evanDB;create=true");
        }
        catch (SQLException e){
            System.out.println("Connection Error");
            e.printStackTrace();
            return;
        }
        System.out.println("Connection Good!");
    }

    /**
     * Sends a command to the server and returns the result set
     * @param command The command to send to the server
     * @return
     */
    public static ResultSet sendCommand(String command){
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(command);
            return rs;

        }
        catch (SQLException e){
            System.out.println("Error Querying, Trying Execute...");
            try {
                stmt.execute(command);
                System.out.println("Executed Successfully");

            }
            catch (SQLException e2){
                e.printStackTrace();
                System.out.println("Query Error!");
            }
        }
        return null;
    }

    /**
     * Start the javafx window, load from fxml
     * @param stage Used by JFX
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("evandb.fxml"));

//        Scene scene = new Scene(root, 600, 150);

//        stage.setTitle("Project C Database");
//        stage.setScene(scene);
//        stage.show();
    }


}
