package lettura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * La classe Lettura è la superclasse per le classi di lettura da file.
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class Lettura
{    
    String nomeFile;
    BufferedReader inputStream;

    public Lettura(String nomeFile) 
    {
        this.nomeFile = nomeFile;
        inputStream = null;
    }
    
    public BufferedReader bufferedReaderInitialization() throws FileNotFoundException
    {
        inputStream = new BufferedReader(new FileReader(nomeFile));
        return inputStream;
    }
}