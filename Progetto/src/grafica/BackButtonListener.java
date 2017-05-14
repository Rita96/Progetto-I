package grafica;

import static grafica.Grafica.p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class BackButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        p.indietro();
        ExecutePage ep = new ExecutePage();
        ep.setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println("Cliccato bottone back");
    }
}
