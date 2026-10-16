package ConnectionsJDBC;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatements {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/Java";
        String username = "postgres";
        String password = "sudhanshu@26022004";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String sql = "CALL increase_salary(?, ?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.setInt(1, 5);
            cs.setBigDecimal(2, new BigDecimal("5000"));

            cs.execute();

            System.out.println("Salary updated successfully!");

            cs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}