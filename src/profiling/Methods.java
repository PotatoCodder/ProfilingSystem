
package profiling;

/**
 *
 * @author Konoe
 */
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
public class Methods {
    static Connection conn = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    static java.sql.Statement stmt = null;
    static String url = "jdbc:mysql://localhost:3308/profilingdb";
    static String user = "root";
    static String pass = "";
    static String error = "";
    
    public static Connection opensDB () {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = java.sql.DriverManager.getConnection(url, user,pass);
            System.out.println("Ok! MySQL DB session connected.");
            return conn;
        }   catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static Connection closeDB() {
        try {
            conn.close();
            System.out.println("ok! mysql db sission is closed.");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    
}
