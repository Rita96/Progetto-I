package graficaListener;

import esecuzione.Struttura;
import grafica.ExecutePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * EndButtonListener serve per terminare il programma e tornare alla HomePage
 * e si usa solo al termine del risolutore
 * 
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 *
 */
public class EndButtonListener implements ActionListener
{
    private ExecutePage executePage;
    private Struttura progetto;   
    private JFrame homePage;
     
    public EndButtonListener (ExecutePage executePage, Struttura progetto, JFrame homePage ){
        super();
        this.executePage = executePage;
        this.homePage = homePage;
        this.progetto = progetto;
        
    }
  
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        executePage.dispose();
        progetto.clearPercorso();
        homePage.dispose();
    }
}
