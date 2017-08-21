package lettura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Lettura {
    
    String nomeFile;
    BufferedReader inputStream;

    public Lettura(String nomeFile) 
    {
        this.nomeFile = nomeFile;
        inputStream = null;
    }
    
    public BufferedReader bufferedReaderInitialization()
    {
        try
        {
            inputStream = new BufferedReader(new FileReader(nomeFile));
            return inputStream;
        }
        catch(FileNotFoundException e)
        {
            System.exit(0);
        }
        return null;
    }
    
}
