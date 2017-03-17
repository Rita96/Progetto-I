package progetto;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetturaListaAdiacenza 
{
    private String nomefile;
    private File file;
    
    public LetturaListaAdiacenza(String nome)
    {
        nomefile=nome;
        file=new File(nome);;
    }
    
    public Map lettura(ArrayList<Stato> lista)
    {
        Map adiacenza=new HashMap<Stato,ArrayList<Stato>>();
        
        int i,k;
        Scanner in=null;
        
        try
        {
            in=new Scanner(file);
            in.useDelimiter("\n|\t");
        }
        catch(FileNotFoundException e)
        {
            System.exit(0);
        }
        
        while(in.hasNextLine() && in.hasNext())
        {
            //Manca tutto il codice, sono le due, io ho sonno, lavorate un po' voi, cani.
            
            
        }
        return adiacenza;
    }
    
}
