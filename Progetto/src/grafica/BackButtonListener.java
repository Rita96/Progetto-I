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
        executePage.removeExecuteComponents();
        progetto.indietro();
        executePage.getExecuteComponents();
        //executePage.dispose();
        //ExecutePage ep = new ExecutePage();
        //executePage = ep;
    }
}
