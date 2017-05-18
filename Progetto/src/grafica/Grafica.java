package grafica;

import progetto.Progetto;

public class Grafica 
{
    public static Progetto progetto;
    public static HomePage homePage;
    public static ExecutePage executePage;
    
    
    public Grafica()
    {
        progetto = new Progetto();
        progetto.letturaOggetti();
        homePage = new HomePage();
    }
}
