package lettura;

import elementi.Scelta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * LetturaScelte legge il file "ScelteOggetto.txt
 * prende un ArrayList di Scelte vuoto e inseriscse le 
 * scelte relative di quello stato
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 *
 */
public class LetturaScelte extends Lettura
{

    public LetturaScelte(String nomeFile) {
        super(nomeFile);
    }
    
    
    /**
     * Il metodo lettura() legge effettivamtente il file "ScelteOggetto.txt"
     * che richiama il metodo subLetturaScelte()
     * 
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
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
    
    
    /**
     * subLetturaScelte() prende quello che gli passa il metodo lettura()
     * e li scrive negli attributi di una scelta e poi aggiunge quella scelta ad un
     * ArrayList.
     * 
     * @param st
     * @param scelte
     */
    public void subLetturaScelte(StringTokenizer st, ArrayList scelte)
    {
        String codice = st.nextToken();
        String testo = st.nextToken();

        Scelta s = new Scelta(codice, testo);
        scelte.add(s);
    }
}