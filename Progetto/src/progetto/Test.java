package progetto;

import java.io.IOException;
import java.util.Scanner;

// Test permette l'esecuzione tramite interfaccia testuale del risolutore di problemi

public class Test 
{
    private Progetto p;
    
    public Test()
    {
        this.p = new Progetto();
    }
    
    public void test() throws IOException
    {
        p.letturaOggetti();
        while(true)
        {
            System.out.println("Scelta Menu:");
            System.out.println("1.Esecuzione risolutore");
            System.out.println("2.Per visualizzare una domanda precedente, le scelte possibili e quella effettuata");
            System.out.println("3.Per modificare la scelta effettuata ad una domanda precedente");
            System.out.println("4.Per tornare alla Home");
            System.out.println("5.Per terminare l'esecuzione");
            
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            
            switch(n)
            {
                case 1:
                {
                    if(p.getOggettoSelezionato()!= null)
                    {
                        System.out.println(p.mostraDomandaAttuale());
                        int i;
                        
                        for(i = 0; i < p.scelteDomandaAttualeSize(); i++)
                        {
                            System.out.println(i + ". " + p.mostraSceltaDomandaAttuale(i));
                        }
                        
                        if(p.adiacenzeDomandaAttualeEmpty())
                        {
                            System.exit(0);
                        }
                        
                        Scanner inputS = new Scanner(System.in);
                        int nscelta = inputS.nextInt();
                        
                        if(nscelta < p.scelteDomandaAttualeSize())
                        {
                            p.esecuzione(nscelta);
                        }
                        else
                            System.out.println("Selezionare un numero di scelta valido");
                    }
                    else {
                        int nogg;
                        System.out.println("Inserire numero oggetto difettoso tra quelli possibili");
                        
                        for(int i = 0; i < p.elencoOggettiSize(); i++) 
                        {
                            System.out.println(i + "." + p.getNomeOggetto(i));
                        }
                        
                        Scanner inputN = new Scanner(System.in);
                        nogg = inputN.nextInt();
                        p.sceltaOggetto(nogg);
                    }
                    break;
                }
                case 2:
                {
                    if(p.percorsoSize() > 0)
                    {
                        System.out.println("Selezionare la domanda a cui si vuole tornare tra quelle possibili");
                        
                        for(int i = 0; i < p.percorsoSize(); i++)
                        {
                            System.out.println(i + "." + p.mostraStatoPercorso(i));
                        }
                        
                        Scanner input2 = new Scanner(System.in);
                        int s = input2.nextInt();
                        
                        if(s < p.percorsoSize())
                        {
                            System.out.println("DOMANDA:");
                            System.out.println(p.mostraStatoPercorso(s));
                            System.out.println("SCELTE POSSIBILI:");
                            
                            for(int k=0; k<p.scelteStatoPercorsoSize(s); k++) 
                            {
                                System.out.println(p.mostraSceltaStatoPercorso(s, k));
                            }
                            
                            System.out.println("SCELTA EFFETTUATA:");
                            System.out.println(p.mostraSceltaPercorso(s));
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
                    if(p.percorsoSize() > 0)
                    {
                        System.out.println("Selezionare la domanda a cui si vuole tornare tra quelle possibili");
                        
                        for(int i = 0; i < p.percorsoSize(); i++)
                        {
                            System.out.println(i + "." + p.mostraStatoPercorso(i));
                        }
                        
                        Scanner input2 = new Scanner(System.in);
                        int s = input2.nextInt();
                        
                        if(s < p.percorsoSize())
                        {
                            p.statoPrecedente(s);
                        }
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
                default:
                {
                    System.out.println("Inserire un numero valido");
                    break;
                }
            }
            
            //eventuale controllo sul percorso se si presentano problemi
            int i = 0;
            
            for(Tappa t : p.getPercorso())
            {
                System.out.println(i);
                System.out.println("DOMANDA:");
                System.out.println(t.mostraStato());
                System.out.println("SCELTE POSSIBILI:");
                
                for(int k = 0; k < t.scelteStatoSize(); k++) 
                {
                    System.out.println(t.mostraSceltaStato(k));
                }
                
                System.out.println("SCELTA EFFETTUATA:");
                System.out.println(t.mostraScelta());
                i++;
            }
        }
    }
}
