package grafica;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import progetto.Progetto;

public class Grafica 
{
    public static Progetto p;
    
    public Grafica()
    {
        p = new Progetto();
        p.letturaOggetti();
        HomePage hp=new HomePage("Home");
        hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
