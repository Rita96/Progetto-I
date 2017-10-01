package graficaListener;

import grafica.ThreadGrafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe StartHomeButtonListener permette di avviare più di un Risolutore
 * alla volta permettendo di utilizzarli contemporaneamente e indipendentemente.
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class StartHomeButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        ThreadGrafica thread = new ThreadGrafica();
        thread.start();
    }
}
