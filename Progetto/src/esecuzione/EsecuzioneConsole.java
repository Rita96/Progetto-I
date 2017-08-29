package esecuzione;

import elementi.Scelta;
import elementi.Stato;
import elementi.Tappa;
import java.io.IOException;
import java.util.Scanner;

// EsecuzioneConsole permette l'esecuzione tramite interfaccia testuale del risolutore di problemi

public class EsecuzioneConsole 
{
    private Struttura p;
    
    public EsecuzioneConsole()
    {
        this.p = new Struttura();
    }
    
    public void esecuzione() throws IOException
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
            int n = inserireNumero();
            System.out.println();
            
            switch(n)
            {
                case 1:
                {
                    esecuzioneRisolutore();
                    break;
                }
                case 2:
                {
                    mostraTappaPrecedente();
                    break;
                }
                case 3:
                {
                    modificaTappaPrecedente();
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
            
            //controllo sul percorso se si presentano problemi
            controlloA();
            //controllo sugli stati dell'oggetto selezionato
            controlloB();
            
            System.out.println();
        }
    }
    
    public void esecuzioneRisolutore() throws IOException
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
                System.out.println("Arrivederci e grazie per aver usato la nostra applicazione");
                System.exit(0);
            }

            int nscelta = inserireNumero();

            if(nscelta < p.scelteDomandaAttualeSize())
            {
                p.esecuzione(nscelta);
            }
            else
            {
                System.out.println();
                System.out.println("Selezionare un numero di scelta valido");
            }
        }
        else {
            System.out.println("Inserire numero oggetto difettoso tra quelli possibili");

            for(int i = 0; i < p.elencoOggettiSize(); i++) 
            {
                System.out.println(i + "." + p.getNomeOggetto(i));
            }

            int nogg = inserireNumero();
            
            if(nogg < p.elencoOggettiSize())
            {
                p.sceltaOggetto(nogg);
            }
            else
            {
                System.out.println("Inserire un numero oggetto valido");
            }
        }
    }
    
    public void mostraTappaPrecedente()
    {
        if(p.percorsoSize() > 0)
        {
            System.out.println("Selezionare la domanda a cui si vuole tornare tra quelle possibili");

            for(int i = 0; i < p.percorsoSize(); i++)
            {
                System.out.println(i + "." + p.mostraStatoPercorso(i));
            }

            int s = inserireNumero();
            System.out.println();

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
    }
    
    public void modificaTappaPrecedente()
    {
        if(p.percorsoSize() > 0)
        {
            System.out.println("Selezionare la domanda a cui si vuole tornare tra quelle possibili");

            for(int i = 0; i < p.percorsoSize(); i++)
            {
                System.out.println(i + "." + p.mostraStatoPercorso(i));
            }

            int s = inserireNumero();
            System.out.println();

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
    }
    
    public int inserireNumero()
    {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    
    public void controlloA()
    {
        int i = 0;
            
        for(Tappa t : p.getPercorso())
        {
            System.out.println();
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
            System.out.println();
            i++;
        }
    }
    
    public void controlloB()
    {
        if(p.getOggettoSelezionato()!= null)
        {
            int i = 0;
            for(Stato a : p.getOggettoSelezionato().getStati())
            {
                System.out.println("DOMANDA");
                System.out.println(i+" COD "+p.getOggettoSelezionato().getStato(i).getCodice()+" "+p.getOggettoSelezionato().getStato(i).mostra());
                System.out.println();
                int j = 0;
                for(Scelta b : p.getOggettoSelezionato().getStati().get(i).getScelte())
                {
                    System.out.println(j+" COD "+p.getOggettoSelezionato().getStato(i).getScelta(j).getCodice()+" "+p.getOggettoSelezionato().getStato(i).mostraScelta(j));
                    j++;
                }
                System.out.println();
                i++;
            }
        }
    }
}
