package progetto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String s = "lavatrice/oggetto.txt";
        
        LetturaOggetti lo = new LetturaOggetti(s);
        ArrayList<Oggetto> oggetti = new ArrayList<>();
        oggetti = lo.lettura();
        
        System.out.println("Inserire numero oggetto difettoso 0,1, ...");
        
        Scanner inputN = new Scanner(System.in);
        int n = inputN.nextInt();
        
        //chiunque abbia deciso di caricare l'intero ArrayList di Oggetto dentro la classe Progetto che è fatta per lavorare solo su
        //UN SOLO determinato Oggetto dovrebbe seriamente pensare all'utilità di questa malsana idea
        Oggetto oggetto = oggetti.get(n);
        
        Progetto p = new Progetto(oggetto);
        p.lettura();
        //questi foreach che rendono difficile la ricerca di problemi vengono usati prima del Test per mostrare l'elenco di
        //tutte le domande(codice,testo) con le rispettive scelte(risposte alle domande) e le adiacenze che dipendono dalle scelte
        //le adiacenze indicano la domanda sucessiva
        for(Domanda d:p.getOggetto().getDomande())
        {
            System.out.println("DOMANDA "+d.getCodice()+" "+d.getTesto());
            for(Scelta r:d.getScelte())
            {
                System.out.println("SCELTA "+r.getCodice()+" "+r.getTesto());
            }
            for(Domanda a:d.getAdiacenze())
            {
                System.out.println("ADIACENZA "+a.getCodice()+" "+a.getTesto());
            }
            System.out.println();
        }
        
        System.out.println("TEST\n");
        
        System.out.println("Per il test inserire il numero della scelta, non il codice 0,1, ...");
        System.out.println();
        while(true)
        {
            p.poniDomanda();    
        }
        
    }
}
