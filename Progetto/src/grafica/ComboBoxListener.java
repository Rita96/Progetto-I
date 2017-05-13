package grafica;
import static grafica.Grafica.p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ComboBoxListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        JComboBox cb=(JComboBox)ae.getSource();
        int n = cb.getSelectedIndex();
        p.sceltaOggetto(n);
        System.out.println("ComboBox Scelto "+n);
    }
}
