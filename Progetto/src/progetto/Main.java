package progetto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
                
        LetturaOggetti lo=new LetturaOggetti();
        ArrayList<Oggetto> oggetti=new ArrayList<>();
        
        oggetti=lo.lettura();
        
        System.out.println("Selezionare l'oggetto difettoso: ");
        
        for(int i = 0; i < oggetti.size(); i++)
        {
            System.out.println(i+" "+oggetti.get(i));
        }
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Oggetto oggetto = oggetti.get(n);
        
        Progetto progetto = new Progetto(oggetto);
        progetto.lettura();
        Domanda domanda = progetto.getOggetto().getDomande().get(0);
        
        while(true)
        {
            System.out.println(domanda);

            input = new Scanner(System.in);
            String s = input.nextLine();
            ArrayList<Scelta> scelte = domanda.getScelte();

            for(int i = 0; i < scelte.size(); i++)
            {
                if(s.equals(scelte.get(i).getCodice()))
                {
                    domanda = domanda.getAdiacenze().get(i);
                }
            }
        }
    }
}
