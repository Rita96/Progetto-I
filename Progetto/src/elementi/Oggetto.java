package elementi;

import java.util.ArrayList;

/**
 * In Oggetto si caricano i dati dal file "Oggetti.txt" strutturato nel seguente modo:
 * - nome (esempio: Lavatrice)
 * - attributo (esempio: Modello Lavatrice A)
 * - nome file testo delle domande (esempio: domande.txt)
 * - nome file testo delle scelte (esempio: scelte.txt)
 * - nome file testo delle adiacenze (esempio: adiacenze.txt)
 * Le adiacenze indicano quali altre domande sono collegate a ciascuna domanda
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */

public class Oggetto
{
    private String nome;
    private String attributo;
    private String fileStati;
    private String fileScelte;
    private String fileAdiacenze;
    private ArrayList<Stato> stati;
    
    public Oggetto(String nome, String attributo, String fileStati, String fileScelte, String fileAdiacenze)
    {
        this.nome = nome;
        this.attributo = attributo;
        this.fileStati = fileStati;
        this.fileScelte = fileScelte;
        this.fileAdiacenze = fileAdiacenze;
        this.stati = new ArrayList();
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public String getFileStati()
    {
        return fileStati;
    }
    
    public String getFileScelte()
    {
        return fileScelte;
    }
    
    public String getFileAdiacenze()
    {
        return fileAdiacenze;
    }
    
    public ArrayList<Stato> getStati()
    {
        return stati;
    }
    
    public Stato getStatoIniziale()
    {
        return stati.get(0);
    }
    
    public Stato getStato(int n)
    {
        return stati.get(n);
    }
    
    public void setStati(ArrayList<Stato> stati)
    {
        this.stati = stati;
    }
    
    @Override
    public String toString()
    {
        return nome;
    }
}
