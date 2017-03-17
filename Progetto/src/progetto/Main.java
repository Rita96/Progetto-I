package progetto;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) 
    {
        LetturaOggetti lo=new LetturaOggetti();
        ArrayList<Oggetto> Oggetti=new ArrayList<>();
        ArrayList<Scelta> Scelte=new ArrayList<>();
        Oggetti=lo.lettura();
        
        int i;
        for(i=0;i<Oggetti.size();i++)
        {
            System.out.println(Oggetti.get(i).getNome());
            System.out.println(Oggetti.get(i).getAttributo());
            System.out.println(Oggetti.get(i).getFileDomande());
            System.out.println(Oggetti.get(i).getFileScelte());
            System.out.println(Oggetti.get(i).getFileAdiacenze());
            System.out.println();
        }
        
        LetturaScelte sc=new LetturaScelte(Oggetti.get(0).getFileScelte());
        Scelte=sc.lettura();
       
        for(i=0;i<Scelte.size();i++)
        {
            System.out.println(Scelte.get(i).getCodS());
            System.out.println(Scelte.get(i).getTestoS());
            System.out.println();
        }
        
    }
}
