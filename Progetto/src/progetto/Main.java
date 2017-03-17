package progetto;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) 
    {
        LetturaOggetti lo=new LetturaOggetti();
        ArrayList<Oggetto> Oggetti=new ArrayList<>();
        Oggetti=lo.lettura();
        
        int i;
        for(i=0;i<Oggetti.size();i++)
        {
            System.out.println(Oggetti.get(i).getNome());
            System.out.println(Oggetti.get(i).getAttributo());
            System.out.println(Oggetti.get(i).getFileDomande());
            System.out.println(Oggetti.get(i).getFileScelte());
            System.out.println(Oggetti.get(i).getFileAdiacenze());
        }
        
    }
}
