package interface_graphique;


import java.awt.*;       
import java.awt.event.*;

import javax.swing.JFrame;  
 
// An AWT program inherits from the top-level container java.awt.Frame
public class Fenetre extends JFrame implements ActionListener {
   private TextField user,pssw; // Declare a TextField component 
   private Button btnCnx;   // Declare a Button component
   private Fenetre2 fen;
   // Constructor to setup GUI components and event handlers
   public Fenetre () {
      setLayout(new FlowLayout());
      
      user = new TextField("Entrez votre Username", 20); // construct the TextField component with initial text
      
      user.setEditable(true);      	 // set to read-only
      add(user);                     // "super" Frame container adds TextField component
      
      pssw = new TextField("Entrez votre Mdp", 20); // construct the TextField component with initial text
      pssw.setEditable(true);      	 // set to read-only
      add(pssw);                     // "super" Frame container adds TextField component
 
      btnCnx = new Button("Connexion");   // construct the Button component
      btnCnx.setForeground(Color.BLACK);
      add(btnCnx);                    // "super" Frame container adds Button component
 
      btnCnx.addActionListener(this);
 
      setTitle("ENSUP Identification");  		// "super" Frame sets its title
      this.setSize(600,100);
      this.setLocationRelativeTo(null);
      setVisible(true);         // "super" Frame shows
 
   }

@Override
public void actionPerformed(ActionEvent e) { 
	this.dispose();
    fen = new Fenetre2();
    
}
}