
package grafica;


import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * ThreadGrafica è la classe che ci permette di creare 
 * diversi thread del nostro programma
 *
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 *
 */

public class ThreadGrafica extends Thread implements Runnable {

    @Override
    public void run(){
        try {
            Grafica interfaccia = new Grafica();
        } catch (IOException ex) {
            Logger.getLogger(ThreadGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
