package progetto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Grafica extends JFrame {

    private Dimension screenSize;
    private JButton back, next, inizia;
    private JRadioButton sceltaA, sceltaB, sceltaC, sceltaD;
    private ButtonGroup scelte;
    private JComboBox elenco, modelli;
    private JLabel welcome, select, domanda;
    private JPanel north, west, center, east, south;
    private Font fontBenvenuto, fontSelect, fontDomanda, fontScelta;

    public Grafica() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        fontBenvenuto = new Font("Times New Romans", Font.BOLD, 14);
        fontSelect = new Font("Times New Romans", Font.PLAIN, 12);
        fontDomanda = new Font("Times New Romans", Font.BOLD, 24);
        createFrame();
    }

    private void createFrame() {
        setTitle("Risolutore di Problemi");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(getCenter(screenSize));
        setLayout(new BorderLayout());
        setResizable(false);

        north = new JPanel(new GridLayout(4, 1));
        west = new JPanel();
        center = new JPanel(new GridLayout(3, 1, 30, 10));
        east = new JPanel();
        south = new JPanel(new FlowLayout());

        /*welcome = new JLabel("Benvenuto nel Risolutore Problemi");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setFont(fontBenvenuto);
        select = new JLabel("Seleziona l'elettrodomestico e il modello in tuo possesso");
        select.setHorizontalAlignment(JLabel.CENTER);
        select.setFont(fontSelect);

        elenco = new JComboBox(getElenco());
        modelli = new JComboBox(getModello());
        modelli.setEnabled(false);
        
        inizia = new JButton("Inizia");
*/
        domanda = new JLabel("Domanda");
        domanda.setHorizontalAlignment(JLabel.CENTER);
        domanda.setFont(fontDomanda);

        sceltaA = new JRadioButton("Scelta A");
        sceltaB = new JRadioButton("Scelta B");
        sceltaC = new JRadioButton("Scelta C");
        sceltaD = new JRadioButton("Scelta D");

        back = new JButton("Indietro");
        next = new JButton("Avanti");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        north.add(new JLabel(""));
        north.add(welcome);
        north.add(select);
        center.add(new JLabel("Elettrodomestico"));
        center.add(new JLabel("Modello"));
        center.add(elenco);
        center.add(modelli);
        south.add(inizia);

        add(north, BorderLayout.NORTH);
        add(west, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        add(east, BorderLayout.EAST);
        add(south, BorderLayout.SOUTH);

        setVisible(true);
    }

    public Point getCenter(Dimension d) {
        return new Point((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
    }

    private String[] getElenco() {
        String lista[] = new String[10];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = "Elettrodomestico " + (i + 1);
        }

        return lista;
    }

    private String[] getModello() {
        String lista[] = new String[10];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = "Modello " + (i + 1);
        }

        return lista;
    }
}
