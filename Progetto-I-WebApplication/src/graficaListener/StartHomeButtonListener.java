package graficaListener;

import grafica.ThreadGrafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DaniTava
 */
public class StartHomeButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        ThreadGrafica thread = new ThreadGrafica();
        thread.start();
    }
    
}
