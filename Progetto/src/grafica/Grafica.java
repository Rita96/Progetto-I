package grafica;

import esecuzione.Struttura;
import java.io.IOException;

public class Grafica 
{
    public static Struttura progetto;
    public static HomePage homePage;
    public static ExecutePage executePage;  
    
    public Grafica() throws IOException
    {
        progetto = new Struttura();
        progetto.letturaOggetti();
        homePage = new HomePage();
    }
}
