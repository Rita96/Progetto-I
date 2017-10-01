package grafica;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe ThreadGrafica permette di creare diversi thread del programma.
 *
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class ThreadGrafica extends Thread implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            Grafica interfaccia = new Grafica();
        }
        catch (IOException ex)
        {
            Logger.getLogger(ThreadGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
