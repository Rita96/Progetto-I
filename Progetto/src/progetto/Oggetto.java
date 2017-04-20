package progetto;

import java.util.ArrayList;

/**
 * L'elemento Oggetto prende i propri dati dal file Oggetti.txt ed è strutturato così:
 * nome(esempio lavatrice) attributo (esempio modello lavatrice) file testo delle domande file testo delle scelte file testo delle adiacenze
 * Le adiacenze vanno indicano quali altre domande sono collegate a ciascuna domanda
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
        this.nome=nome;
        this.attributo=attributo;
        this.fileStati=fileStati;
        this.fileScelte=fileScelte;
        this.fileAdiacenze=fileAdiacenze;
        stati=new ArrayList();
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
    
    /**
    * Metodo che aggiunge all'attributo domande di oggetto un ArrayList di domande
    * @param stati: ArrayList di Domanda
    */
    public void addStato(ArrayList<Stato> stati)
    {
        this.stati.addAll(stati);
    }
    
    public ArrayList<Stato> getStati()
    {
        return stati;
    }
    
}
