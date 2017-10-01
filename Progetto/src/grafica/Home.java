package grafica;

import graficaListener.StartHomeButtonListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  La classe Home permette di creare i diversi thread del programma.
 *
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class Home extends JFrame
{
    private JPanel main, north, center, south;
    private JButton start;
    private JLabel testo, seleziona;
    private ImageIcon startIcon;
    
    public Home()
    {
        super("Home");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setHomeLocation();
        setLabels();
        setButton();
        setPanels();
        setMainPanel();
        setResizable(false);
        setContentPane(main);
        setVisible(true);
    }
    
    private void setPanels()
    {
        main = new JPanel(new BorderLayout());
        north = new JPanel(new FlowLayout());
        center = new JPanel(new FlowLayout());
        south = new JPanel(new FlowLayout());
        south.add(start);
        center.add(testo);
    }
    
    private void setMainPanel()
    {
        main.add(north, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);
        main.add(south, BorderLayout.SOUTH);
    }
        
    private void setHomeLocation()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 3, screenHeight / 3);
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
    }
    
    public void setButton(){
        start = new JButton();
        start.setPreferredSize(new Dimension(60, 30));
        StartHomeButtonListener sbl = new StartHomeButtonListener();
        start.addActionListener(sbl);
        setStartIcon();
    }
    
   private void setLabels()
    {
        testo = new JLabel("Per avviare il programma premere il pulsante \">\"");
        testo.setHorizontalAlignment(JLabel.CENTER);
    }

    private void setStartIcon()
    {
        startIcon = new ImageIcon("icon/next.png");
        Image icon = startIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        startIcon.setImage(icon);
        start.setIcon(startIcon);
    }
}
