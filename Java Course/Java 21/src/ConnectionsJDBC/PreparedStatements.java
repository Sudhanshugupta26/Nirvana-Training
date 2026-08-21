package ConnectionsJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatements {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/Java";
        String username = "postgres";
        String password = "sudhanshu@26022004";

        String sql1 = "INSERT INTO employee(name, salary) VALUES (?, ?)";

        String sql2 = "SELECT * FROM employee WHERE id = ?";

        try  (
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql1)
        ) {

            ps.setString(1, "Deepanshu");
            ps.setDouble(2, 200000);

            int rows = ps.executeUpdate();

            System.out.println(rows + " row inserted!");
            
            PreparedStatement ps2 = con.prepareStatement(sql2);

            ps2.setInt(1, 6);

            ResultSet rs = ps2.executeQuery();

            while (rs.next()) {

    System.out.println(rs.getInt("id"));
    System.out.println(rs.getString("name"));
    System.out.println(rs.getDouble("salary"));
}

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}