package progetto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int i;        
        LetturaOggetti lo=new LetturaOggetti();
        ArrayList<Oggetto> oggetti=new ArrayList<>();
        
        oggetti=lo.lettura();
        
        System.out.println();
        System.out.println("Selezionare IL NUMERO nell'ArrayList dell'oggetto per il Test: ");
        System.out.println();
        
        for(i = 0; i < oggetti.size(); i++)
        {
            System.out.println("Elenco Oggetti: ");
            System.out.println("("+i+")"+ oggetti.get(i));
            System.out.println();
        }
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        Oggetto oggetto = oggetti.get(n);
        
        System.out.println(oggetto.getNome());
        System.out.println(oggetto.getFileScelte());
        System.out.println(oggetto.getFileDomande());
        System.out.println(oggetto.getFileAdiacenze());
        
        Progetto progetto = new Progetto(oggetto);
        progetto.lettura();
        
        for(i=0;i<progetto.getOggetto().getDomande().size();i++)
        {
            System.out.println();
            System.out.println(progetto.getOggetto().getDomande().get(i).toString());
        }
    }
}
