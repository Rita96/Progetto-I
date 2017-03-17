package progetto;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LetturaDomande
{
    private String nomefile;
    private BufferedReader inputStream;
    
    public LetturaDomande(String fileDomande)
    {
        nomefile=fileDomande;
        inputStream=null;
    }
    
    public ArrayList<Domanda> lettura(ArrayList<Scelta> s)
    {
        ArrayList<Domanda> Domande=new ArrayList<>();
        
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
                st = new StringTokenizer(stringa, "\t");
                while(st.hasMoreElements())
                {
                    int num=st.countTokens();
                    //System.out.println("Conteggio: "+num);
                    int n=0;
                    int i;
                    int k;
                    String cod=st.nextToken();
                    String text=st.nextToken();
                    while(n<num-2)
                    {
                        String codS=st.nextToken();
                        codScelte.add(codS);
                        //System.out.println(codS);
                        n++;
                    }
                    Domanda D=new Domanda(cod,text);
                    
                    
                    
                    /*
                    for(i=0;i<codScelte.size();i++) 
                    {
                        for(k=0;k<s.size();k++)
                        {
                            if(s.get(k).controllo(codScelte.get(i))==true)
                                D.addScelta(s.get(k));
                        }
                    }
                    codScelte.clear();*/
                    Domande.add(D);
                }
                
                
                stringa=inputStream.readLine();
            }
            inputStream.close();
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        return Domande;
    }
    
}
