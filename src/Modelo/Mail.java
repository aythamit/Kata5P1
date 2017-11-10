
package Modelo;

public class Mail {
    
    private String mail;
    private String usuario;
    private String dominio;

    public Mail(String mail) {
        
        this.mail = mail;
        String[] Split = mail.split("@");
        this.usuario = Split[0];
        this.dominio = Split[1];
    }
    
        public String getDomain() {
           
        return dominio;
    }
        
        public String toString(){
            return mail;
        }
    
    
}
