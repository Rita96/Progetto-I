package lettura;

import elementi.Scelta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LetturaScelte extends Lettura
{

    public LetturaScelte(String nomeFile) {
        super(nomeFile);
    }
    
    public ArrayList<Scelta> lettura() throws FileNotFoundException, IOException
    {
        ArrayList<Scelta> scelte = new ArrayList<>();
        bufferedReaderInitialization();
        
        StringTokenizer st;
        String stringa = inputStream.readLine();

        while(stringa != null)
        {
            st = new StringTokenizer(stringa, "\t\n");
            while(st.hasMoreElements())
            {
                subLetturaScelte(st, scelte);
            }
            stringa = inputStream.readLine();
        }
        inputStream.close();
        return scelte;
    }
    
    public void subLetturaScelte(StringTokenizer st, ArrayList scelte)
    {
        String codice = st.nextToken();
        String testo = st.nextToken();

        Scelta s = new Scelta(codice, testo);
        scelte.add(s);
    }
}