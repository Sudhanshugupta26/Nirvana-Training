package ConnectionsJDBC;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPool {

    public static void main(String[] args) throws SQLException {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/Java");
        config.setUsername("postgres");
        config.setPassword("your_password");
        config.setMaximumPoolSize(10);

        try (HikariDataSource dataSource = new HikariDataSource(config)) {
            String sql = "SELECT * FROM employee";

            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement ps = connection.prepareStatement(sql);

                    ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    System.out.println(rs.getInt("id")
                            + " | "
                            + rs.getString("name")
                            + " | "
                            + rs.getBigDecimal("salary"));
                }
            }
        }
    }
}