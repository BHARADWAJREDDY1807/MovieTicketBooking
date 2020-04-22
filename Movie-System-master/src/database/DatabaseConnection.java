package database;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
  String driver;
  String dbName;
  String connectionURL;

  String username;
  String password;
  public DatabaseConnection()
  {
   driver = "com.mysql.cj.jdbc.Driver";
   connectionURL = "jdbc:mysql://localhost:3308/movie_db";
   //dbName = "root";
   username = "root";
   password = "";
  }
  
  public Connection getConnection() throws Exception {

    Class.forName(driver);
    Connection connection = DriverManager.getConnection(connectionURL,username,password);

    return connection;
  }
  
  public static void main(String[] args) {
   DatabaseConnection db = new DatabaseConnection();
   try {
    Connection conn = db.getConnection();
    System.out.println("Database successfully connected!");
    conn.close();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
}