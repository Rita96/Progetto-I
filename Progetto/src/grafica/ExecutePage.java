package grafica;

import static grafica.Grafica.p;
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
    private JButton home, back, next;
    private ButtonGroup gruppo;
    
    public ExecutePage()
    {
        
        super("Risolutore di Problemi - Domande");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setExecutePageLocation();
        setPanels();
        
        setContentPane(pannello);
    }
    public void riempi()
    {
        setDomanda();
        
        ArrayList<String> testoScelte = new ArrayList();
        for(int i = 0; i < p.getAttuale().getScelte().size(); i++)
            testoScelte.add(p.getAttuale().getScelte().get(i).getTesto());
        
        setRadioButtons(p.getAttuale().getScelte().size(), testoScelte);
        setButtons();
        
        north.add(new JLabel());
        north.add(domanda);
        south.add(home);
        south.add(back);
        south.add(next);
        
        pannello.add(north, BorderLayout.NORTH);
        pannello.add(center, BorderLayout.CENTER);
        pannello.add(south, BorderLayout.SOUTH);
        
        setResizable(false);
        setVisible(true);
    }
    
    public void svuota()
    {
        pannello.removeAll();
        north.removeAll();
        south.removeAll();
        center.removeAll();
        repaint();
    }
    
    private void setExecutePageLocation()
    {
        Toolkit kit = Toolkit.getDefaultToolkit(); 
        Dimension screenSize = kit.getScreenSize(); 
        int screenHeight = screenSize.height; 
        int screenWidth = screenSize.width; 
        setSize(screenWidth / 4, screenHeight / 4); 
        setLocation((screenWidth - getWidth())/ 2, (screenHeight - getHeight() )/ 2);
    }
    
    private void setPanels()
    {
        pannello = new JPanel(new BorderLayout());
        north = new JPanel(new GridLayout(4, 1));
        center = new JPanel(new GridLayout(5, 1));
        south = new JPanel(new FlowLayout());
    }
    
    private void setDomanda()
    {
        domanda = new JLabel();
        domanda.setText(p.getAttuale().getTesto());
        domanda.setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void setButtons()
    {
        back = new JButton("←");
        BackButtonListener bbl = new BackButtonListener();
        back.addActionListener(bbl);
        
        next = new JButton("→");
        NextButtonListener nbl = new NextButtonListener();
        next.addActionListener(nbl);
        
        home = new JButton("🏠");
        HomeButtonListener hbl = new HomeButtonListener();
        home.addActionListener(hbl);
    }
    
    private void setRadioButtons(int n, ArrayList<String> s)
    {
        gruppo = new ButtonGroup();
        
        for(int i = 0; i < n; i++)
        {
            JRadioButton radio = new JRadioButton(s.get(i));
            RadioButtonListener rbl = new RadioButtonListener();
            radio.addActionListener(rbl);
            gruppo.add(radio);
            center.add(radio);
        }
    }
    
}
