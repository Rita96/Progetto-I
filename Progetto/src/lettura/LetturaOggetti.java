package lettura;

import elementi.Oggetto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LetturaOggetti extends Lettura
{

    public LetturaOggetti(String nomeFile) {
        super(nomeFile);
    }
    
    public ArrayList<Oggetto> lettura()
    {
        ArrayList<Oggetto> oggetti = new ArrayList<>();
        
        super.bufferedReaderInitialization();
        
        try
        {
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
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        
        return oggetti;
    }
    
    public void subLetturaOggetti(StringTokenizer st, ArrayList oggetti)
    {
        String nome = st.nextToken();
        String attributo = st.nextToken();
        String fileDomande = st.nextToken();
        String fileScelte = st.nextToken();
        String fileAdiacenze = st.nextToken();

        Oggetto o = new Oggetto(nome, attributo, fileDomande, fileScelte, fileAdiacenze);
        oggetti.add(o);
    }
}
