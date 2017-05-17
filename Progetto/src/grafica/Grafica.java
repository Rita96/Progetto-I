package grafica;

import progetto.Progetto;

public class Grafica 
{
    public static Progetto p;
    public static HomePage hp;
    public static ExecutePage exe;
    
    public Grafica()
    {
        p = new Progetto();
        p.letturaOggetti();
        hp = new HomePage();
        exe= new ExecutePage();
    }
}
