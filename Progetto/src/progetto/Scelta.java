package progetto;

public class Scelta 
{
    private String codS;
    private String testoS;
    
    public Scelta(String c, String s)
    {
        codS=c;
        testoS=s;
    }
    
    public String getCodS()
    {
        return codS;
    }
    
    public String getTestoS()
    {
        return testoS;
    }
    
    public boolean controllo(String cod)
    {
        if(cod==codS)
            return true;
        else
            return false;
    }
    
}
