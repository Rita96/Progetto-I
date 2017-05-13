package grafica;

import static grafica.Grafica.p;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomePage extends JFrame 
{
    public HomePage(String s)
    {
        super(s);
        
        JPanel pannello=new JPanel();
        
        JButton start=new JButton("Start");
        StartButtonListener sbl=new StartButtonListener();
        start.addActionListener(sbl);
        
        String[] listaOggetti = new String[p.getOggetti().size()];
        for(int i=0; i<p.getOggetti().size(); i++) {
            listaOggetti[i]=p.getOggetti().get(i).getNome();
        }
        
        JComboBox box=new JComboBox(listaOggetti);
        ComboBoxListener cbl=new ComboBoxListener();
        box.addActionListener(cbl);
        
        pannello.add(start,BorderLayout.EAST);
        pannello.add(box,BorderLayout.WEST);
        
        Toolkit kit = Toolkit.getDefaultToolkit(); 
        Dimension screenSize = kit.getScreenSize(); 
        int screenHeight = screenSize.height; 
        int screenWidth = screenSize.width; 
        setSize(screenWidth/2, screenHeight/2); 
        setLocation(screenWidth/4, screenHeight/4); 
        
        setContentPane(pannello);
        pack();
        setVisible(true);
    }
}
