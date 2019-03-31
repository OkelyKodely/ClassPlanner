package classplanner;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Manager {

    JFrame f = null;
    
    ClassList ca = null;
    
    
    int a = 0;
    
    
    public void setClassList(ClassList cl) {
        ca = cl;
        f = new JFrame("Class List");
        
        f.setLayout(null);
    }
    
    private void applyPanel() {
        JPanel pa = new JPanel();
        
        pa.setLayout(null);

        pa.setBounds(f.getBounds());

        JButton bu = new JButton();
        bu.setText("Exit");
        bu.setBounds(10, 310, 980, 100);
        
        pa.add(bu);
        
        bu.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            public void mousePressed(MouseEvent e) {
            }
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
        });
        
        JLabel la = new JLabel();
        la.setText("sdfa");
        la.setIcon(new javax.swing.ImageIcon(getClass().getResource("banner.jpg")));
        la.setBounds(500, 10, 600, 300);
        pa.add(la);
        
        pa.add(ca.sp);
        
        JTextArea te = new JTextArea();
        te.setBounds(220, 10, 200, 300);
        pa.add(te);

        ca.l.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                try {
                    DataHandler at = new DataHandler();
                    at.connect();
                    at.enable();
                    te.setText(at.getSynopsis(ca.l.getSelectedIndex()+4));
                } catch (SQLException sq) {
                    sq.printStackTrace();
                }
            }
        });
        
        f.add(pa);
    }
    
    public void show() {
        int x = 0; int y = 0;
        int width = 1000; int height = 500;
        f.setBounds(x, y, width, height);
        
        if(a == 0) {
            applyPanel();
        } else {
            a = 1;
        }
                
        f.setVisible(true);
    }
}