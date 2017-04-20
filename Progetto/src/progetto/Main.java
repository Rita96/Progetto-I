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
         
        }
    }
}
