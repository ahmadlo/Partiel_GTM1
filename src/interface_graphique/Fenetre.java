package interface_graphique;


import java.awt.*;       
import java.awt.event.*;

import javax.swing.JFrame;  
 

public class Fenetre extends JFrame implements ActionListener {
   private TextField user,pssw; 
   private Button btnCnx;  
   private Fenetre2 fen;
   
   public Fenetre () {
      setLayout(new FlowLayout());
      
      user = new TextField("Entrez votre Username", 20); 
      user.setBackground(Color.WHITE);
      user.setEditable(true);      	
      add(user);                     
      
      pssw = new TextField("Entrez votre Mdp", 20); 
      pssw.setBackground(Color.WHITE);
      pssw.setEditable(true);     
      add(pssw);                    
 
      btnCnx = new Button("Connexion");   
      btnCnx.setForeground(Color.BLACK);
      add(btnCnx);                   
 
      btnCnx.addActionListener(this);
 
      setTitle("ENSUP Identification");  	
      
      this.setSize(600,100);
      this.setLocationRelativeTo(null);
      setVisible(true);        
 
   }

@Override
public void actionPerformed(ActionEvent e) { 
	this.dispose();
    fen = new Fenetre2();
    
}
}