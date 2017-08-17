package grafica;

import static grafica.Grafica.progetto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ExecutePage extends JFrame 
{
    private Font fontDomanda, fontScelta;
    private JPanel main, north, center, east, south;
    private JLabel domanda, seleziona;
    private JButton home, back, next, end;
    private ImageIcon homeIcon, backIcon, nextIcon, endIcon;
    static JComboBox percorso;
    private ButtonGroup gruppo;
    
    public ExecutePage()
    {
        super("Risolutore di Problemi - Domande");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExecutePageLocation();
        initPanels();
        initFont();
        initLabels();
        initButtons();
        setComboBox();
        setRadioButtons();
        setPanels();
        setMainPanel();
        setContentPane(main);
        setResizable(false);
        setVisible(true);
    }
    
    private void setExecutePageLocation()
    {
        Toolkit kit = Toolkit.getDefaultToolkit(); 
        Dimension screenSize = kit.getScreenSize(); 
        int screenHeight = screenSize.height; 
        int screenWidth = screenSize.width; 
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation((screenWidth - getWidth())/ 2, (screenHeight - getHeight() )/ 2);
    }
    
    private void initPanels()
    {
        main = new JPanel(new BorderLayout());
        north = new JPanel(new GridLayout(4, 1));
        center = new JPanel(new GridLayout(5, 1));
        east = new JPanel(new GridLayout(10, 1));
        south = new JPanel(new FlowLayout());
    }
    
    private void initFont()
    {
        fontDomanda = new Font("Times New Romans", Font.BOLD, 18);
        fontScelta = new Font("Times New Romans", Font.PLAIN, 14);
    }
    
    private void initLabels()
    {
        domanda = new JLabel();
        domanda.setFont(fontDomanda);
        domanda.setText(progetto.mostraDomandaAttuale());
        domanda.setHorizontalAlignment(JLabel.CENTER);
        
        seleziona = new JLabel("Seleziona domande precedenti:");
        seleziona.setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void initButtons()
    {
        Dimension buttonDimension = new Dimension(60, 30);
        
        back = new JButton();
        back.setPreferredSize(buttonDimension);
        BackButtonListener bbl = new BackButtonListener();
        back.addActionListener(bbl);
        
        next = new JButton();
        next.setPreferredSize(buttonDimension);
        NextButtonListener nbl = new NextButtonListener();
        next.addActionListener(nbl);
        
        home = new JButton();
        home.setPreferredSize(buttonDimension);
        HomeButtonListener hbl = new HomeButtonListener();
        home.addActionListener(hbl);
        
        end = new JButton();
        end.setPreferredSize(buttonDimension);
        EndButtonListener ebl = new EndButtonListener();
        end.addActionListener(ebl);
        
        setIconButtons();
    }
    
    private void setIconButtons()
    {
        homeIcon = new ImageIcon("icon/home.png");
        Image icon = homeIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        homeIcon.setImage(icon);
        home.setIcon(homeIcon);
        
        nextIcon = new ImageIcon("icon/next.png");
        icon = nextIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        nextIcon.setImage(icon);
        next.setIcon(nextIcon);
        
        backIcon = new ImageIcon("icon/back.png");
        icon = backIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        backIcon.setImage(icon);
        back.setIcon(backIcon);
        
        endIcon = new ImageIcon("icon/end.png");
        icon = endIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        endIcon.setImage(icon);
        end.setIcon(endIcon);
    }
    
    private void setComboBox()
    {
        percorso = new JComboBox(progetto.percorsoArray());
        percorso.setPreferredSize(new Dimension(200, 30));
        ComboBoxListener cbl = new ComboBoxListener();
        percorso.addActionListener(cbl);
    }
    
    private void setRadioButtons()
    {
        int numeroScelte = progetto.scelteDomandaAttualeSize();
        ArrayList<String> testoScelte = new ArrayList();
        
        for(int i = 0; i < numeroScelte; i++)
            testoScelte.add(progetto.mostraSceltaDomandaAttuale(i));
        
        gruppo = new ButtonGroup();
        
        for(int i = 0; i < numeroScelte; i++)
        {
            JRadioButton radio = new JRadioButton(testoScelte.get(i));
            radio.setFont(fontScelta);
            RadioButtonListener rbl = new RadioButtonListener();
            radio.addActionListener(rbl);
            gruppo.add(radio);
            center.add(radio);
        }
    }
    
    private void setPanels()
    {
        north.add(new JLabel());
        south.add(home);
        
        if(!progetto.percorsoEmpty())
        {
            east.add(seleziona);
            east.add(percorso);
            south.add(back);
        }
            
        if(progetto.scelteDomandaAttualeEmpty())
        {
            center.add(new JLabel());
            center.add(new JLabel());
            center.add(domanda);
            east.removeAll();
            south.add(end);
        }
        else
        {
            north.add(domanda);
            south.add(next);
        }
    }
    
    private void setMainPanel()
    {
        main.add(north, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);
        main.add(east, BorderLayout.EAST);
        main.add(south, BorderLayout.SOUTH);
    }
    
    public void refreshFrame()
    {
        domanda.setText(progetto.mostraDomandaAttuale());
        setRadioButtons();
        setComboBox();
        setPanels();
        revalidate();
        repaint();
    }
    
    public void clearFrame()
    {
        north.removeAll();
        center.removeAll();
        east.removeAll();
        south.removeAll();
    }
}