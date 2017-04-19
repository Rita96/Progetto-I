package progetto;

import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class Progetto
{   //l'attributo Domanda attuale indica la domanda che viene posta al momento all'utente
    private Domanda attuale;
    private Oggetto oggetto;
    //l'attributo ArrayList Riposta risposte salva il percorso fatto dall'utente man mano che risponde alle domande
    private ArrayList<Risposta> risposte;
    private ArrayList<Oggetto> oggetti;

    public Progetto()
    {
        risposte = new ArrayList();
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
        ArrayList<Domanda> domande=null;
        
        LetturaScelte letturaS=new LetturaScelte(oggetto.getFileScelte());
        scelte=letturaS.lettura();
        LetturaDomande letturaD=new LetturaDomande(oggetto.getFileDomande());
        domande=letturaD.lettura(scelte);
        
        LetturaAdiacenze letturaA=new LetturaAdiacenze(oggetto.getFileAdiacenze());
        domande=letturaA.lettura(domande);
        
        oggetto.addDomande(domande);
        //la domanda in posizione 0 cioè la prima nel file testo diventa la prima domanda da fare all'utente
        attuale = oggetto.getDomande().get(0);
    }
    
    public void poniDomanda()//TEXT
    {
        System.out.println(attuale.getTesto());
        System.out.println();
        attuale.mostraScelte();
    }
    
    public void scelta() throws IOException
    {   //questo metodo viene usato per rispondere alle varie domande e proseguire nel percorso fino ad arrivare
        //alla soluzione finale
        if(attuale.getScelte().isEmpty())
        {   //questo if controlla se la domanda attuale ha delle possibili scelte e quindi delle adiacenze
            //se non ne ha vuol dire che siamo arrivati ad una soluzione finale del programma
            //per uscire premere ancora invio
            poniDomanda();
            System.in.read();
            System.exit(0);
        }
        else
        {   //l'utilizzo dello scanner è per fare test il programma finale userà la grafica
            poniDomanda();
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            if(n < attuale.getScelte().size())    //controllo sulle Scelte
            {   //n indica la risposta data dall'utente, NON CONTIENE IL CODICE SCELTA MA LA POSIZIONE NELL'ARRAY
                Scelta s = attuale.getScelte().get(n);
                Risposta r = new Risposta(attuale, s);
                /*addRisposta(r); //metodo che viene usato per tenere memoria della risposta data all'interno dell'Array risposte (1)
                attuale = getDomanda(d, n);*/
                prossimaDomanda(n);
            }
            else
            {
                System.out.println("Inserire un numero valido");
                exit(0);
            }
        }
    }
    
    public void prossimaDomanda(int scelta)
    {   
        attuale=attuale.getProssimaAdiacenza(scelta);
    }
    
    public Risposta getRisposta(int i)
    {
        return risposte.get(i);
    }
    
    public void cambioRisposta(int i)
    {   //metodo ancora da implementare
        
    }
    
    //metodo che ripulisce tutte le informazioni tranne l'arraylist di oggetti
    //in modo da poter partire da capo a risolvere problemi di un altro oggetto
    //dopo aver chiamato questo metodo bisogna chiamare lettura per inizializzare un nuovo oggetto
    public void returnHome()
    {
        attuale = null;
        oggetto = null;
        risposte.clear();
    }
    
    public void ClearRoute(boolean b)//il booleano indica se c'è stato un cambiamento nelle risposte date in precedenza
    {
        if(b==true)
        {
            int n=risposte.size();
            int i;
            int c=n;
        
            for(i=0;i<n;i++)//trova da che domanda in poi bisogna cancellare le risposte(compresa attuale)
            {
                if(attuale.getCodice().equals(risposte.get(i).getDomanda().getCodice()))
                {
                    c=i;
                    i=n++;
                }
            }
            
            for(;c<n;c++)//cancella le risposte sucessive(compresa attuale)
            {
                risposte.remove(c);
            }
        }
    }
}
