package graficaListener;

import grafica.ExecutePage;
import static grafica.Grafica.executePage;
import static grafica.Grafica.progetto;
import static grafica.Grafica.homePage;
import static grafica.HomePage.elencoOggetti;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        int selezionato = elencoOggetti.getSelectedIndex();
        try {
            progetto.selezionaOggetto(selezionato);
        } catch (IOException ex) {
            Logger.getLogger(StartButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        executePage = new ExecutePage();
        
        homePage.dispose();
    }
}
