package esecuzione;

import elementi.Oggetto;
import elementi.Tappa;
import java.io.IOException;

public class EsecuzioneTest {
    private Struttura p;
    private boolean controllo;
    
    public EsecuzioneTest()
    {
        this.p = new Struttura();
    }
    
    public void esecuzione(int scelteMenu[], int scelte[]) throws IOException
    {
        p.letturaOggetti();
        int i = 0;
        controllo = true;
        
        while(controllo)
        {            
            switch(scelteMenu[i])
            {
                case 1:
                {
                    esecuzioneRisolutore(scelte[i]);
                    break;
                }
                case 2:
                {
                    mostraTappaPrecedente(scelte[i]);
                    break;
                }
                case 3:
                {
                    modificaTappaPrecedente(scelte[i]);
                    break;
                }
                case 4:
                {
                    p.returnHome();
                    break;
                }
                case 5:
                {
                    controllo = false;
                    break;
                }
                default:
                {
                    break;
                }
            }
            i++;
        }
    }
    
    public void esecuzioneRisolutore(int n) throws IOException
    {
        if(p.getOggettoSelezionato()!= null)
        {
            if(p.adiacenzeDomandaAttualeEmpty())
            {
                controllo = false;
            }

            if(n < p.scelteDomandaAttualeSize())
            {
                p.esecuzione(n);
            }
        }
        else {
            if(n < p.elencoOggettiSize())
            {
                p.sceltaOggetto(n);
            }
        }
    }
    
    public void mostraTappaPrecedente(int n)
    {
        if(p.percorsoSize() > 0)
        {
            if(n < p.percorsoSize())
            {
                //return Tappa precedente
            }
        }
    }
    
    public void modificaTappaPrecedente(int n)
    {
        if(p.percorsoSize() > 0)
        {
            if(n < p.percorsoSize())
            {
                p.statoPrecedente(n);
            }
        }
    }
    
    public Object[] getPercorsoArray()
    {
        return p.percorsoArray();
    }
    
    public Oggetto getOggettoSelezionato()
    {
        return p.getOggettoSelezionato();
    }
    
    public Tappa getTappa(int a, int b)
    {
        return p.getTappa(a, b);
    }
}
