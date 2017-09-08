package graficaListener;

import esecuzione.Struttura;
import grafica.ExecutePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

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