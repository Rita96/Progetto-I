package progetto;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
        ArrayList<Oggetto> Oggetti=new ArrayList<>();
        
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
                    String nome=st.nextToken();
                    String attributo=st.nextToken();
                    String fileDomande=st.nextToken();
                    String fileScelte=st.nextToken();
                    String fileAdiacenze=st.nextToken();
                    
                    Oggetto O=new Oggetto(nome,attributo,fileDomande,fileScelte,fileAdiacenze);
                    Oggetti.add(O);
                }
                stringa=inputStream.readLine();
            }
            inputStream.close();
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        return Oggetti;
    }
    
}
