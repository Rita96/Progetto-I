package Test;

import elementi.Tappa;
import esecuzione.EsecuzioneTest;
import java.io.IOException;
import java.util.ArrayList;

public class TestEsecuzione {
    
    public void testPercorso() throws IOException
    {
        EsecuzioneTest test = new EsecuzioneTest();
        int scelteMenu[] = {1, 1, 1};
        int scelte[] = {0, 0, 0};
        ArrayList<Tappa> verifica = new ArrayList();
        
        test.esecuzione(scelteMenu, scelte);
        
    }
    
}
