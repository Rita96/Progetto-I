package progetto;

import java.io.IOException;
import java.util.ArrayList;

public class Progetto
{
    private Stato domandaAttuale;
    private Oggetto oggettoSelezionato;
    private ArrayList<Tappa> percorso; // percorso tiene traccia delle scelte fatte dall'utente rispondendo alle domande
    private ArrayList<Oggetto> elencoOggetti;
    
    public Progetto()
    {
        this.percorso = new ArrayList();
        this.elencoOggetti = new ArrayList();
    }
    
    public Stato getDomandaAttuale()
    {
        return domandaAttuale;
    }
    
    public ArrayList<Tappa> getPercorso()
    {
        return percorso;
    }
    
    public ArrayList<Oggetto> getElencoOggetti()
    {
        return elencoOggetti;
    }
    
    /**
     * Il metodo letturaOggetti() legge tutti gli oggetti di cui si vuole
     * proporre un problema all'applicazione.
     */
    public void letturaOggetti()
    {
        LetturaOggetti lo = new LetturaOggetti("oggetti.txt");
        elencoOggetti = lo.lettura();
    }
    
    /** 
     * Il metodo letturaDatiOggetto() va a leggere per l'oggetto selezionato tutte le 
     * domande, le scelte e le adiacenze alle domande usando le classi di
     * lettura delle Scelte, Domande ed Adiacenze.
     */
    public void letturaDatiOggetto() 
    {
        ArrayList<Scelta> scelte;
        ArrayList<Stato> stati;
        
        LetturaScelte letturaS = new LetturaScelte(oggettoSelezionato.getFileScelte());
        scelte = letturaS.lettura();
        LetturaStati letturaD = new LetturaStati(oggettoSelezionato.getFileStati());
        stati=letturaD.lettura(scelte);
        LetturaAdiacenze letturaA = new LetturaAdiacenze(oggettoSelezionato.getFileAdiacenze());
        stati = letturaA.lettura(stati);
        
        oggettoSelezionato.setStati(stati);
    }
    
    /**
     * Il metodo sceltaOggetto(int n) consente all'utente di scegliere di quale
     * oggetto intende risolvere un problema.
     * @param n
     */
    public void selezionaOggetto(int n)
    {
        oggettoSelezionato = elencoOggetti.get(n);
        letturaDatiOggetto();
        domandaAttuale = oggettoSelezionato.getStatoIniziale();
    }
    
    /** 
     * Il metodo esecuzioneProg(int n) consente all'utente di effettuare una scelta
     * tra quelle possibili ad un determinato stato.
     * @param n
     */
    public void esecuzioneProgetto(int n)
    {
        Scelta s = domandaAttuale.getScelta(n);
        Tappa r = new Tappa(domandaAttuale, s);
        percorso.add(r);
        prossimoStato(n);
    }
    
    /** 
     * Il metodo prossimoStato(int scelta) imposta lo stato successivo in base
     * alla scelta effettuata allo stato attuale.
     * @param scelta
     */
    public void prossimoStato(int scelta)
    {
        domandaAttuale = domandaAttuale.getProssimaAdiacenza(scelta);
    }
    
    /** 
     * Il metodo returnHome() ripulisce tutte le informazioni tranne l'arraylist
     * di oggetti in modo da poter partire da capo a risolvere problemi di un
     * altro oggetto;
     * Dopo aver chiamato questo metodo bisogna chiamare lettura per
     * inizializzare un nuovo oggetto.
     */    
    public void returnHome()
    {
        domandaAttuale = null;
        oggettoSelezionato = null;
        percorso.clear();
    }
    
    /** 
     * Il metodo statoPrecedente(int i) ritorna ad una domanda a cui
     * si è precedente risposto.
     * @param i
     */
    public void statoPrecedente(int i)
    {
        domandaAttuale = getTappa(i).getStato();
        for(int j = percorso.size() - 1; j >= i; j--)
            percorso.remove(j);
    }
    
