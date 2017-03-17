package progetto;

import java.util.ArrayList;

public class Progetto {

    public static void main(String[] args) 
    {
        LetturaDomande l=new LetturaDomande("Domande.txt");
        
        ArrayList<Stato> lista=new ArrayList<>();
        lista=l.lettura();
        
        int i;
        for(i=0;i<lista.size();i++)
        {
            System.out.println(lista.get(i).getId());
        }

    }
}
