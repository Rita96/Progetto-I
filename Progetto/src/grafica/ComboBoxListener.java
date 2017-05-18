package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static grafica.HomePage.elencoAttributi;

public class ComboBoxListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        elencoAttributi.setEnabled(true);
    }
    
}
