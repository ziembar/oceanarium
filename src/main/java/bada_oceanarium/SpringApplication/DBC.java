package bada_oceanarium.SpringApplication;


import java.sql.*;

public final class DBC {
    private static DBC instance;
    private Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@194.29.170.4:1521:xe",
            "BADAGRB18", "badagrb18");

    private DBC() throws SQLException {}

    public static DBC getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBC();
        }
        return instance;
    }

    public ResultSet query(String query) throws SQLException {
        Statement statement = this.connection.createStatement();
        return statement.executeQuery(query);
    }
}