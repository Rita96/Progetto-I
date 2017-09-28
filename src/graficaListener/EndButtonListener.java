package graficaListener;

import esecuzione.Struttura;
import grafica.ExecutePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

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
    /*
    @Override
    public void actionPerformed(ActionEvent e)
    {
        executePage.dispose();
        progetto.clearPercorso();
        homePage.setVisible(true);
    }
    */
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        executePage.dispose();
        progetto.clearPercorso();
        homePage.dispose();
    }
}
