package grafica;

import static grafica.Grafica.p;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JFrame 
{
    private Font fontBenvenuto, fontSeleziona;
    private JPanel pannello, north, center, south;
    private JLabel benvenuto, seleziona, oggetto;
    static JComboBox elencoOggetti;
    private JButton start;
    
    public HomePage()
    {
        super("Risolutore di Problemi - Home");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setHomeLocation();
        setPanels();
        setLabels();
        setElencoOggetti();
        setStartButton();
        
        north.add(new JLabel());
        north.add(benvenuto);
        north.add(seleziona);
        center.add(oggetto);
        center.add(elencoOggetti);
        south.add(start);
        
        pannello.add(north, BorderLayout.NORTH);
        pannello.add(center, BorderLayout.CENTER);
        pannello.add(south, BorderLayout.SOUTH);
        
        setResizable(false);
        setContentPane(pannello);
        setVisible(true);
    }
    
    private void setHomeLocation()
    {
        Toolkit kit = Toolkit.getDefaultToolkit(); 
        Dimension screenSize = kit.getScreenSize(); 
        int screenHeight = screenSize.height; 
        int screenWidth = screenSize.width; 
        setSize(screenWidth / 4, screenHeight / 4); 
        setLocation((screenWidth - getWidth())/ 2, (screenHeight - getHeight() )/ 2);
    }
    
    private void setFonts()
    {
        fontBenvenuto = new Font("Times New Romans", Font.BOLD, 18);
        fontSeleziona = new Font("Times New Romans", Font.PLAIN, 14);
    }
    
    private void setPanels()
    {
        pannello = new JPanel(new BorderLayout());
        north = new JPanel(new GridLayout(4, 1));
        center = new JPanel(new GridLayout(3, 2, 30, 0));
        south = new JPanel(new FlowLayout());
    }
    
    private void setLabels()
    {
        setFonts();
        benvenuto = new JLabel("Benvenuto nel Risolutore Problemi");
        benvenuto.setHorizontalAlignment(JLabel.CENTER);
        benvenuto.setFont(fontBenvenuto);
        
        seleziona = new JLabel("Seleziona l'elettrodomestico in tuo possesso");
        seleziona.setHorizontalAlignment(JLabel.CENTER);
        seleziona.setFont(fontSeleziona);
        
        oggetto = new JLabel("Oggetto");
        oggetto.setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void setElencoOggetti()
    {
        elencoOggetti = new JComboBox(p.getOggetti().toArray());
    }
    
    private void setStartButton()
    {
        start = new JButton("Start");
        StartButtonListener sbl = new StartButtonListener();
        start.addActionListener(sbl);
    }
}
