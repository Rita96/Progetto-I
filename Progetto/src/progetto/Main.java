package progetto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        
        Progetto p = new Progetto();
        p.sceltaOggetto();
        p.lettura();
        
        System.out.println("Per il test inserire il numero della scelta: 0,1, ...");
        System.out.println();
        
        while(true)
        {
            p.scelta();    
        }
    }
}
