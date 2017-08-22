package Test;

import elementi.Tappa;
import esecuzione.EsecuzioneTest;
import java.io.IOException;
import java.util.ArrayList;

public class TestEsecuzione {
    
    void testPercorso() throws IOException
    {
        EsecuzioneTest test = new EsecuzioneTest();
        int scelteMenu[] = {5};
        int scelte[] = {};
        ArrayList<Tappa> verifica = new ArrayList();
        
        test.esecuzione(scelteMenu, scelte);
        
    }
    
}
