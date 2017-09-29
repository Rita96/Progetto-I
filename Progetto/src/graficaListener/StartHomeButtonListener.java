package graficaListener;

import grafica.ThreadGrafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Consente di avviare più di un risolutore alla volta
 * permettendo di usarli in modo contemporaneo
 *
 *
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class StartHomeButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        ThreadGrafica thread = new ThreadGrafica();
        thread.start();
    }
    
}
