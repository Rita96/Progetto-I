package grafica;

import static grafica.Grafica.progetto;
import static grafica.Grafica.homePage;
import static grafica.Grafica.executePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        progetto.returnHome();
        homePage.setVisible(true);
        executePage.dispose();
        //executePage.dispose();
        //executePage.setVisible(false);
        //HomePage hp = new HomePage();
        //homePage = hp;
    }
}