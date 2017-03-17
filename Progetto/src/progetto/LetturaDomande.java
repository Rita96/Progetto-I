package progetto;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;

public class LetturaDomande
{
    private String nomefile;
    private File file;
    
    public LetturaDomande(String nome)
    {
        nomefile=nome;
        file=new File(nome);;
    }
    
    public ArrayList<Stato> lettura()
    {
        String cod;
        String text;
        ArrayList<Stato> lista=new ArrayList<>();
        
        Scanner in=null;
        
        try
        {
            in=new Scanner(file);
            in.useDelimiter("\n|\t");
        }
        catch(FileNotFoundException e)
        {
            System.exit(0);
        }
        
        while(in.hasNextLine() && in.hasNext())
        {
            cod=in.next();
            text=in.next();
            lista.add(new Stato(cod,text));
        }
        in.close();
        return lista;
    }
    
}
