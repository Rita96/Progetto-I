/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.util.Scanner;

/**
 *
 * @author Pippo
 */
public class Test {
    
    private Progetto p;
    
    public Test() {
        this.p = new Progetto();
    }
    
    public void test() {
        
        while(true)
        {
            System.out.println("Scelta Menu:");
            System.out.println("1.Per caricare Oggetto\n2.Per esecuzione\n3.Per tornare alla Home\n4.Per tornare indietro\n5.Per terminare l'esecuzione");
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
                    if(p.getOggetto() != null) {
                        p.esecuzione();
                    }
                    else {
                        System.out.println("Operazione non valida: Selezionare un oggetto");
                    }
                    break;
                }
                case 3:
                {
                    p.returnHome();
                    break;
                }
                case 4:
                {
                    if(p.getPercorso().size() > 0) {
                        System.out.println("Selezionare la domanda a cui si vuole tornare 0,1...");
                        Scanner input2 = new Scanner(System.in);
                        int s = input2.nextInt();
                        p.statoPrecedente(s);
                        p.esecuzione();
                    }
                    else {
                        System.out.println("Operazione non valida: Rispondere ad almeno una domanda");
                    }
                    break;
                }
                case 5:
                {
                    System.out.println("Arrivederci");
                    System.exit(0);
                }      
            }
            
            /*
            //CONTROLLO SUL PERCORSO
            
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
            */
        }
    }
    
}
