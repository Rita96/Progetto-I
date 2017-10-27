package lettura;

import elementi.Oggetto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static esecuzione.Struttura.percorsoFile;

/**
 * La classe LetturaOggetti legge il file "Oggetti.txt" così che le altre classi
 * di lettura sappiano dove trovare i vari file da leggere.
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class LetturaOggetti extends Lettura
{
    public LetturaOggetti(String nomeFile)
    {
        super(nomeFile);
    }
    
    /**
     * Il metodo lettura() legge effettivamtente il file "Oggetti.txt"
     * che richiama il metodo subLetturaOggetti()
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ArrayList<Oggetto> lettura() throws FileNotFoundException, IOException
    {
        ArrayList<Oggetto> oggetti = new ArrayList<>();
        
        super.bufferedReaderInitialization();
        
        StringTokenizer st;
        String stringa = inputStream.readLine();

        while(stringa != null)
        {
            st = new StringTokenizer(stringa, "\t\n");
            
            while(st.hasMoreTokens())
            {
                subLetturaOggetti(st, oggetti);
            }
            
            stringa = inputStream.readLine();
        }
        inputStream.close();
        return oggetti;
    }
    
    /**
     * subLetturaOggetti() prende quello che gli passa il metodo lettura()
     * e li scrive negli attributi di un oggetto, e poi aggiunge quell'oggetto ad un
     * ArrayList.
     * 
     * @param st
     * @param oggetti
     */
    public void subLetturaOggetti(StringTokenizer st, ArrayList oggetti)
    {
        String nome = st.nextToken();
        String attributo = st.nextToken();
        String fileDomande = percorsoFile + st.nextToken();
        String fileScelte = percorsoFile + st.nextToken();
        String fileAdiacenze = percorsoFile + st.nextToken();

        Oggetto o = new Oggetto(nome, attributo, fileDomande, fileScelte, fileAdiacenze);
        oggetti.add(o);
    }
}
