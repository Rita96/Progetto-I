package progetto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LetturaScelte
{
    private String nomeFile;
    private BufferedReader inputStream;
    
    public LetturaScelte(String nomeFile)
    {
        this.nomeFile=nomeFile;
        inputStream=null;
    }
    
    public ArrayList<Scelta> lettura()
    {
        ArrayList<Scelta> scelte=new ArrayList<>();
        
        try
        {
            inputStream=new BufferedReader(new FileReader(nomeFile));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Scelte non trovato");
            System.exit(0);                    
        }
        
        try
        {
            StringTokenizer st;
            String stringa=inputStream.readLine();
            while(stringa!=null)
            {
                st = new StringTokenizer(stringa, "\t\n");
                while(st.hasMoreElements())
                {
                    String cod=st.nextToken();
                    String text=st.nextToken();
                                        
                    Scelta s=new Scelta(cod,text);
                    scelte.add(s);
                }
                stringa=inputStream.readLine();
            }
            inputStream.close();
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        return scelte;
    }
  
}
