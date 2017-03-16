package progetto;

public class Domanda extends Frase {

    private String nextTrue, nextFalse;

    public Domanda(String nextTrue, String nextFalse, String ID, String text) {
        super(ID, text);
        this.nextTrue = nextTrue;
        this.nextFalse = nextFalse;
    }

    public String next(boolean b) {
        if (b) {
            return nextTrue;
        } else {
            return nextFalse;
        }
    }
}
