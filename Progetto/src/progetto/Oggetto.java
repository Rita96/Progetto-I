package progetto;

import java.util.ArrayList;

/**
 * Oggetto legge dati dal file "Oggetti.txt" strutturato nel seguente modo:
 * - nome (esempio: Lavatrice)
 * - attributo (esempio: Modello Lavatrice A)
 * - nome file testo delle domande (esempio: domande.txt)
 * - nome file testo delle scelte (esempio: scelte.txt)
 * - nome file testo delle adiacenze (esempio: adiacenze.txt)
 * Le adiacenze indicano quali altre domande sono collegate a ciascuna domanda
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
        stati = new ArrayList();
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
    
    /**
    * Metodo che aggiunge all'attributo domande di oggetto un ArrayList di domande
    * @param stati: ArrayList di Domanda
    */
    public void addStato(ArrayList<Stato> stati)
    {
        this.stati.addAll(stati);
    }
}
