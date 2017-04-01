package progetto;

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

    public Progetto(Oggetto o)
    {
        risposte = new ArrayList();
        oggetti=new ArrayList();
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
    
    public void scelta(Domanda d)
    {   //questo metodo viene usato per rispondere alle varie domande e proseguire nel percorso fino ad arrivare
        //alla soluzione finale
        if(d.getScelte().isEmpty())
        {   //questo if controlla se la domanda attuale ha delle possibili scelte e quindi delle adiacenze
            //se non ne ha vuol dire che siamo arrivati ad una risoluzione del problema ed esce dal programma
            System.out.println("FINE");
            System.exit(0);
        }
        else
        {   //l'utilizzo dello scanner è per fare test il programma finale userà la grafica
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            if(n < d.getScelte().size())    //controllo sulle Scelte
            {   //n indica la risposta data dall'utente, NON CONTIENE IL CODICE SCELTA MA LA POSIZIONE NELL'ARRAY
                Scelta s = d.getScelte().get(n);
                Risposta r = new Risposta(d, s);
                /*addRisposta(r); //metodo che viene usato per tenere memoria della risposta data all'interno dell'Array risposte (1)
                attuale = getDomanda(d, n);*/
            }
            else
            {
                System.out.println("Inserire un numero valido");
                exit(0);
            }
        }
    }
    
    public Domanda prossimaDomanda(int scelta)
    {   
        return attuale.getProssimaAdiacenza(scelta);
    }
    
    public Risposta getRisposta(int i)
    {
        return risposte.get(i);
    }
    
    public void cambioRisposta(int i)
    {   //metodo ancora da implementare
        
    }
}
