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
        
        Assert.assertEquals(3, test.percorsoSize());
        
        Assert.assertEquals("1", test.getCodiceStato(0));
        Assert.assertEquals("6", test.getCodiceScelta(0));
        
        Assert.assertEquals("2", test.getCodiceStato(1));
        Assert.assertEquals("3", test.getCodiceScelta(1));
        
        Assert.assertEquals("7", test.getCodiceStato(2));
        Assert.assertEquals("4", test.getCodiceScelta(2));
    }
    
    @Test
    public void testPercorsoCompleto() throws IOException
    {
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 1, 1, 1};
        int[] scelte = {0, 0, 1, 1, 0, 0};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals(4, test.percorsoSize());
        
        Assert.assertEquals("1", test.getCodiceStato(0));
        Assert.assertEquals("6", test.getCodiceScelta(0));
        
        Assert.assertEquals("2", test.getCodiceStato(1));
        Assert.assertEquals("2", test.getCodiceScelta(1));
        
        Assert.assertEquals("4", test.getCodiceStato(2));
        Assert.assertEquals("5", test.getCodiceScelta(2));
        
        Assert.assertEquals("9", test.getCodiceStato(3));
        Assert.assertEquals("4", test.getCodiceScelta(3));
    }
    
    @Test
    public void testPercorsoTornaIndietro() throws IOException{
        
        EsecuzioneTest test =  new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 3, 1, 5};
        int[] scelte =  {0, 0, 1, 1, 2};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals(2, test.percorsoSize());
        
        Assert.assertEquals("1", test.getCodiceStato(0));
        Assert.assertEquals("6", test.getCodiceScelta(0));
        
        Assert.assertEquals("2", test.getCodiceStato(1));
        Assert.assertEquals("3", test.getCodiceScelta(1));
        //Se la modifica della scelta già fatta non funzionasse il codice della scelta sarebbe 2
        
        /*non possiamo avere tre scelte perchè quando cambiamo risposta la andiamo a sovrascrivere, quindi nell'array ci 
        saranno effettivamente solo 2 scelte*/
    }
    
    @Test
    public void testHomePercorsoVuoto() throws IOException
    {
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 1, 4, 5};
        int[] scelte = {0, 0, 1, 2};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals(0, test.percorsoSize());
    }
    
    @Test
    public void testVisualizzaDomandaPrecedente() throws IOException{
        
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 1, 2, 5};
        int[] scelte = {0, 0, 1, 0, 2};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals(3, test.percorsoSize());
        
        Assert.assertEquals("1", test.getCodiceStato(0));
        Assert.assertEquals("6", test.getCodiceScelta(0));
        
        Assert.assertEquals("2", test.getCodiceStato(1));
        Assert.assertEquals("2", test.getCodiceScelta(1));
        
        Assert.assertEquals("4", test.getCodiceStato(2));
        Assert.assertEquals("4", test.getCodiceScelta(2));
    }

    @Test
    public void testSceltaNonValidaMenu() throws IOException{
        
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 6, 1, 5};
        int[] scelte = {0, 0, 1, 0};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals(3, test.percorsoSize());
        
        Assert.assertEquals("1", test.getCodiceStato(0));
        Assert.assertEquals("6", test.getCodiceScelta(0));
        
        Assert.assertEquals("2", test.getCodiceStato(1));
        Assert.assertEquals("2", test.getCodiceScelta(1));
        
        Assert.assertEquals("4", test.getCodiceStato(2));
        Assert.assertEquals("4", test.getCodiceScelta(2));
    }
    
    @Test
    public void testSceltaNonValidaScelte() throws IOException {
        
        EsecuzioneTest test = new EsecuzioneTest();
        int[] scelteMenu = {1, 1, 1, 1, 5};
        int[] scelte = {0, 0, 14, 1};
        
        test.esecuzione(scelteMenu, scelte);
        
        Assert.assertEquals(2, test.percorsoSize());
        
        Assert.assertEquals("1", test.getCodiceStato(0));
        Assert.assertEquals("6", test.getCodiceScelta(0));
        
        Assert.assertEquals("2", test.getCodiceStato(1));
        Assert.assertEquals("2", test.getCodiceScelta(1));
    }
}
