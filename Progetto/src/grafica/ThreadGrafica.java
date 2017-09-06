
package grafica;

/**
 *
 * @author Gabriele Guazzardi
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadGrafica implements Runnable{

    @Override
    public void run(){
        try {
            Grafica interfaccia = new Grafica();
        } catch (IOException ex) {
            Logger.getLogger(ThreadGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
