package progetto;

import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class Progetto
{   //l'attributo Domanda attuale indica la domanda che viene posta al momento all'utente
    private Stato attuale;
    private Oggetto oggetto;
    //l'attributo ArrayList Riposta risposte salva il percorso fatto dall'utente man mano che risponde alle domande
    private ArrayList<Tappa> percorso;
    private ArrayList<Oggetto> oggetti;

    public Progetto()
    {
        percorso = new ArrayList();
        oggetti=new ArrayList();
    }
    
    public void sceltaOggetto()
    {
        String s = "lavatrice/oggetto.txt";
        
        LetturaOggetti lo = new LetturaOggetti(s);
        ArrayList<Oggetto> oggetti = new ArrayList<>();
        oggetti = lo.lettura();
        int n;
        do
        {
            System.out.println("Inserire numero oggetto difettoso 0,1, ...");
            Scanner inputN = new Scanner(System.in);
            n = inputN.nextInt();
            if(n<oggetti.size())
            {
                oggetto = oggetti.get(n);
            }
            else
                System.out.println("Inserire un numero oggetto valido");
        }
        while(n>oggetti.size()-1);
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
    
    public void stampaStato()//TEXT
    {
        System.out.println(attuale.getTesto());
        System.out.println();
        attuale.mostraScelte();
    }
    
    public void esecuzione() throws IOException
    {   //questo metodo viene usato per rispondere alle varie domande e proseguire nel percorso fino ad arrivare
        //alla soluzione finale
        if(attuale.getScelte().isEmpty())
        {   //questo if controlla se la domanda attuale ha delle possibili scelte e quindi delle adiacenze
            //se non ne ha vuol dire che siamo arrivati ad una soluzione finale del programma
            //per uscire premere ancora invio
            stampaStato();
            System.in.read();
            System.exit(0);
        }
        else
        {   //l'utilizzo dello scanner è per fare test il programma finale userà la grafica
            stampaStato();
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            if(n < attuale.getScelte().size())    //controllo sulle Scelte
            {   //n indica la risposta data dall'utente, NON CONTIENE IL CODICE SCELTA MA LA POSIZIONE NELL'ARRAY
                Scelta s = attuale.getScelte().get(n);
                Tappa r = new Tappa(attuale, s);
                percorso.add(r);
                /*addRisposta(r); //metodo che viene usato per tenere memoria della risposta data all'interno dell'Array risposte (1)
                attuale = getDomanda(d, n);*/
                prossimoStato(n);
            }
            else
            {
                System.out.println("Inserire un numero valido");
            }
        }
    }
    
    public void prossimoStato(int scelta)
    {   
        attuale=attuale.getProssimaAdiacenza(scelta);
    }
    
    public Tappa getRisposta(int i)
    {
        return percorso.get(i);
    }
    
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
    
    public void pulisciPercorso()
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
        if(i<percorso.size()-1)
            System.out.println("Valore inatteso");
        else
        {
            attuale = percorso.get(i).getStato();
            System.out.println(attuale.getTesto());
            System.out.println(percorso.get(i).getScelta());
        }
    }
    
    //metodo che ritorna alla domanda precedente
    public void indietro() {
        try {
            if(percorso.size() > 0) {
                statoPrecedente(percorso.size()-1);
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            //da decidere e implementare
        }
    }
    
}
