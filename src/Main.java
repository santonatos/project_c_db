/**
 * Created by evan on 3/25/17.
 * Main Execution Entry Point
 */
public class Main {
    private static DatabaseController dbc = null;

    /**
     * Main entry point of the application, testing grounds for the time being
     * @param args Command line args
     */
    public static void main(String[] args){
        dbc = new DatabaseController("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@oracle.wpi.edu:1521:orcl");
        DatabaseEditor dbe = new DatabaseEditor(dbc);
        try {
            dbc.registerDriver();
            dbc.connect("UN","PW");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbe.add_Service(1, "X-Ray");
        dbe.add_Service(2, "Surgery");
        dbe.add_Service(3, "Facilities");
        System.out.println(dbc);

    }

}
