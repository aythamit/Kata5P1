
package Vista;

import Modelo.Mail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MailListReader {
    
       public static List<Mail> read(String fileName) throws FileNotFoundException, IOException{
        
        List<Mail> mails = new ArrayList<Mail>() {};
        String mailActual;
        BufferedReader reader =
        new BufferedReader(new FileReader(new File(fileName)));
        
        while( (mailActual = reader.readLine()) != null){
            if(mailActual.contains("@"))
                mails.add(new Mail(mailActual));
        }
        
        reader.close();
        
        return mails;
}
}
