import java.sql.*;

/**
 * Created by evan on 3/25/17.
 * This Object will register, connect, and submit queries to any database specified by '_driver' and '_url' in the constructor
 */
public class DatabaseController {
    private Connection conn = null;
    private Statement stmt = null;
    private String url = "";
    private String driver = "";

    DatabaseController(String _driver, String _url){
        this.url = _url;
        this.driver =   _driver;
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
        Class.forName(driver);
        return true;
    }

    boolean connect() throws SQLException{
        conn = DriverManager.getConnection(url);
        return true;
    }

    @Override
    public String toString(){
        if (url.length() > 0)
            return "DatabaseController connected to " + url;
        return "Unconnected DatabaseController";
    }
}
