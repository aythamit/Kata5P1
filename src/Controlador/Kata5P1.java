
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
import java.util.Calendar;

public class Kata5P1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String fileName = "emails.txt";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        Connection connection = 
                DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "system", "orcl");
        
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM HISTORICO_cambios");
         while(rs.next()){
            System.out.println("De Divisa = " + rs.getString("DIVISA_DESDE") + " A DIVISA  = " + rs.getString("DIVISA_A") + 
                    " el cambio es: " + rs.getFloat("CAMBIO") + " a la hora : "+ rs.getTime(6, Calendar.getInstance()));
        }
         
        //statement.execute("CREATE TABLE IF NOT EXISTS MAIL ('ID' INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT NOT NULL)");
        
        
       /* ArrayList<Mail> mails = new ArrayList<Mail>();
        mails = (ArrayList<Mail>) MailListReader.read(fileName);
        
        String query;
        for (Mail it : mails) {
            query = "INSERT INTO MAIL (Mail) VALUES ('" + it + "');";
            statement.executeUpdate(query);
        }
        */
    }
    
}
