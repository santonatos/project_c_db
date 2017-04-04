import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

public class DatabaseControllerTest extends DatabaseController{

    DatabaseControllerTest () {
        super("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:testDB;create=true");
    }

    @Test
    void testSendCommand(){

    }

}
