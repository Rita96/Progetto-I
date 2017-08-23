package Test;

import elementi.Tappa;
import esecuzione.EsecuzioneTest;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TestEsecuzione {
    
    @Test
    public void testPercorso() throws IOException
    {
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 5};
        int[] scelte = {0, 0, 0};
        
        test.esecuzione(scelteMenu, scelte);
        Object[] risultato = test.getPercorsoArray();
        
        Tappa t1 = test.getTappa(0, 0);
        Tappa[] verifica = {};
        
        Assert.assertArrayEquals(verifica, risultato);
    }
}
