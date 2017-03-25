package progetto;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class Progetto
{
    private Domanda attuale;
    private Oggetto oggetto;
    private ArrayList<Risposta> risposte;

    public Progetto(String s, int n)
    {
        LetturaOggetti lo = new LetturaOggetti(s);
        ArrayList<Oggetto> oggetti = new ArrayList<>();
        oggetti = lo.lettura();
        oggetto = oggetti.get(n);
        
        risposte = new ArrayList();
        attuale = null;
    }
    
    public void lettura()
    {
        
        ArrayList<Scelta> scelte=null;
        ArrayList<Domanda> domande=null;
        
        LetturaScelte letturaS=new LetturaScelte(oggetto.getFileScelte());
        scelte=letturaS.lettura();
        LetturaDomande letturaD=new LetturaDomande(oggetto.getFileDomande());
        domande=letturaD.lettura(scelte);
        
        LetturaAdiacenze letturaA=new LetturaAdiacenze(oggetto.getFileAdiacenze());
        domande=letturaA.lettura(domande);
        
        oggetto.addDomande(domande);
        attuale = oggetto.getDomande().get(0);
    }
    
    public void poniDomanda()
    {
        System.out.println(attuale);
        scelta(attuale);
    }
    
    public void scelta(Domanda d)
    {
        if(d.getScelte().isEmpty())
        {
            System.out.println("FINE");
            exit(0);
        }
        else
        {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            if(n < d.getScelte().size())
            {
                Scelta s = d.getScelte().get(n);
                Risposta r = new Risposta(d, s);
                addRisposta(r);
                attuale = getDomanda(d, n);
            }
            else
            {
                System.out.println("Inserire un numero valido");
                exit(0);
            }
        }
    }
    
    public void addRisposta(Risposta risposta)
    {
        risposte.add(risposta);
    }
    
    public Domanda getDomanda(Domanda d, int n)
    {
        if(n < d.getAdiacenze().size())
        {
            return d.getAdiacenze().get(n);
        }
        else
        {
            exit(0);
        }
        return null;
    }
    
    public Risposta getRisposta(int i)
    {
        return risposte.get(i);
    }
    
    public void cambioRisposta(int i)
    {
        
    }

    @Override
    public String toString()
    {
        return oggetto.toString();
    }

    public Domanda getAttuale() {
        return attuale;
    }

    public ArrayList<Risposta> getRisposte() {
        return risposte;
    }
}
