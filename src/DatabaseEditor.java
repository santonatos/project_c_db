import java.sql.ResultSet;

/**
 * Created by evan on 3/25/17.
 * This Object will add, remove and edit our hospital database
 */
public class DatabaseEditor {
    DatabaseController dbc = null;

    /**
     * Constructor, takes a database connection to use for editing
     * @param _dbc
     */
    public DatabaseEditor (DatabaseController _dbc){
        this.dbc = _dbc;
    }

    public boolean edit_Room(){
        return false;
    }

    public boolean add_Room(){
        return false;
    }
    public boolean remove_Room(){
        return false;
    }

    /**
     * Adds Services, takes in a unique ID number and a name for the service
     * @param service_id
     * @param name
     * @return
     */
    public boolean add_Service(int service_id, String name){
        ResultSet rs;
        rs = dbc.send_Command("insert into service values(" + Integer.toString(service_id) + ", '" + name + "')");
        return (rs==null);
    }
    public boolean edit_Service(int service_id, String new_name){
        return false;
    }

    /**
     * Takes in a service id and then removes any entry with that id number
     * @param service_id
     * @return
     */
    public boolean remove_Service(int service_id){
        ResultSet rs;
        rs = dbc.send_Command("delete from service where id=" + Integer.toString(service_id) + "')");
        return (rs==null);
    }

    /**
     * Takes in a string name of the service and deletes any service with that name
     * @param name
     * @return
     */
    public boolean remove_Service(String name){
        ResultSet rs;
        rs = dbc.send_Command("delete from service where name=" + name + "')");
        return (rs==null);
    }


    /**
     * Takes in a service ID and a room number and associates them so that the room will offer the service
     * @param service_id
     * @param room_number
     * @return
     */
    public boolean add_Room_Service(int service_id, String room_number){
        ResultSet rs;
        rs = dbc.send_Command("insert into located values(" + Integer.toString(service_id) + ", '" + room_number + "')");
        return (rs==null);

    }

    /**
     * Removes an association between a room and a service
     * @param service_id
     * @param room_number
     * @return
     */
    public boolean remove_Room_Service(int service_id, String room_number){
        ResultSet rs;
        rs = dbc.send_Command("delete from located where sid=" + Integer.toString(service_id) + " and room_number='" + room_number + "')");
        return (rs==null);
    }

}
