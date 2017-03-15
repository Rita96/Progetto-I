package progetto.i;

public abstract class Frase {

    private String ID, text;

    public Frase(String ID, String text) {
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
