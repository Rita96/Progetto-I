package progetto;

import java.util.ArrayList;

public class Oggetto
{
    private String nome;
    private String attributo;
    private String fileDomande;
    private String fileScelte;
    private String fileAdiacenze;
    private ArrayList<Domanda> domande;
    
    public Oggetto(String n,String a,String f1,String f2,String f3)
    {
        nome=n;
        attributo=a;
        fileDomande=f1;
        fileScelte=f2;
        fileAdiacenze=f3;
        domande = new ArrayList<>();
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public String getAttributo()
    {
        return attributo;        
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
    
    public void addDomande(ArrayList<Domanda> d)
    {
        domande.addAll(d);
    }

    public ArrayList<Domanda> getDomande()
    {
        return domande;
    }
}
