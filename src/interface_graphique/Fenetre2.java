package interface_graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class Fenetre2 extends JFrame implements ActionListener  {
		
      //  private JPanel pan = new JPanel();
     //   private JLabel label = new JLabel();
        private JButton btnAff = new JButton("Liste Etudiant");
        private TextField fieldAff = new TextField("",100); 
        private JPanel panel = new JPanel();
        private BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
   
        public Fenetre2(){
        	panel.setLayout(boxLayout);
            btnAff.setAlignmentX(CENTER_ALIGNMENT);
            panel.add(btnAff);
            panel.add(fieldAff);
            fieldAff.setBackground(Color.WHITE);
            fieldAff.setEditable(false);  
            panel.setAlignmentX(CENTER_ALIGNMENT);
            add(panel);
            setSize(300, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
                         
        
            
        this.setVisible(true);                             
     }
        
        
        @Override
        public void actionPerformed(ActionEvent e) { 
        
            
        }
}
