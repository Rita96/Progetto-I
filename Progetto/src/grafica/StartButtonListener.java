package grafica;

import static grafica.Grafica.exe;
import static grafica.Grafica.p;
import static grafica.Grafica.hp;
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
        try 
        {
            int selezionato = elencoOggetti.getSelectedIndex();
            p.sceltaOggetto(selezionato);
            p.esecuzione(0);
            //ExecutePage ep = new ExecutePage();
            hp.dispose();
            hp.setVisible(false);
            exe.setVisible(true);
            exe.riempi();
        }
        catch (IOException ex)
        {
            Logger.getLogger(StartButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
