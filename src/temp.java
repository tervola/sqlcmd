import java.sql.*;

/**
 * Created by user on 8/28/2015.
 */
public class temp {

    public static void main(String[] args) {


        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Mydb", "postgres", "Password01");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            /**
             String sql = "CREATE TABLE COMPANY " +
             "(ID INT PRIMARY KEY     NOT NULL," +
             " NAME           TEXT    NOT NULL, " +
             " AGE            INT     NOT NULL, " +
             " ADDRESS        CHAR(50), " +
             " SALARY         REAL)";
             */
            String sql = "SELECT * FROM id";
            //stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(sql);
            int index = 1;
            System.out.println(rs.getMetaData().getColumnName(1));
            System.out.println(rs.getMetaData().getColumnName(2));

            while (rs.next()) {
                System.out.println(rs.getString(index) +  ": " +rs.getString(index + 1));
            }
            System.out.println("\n");
            try {
                stmt.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println(String.format("%" + 30 + "s", ""));
        System.out.println("Table created successfully");
    }
}
