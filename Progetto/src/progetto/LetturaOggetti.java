package progetto;
import java.io.*;
import java.util.ArrayList;

public class LetturaOggetti 
{
    private String nomefile;
    private BufferedReader inputStream;
    
    public LetturaOggetti()
    {
        nomefile="Oggetti.txt";
        inputStream=null;
    }
    
    public ArrayList<Oggetto> lettura()
    {
        try
        {
            inputStream=new BufferedReader(new FileReader(nomefile));
        }
        catch(FileNotFoundException e)
        {
            System.exit(0);                    
        }
        
        try
        {
            String stringa=inputStream.readLine();
            while(stringa!=null)
            {
                
            }
            inputStream.close();
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        return null;
    }
    
}
