package grafica;

import esecuzione.Struttura;

public class Grafica 
{
    public static Struttura progetto;
    public static HomePage homePage;
    public static ExecutePage executePage;  
    
    public Grafica()
    {
        progetto = new Struttura();
        progetto.letturaOggetti();
        homePage = new HomePage();
    }
}
