package progetto;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) 
    {
        
        LetturaOggetti lo=new LetturaOggetti();
        ArrayList<Oggetto> oggetti=new ArrayList<>();
        oggetti=lo.lettura();
        Progetto p = new Progetto(oggetti.get(0));
        p.letture();
        p.toString();
        
    }
}
