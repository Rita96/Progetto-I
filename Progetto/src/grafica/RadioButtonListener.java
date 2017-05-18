package grafica;

import static grafica.Grafica.progetto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class RadioButtonListener implements ActionListener
{
    public static int indice;
    
    public RadioButtonListener()
    {
        super();
        indice = -1;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        JRadioButton radio = (JRadioButton)ae.getSource();
        String s = radio.getText();
        
        for(int i = 0; i < progetto.getAttuale().getScelte().size(); i++)
        {
            if(s.equals(progetto.getAttuale().getScelte().get(i).getTesto()))
                indice = i;
        }
    }
}
