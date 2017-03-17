package progetto;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) 
    {
        LetturaOggetti lo=new LetturaOggetti();
        ArrayList<Oggetto> Oggetti=new ArrayList<>();
        ArrayList<Scelta> Scelte=new ArrayList<>();
        ArrayList<Domanda> Domande=new ArrayList<>();
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
        
        LetturaDomande dm=new LetturaDomande(Oggetti.get(0).getFileDomande());
        Domande=dm.lettura(Scelte);
      
        
        for(i=0;i<Domande.size();i++)
        {
            System.out.println(Domande.get(i).getCodD());
            System.out.println(Domande.get(i).getTestoD());
            int k;/*
            for(k=0;k<Domande.get(i).getScelteD().size();k++)
            {
                System.out.println(Domande.get(i).getScelteD().get(k).getCodS());
                System.out.println(Domande.get(i).getScelteD().get(k).getTestoS());
            }*/
            System.out.println();
        }
    }
}
