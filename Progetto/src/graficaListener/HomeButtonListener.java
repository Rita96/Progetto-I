package graficaListener;

import esecuzione.Struttura;
import grafica.ExecutePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * HomeButtonListener serve per tornare alla HomePage (pulendo il percorso) 
 * in qualsiasi punto del programma
 * 
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 *
 */
public class HomeButtonListener implements ActionListener
{
    private ExecutePage executePage;
    private Struttura progetto;
    private JFrame homePage;
    public HomeButtonListener(ExecutePage executePage, Struttura progetto, JFrame homePage){
        super();
        this.executePage = executePage;
        this.homePage = homePage;
        this.progetto = progetto;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        progetto.returnHome();
        homePage.setVisible(true);
        executePage.dispose();
        
    }
}