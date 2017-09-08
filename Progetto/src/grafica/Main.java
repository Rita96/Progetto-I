package grafica;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException 
    {
        ThreadGrafica thread = new ThreadGrafica();
        thread.run();
        ThreadGrafica thread2 = new ThreadGrafica();
        thread2.run();
    }
}
