package grafica;

import static grafica.Grafica.p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class RadioButtonListener implements ActionListener
{
    public static int indice;
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        JRadioButton radio = (JRadioButton)ae.getSource();
        String s = radio.getText();
        
        for(int i = 0; i < p.getAttuale().getScelte().size(); i++)
        {
            if(s.equals(p.getAttuale().getScelte().get(i).getTesto()))
                indice = i;
        }
        
        System.out.println("RadioButton Scelto "+indice);
    }
}
