package ConnectionsJDBC;


import java.sql.*;

public class CRUD {

    static String url =
        "jdbc:postgresql://localhost:5432/Java";

    static String username = "postgres";
    static String password = "sudhanshu@26022004";

    public static void main(String[] args) {

        try (Connection con =
                DriverManager.getConnection(
                    url,
                    username,
                    password
                )) {

            // CREATE
            insertEmployee(con);

            // READ
            getEmployees(con);

            // UPDATE
            updateEmployee(con);

            // DELETE
            deleteEmployee(con);

            // READ again
            getEmployees(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insertEmployee(Connection con)
            throws SQLException {

        String sql =
            "INSERT INTO employee(name, salary) " +
            "VALUES (?, ?)";

        try (PreparedStatement ps =
                con.prepareStatement(sql)) {

            ps.setString(1, "Rahul");
            ps.setDouble(2, 60000);

            int rows = ps.executeUpdate();

            System.out.println(
                rows + " employee inserted"
            );
        }
    }

    static void getEmployees(Connection con)
            throws SQLException {

        String sql =
            "SELECT * FROM employee";

        try (PreparedStatement ps =
                con.prepareStatement(sql);
             ResultSet rs =
                ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") +
                    " | " +
                    rs.getString("name") +
                    " | " +
                    rs.getDouble("salary")
                );
            }
        }
    }

    static void updateEmployee(Connection con)
            throws SQLException {

        String sql =
            "UPDATE employee " +
            "SET salary = ? " +
            "WHERE id = ?";

        try (PreparedStatement ps =
                con.prepareStatement(sql)) {

            ps.setDouble(1, 65000);
            ps.setInt(2, 7);

            int rows = ps.executeUpdate();

            System.out.println(
                rows + " employee updated"
            );
        }
    }

    static void deleteEmployee(Connection con)
            throws SQLException {

        String sql =
            "DELETE FROM employee WHERE id = ?";

        try (PreparedStatement ps =
                con.prepareStatement(sql)) {

            ps.setInt(1, 6);

            int rows = ps.executeUpdate();

            System.out.println(
                rows + " employee deleted"
            );
        }
    }
}
