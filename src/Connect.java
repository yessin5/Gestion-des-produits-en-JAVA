import java.sql.Connection;
import java.sql.DriverManager;


public class Connect {
    private static Connection con;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver ok");
            String url = "jdbc:mysql://localhost:3306/Catalogue";
            String user = "root";
            String pwd = "";
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return con;
    }
}