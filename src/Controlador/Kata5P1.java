
package Controlador;

import Modelo.Mail;
import Vista.MailListReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String fileName = "emails.txt";
        Class.forName("org.sqlite.JDBC");
        
        Connection connection = DriverManager.getConnection("jdbc:sqlite:KATA5.db");
        
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM PEOPLE");
         while(rs.next()){
            System.out.println("ID = " + rs.getInt("ID") + "NAME = " + rs.getString(2));
        }
         
        statement.execute("CREATE TABLE IF NOT EXISTS MAIL ('ID' INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT NOT NULL)");
        
        
        ArrayList<Mail> mails = new ArrayList<Mail>();
        mails = (ArrayList<Mail>) MailListReader.read(fileName);
        
        String query;
        for (Mail it : mails) {
            query = "INSERT INTO MAIL (Mail) VALUES ('" + it + "');";
            statement.executeUpdate(query);
        }
        
    }
    
}
