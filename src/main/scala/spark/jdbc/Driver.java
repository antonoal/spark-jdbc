package spark.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by antonoal on 27/11/2016.
 */
public class Driver {

    static {
        try {
            DriverManager.registerDriver(new DriverImpl());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
