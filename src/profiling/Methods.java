
    package profiling;
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

        public static boolean insertStudent(String firstName, String middleName, String lastName, String suffix, String birthdate, String gender, String course, String section, String imgPath) {
        Connection conn = opensDB();
        String sql = "INSERT INTO student (fname, mname, lname, suffix, birthdate, gender, course, ssection,img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, firstName);
            pst.setString(2, middleName);
            pst.setString(3, lastName);
            pst.setString(4, suffix);
            pst.setString(5, birthdate);
            pst.setString(6, gender);
            pst.setString(7, course);
            pst.setString(8, section);
            pst.setString(9, imgPath);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Student added successfully!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add student.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        } finally {
            closeDB();
        }
    }


    }
