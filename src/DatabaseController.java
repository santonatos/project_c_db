import java.sql.*;

/**
 * Created by evan on 3/25/17.
 * This Object will register, connect, and submit queries to any database specified by '_url' in the constructor
 */
public class DatabaseController {
    private Connection conn = null;
    private Statement stmt = null;
    private String url = "";

    DatabaseController(String _url){
        this.url = _url;
    }

    public ResultSet send_Command(String command){
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

    boolean registerDriver() throws ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        return true;
    }

    boolean connect() throws SQLException{
        conn = DriverManager.getConnection("jdbc:derby:testDB;create=true");
        return true;
    }

    @Override
    public String toString(){
        if (url.length() > 0)
            return "DatabaseController connected to " + url;
        return "Unconnected DatabaseController";
    }
}
