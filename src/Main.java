import java.sql.*;

/**
 * Created by evan on 3/25/17.
 * Main Execution Entry Point
 */
public class Main {
    private static DatabaseController dbc = null;

    public static void main(String[] args){
        dbc = new DatabaseController("org.apache.derby.jdbc.EmbeddedDriver","jdbc:derby:testDB;create=true");
        DatabaseEditor dbe = new DatabaseEditor(dbc);
        try {
            dbc.registerDriver();
            dbc.connect();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(dbc);
    }

}
