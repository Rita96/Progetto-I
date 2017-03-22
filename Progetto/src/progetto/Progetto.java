package progetto;

import java.util.ArrayList;

public class Progetto 
{
    private Oggetto oggetto;
    private ArrayList<RispostaData> risposte;

    public Progetto(Oggetto oggetto)
    {
        this.oggetto=oggetto;
        risposte = new ArrayList();
    }

    public Oggetto getOggetto()
    {
        return oggetto;
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
    }
    
    public void addRisposta(RispostaData risposta) {
        risposte.add(risposta);
    }

    @Override
    public String toString()
    {
        String string=oggetto.toString();
        return string;
    }
    
}
