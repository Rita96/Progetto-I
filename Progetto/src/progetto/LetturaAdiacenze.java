package progetto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class LetturaAdiacenze 
{

    private String nomeFile;
    private BufferedReader inputStream;

    public LetturaAdiacenze(String nomeFile) 
    {
        this.nomeFile = nomeFile;
        inputStream = null;
    }

    public ArrayList<Stato> lettura(ArrayList<Stato> stati)
    {
        ArrayList<Stato> adiacenze = new ArrayList<>();

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
            ArrayList<String> codici = new ArrayList<>();
            StringTokenizer st;
            String stringa = inputStream.readLine();
            
            while (stringa != null) 
            {
                st = new StringTokenizer(stringa, "\t\n");
                while (st.hasMoreElements()) 
                {
                    int n = 0;
                    int nTokens = st.countTokens();
                    String codice = st.nextToken();
                    
                    while (n < nTokens - 1)
                    {
                        String line = st.nextToken();
                        codici.add(line);
                        n++;
                    }

                    for (String c : codici) {
                        for (Stato d : stati) { 
                            if (d.controllo(c)) {
                                adiacenze.add(d);
                            }
                        }
                    }

                    for (Stato d : stati)
                    {
                        if (d.controllo(codice))
                        {
                            d.addAdiacenze(adiacenze);
                            
                        }
                    }
                    codici.clear();
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
        return stati;
    }
}
