package graficaListener;

import esecuzione.Struttura;
import grafica.ExecutePage;
import static graficaListener.RadioButtonListener.indice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe NextButtonListener permette di proseguire nell'esecuzione dopo aver
 * selezionato una risposta.
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class NextButtonListener implements ActionListener
{
    private ExecutePage executePage;
    private Struttura progetto;
    
    public NextButtonListener(Struttura progetto, ExecutePage executePage)
    {
        super();
        this.executePage = executePage;
        this.progetto = progetto;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {   
        if(indice != -1 && !progetto.scelteDomandaAttualeEmpty())
        {
            progetto.esecuzioneProgetto(indice);
            executePage.clearFrame();
            executePage.refreshFrame();
        }
    }
}
