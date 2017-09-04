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
    
    @Test
    public void testPercorsoTornaIndietro() throws IOException{
        
        EsecuzioneTest test =  new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 3, 1, 5};
        int[] scelte =  {0, 0, 1, 1, 2};
        
        test.esecuzione(scelteMenu,scelte);
        
        Assert.assertEquals("6", test.getTappa(0).getCodiceScelta());
        Assert.assertEquals("3", test.getTappa(1).getCodiceScelta());
        
        /*non possiamo avere tre scelte perchè quando cambiamo risposta la andiamo a sovrascrivere, quindi nell'array ci 
        saranno effettivamente solo 2 scelte*/
        //Assert.assertEquals("3", test.getTappa(2).getCodiceScelta());
        
    }
    
    @Test
    public void testHomePercorsoVuoto() throws IOException
    {
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 1, 4, 5};
        int[] scelte = {0, 0, 1, 2};
        test.esecuzione(scelteMenu,scelte);
        
        Assert.assertEquals(0,test.getPercorso().size());
    }
    
    @Test
    public void testVisualizzaDomandaPrecedente() throws IOException{
        
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 1, 2, 5};
        int[] scelte = {0, 0, 1, 0, 2};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals("1", test.getTappa(0).getCodiceStato());
        Assert.assertEquals("2", test.getTappa(1).getCodiceStato());
        Assert.assertEquals("4", test.getTappa(2).getCodiceStato());
    }

    @Test
    public void testSceltaNonValidaMenu() throws IOException{
        
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 6, 1, 5};
        int[] scelte = {0, 0, 1, 0};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals("1", test.getTappa(0).getCodiceStato());
        Assert.assertEquals("2", test.getTappa(1).getCodiceStato());
        Assert.assertEquals("4", test.getTappa(2).getCodiceStato());
    }
}
