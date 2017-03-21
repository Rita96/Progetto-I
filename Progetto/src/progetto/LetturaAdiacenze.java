package progetto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
//c

public class LetturaAdiacenze 
{

    private String nomeFile;
    private BufferedReader inputStream;

    public LetturaAdiacenze(String fileAdiacenze) 
    {
        nomeFile = fileAdiacenze;
        inputStream = null;
    }

    public void lettura(ArrayList<Domanda> d)
    {
        ArrayList<Domanda> adiacenze = new ArrayList<>();

        try
        {
            inputStream = new BufferedReader(new FileReader(nomeFile));
        }
        catch (FileNotFoundException e)
        {
            System.exit(0);
        }

        try
        {
            ArrayList<String> codAdiacenze = new ArrayList<>();
            StringTokenizer st;
            String stringa = inputStream.readLine();
            
            while (stringa != null) 
            {
                st = new StringTokenizer(stringa, "\t\n");
                while (st.hasMoreElements()) 
                {
                    int num = st.countTokens();
                    int n = 0;
                    int i;
                    int k;
                    String cod = st.nextToken();
                    
                    while (n < num - 1)
                    {
                        String codA = st.nextToken();
                        codAdiacenze.add(codA);
                        n++;
                    }

                    for (i = 0; i < codAdiacenze.size(); i++) 
                    {
                        for (k = 0; k < d.size(); k++)
                        {
                            if (d.get(k).controllo(codAdiacenze.get(i)) == true)
                            {
                                adiacenze.add(d.get(k));
                            }
                        }
                    }

                    for (Domanda dom : d)//for(i=0;i<d.size();i++)
                    {
                        if (dom.controllo(cod) == true)
                        {
                            dom.addAdiacenze(adiacenze);
                        }
                    }
                    codAdiacenze.clear();
                    adiacenze.clear();
                }
                stringa = inputStream.readLine();
            }
            inputStream.close();
        }
        catch (IOException e)
        {
            System.exit(0);
        }
    }
}
