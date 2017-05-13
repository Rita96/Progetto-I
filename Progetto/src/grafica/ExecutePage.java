package grafica;

import static grafica.Grafica.p;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ExecutePage extends JFrame 
{
    public ExecutePage(String s)
    {
        super(s);
        JPanel pannello=new JPanel();
        
        JButton back=new JButton("Back");
        BackButtonListener bbl=new BackButtonListener();
        back.addActionListener(bbl);
        
        JButton next=new JButton("Next");
        NextButtonListener nbl=new NextButtonListener();
        next.addActionListener(nbl);
        
        JButton home=new JButton("Home");
        HomeButtonListener hbl=new HomeButtonListener();
        home.addActionListener(hbl);
        
        ArrayList<String> testoScelte = new ArrayList();
        for(int i=0; i<p.getAttuale().getScelte().size(); i++) {
            testoScelte.add(p.getAttuale().getScelte().get(i).getTesto());
        }
        
        pannello.add(back,BorderLayout.EAST);
        pannello.add(next,BorderLayout.WEST);
        pannello.add(home,BorderLayout.CENTER);
        pannello.add(insertRadioButtonS(p.getAttuale().getScelte().size(),testoScelte),BorderLayout.SOUTH);
        
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
    
    public JPanel insertRadioButtonS(int n, ArrayList<String> s)
    {
        JPanel pannello=new JPanel();
        ButtonGroup gruppo=new ButtonGroup();
        
        int i;
        
        for(i=0;i<n;i++)
        {
                JRadioButton radio=new JRadioButton(s.get(i));
                RadioButtonListener rbl=new RadioButtonListener();
                radio.addActionListener(rbl);
                gruppo.add(radio);
                pannello.add(radio);
                pannello.setLayout(new BoxLayout(pannello, BoxLayout.PAGE_AXIS));
        }
        
        return pannello;
    } 
}
