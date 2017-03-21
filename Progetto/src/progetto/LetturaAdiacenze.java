package progetto;

import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;

public class LetturaAdiacenze
{
    private String nomefile;
    private BufferedReader inputStream;
    
    public LetturaAdiacenze(String fileAdiacenze)
    {
        nomefile=fileAdiacenze;
        inputStream=null;
    }
    
    public void lettura(ArrayList<Domanda> d)
    {
        ArrayList<Domanda> adiacenze=new ArrayList<>();
        
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
            ArrayList<String> codScelte=new ArrayList<>();
            StringTokenizer st;
            String stringa=inputStream.readLine();
            while(stringa!=null)
            {
                st = new StringTokenizer(stringa, "\t\n");
                while(st.hasMoreElements())
                {
                    
                    int num=st.countTokens();
                    int n=0;
                    int i;
                    int k;
                    String cod=st.nextToken();
                    while(n<num-1)
                    {
                        String codS=st.nextToken();
                        codScelte.add(codS);
                        n++;
                    }
                    
                    for(i=0;i<codScelte.size();i++) 
                    {
                        for(k=0;k<d.size();k++)
                        {
                            if(d.get(k).controllo(codScelte.get(i))==true)
                            {
                                adiacenze.add(d.get(k));
                            }
                        }
                    }
                    
                    for(Domanda dom:d)
                    {
                        if(dom.getCodD().equals(cod)){
                            dom.addAdiacenze(adiacenze);
                        }
                    }
                    codScelte.clear();
                    adiacenze.clear();
                    
                }
                stringa=inputStream.readLine();
            }
            inputStream.close();
        }
        catch(IOException e)
        {
            System.exit(0);
        }
    }
}
