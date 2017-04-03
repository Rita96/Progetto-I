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
        
        Oggetto oggetto = oggetti.get(n);
        
        Progetto p = new Progetto(oggetto);
        p.lettura();
        
        System.out.println("Per il test inserire il numero della scelta: 0,1, ...");
        System.out.println();
        
        while(true)
        {
            p.scelta();    
        }
    }
}
