package grafica;

import static grafica.Grafica.p;
import static grafica.RadioButtonListener.indice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class NextButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        try {
            p.esecuzione(indice);
            ExecutePage ep=new ExecutePage("Esecuzione");
            ep.setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch (IOException ex) {
            Logger.getLogger(NextButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cliccato bottone Next");
    }
}
