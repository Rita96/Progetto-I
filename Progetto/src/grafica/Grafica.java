package grafica;

import progetto.Progetto;

public class Grafica 
{
    public static Progetto p;
    public static HomePage hp;
    
    public Grafica()
    {
        p = new Progetto();
        p.letturaOggetti();
        hp = new HomePage();
    }
}
