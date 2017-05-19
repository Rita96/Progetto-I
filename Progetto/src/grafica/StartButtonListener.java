package grafica;

import static grafica.Grafica.executePage;
import static grafica.Grafica.progetto;
import static grafica.Grafica.homePage;
import static grafica.HomePage.elencoOggetti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        int selezionato = elencoOggetti.getSelectedIndex();
        progetto.sceltaOggetto(selezionato);
        progetto.esecuzione(0);
        
        executePage = new ExecutePage();
        
        homePage.dispose();
        homePage.setVisible(false);
    }
}
