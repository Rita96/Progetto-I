package lettura;

import elementi.Scelta;
import elementi.Stato;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class LetturaStati extends Lettura
{

    public LetturaStati(String nomeFile) {
        super(nomeFile);
    }
    
    public ArrayList<Stato> lettura(ArrayList<Scelta> s) throws FileNotFoundException, IOException
    {
        ArrayList<Stato> domande = new ArrayList<>();
        
        super.bufferedReaderInitialization();
        
        ArrayList<String> codiceScelte = new ArrayList<>();
        StringTokenizer st;
        String stringa = inputStream.readLine();

        while(stringa != null)
        {
            st = new StringTokenizer(stringa, "\n\t");
            while(st.hasMoreTokens())
            {
                int num = st.countTokens();
                int n = 0;
                int i;
                int k;
                String codice = st.nextToken();
                String testo = st.nextToken();

                while(n < num - 2)
                {
                    String codS = st.nextToken();
                    codiceScelte.add(codS);
                    n++;
                }

                Stato d = new Stato(codice, testo);

                for(i = 0; i < codiceScelte.size(); i++) 
                {
                    for(k = 0; k < s.size(); k++)
                    {
                        Scelta tmp = s.get(k);

                        if(tmp.controllo(codiceScelte.get(i)))
                        {
                            d.addScelta(tmp);
                        }
                    }
                }
                codiceScelte.clear();
                domande.add(d);
            }
            stringa = inputStream.readLine();
        }
        inputStream.close();
        return domande;
    }
}