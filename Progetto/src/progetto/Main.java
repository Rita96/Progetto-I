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
        
        while(true)
        {
            p.poniDomanda();    //per il test inserire il numero della scelta, non il codice
        }

    }
}