    /** 
     * Il metodo indietro() ritorna alla domanda precedente
     */
    public void back()
    {
        statoPrecedente(percorso.size() - 1);
    }
    
//------------------------------------------------------------------------------
// Metodi Debug/Test/Inutilizzati:
    
    //TEXT
    public String stampaStato() 
    {
        return domandaAttuale.getTesto();
        //attuale.mostraScelte();
    }
    
    /**
     * Il metodo sceltaOggetto(int n) consente all'utente di scegliere di quale
     * oggetto intende risolvere un problema.
     * @param n
     */
    public void sceltaOggetto(int n)
    {
        if(n < elencoOggetti.size())
        {
            oggettoSelezionato = elencoOggetti.get(n);
            letturaDatiOggetto();
            domandaAttuale = oggettoSelezionato.getStatoIniziale();
        }
        else
            System.out.println("Inserire un numero oggetto valido");
    }
    
    /** 
     * Il metodo esecuzione(int n) consente all'utente di effettuare una scelta
     * tra quelle possibili ad un determinato stato.
     * @param n
     */
    public void esecuzione(int n) throws IOException
    {
        /*  Questo if controlla se la domanda attuale ha delle possibili 
            scelte, e quindi delle adiacenze. In caso contrario siamo
            arrivati ad una possibile soluzione del problema.
            Per terminare l'esecuzione del programma premere il tasto "Invio".
        */
        if(domandaAttuale.getScelte().isEmpty())
        {   
            System.in.read();
            System.exit(0);
        }
        else
        {
            /* n indica la risposta data dall'utente.
               NON CONTIENE IL CODICE SCELTA MA LA POSIZIONE NELL'ARRAY
            */
            Scelta s = domandaAttuale.getScelta(n);
            Tappa r = new Tappa(domandaAttuale, s);
            percorso.add(r);
            /*
            //metodo usato per tenere traccia della risposta data all'interno dell'Array risposte (1)
            addRisposta(r); 
            attuale = getDomanda(d, n);
            */
            prossimoStato(n);
        }
    }
    
    /** 
     * !! METODO PROBABILMENTE INUTILE !!
     * 
     * Il metodo cambioTappa(int n) permette di cambiare scelta ad uno stato
     * a cui si è già risposto.
     * @param n
     */
    public void cambioTappa(int n)
    {
        if(n < domandaAttuale.getScelte().size())
        {
            Scelta s = domandaAttuale.getScelta(n);
            getTappa(n).setScelta(s);
            pulisciPercorso();
        }
    }
    
    /** 
     * Il metodo indietro() ritorna alla domanda precedente
     */
    public void indietro()
    {
        if(percorso.size() > 1)
        {
            statoPrecedente(percorso.size() - 1);
        }
    }
    
    public void tappaPrecedente(int n)
    {
        Scelta s = domandaAttuale.getScelte().get(n);
        percorso.get(n).setScelta(s);
        pulisciPercorso();
    }
    
    public Oggetto getOggettoSelezionato()
    {
        return oggettoSelezionato;
    }
    
    public Tappa getTappa(int i)
    {
        return percorso.get(i);
    }
    
    /**
     * !! METODO PROBABILMENTE INUTILE !!
     * 
     * Il metodo pulisciPercorso() cancella le tappe successive a quella 
     * di cui si è cambiata scelta.
     */
    public void pulisciPercorso() 
    {
        int n = percorso.size();
        int c = n;
        
        // Trova da che domanda in poi bisogna cancellare le risposte (compresa attuale)
        for(int i = 0; i < n; i++)
        {
            if(domandaAttuale.getCodice().equals(getTappa(i).getCodiceStato()))
            {
                c = i;
                i = n;
            }
        }
        
        // Cancella le risposte sucessive (compresa attuale).
        while(c < n)
        {
            percorso.remove(c);
            c++;
        }
    }
}
