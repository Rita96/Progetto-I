package progetto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Progetto
{   //l'attributo Stato attuale indica la domanda che viene posta al momento all'utente
    private Stato attuale;
    private Oggetto oggetto;
    //l'attributo ArrayList Tappa percorso salva il percorso fatto dall'utente man mano che risponde alle domande
    private ArrayList<Tappa> percorso;
    private ArrayList<Oggetto> oggetti;

    public Progetto()
    {
        percorso = new ArrayList();
        oggetti=new ArrayList();
    }
    
    public Stato getAttuale()
    {
        return attuale;
    }
    
    public Oggetto getOggetto() {
        return oggetto;
    }
    
    public ArrayList<Tappa> getPercorso() {
        return percorso;
    }
    
    public Tappa getTappa(int i)
    {
        return percorso.get(i);
    }

    public ArrayList<Oggetto> getOggetti() {
        return oggetti;
    }
    
    public String stampaStato()//TEXT
    {
        return attuale.getTesto();
        //attuale.mostraScelte();
    }
    
    public void letturaOggetti() {//Questo metodo va a leggere tutti gli oggetti di cui si vuole proporre un a risoluzione di problemi
        //contiene i nomi dei file da cui prendere le scelte, gli stati e le adiacenze
        String s = "oggetti.txt";
        LetturaOggetti lo = new LetturaOggetti(s);
        oggetti = new ArrayList<>();
        oggetti = lo.lettura();
    }
    
    public void lettura() //Questo metodo va a leggere per l'Oggetto che è attributo di Progetto dai rispettivi file di testo
    { //tutte le domande relative, le scelte e le adiacenze alle domande usando le classi di lettura delle Scelte, Domande ed Adiacenze
        
        ArrayList<Scelta> scelte=null;
        ArrayList<Stato> stati=null;
        
        LetturaScelte letturaS=new LetturaScelte(oggetto.getFileScelte());
        scelte=letturaS.lettura();
        LetturaStati letturaD=new LetturaStati(oggetto.getFileStati());
        stati=letturaD.lettura(scelte);
        
        LetturaAdiacenze letturaA=new LetturaAdiacenze(oggetto.getFileAdiacenze());
        stati=letturaA.lettura(stati);
        
        oggetto.addStato(stati);
        //la domanda in posizione 0 cioè la prima nel file testo diventa la prima domanda da fare all'utente
        attuale = oggetto.getStati().get(0);
    }
    
    public void sceltaOggetto(int n)//metodo che consente all'utente di scegliere con quale oggetto vuole risolvere un problema tra quelli disponibili
    {
        if(n<oggetti.size())
        {
            oggetto = oggetti.get(n);
            lettura();
        }
        else
            System.out.println("Inserire un numero oggetto valido");
    }
    
    //metodo che consente all'utente di effettuare una scelta tra quelle possibili ad un determinato stato
    public void esecuzione(int n) throws IOException
    {       
        if(attuale.getScelte().isEmpty())
        {   //questo if controlla se la domanda attuale ha delle possibili scelte e quindi delle adiacenze
            //se non ne ha vuol dire che siamo arrivati ad una soluzione finale del programma
            //per uscire premere ancora invio
            System.in.read();
            System.exit(0);
        }
        else
        {
            //n indica la risposta data dall'utente, NON CONTIENE IL CODICE SCELTA MA LA POSIZIONE NELL'ARRAY
            Scelta s = attuale.getScelte().get(n);
            Tappa r = new Tappa(attuale, s);
            percorso.add(r);
            /*addRisposta(r); //metodo che viene usato per tenere memoria della risposta data all'interno dell'Array risposte (1)
            attuale = getDomanda(d, n);*/
            prossimoStato(n);
        }
    }
    
    //metodo che imposta lo stato successivo in base alla scelta effettuata allo stato attuale
    public void prossimoStato(int scelta)
    {   
        attuale=attuale.getProssimaAdiacenza(scelta);
    }
    
    //metodo che permette di cambiare scelta ad uno stato a cui si è già risposto
    public void cambioTappa(int posizione_tappa)
    {  
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n < attuale.getScelte().size()){
            Scelta s=attuale.getScelte().get(n);
            percorso.get(posizione_tappa).setScelta(s);
            pulisciPercorso();
        } 
    }
    
    //metodo che ripulisce tutte le informazioni tranne l'arraylist di oggetti
    //in modo da poter partire da capo a risolvere problemi di un altro oggetto
    //dopo aver chiamato questo metodo bisogna chiamare lettura per inizializzare un nuovo oggetto
    public void returnHome() //<3
    {
        attuale = null;
        oggetto = null;
        percorso.clear(); 
    }
    
    public void pulisciPercorso()//metodo che cancella le tappe successive a quella di cui si è cambiata scelta
    {
        int n=percorso.size();
        int i;
        int c=n;

        for(i=0;i<n;i++)//trova da che domanda in poi bisogna cancellare le risposte(compresa attuale)
        {
            if(attuale.getCodice().equals(percorso.get(i).getStato().getCodice()))
            {
                c=i;
                i=n++;
            }
        }

        for(;c<n;c++)//cancella le risposte sucessive(compresa attuale)
        {
            percorso.remove(c);
        }
    }
    
    //metodo che ritorna ad una domanda precedente a cui si è già risposto
    public void statoPrecedente(int i) {
        attuale = percorso.get(i).getStato();
    }
    
    //metodo che ritorna alla domanda precedente
    public void indietro() {
        statoPrecedente(percorso.size()-1);
    }
}
