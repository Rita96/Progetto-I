package graficaListener;

import static grafica.Grafica.executePage;
import static grafica.Grafica.progetto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        executePage.clearFrame();
        progetto.back();
        executePage.refreshFrame();
    }
}
