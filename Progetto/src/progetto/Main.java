package progetto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        
        
        Progetto p = new Progetto();
        
        while(true)
        {
            System.out.println("Scelta Menu:");
            System.out.println("1.Per caricare Oggetto\n2.Per esecuzione\n3.Per tornare alla Home\n4.Per tornare indietro");
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            switch(n)
            {
                case 1:
                {
                    p.sceltaOggetto();
                    p.lettura();
                    break;
                }
                case 2:
                {
                    p.esecuzione();
                    break;
                }
                case 3:
                {
                    p.returnHome();
                    break;
                }
                case 4:
                {
                    System.out.println("Selezionare la domanda a cui si vuole tornare 0,1...");
                    Scanner input2 = new Scanner(System.in);
                    int s = input2.nextInt();
                    p.statoPrecedente(s);
                    p.esecuzione();
                    break;
                }
                        
            }
            
            System.out.println();
            System.out.println("---CONTROLLO PERCORSO---");
            int i = 0;
            
            for(Tappa t : p.getPercorso()) {
                System.out.println(i);
                System.out.println("DOMANDA:");
                System.out.println(t.getStato().getTesto());
                System.out.println("SCELTE POSSIBILI:");
                t.getStato().mostraScelte();
                System.out.println("SCELTA EFFETTUATA:");
                System.out.println(t.getScelta().getTesto());
                i++;
            }
            System.out.println();
        }
    }
}
