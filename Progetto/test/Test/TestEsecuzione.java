package Test;

import esecuzione.EsecuzioneTest;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TestEsecuzione {
    
    @Test
    public void testPercorso() throws IOException
    {
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 1, 5};
        int[] scelte = {0, 0, 2, 0};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals("1", test.getTappa(0).getCodiceStato());
        Assert.assertEquals("2", test.getTappa(1).getCodiceStato());
        Assert.assertEquals("7", test.getTappa(2).getCodiceStato());
    }
}
