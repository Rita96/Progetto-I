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
    private String fileDomande;
    private String fileScelte;
    private String fileAdiacenze;
    private ArrayList<Domanda> domande;

    public Oggetto(String nome, String attributo, String fileDomande, String fileScelte, String fileAdiacenze)
    {
        this.nome=nome;
        this.attributo=attributo;
        this.fileDomande=fileDomande;
        this.fileScelte=fileScelte;
        this.fileAdiacenze=fileAdiacenze;
        domande=new ArrayList();
    }
    
    public String getFileDomande()
    {
        return fileDomande;
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
    * @param domande: ArrayList di Domanda
    */
    public void addDomande(ArrayList<Domanda> domande)
    {
        this.domande.addAll(domande);
    }
    
    public ArrayList<Domanda> getDomande()
    {
        return domande;
    }
    
}
