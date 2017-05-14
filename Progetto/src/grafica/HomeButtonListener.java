package grafica;

import static grafica.Grafica.p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        p.returnHome();
        HomePage hp = new HomePage();
        
        System.out.println("Cliccato bottone home");
    }
}
