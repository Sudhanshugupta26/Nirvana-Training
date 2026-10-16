package ConnectionsJDBC;

import java.sql.*;

public class ResultSetMetadataExample {

    public static void main(String[] args) {

        String url =
            "jdbc:postgresql://localhost:5432/Java";

        String username = "postgres";
        String password = "sudhanshu@26022004";

        String sql =
            "SELECT * FROM employee";

        try (
            Connection con =
                DriverManager.getConnection(
                    url,
                    username,
                    password
                );

            PreparedStatement ps =
                con.prepareStatement(sql);

            ResultSet rs =
                ps.executeQuery()
        ) {

            ResultSetMetaData metaData =
                rs.getMetaData();

            int columnCount =
                metaData.getColumnCount();

            System.out.println(
                "Number of columns: "
                + columnCount
            );

            for (int i = 1;
                 i <= columnCount;
                 i++) {

                System.out.println(
                    "Column: "
                    + metaData.getColumnName(i)
                );

                System.out.println(
                    "Type: "
                    + metaData.getColumnTypeName(i)
                );

                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}