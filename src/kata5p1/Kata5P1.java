
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        
        Connection connection = DriverManager.getConnection("jdbc:sqlite:KATA5.db");
        
        Statement statement = connection.createStatement();
        
        ResultSet rs = statement.executeQuery("SELECT * FROM PEOPLE");
        
        while(rs.next()){
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString(2));
        }
    }
    
}
