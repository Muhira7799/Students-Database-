
import java.sql.*;

public class Students {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/University",
                "root",
                ""
            );

            Statement st = con.createStatement();

            // i. Display all LName starting with J
            ResultSet rs = st.executeQuery(
                "SELECT * FROM students WHERE LName LIKE 'J%'"
            );
            System.out.println("Names starting with J:");
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " "
                    + rs.getString("LName") + " "
                    + rs.getString("Course") + " "
                    + rs.getString("Country"));
            }

            
            
            // ii. Display countries starting with R
            rs = st.executeQuery(
                "SELECT * FROM students WHERE Country LIKE 'R%'"
            );
            System.out.println("Countries starting with R:");
            while (rs.next()) {
                System.out.println(rs.getString("Country"));
            }

            // iii. Display all information of ID 2012
            rs = st.executeQuery(
                "SELECT * FROM students WHERE Id = 2012"
            );
            System.out.println("Student with ID 2012:");
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " "
                    + rs.getString("LName") + " "
                    + rs.getString("Course") + " "
                    + rs.getString("Country"));
            }

            // iv. Display all IT courses
            rs = st.executeQuery(
                "SELECT * FROM students WHERE Course = 'IT'"
            );
            System.out.println("IT students:");
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " "
                    + rs.getString("LName") + " "
                    + rs.getString("Course") + " "
                    + rs.getString("Country"));
            }

            

String sql = "INSERT INTO students (Id, LName, Course, Country) "
           + "VALUES (2026, 'Jolie', 'Java', 'Rwanda')";

st.executeUpdate(sql);

System.out.println("Student inserted successfully");



            // Close connection
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
