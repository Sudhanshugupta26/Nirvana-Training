package ConnectionsJDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableOut {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/Java";
        String username = "postgres";
        String password = "sudhanshu@26022004";

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            CallableStatement cs = con.prepareCall("CALL get_salary(?, ?)");

            // IN parameter
            cs.setInt(1, 5);

            // OUT parameter
            cs.registerOutParameter(2, Types.NUMERIC);

            // Execute procedure
            cs.execute();

            // Get OUT parameter
            double salary = cs.getBigDecimal(2).doubleValue();

            System.out.println("Employee Salary = " + salary);

            cs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
