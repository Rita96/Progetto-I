package graficaListener;

import static grafica.ExecutePage.percorso;
import static grafica.Grafica.executePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static grafica.Grafica.progetto;

public class ComboBoxListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int selezionata = percorso.getSelectedIndex();
        progetto.statoPrecedente(selezionata);
        executePage.clearFrame();
        executePage.refreshFrame();
    }
    
}
