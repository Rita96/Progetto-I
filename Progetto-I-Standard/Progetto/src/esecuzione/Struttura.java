package esecuzione;

import lettura.LetturaScelte;
import lettura.LetturaStati;
import lettura.LetturaAdiacenze;
import lettura.LetturaOggetti;
import elementi.Oggetto;
import elementi.Scelta;
import elementi.Tappa;
import elementi.Stato;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Struttura contiene tutte le funzioni principale 
 * per il funzionamento corretto del programma
 * 
 * @author Gabriele Guazzardi, Francesco Giudice
 *
 */
public class Struttura
{
    private Stato domandaAttuale;
    private Oggetto oggettoSelezionato;
    private ArrayList<Tappa> percorso; // percorso tiene traccia delle scelte fatte dall'utente rispondendo alle domande
    private ArrayList<Oggetto> elencoOggetti;
    
    public Struttura()
    {
        this.percorso = new ArrayList();
        this.elencoOggetti = new ArrayList();
    }
    
    /**
     * Il metodo letturaOggetti() legge tutti gli oggetti di cui si vuole
     * proporre un problema all'applicazione
     *
     * @throws IOException
     */
    public void letturaOggetti() throws IOException
    {
        LetturaOggetti lo = new LetturaOggetti("/home/bluegecko/git/ProvaEclipse/esame/File/oggetti.txt");
        elencoOggetti = lo.lettura();
    }
    
    /**
     * Il metodo sceltaOggetto(int n) consente all'utente di scegliere di quale
     * oggetto intende risolvere un problema.
     * 
     * @param n
     */
    public void sceltaOggetto(int n) throws IOException
    {
        oggettoSelezionato = elencoOggetti.get(n);
        letturaDatiOggetto();
        domandaAttuale = oggettoSelezionato.getStatoIniziale();
    }
    
   /**
    * Il metodo letturaDatiOggetto() va a leggere per l'oggetto selezionato tutte le 
    * domande, le scelte e le adiacenze alle domande usando le classi di
    * lettura delle Scelte, Domande ed Adiacenze.
    * 
    * 
    * @throws FileNotFoundException
    * @throws IOException
    */
    public void letturaDatiOggetto() throws FileNotFoundException, IOException 
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
     * Il metodo esecuzioneProg(int n) consente all'utente di effettuare una scelta
     * tra quelle possibili ad un determinato stato.
     * 
     * 
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
     * 
     * 
     * @param scelta
     */
    public void prossimoStato(int scelta)
    {
        domandaAttuale = domandaAttuale.getAdiacenza(scelta);
    }
    
    /** 
     * Il metodo statoPrecedente(int i) ritorna ad una domanda a cui
     * si Ã¨ precedente risposto.
     * 
     * 
     * @param i
     */
    public void statoPrecedente(int i)
    {
        domandaAttuale = getTappa(i).getStato();
        for(int j = percorso.size() - 1; j >= i; j--)
            percorso.remove(j);
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
     * Il metodo esecuzione(int n) consente all'utente di effettuare una scelta
     * tra quelle possibili ad un determinato stato.
     * 
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
    
    public Stato getDomandaAttuale()
    {
        return domandaAttuale;
    }
    
    public Oggetto getOggettoSelezionato()
    {
        return oggettoSelezionato;
    }
    
    public ArrayList<Tappa> getPercorso()
    {
        return percorso;
    }
    
    public ArrayList<Oggetto> getElencoOggetti()
    {
        return elencoOggetti;
    }
    
    public String mostraDomandaAttuale() 
    {
        return domandaAttuale.mostra();
        //attuale.mostraScelte();
    }
    
    public ArrayList<Scelta> getScelteDomandaAttuale()
    {
        return domandaAttuale.getScelte();
    }
    
    public String mostraSceltaDomandaAttuale(int i)
    {
        return domandaAttuale.mostraScelta(i);
    }

    public ArrayList<Stato> getAdiacenzeDomandaAttuale()
    {
        return domandaAttuale.getAdiacenze();
    }
    
    public Tappa getTappa(int i)
    {
        return percorso.get(i);
    }
    
    public Oggetto getOggetto(int i)
    {
        return elencoOggetti.get(i);
    }
    
    public String getNomeOggetto(int i)
    {
        return getOggetto(i).getNome();
    }
    
    public String mostraStatoPercorso(int i)
    {
        return getTappa(i).mostraStato();
    }
    
    public String getTestoSceltaPercorso(int i)
    {
        return getTappa(i).mostraScelta();
    }
    
    public Stato getStatoPercorso(int i)
    {
        return getTappa(i).getStato();
    }
    
    public Scelta getSceltaPercorso(int i)
    {
        return getTappa(i).getScelta();
    }
    
    public ArrayList<Scelta> getScelteStatoPercorso(int i)
    {
        return getTappa(i).getScelteStato();
    }
    
    public int scelteDomandaAttualeSize()
    {
        return domandaAttuale.scelteSize();
    }
    
    public boolean adiacenzeDomandaAttualeEmpty()
    {
        return domandaAttuale.adiacenzeEmpty();
    }
    
    public boolean scelteDomandaAttualeEmpty()
    {
        return domandaAttuale.scelteEmpty();
    }
    
    public int elencoOggettiSize()
    {
        return elencoOggetti.size();
    }
    
    public int percorsoSize()
    {
        return percorso.size();
    }
    
    public int scelteStatoPercorsoSize(int i)
    {
        return getTappa(i).scelteStatoSize();
    }
    
    public String mostraSceltaPercorso(int i)
    {
        return getTappa(i).mostraScelta();
    }
    
    /** 
     * Il metodo mostraSceltaStatoPercorso() restituisce il testo della scelta j dello stato i del percorso
     */
    public String mostraSceltaStatoPercorso(int i, int j)
    {
        return getTappa(i).mostraSceltaStato(j);
    }
    
  
    public void back()
    {
        statoPrecedente(percorso.size() - 1);
    }
    
    /**
     * selezionaOggetto() permette di selezionare l'oggetto di cui
     * si vuole risolvere i problemi.
     * @param n
     * @throws IOException
     */
    public void selezionaOggetto(int n) throws IOException
    {
        oggettoSelezionato = elencoOggetti.get(n);
        letturaDatiOggetto();
        domandaAttuale = oggettoSelezionato.getStatoIniziale();
    }
    
    public void clearPercorso()
    {
        percorso.clear();
    }
    
    public Object[] percorsoArray()
    {
        return percorso.toArray();
    }
    
    public boolean percorsoEmpty()
    {
        return percorso.isEmpty();
    }
    
    public Object[] elencoOggettiArray()
    {
        return elencoOggetti.toArray();
    }

    String getCodiceDomandaAttuale() {
        return domandaAttuale.getCodice();
    }

    String getCodiceSceltaDomandaAttuale(int n) {
        return domandaAttuale.getCodiceScelta(n);
    }

    public ArrayList<Stato> getStatiOggettoSelezionato() {
        return oggettoSelezionato.getStati();
    }
}