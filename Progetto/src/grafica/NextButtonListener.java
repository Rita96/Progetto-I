package grafica;

import static grafica.Grafica.executePage;
import static grafica.Grafica.homePage;
import static grafica.Grafica.progetto;
import static grafica.RadioButtonListener.indice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonListener implements ActionListener
{
    static boolean ultimoStato;
    
    public NextButtonListener()
    {
        super();
        ultimoStato=false;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {   
        if(indice != -1 && !progetto.getAttuale().getScelte().isEmpty())
        {
            progetto.esecuzione(indice);
            //executePage.dispose();
            //ExecutePage ep = new ExecutePage();
            //executePage = ep;
            executePage.removeExecuteComponents();
            executePage.getExecuteComponents();
        }
        
        if(ultimoStato==true)
        {
            executePage.dispose();
            homePage.setVisible(true);
        }
        if(progetto.getAttuale().getScelte().isEmpty())
        {
            ultimoStato=true;
        }
        //else {
        //    progetto.esecuzione(indice);
        //    executePage.dispose();
        //    System.exit(0);
        //}
    }
}
