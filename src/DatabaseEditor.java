import java.sql.ResultSet;

/**
 * Created by evan on 3/25/17.
 * This Object will add, remove and edit our hospital database
 */
public class DatabaseEditor {
    DatabaseController dbc = null;
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


    public boolean add_Service(int service_id, String name){
        ResultSet rs;
        rs = dbc.send_Command("insert into service values(" + Integer.toString(service_id) + ", '" + name + "')");
        return (rs==null);
    }
    public boolean edit_Service(int service_id, String new_name){
        return false;
    }
    public boolean remove_Service(int service_id){
        ResultSet rs;
        rs = dbc.send_Command("delete from service where id=" + Integer.toString(service_id) + "')");
        return (rs==null);
    }


    public boolean add_Room_Service(int service_id, String room_number){
        ResultSet rs;
        rs = dbc.send_Command("insert into located values(" + Integer.toString(service_id) + ", '" + room_number + "')");
        return (rs==null);

    }
    public boolean remove_Room_Service(int service_id, String room_number){
        ResultSet rs;
        rs = dbc.send_Command("delete from located where sid=" + Integer.toString(service_id) + " and room_number='" + room_number + "')");

        return (rs==null);
    }

}
