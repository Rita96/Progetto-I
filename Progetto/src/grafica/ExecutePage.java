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
    private JPanel main, north, center, south;
    private JLabel domanda;
    private JButton home, back, next, end;
    private ButtonGroup gruppo;
    static boolean ultimoStato;  
    
    public ExecutePage()
    {
        super("Risolutore di Problemi - Domande");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExecutePageLocation();
        initPanels();
        initFont();
        initDomanda();
        initButtons();
        setRadioButtons();
        setPanels();
        setMainPanel();
        setContentPane(main);
        setResizable(false);
        setVisible(true);
        ultimoStato=false;
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
        south = new JPanel(new FlowLayout());
    }
    
    private void initFont()
    {
        fontDomanda = new Font("Times New Romans", Font.BOLD, 18);
        fontScelta = new Font("Times New Romans", Font.PLAIN, 14);
    }
    
    private void initDomanda()
    {
        domanda = new JLabel();
        domanda.setFont(fontDomanda);
        domanda.setText(progetto.getAttuale().getTesto());
        domanda.setHorizontalAlignment(JLabel.CENTER);
    }
    
    private void initButtons()
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
        
        end = new JButton("Fine");
        EndButtonListener ebl = new EndButtonListener();
        end.addActionListener(ebl);
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
        south.add(home);
        
        if(progetto.getPercorso().size() != 1)
            south.add(back);
        
        if(progetto.getAttuale().getScelte().isEmpty())
        {
            center.add(new JLabel());
            center.add(new JLabel());
            center.add(domanda);
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
        main.add(south, BorderLayout.SOUTH);
    }
    
    public void refreshFrame()
    {
        domanda.setText(progetto.getAttuale().getTesto());
        setRadioButtons();
        setPanels();
        revalidate();
        repaint();
    }
    
    public void clearFrame()
    {
        north.removeAll();
        south.removeAll();
        center.removeAll();
    }
}
