package grafica;

import progetto.Progetto;

public class Grafica 
{
    public static Progetto progetto;
    public static HomePage homePage;
    public static ExecutePage executePage;
    static boolean ultimoStato;    
    
    public Grafica()
    {
        progetto = new Progetto();
        progetto.letturaOggetti();
        homePage = new HomePage();
        ultimoStato = false;
    }
}
