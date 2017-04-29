/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pippo
 */
public class Test{
    
    private Progetto p;
    
    public Test() {
        this.p = new Progetto();
    }
    
    public void test() throws IOException{
        p.letturaOggetti();
        while(true)
        {
            System.out.println("Scelta Menu:");
            System.out.println("1.Esecuzione risolutore");
            System.out.println("2.Per visulaizzare una domanda precedente, le scelte possibili e quella effettuata");
            System.out.println("3.Per modificare la scelta effettuata ad una domanda precedente");
            System.out.println("4.Per tornare alla Home");
            System.out.println("5.Per terminare l'esecuzione");
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            switch(n)
            {
                case 1:
                {
                    if(p.getOggetto() != null) {
                        System.out.println(p.stampaStato());
                        int i;
                        for(i=0;i<p.getAttuale().getScelte().size();i++)
                        {
                            System.out.println(i+". "+p.getAttuale().mostraScelta(i));
                        }
                        if(p.getAttuale().getAdiacenze().isEmpty()) {
                            System.exit(0);
                        }
                        Scanner inputS = new Scanner(System.in);
                        int nscelta = inputS.nextInt();
                        if(nscelta<p.getAttuale().getScelte().size())
                        {
                            p.esecuzione(nscelta);
                        }
                        else
                            System.out.println("Selezionare un numero di scelta valido");
                    }
                    else {
                        int nogg;
                        System.out.println("Inserire numero oggetto difettoso tra quelli possibili");
                        for(int i = 0; i < p.getOggetti().size(); i++) {
                            System.out.println(i + "." + p.getOggetti().get(i).getNome());
                        }
                        Scanner inputN = new Scanner(System.in);
                        nogg = inputN.nextInt();
                        p.sceltaOggetto(nogg);
                    }
                    break;
                }
                case 2:
                {
                    if(p.getPercorso().size() > 0) {
                        System.out.println("Selezionare la domanda a cui si vuole tornare tra quelle possibili");
                        for(int i = 0; i < p.getPercorso().size(); i++) {
                            System.out.println(i + "." + p.getPercorso().get(i).getStato().getTesto());
                        }
                        Scanner input2 = new Scanner(System.in);
                        int s = input2.nextInt();
                        if(s<p.getPercorso().size()) {
                            System.out.println("DOMANDA:");
                            System.out.println(p.getPercorso().get(s).getStato().getTesto());
                            System.out.println("SCELTE POSSIBILI:");
                            for(int k=0;k<p.getPercorso().get(s).getStato().getScelte().size();k++) {
                                System.out.println(p.getPercorso().get(s).getStato().mostraScelta(k));
                            }
                            System.out.println("SCELTA EFFETTUATA:");
                            System.out.println(p.getPercorso().get(s).getScelta().getTesto());
                        }
                            
                        else
                            System.out.println("Valore inatteso");
                    }
                    else {
                        System.out.println("Operazione non valida: Rispondere ad almeno una domanda");
                    }
                    break;
                }
                case 3:
                {
                    if(p.getPercorso().size() > 0) {
                        System.out.println("Selezionare la domanda a cui si vuole tornare tra quelle possibili");
                        for(int i = 0; i < p.getPercorso().size(); i++) {
                            System.out.println(i + "." + p.getPercorso().get(i).getStato().getTesto());
                        }
                        Scanner input2 = new Scanner(System.in);
                        int s = input2.nextInt();
                        if(s<p.getPercorso().size())
                            p.statoPrecedente(s);
                        else
                            System.out.println("Valore inatteso");
                    }
                    else {
                        System.out.println("Operazione non valida: Rispondere ad almeno una domanda");
                    }
                    break;
                }
                case 4:
                {
                    p.returnHome();
                    break;
                }
                
                case 5:
                {
                    System.out.println("Arrivederci e grazie per aver usato la nostra applicazione");
                    System.exit(0);
                }      
            }
            
            /*
            int i = 0;
            for(Tappa t : p.getPercorso()) {
                System.out.println(i);
                System.out.println("DOMANDA:");
                System.out.println(t.getStato().getTesto());
                System.out.println("SCELTE POSSIBILI:");
                for(int k=0;k<t.getStato().getScelte().size();k++) {
                    System.out.println(t.getStato().mostraScelta(k));
                }
                System.out.println("SCELTA EFFETTUATA:");
                System.out.println(t.getScelta().getTesto());
                i++;
            }
            */
        }
    }
    
}
