package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static String ip = "127.0.0.1";
    static String port = "3306";
    static String database = "hutubill";
    static String encode = "UTF-8";
    static String username = "root";
    static String password = "hqm1775403507";

    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encode);
        return DriverManager.getConnection(url , username, password);
    }

}
