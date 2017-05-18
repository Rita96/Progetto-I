package grafica;

import static grafica.Grafica.executePage;
import static grafica.Grafica.progetto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        progetto.indietro();
        executePage.dispose();
        ExecutePage ep = new ExecutePage();
        executePage = ep;
    }
}
