package lettura;

import elementi.Stato;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * La classe LetturaAdiacenze legge il file "AdiacenzeOggetto.txt"
 * e per ogni stato di un oggetto restituisce le adiacenze,
 * ossia i possibili stati successivi.
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class LetturaAdiacenze extends Lettura 
{
    public LetturaAdiacenze(String nomeFile)
    {
        super(nomeFile);
    }
    
    /**
     * Si passa un ArrayList di stati senza adiacenze
     * e restituisce lo stesso ArrayList con le adiacenze per ogni stato.
     * 
     * @param stati
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ArrayList<Stato> lettura(ArrayList<Stato> stati) throws FileNotFoundException, IOException
    {
        ArrayList<Stato> adiacenze = new ArrayList<>();

        super.bufferedReaderInitialization();

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
                
                for (String c : codici)
                {
                    for (Stato d : stati)
                    { 
                        if (d.controllo(c))
                        {
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
        return stati;
    }
}