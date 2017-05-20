package grafica;

import static grafica.Grafica.executePage;
import static grafica.Grafica.progetto;
import static grafica.RadioButtonListener.indice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {   
        if(indice != -1 && !progetto.getDomandaAttuale().getScelte().isEmpty())
        {
            progetto.esecuzioneProgetto(indice);
            executePage.clearFrame();
            executePage.refreshFrame();
        }
    }
}
