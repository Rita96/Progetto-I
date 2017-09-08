package graficaListener;

import esecuzione.Struttura;
import grafica.ExecutePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ComboBoxListener implements ActionListener
{
    private Struttura progetto;
    private ExecutePage executePage;
    private JComboBox percorso;
    public ComboBoxListener(Struttura progetto, ExecutePage executePage,JComboBox percorso ){
        super();
        this.progetto = progetto;
        this.executePage = executePage;
        this.percorso = percorso;
    }
            
            
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int selezionata = percorso.getSelectedIndex();
        progetto.statoPrecedente(selezionata);
        executePage.clearFrame();
        executePage.refreshFrame();
    }
    
}
