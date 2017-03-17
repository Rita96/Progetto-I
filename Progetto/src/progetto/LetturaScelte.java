package progetto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LetturaScelte 
{
    private String nomefile;
    private BufferedReader inputStream;
    
    public LetturaScelte(String fileScelte)
    {
        nomefile=fileScelte;
        inputStream=null;
    }
    
    public ArrayList<Scelta> lettura()
    {
        ArrayList<Scelta> Scelte=new ArrayList<>();
        
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
            StringTokenizer st;
            String stringa=inputStream.readLine();
            while(stringa!=null)
            {
                st = new StringTokenizer(stringa, "\t\n");
                while(st.hasMoreElements())
                {
                    String cod=st.nextToken();
                    String text=st.nextToken();
                                        
                    Scelta S=new Scelta(cod,text);
                    Scelte.add(S);
                }
                stringa=inputStream.readLine();
            }
            inputStream.close();
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        return Scelte;
    }
  
}
