package progetto;

public class Stato {

    private String ID, text;

    public Stato(String ID, String text) {
        this.ID = ID;
        this.text = text;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return text;
    }
}
