
package Test;

/**
 *
 * @author Gabriele Guazzardi
 */
import esecuzione.EsecuzioneTest;
import esecuzione.Struttura;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
public class TestStruttura {
    
    @Test
    public void testReturnHome() throws IOException{
        
        Struttura struttura =  new Struttura();
        
        struttura.returnHome();
        
        Assert.assertNull(struttura.getDomandaAttuale());
        Assert.assertNull(struttura.getOggettoSelezionato());
        Assert.assertEquals(0, struttura.getPercorso().size());
    }
    
    @Test
    public void testSceltaOggetti() throws IOException{
        
        Struttura struttura =  new Struttura();
        
        struttura.letturaOggetti();
        struttura.sceltaOggetto(0);
        
        Assert.assertNotNull(struttura.getOggettoSelezionato());
        Assert.assertNotNull(struttura.getDomandaAttuale());
    }
    
    @Test
    public void testLetturaDatiOggetto() throws IOException{
        Struttura struttura = new Struttura();
        
        struttura.letturaOggetti();
        struttura.sceltaOggetto(0);
        
        struttura.letturaDatiOggetto();
        
        Assert.assertNotNull(struttura.getOggettoSelezionato().getStati());
        
    }
}
