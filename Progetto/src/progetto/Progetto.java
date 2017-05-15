package progetto;

import java.io.IOException;
import java.util.ArrayList;

public class Progetto
{
    // attuale indica la domanda posta attualmente all'utente
    private Stato attuale;
    private Oggetto oggetto;
    // percorso tiene traccia delle scelte fatte dall'utente rispondendo alle domande
    private ArrayList<Tappa> percorso; 
    private ArrayList<Oggetto> oggetti;
    
    public Progetto()
    {
        percorso = new ArrayList();
        oggetti = new ArrayList();
    }
    
    public Stato getAttuale()
    {
        return attuale;
    }
    
    public Oggetto getOggetto()
    {
        return oggetto;
    }
    
    public ArrayList<Tappa> getPercorso()
    {
        return percorso;
    }
    
    public Tappa getTappa(int i)
    {
        return percorso.get(i);
    }
    
    public ArrayList<Oggetto> getOggetti()
    {
        return oggetti;
    }
    
    //TEXT
    public String stampaStato() 
    {
        return attuale.getTesto();
        //attuale.mostraScelte();
    }
    
    /**
     * Il metodo letturaOggetti() legge tutti gli oggetti di cui si vuole
     * proporre un a risoluzione di problemi contiene i nomi dei file da cui
     * prendere le scelte, gli stati e le adiacenze.
     */
    public void letturaOggetti()
    {
        String s = "oggetti.txt";
        LetturaOggetti lo = new LetturaOggetti(s);
        oggetti = new ArrayList<>();
        oggetti = lo.lettura();
    }
    
    /** 
     * Il metodo lettura() va a leggere per l'Oggetto che è attributo di Progetto
     * dai rispettivi file di testo tutte le domande relative, le scelte e le
     * adiacenze alle domande usando le classi di lettura delle Scelte, Domande
     * ed Adiacenze.
     */
    public void lettura() 
    {
        ArrayList<Scelta> scelte = null;
        ArrayList<Stato> stati = null;
        
        LetturaScelte letturaS = new LetturaScelte(oggetto.getFileScelte());
        scelte = letturaS.lettura();
        LetturaStati letturaD = new LetturaStati(oggetto.getFileStati());
        stati=letturaD.lettura(scelte);
        LetturaAdiacenze letturaA = new LetturaAdiacenze(oggetto.getFileAdiacenze());
        stati = letturaA.lettura(stati);
        
        oggetto.addStato(stati);
        // la prima nel file di testo diventa la prima domanda da porre all'utente
        attuale = oggetto.getStati().get(0);
    }
    
    /**
     * Il metodo sceltaOggetto(int n) consente all'utente di scegliere di quale
     * oggetto intende risolvere un problema.
     * @param n
     */
    public void sceltaOggetto(int n)
    {
        if(n < oggetti.size())
        {
            oggetto = oggetti.get(n);
            lettura();
        }
        else
            System.out.println("Inserire un numero oggetto valido");
    }
    
    /** 
     * Il metodo esecuzione(int n) consente all'utente di effettuare una scelta
     * tra quelle possibili ad un determinato stato.
     * @param n
     * @throws java.io.IOException
     */
    public void esecuzione(int n) throws IOException
    {
        /*  Questo if controlla se la domanda attuale ha delle possibili 
            scelte, e quindi delle adiacenze. In caso contrario siamo
            arrivati ad una possibile soluzione del problema.
            Per terminare l'esecuzione del programma premere il tasto "Invio".
        */
        if(attuale.getScelte().isEmpty())
        {   
            System.in.read();
            System.exit(0);
        }
        else
        {
            /* n indica la risposta data dall'utente.
               NON CONTIENE IL CODICE SCELTA MA LA POSIZIONE NELL'ARRAY
            */
            Scelta s = attuale.getScelte().get(n);
            Tappa r = new Tappa(attuale, s);
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
     * Il metodo prossimoStato(int scelta) imposta lo stato successivo in base
     * alla scelta effettuata allo stato attuale.
     * @param scelta
     */
    public void prossimoStato(int scelta)
    {   
        attuale = attuale.getProssimaAdiacenza(scelta);
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
        if(n < attuale.getScelte().size())
        {
            Scelta s = attuale.getScelte().get(n);
            percorso.get(n).setScelta(s);
            pulisciPercorso();
        } 
    }
    
    /** 
     * Il metodo returnHome() ripulisce tutte le informazioni tranne l'arraylist
     * di oggetti in modo da poter partire da capo a risolvere problemi di un
     * altro oggetto;
     * Dopo aver chiamato questo metodo bisogna chiamare lettura per
     * inizializzare un nuovo oggetto.
     */    
    public void returnHome() // <3
    {
        attuale = null;
        oggetto = null;
        percorso.clear();
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
            if(attuale.getCodice().equals(percorso.get(i).getStato().getCodice()))
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
    
    /** 
     * Il metodo statoPrecedente(int i) ritorna ad una domanda a cui
     * si è precedente risposto.
     * @param i
     */
    public void statoPrecedente(int i)
    {
        if(i < percorso.size())
        {
            attuale = percorso.get(i).getStato();
            for(int j = percorso.size() - 1; j >= i; j--) 
            {
                percorso.remove(j);
            }
        }
    }
    
    /** 
     * Il metodo indietro() ritorna alla domanda precedente
     */
    public void indietro()
    {
        if(percorso.size()>1)
        {
            statoPrecedente(percorso.size() - 1);
        }
    }
}
