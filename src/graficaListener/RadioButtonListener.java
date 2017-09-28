package graficaListener;

import esecuzione.Struttura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class RadioButtonListener implements ActionListener
{
    public static int indice;
    public Struttura progetto;
    
    public RadioButtonListener(Struttura progetto)
    {
        super();
        this.progetto = progetto;
        indice = -1;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        JRadioButton radio = (JRadioButton)ae.getSource();
        String s = radio.getText();
        
        for(int i = 0; i < progetto.scelteDomandaAttualeSize(); i++)
        {
            if(s.equals(progetto.mostraSceltaDomandaAttuale(i)))
                indice = i;
        }
    }
}
