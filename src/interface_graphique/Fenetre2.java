package interface_graphique;
import service.* ;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Etudiant;

import javax.swing.BoxLayout;

public class Fenetre2 extends JFrame implements ActionListener  {
      
	private static final long serialVersionUID1 = 1L;
	
	private static final long serialVersionUID = -4721124658632373556L;
		private JButton btnAff = new JButton("Liste Etudiant");
        private TextArea fieldAff = new TextArea("",100,100); 
        private JPanel panel = new JPanel();
        private BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
   
        public Fenetre2(){
        	panel.setLayout(boxLayout);
            btnAff.setAlignmentX(CENTER_ALIGNMENT);
            btnAff.addActionListener(this);
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
     }
        
        
        @Override
        public void actionPerformed(ActionEvent e) { 
        	ArrayList <Etudiant> le = new EtudiantService().lireEtudiants();
        	String resultat = "La liste des étudiants :  \r\n";
        	for (Etudiant etudiant : le) {
				resultat = resultat + etudiant.getNom() + " " + etudiant.getPrenom()+ " \r\n ";
			}
        	fieldAff.setText(resultat);
        	System.out.println(resultat);
        }
}
