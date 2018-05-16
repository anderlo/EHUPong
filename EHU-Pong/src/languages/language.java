package languages;
import java.io.IOException;
import java.util.Properties;
 
public class language extends Properties{
    private static final long serialVersionUID = 1L;
    public language(String idioma){

        switch(idioma){
            case "ESP":
                    getProperties("espanol.properties");
                    break;
            case "EUS":
                    getProperties("euskera.properties");
                    break;
            case "ENG":
                getProperties("ingles.properties");
                break;
            default:
                    getProperties("euskera.properties");
        }
 
    }
    private void getProperties(String atala) {
        try {
            this.load( getClass().getResourceAsStream(atala) );
        } 
        catch (IOException ex) {
        }
   }
}