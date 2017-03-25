package progetto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //Inserire nome file dell'oggetto difettoso
        String s = "lavatrice/oggetto.txt";
        
        System.out.println("Inserire numero oggetto difettoso");
        
        Scanner inputN = new Scanner(System.in);
        int n = inputN.nextInt();
        
        Progetto p = new Progetto(s, n);
        p.lettura();
        
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
        
        while(true)
        {
            p.poniDomanda();    //per il test inserire il numero della scelta, non il codice
        }
        
    }
}
