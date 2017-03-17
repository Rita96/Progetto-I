package progetto;

public class Stato {

    private String ID, text;
    

    public Stato(String ID, String text) {
        this.ID = ID;
        this.text = text;
    }

    public String getId() {
        return ID;
    }

    @Override
    public String toString() {
        return text;
    }
    
    public boolean controllo(String cod)
    {
        if(cod==ID)
            return true;
        else
            return false;
    }
}
