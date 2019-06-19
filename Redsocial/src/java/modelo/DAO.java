package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static String bd = "info";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/info?";

    public static Connection Enlace(Connection conn) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException e) {
            System.out.print("Clase no encontrada");
        }
        return conn;
    }

    public static Statement sta(Statement st) throws SQLException {
        conn = Enlace(conn);
        st = conn.createStatement();
        return st;
    }
}
