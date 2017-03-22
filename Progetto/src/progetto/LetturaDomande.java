package progetto;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetturaDomande
{
    private String nomeFile;
    private BufferedReader inputStream;
    
    public LetturaDomande(String nomeFile)
    {
        this.nomeFile=nomeFile;
        inputStream=null;
    }
    
    public ArrayList<Domanda> lettura(ArrayList<Scelta> s)
    {
        ArrayList<Domanda> domande=new ArrayList<>();
        
        try
        {
            inputStream=new BufferedReader(new FileReader(nomeFile));
        }
        catch(FileNotFoundException e)
        {
            System.exit(0);                    
        }
        
        try
        {
            ArrayList<String> codScelte=new ArrayList<>();
            StringTokenizer st;
            String stringa=inputStream.readLine();
            while(stringa!=null)
            {
                st = new StringTokenizer(stringa, "\n\t");
                while(st.hasMoreElements())
                {
                    int num=st.countTokens();
                    int n=0;
                    int i;
                    int k;
                    String cod=st.nextToken();
                    String text=st.nextToken();
                    
                    while(n<num-2)
                    {
                        String codS=st.nextToken();
                        codScelte.add(codS);
                        n++;
                    }
                    
                    Domanda d=new Domanda(cod,text);
                    
                    for(i=0;i<codScelte.size();i++) 
                    {
                        for(k=0;k<s.size();k++)
                        {
                            if(s.get(k).controllo(codScelte.get(i))==true)
                            {
                                d.addScelta(s.get(k));
                            }
                        }
                    }
                    codScelte.clear();
                    domande.add(d);
                }
                
                stringa=inputStream.readLine();
            }
            inputStream.close();
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        
        return domande;
    }
    
}
