package graficaListener;

import static grafica.Grafica.executePage;
import static grafica.Grafica.progetto;
import static graficaListener.RadioButtonListener.indice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonListener implements ActionListener
{
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
