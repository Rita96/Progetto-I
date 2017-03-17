package progetto;


public class Oggetto 
{
    private String nome;
    private String attributo;
    private String fileDomande;
    private String fileScelte;
    private String fileAdiacenze;
    
    public Oggetto(String n,String a,String f1,String f2,String f3)
    {
        nome=n;
        attributo=a;
        fileDomande=f1;
        fileScelte=f2;
        fileAdiacenze=f3;
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
    
}
