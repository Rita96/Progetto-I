package test;

/**
 *
 * @author Gabriele Guazzardi
 */
import esecuzione.Struttura;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
public class TestStruttura {
    
    @Test
    public void testSceltaOggetti() throws IOException
    {
        Struttura struttura =  new Struttura();
        struttura.letturaOggetti();
        struttura.sceltaOggetto(0);
        
        Assert.assertNotNull(struttura.getOggettoSelezionato());
        Assert.assertNotNull(struttura.getDomandaAttuale());
    }
    
    @Test
    public void testLetturaDatiOggetto() throws IOException
    {
        Struttura struttura = new Struttura();
        struttura.letturaOggetti();
        struttura.sceltaOggetto(0);
        struttura.letturaDatiOggetto();
        
        Assert.assertNotNull(struttura.getOggettoSelezionato());
        Assert.assertNotNull(struttura.getDomandaAttuale());
        Assert.assertNotNull(struttura.getStatiOggettoSelezionato());
    }
    
    @Test
    public void testEsecuzioneProgetto() throws IOException
    {
        Struttura struttura = new Struttura();
        struttura.letturaOggetti();
        struttura.sceltaOggetto(0);
        struttura.letturaDatiOggetto();
        struttura.esecuzioneProgetto(0);
        struttura.esecuzioneProgetto(1);
        struttura.esecuzioneProgetto(0);
        
        Assert.assertNotNull(struttura.getOggettoSelezionato());
        Assert.assertNotNull(struttura.getDomandaAttuale());
        Assert.assertNotNull(struttura.getStatiOggettoSelezionato());
        Assert.assertEquals(3, struttura.percorsoSize());
    }
    
    @Test
    public void testStatoPrecedente() throws IOException
    {
        Struttura struttura = new Struttura();
        struttura.letturaOggetti();
        struttura.sceltaOggetto(0);
        struttura.letturaDatiOggetto();
        struttura.esecuzioneProgetto(0);
        struttura.esecuzioneProgetto(1);
        struttura.statoPrecedente(1);
        struttura.esecuzioneProgetto(0);
        //la seconda tappa del percorso viene modificata, cioè cancellata e riscritta
        
        Assert.assertNotNull(struttura.getOggettoSelezionato());
        Assert.assertNotNull(struttura.getDomandaAttuale());
        Assert.assertNotNull(struttura.getStatiOggettoSelezionato());
        Assert.assertEquals(2, struttura.percorsoSize());
    }
    
    @Test
    public void testReturnHome() throws IOException{
        
        Struttura struttura =  new Struttura();
        struttura.letturaOggetti();
        struttura.sceltaOggetto(0);
        struttura.letturaDatiOggetto();
        struttura.esecuzioneProgetto(0);
        struttura.returnHome();
        
        Assert.assertNull(struttura.getDomandaAttuale());
        Assert.assertNull(struttura.getOggettoSelezionato());
        Assert.assertEquals(0, struttura.percorsoSize());
    }
}
