package grafica;

import static grafica.Grafica.p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HomeButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        p.returnHome();
        HomePage hp=new HomePage("Home");
        hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println("Cliccato bottone home");
    }
}
