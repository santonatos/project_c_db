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
    private boolean connected = false;

    /**
     * Constructor. Takes in a driver class in a string and a url in a string and will later use them to register and connect
     * @param _driver
     * @param _url
     */
    DatabaseController(String _driver, String _url){
        this.url = _url;
        this.driver =   _driver;
    }

    /**
     * Sends a raw SQL Command to the server, returns a result set if that command returns a set and NULL if it doesn't
     * @param command
     * @return
     */
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

    /**
     * Registers the driver that was specified in the constructor
     * @return true if registered correctly
     * @throws ClassNotFoundException if the class of the driver is not found in the classpath
     */
    boolean registerDriver() throws ClassNotFoundException{
        Class.forName(driver);
        return true;
    }

    /**
     * Connects to the database specified by the url in the constructor
     * @return true if connected correctly
     * @throws SQLException if there is a problem connecting
     */
    boolean connect() throws SQLException{
        conn = DriverManager.getConnection(url);
        this.connected = true;
        return true;
    }

    /**
     * Connects to the database specified by the url in the constructor and uses the credentials specified below
     * @param username username to the server
     * @param password password to the server
     * @return true if correctly connected
     * @throws SQLException if there is a problem connecting or the username/password is wrong
     */
    boolean connect(String username, String password) throws SQLException{
        conn = DriverManager.getConnection(url,username,password);
        this.connected = true;
        return true;
    }

    /**
     * Makes it nice to println this class
     * @return A pretty string representation of the object
     */
    @Override
    public String toString(){
        if (url.length() > 0 && connected)
            return "DatabaseController connected to " + url;
        return "Unconnected DatabaseController";
    }
}
