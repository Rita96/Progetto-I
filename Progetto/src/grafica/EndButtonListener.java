package grafica;

import static grafica.Grafica.executePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndButtonListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        executePage.dispose();
    }
}
