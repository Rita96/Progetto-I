package graficaListener;


import esecuzione.Struttura;
import grafica.ExecutePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener
{
    private Struttura progetto;
    private ExecutePage executePage;
    public BackButtonListener(Struttura progetto, ExecutePage executePage){
        super();
        this.progetto = progetto;
        this.executePage = executePage;
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        executePage.clearFrame();
        progetto.back();
        executePage.refreshFrame();
    }
}
