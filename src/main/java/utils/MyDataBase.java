package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MyDataBase {
    final String URL = "jdbc:mysql://localhost:3306/";
    final String USER = "root";
    final String PASSWORD = "";
    Connection connection ;

    static MyDataBase Instance;
    private MyDataBase() {
        try{
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connection established");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static MyDataBase getInstance(){
        if(Instance==null){
            Instance=new MyDataBase();
        }
        return Instance;
    }

    public Connection getConnection(){ return connection; }

}
