package grafica;

import static grafica.Grafica.progetto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ExecutePage extends JFrame 
{
    private Font fontDomanda, fontScelta;
    private JPanel pannello, north, center, south;
    private JLabel domanda;
    private JButton home, back, next, end;
    private ButtonGroup gruppo;
    
    public ExecutePage()
    {
        super("Risolutore di Problemi - Domande");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExecutePageLocation();
        initPanels();
        setFont();
        setDomanda();
        setRadioButtons();
        setButtons();
        setPanels();
        setMainPanel();
        setContentPane(pannello);
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
        pannello = new JPanel(new BorderLayout());
        north = new JPanel(new GridLayout(4, 1));
        center = new JPanel(new GridLayout(5, 1));
        south = new JPanel(new FlowLayout());
    }
    
    private void setFont()
    {
        fontDomanda = new Font("Times New Romans", Font.BOLD, 14);
        fontScelta = new Font("Times New Romans", Font.PLAIN, 14);
    }
    
    private void setDomanda()
    {
        domanda = new JLabel();
        domanda.setFont(fontDomanda);
        domanda.setText(progetto.getAttuale().getTesto());
        domanda.setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void setButtons()
    {
        back = new JButton("←");
        BackButtonListener bbl = new BackButtonListener();
        back.addActionListener(bbl);
        
        if(progetto.getAttuale().getScelte().isEmpty())
            next = new JButton("FINE");
        else
            next = new JButton("→");
        
        NextButtonListener nbl = new NextButtonListener();
        next.addActionListener(nbl);
        
        home = new JButton("🏠");
        HomeButtonListener hbl = new HomeButtonListener();
        home.addActionListener(hbl);
    }
    
    private void setRadioButtons()
    {
        int numeroScelte = progetto.getAttuale().getScelte().size();
        ArrayList<String> testoScelte = new ArrayList();
        
        for(int i = 0; i < numeroScelte; i++)
            testoScelte.add(progetto.getAttuale().getScelte().get(i).getTesto());
        
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
        north.add(domanda);
        south.add(home);
        south.add(back);
        south.add(next);
    }
    
    private void setMainPanel()
    {
        pannello.add(north, BorderLayout.NORTH);
        pannello.add(center, BorderLayout.CENTER);
        pannello.add(south, BorderLayout.SOUTH);
    }
}
