package graficaListener;

import esecuzione.Struttura;
import grafica.ExecutePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * La classe StartButtonListener permette di avviare Risolutore di Problemi
 * una volta selezionato l'oggetto difettoso.
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class StartButtonListener implements ActionListener
{
    private JFrame executePage;
    private Struttura progetto;
    private JFrame homePage;
    private JComboBox elencoOggetti;
    
    public StartButtonListener(JFrame homePage, Struttura progetto, JComboBox elencoOggetti)
    {
        this.homePage = homePage;
        this.progetto = progetto;
        this.elencoOggetti = elencoOggetti;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        int selezionato = elencoOggetti.getSelectedIndex();
        
        try
        {
            progetto.selezionaOggetto(selezionato);
        }
        catch (IOException ex)
        {
            Logger.getLogger(StartButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        executePage = new ExecutePage(progetto, homePage);
        homePage.dispose();
    }
}
