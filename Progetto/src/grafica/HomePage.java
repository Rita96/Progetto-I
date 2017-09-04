package grafica;

import graficaListener.StartButtonListener;
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
    private JPanel main, north, center, south;
    private JLabel benvenuto, seleziona;
    public static JComboBox elencoOggetti;
    private JButton start;
    private ImageIcon startIcon;
    
    public HomePage()
    {
        super("Risolutore di Problemi - Home");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //messo DISPOSE_ON_CLOSE per i thread in modo che non si chiudano tutte le finestre quando ne chiudi una
        setHomeLocation();
        setLabels();
        setComboBoxes();
        setStartButton();
        setPanels();
        setMainPanel();
        setResizable(false);
        setContentPane(main);
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
    }
    
    private void setComboBoxes()
    {
        elencoOggetti = new JComboBox(progetto.elencoOggettiArray());
        elencoOggetti.setPreferredSize(new Dimension(200, 30));
    }
    
    private void setStartButton()
    {
        start = new JButton();
        start.setPreferredSize(new Dimension(60, 30));
        StartButtonListener sbl = new StartButtonListener();
        start.addActionListener(sbl);
        setStartIcon();
    }
    
    private void setStartIcon()
    {
        startIcon = new ImageIcon("icon/start.png");
        Image icon = startIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        startIcon.setImage(icon);
        start.setIcon(startIcon);
    }
    
    private void setPanels()
    {
        main = new JPanel(new BorderLayout());
        north = new JPanel(new GridLayout(4, 1));
        center = new JPanel(new FlowLayout());
        south = new JPanel(new FlowLayout());
        
        north.add(new JLabel());
        north.add(benvenuto);
        north.add(seleziona);
        center.add(elencoOggetti);
        south.add(start);
    }
    
    private void setMainPanel()
    {
        main.add(north, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);
        main.add(south, BorderLayout.SOUTH);
    }
}
