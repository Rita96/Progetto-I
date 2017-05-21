package grafica;

import static grafica.Grafica.progetto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JFrame 
{
    private Font fontBenvenuto, fontSeleziona;
    private JPanel pannello, north, east, center, west, south;
    private JLabel benvenuto, seleziona, oggetto, attributo;
    static JComboBox elencoOggetti, elencoAttributi;
    private JButton start;
    private ImageIcon startIcon;
    
    public HomePage()
    {
        super("Risolutore di Problemi - Home");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setHomeLocation();
        setLabels();
        setComboBoxes();
        setStartButton();
        setPanels();
        setMainPanel();
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
        setSize(screenWidth / 3, screenHeight / 3);
        setLocation((screenWidth - getWidth())/ 2, (screenHeight - getHeight() )/ 2);
    }
    
    private void setFonts()
    {
        fontBenvenuto = new Font("Times New Romans", Font.BOLD, 18);
        fontSeleziona = new Font("Times New Romans", Font.PLAIN, 14);
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
        
        oggetto = new JLabel("Elettrodomestico");
        oggetto.setHorizontalAlignment(JLabel.CENTER);
        
        attributo = new JLabel("Modello");
        attributo.setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void setComboBoxes()
    {
        elencoOggetti = new JComboBox(progetto.getElencoOggetti().toArray());
        ComboBoxListener cbl = new ComboBoxListener();
        elencoOggetti.addActionListener(cbl);
        
        elencoAttributi = new JComboBox();
        elencoAttributi.setEnabled(false);
    }
    
    private void setStartButton()
    {
        start = new JButton();
        StartButtonListener sbl = new StartButtonListener();
        start.addActionListener(sbl);
        setStartIcon();
    }
    
    private void setStartIcon()
    {
        startIcon = new ImageIcon("icon/start.png");
        Image img = startIcon.getImage().getScaledInstance(40, 25, Image.SCALE_SMOOTH);
        startIcon.setImage(img);
        start.setIcon(startIcon);
    }
    
    private void setPanels()
    {
        pannello = new JPanel(new BorderLayout());
        north = new JPanel(new GridLayout(4, 1));
        east = new JPanel();
        center = new JPanel(new GridLayout(3, 2, 30, 0));
        west = new JPanel();
        south = new JPanel(new FlowLayout());
        
        north.add(new JLabel());
        north.add(benvenuto);
        north.add(seleziona);
        center.add(oggetto);
        center.add(attributo);
        center.add(elencoOggetti);
        center.add(elencoAttributi);
        south.add(start);
    }
    
    private void setMainPanel()
    {
        pannello.add(north, BorderLayout.NORTH);
        pannello.add(east, BorderLayout.EAST);
        pannello.add(center, BorderLayout.CENTER);
        pannello.add(west, BorderLayout.WEST);
        pannello.add(south, BorderLayout.SOUTH);
    }
}
