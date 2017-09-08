package grafica;

import esecuzione.Struttura;
import java.io.IOException;

public class Grafica 
{
    private Struttura progetto;
    private HomePage homePage;
    private ExecutePage executePage;  
    
    public Grafica() throws IOException
    {
        progetto = new Struttura();
        progetto.letturaOggetti();
        homePage = new HomePage(progetto);
    }
}
