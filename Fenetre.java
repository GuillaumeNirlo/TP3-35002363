//NIRLO GUILLAUME
//35002363


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Fenetre extends Thread{
	  //Déclaration variable
	  Panneau pan = new Panneau();
	  private JFrame fenetre = new JFrame();
	  
	  private JPanel container = new JPanel();
	  private JPanel contbout = new JPanel();
	  private JPanel info = new JPanel();
	  
	  private JLabel score = new JLabel("  Score :  0 ");
	  private JLabel tmp = new JLabel("  Temps :  En Attente de lancement ");
	  
	  private JButton start = new JButton(" START ");
	  private JButton stop = new JButton("  STOP ");
	  private JButton plus = new JButton("   +   ");
	  private JButton moins = new JButton("   -   ");
	  
	  private static int seconde=0;
	  Timer t;
	  
	  Thread t1;
	  
	  // Constructeur
	  public Fenetre() {
		  
		    fenetre.setTitle("Animation : Balle en mouvements");
		    fenetre.setSize(800, 800);
		    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    fenetre.setLocationRelativeTo(null);
		    container.setBackground(Color.white);
		    container.setLayout(new BorderLayout());
		    
		    start.addActionListener(new BoutonStart());
		    stop.addActionListener(new BoutonStop());
		    plus.addActionListener(new BoutonPlus());
		    moins.addActionListener(new BoutonMoins());
		    
		    contbout.setLayout(new FlowLayout());
		    contbout.add(start);
		    contbout.add(stop);
		    contbout.add(plus);
		    contbout.add(moins);
		    container.add(contbout, BorderLayout.SOUTH);
		    
		    info.setLayout(new BorderLayout());
		    Font police = new Font("Tahoma", Font.BOLD, 16);
		    score.setFont(police);
		    tmp.setFont(police);
		    
		    score.setForeground(Color.blue);
		    tmp.setForeground(Color.blue);
		    
		    info.add(score, BorderLayout.WEST);
		    info.add(tmp, BorderLayout.EAST);
		    
		    container.add(info, BorderLayout.NORTH);
		    fenetre.setContentPane(container);
		    fenetre.setVisible(true);
		    
		    
	  }
	  
	  public void run() {
		  while(true) {
			 pan.mvt();
			 pan.Collision();
			 score.setText("Score : "+Panneau.Score);
			 container.add(pan);
			 container.repaint();
			 
			 try {
				   Thread.sleep(1);
				} catch (InterruptedException e) {
				    //e.printStackTrace();
			}
			 
			 //fenetre.setContentPane(container);
		  }
		  
	  }
	  
	// Classe qui gère l'évènement du Bouton "START"
	  class BoutonStart implements ActionListener{
		    
		    public void actionPerformed(ActionEvent e) {
		    	t=new Timer(1000, new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    			
				         seconde++;
				         tmp.setText("Temps : "+seconde+" s ");
					 }
				 } ); 
		    	t.start();
		    }
	  }
	  
	// Classe qui gère l'évènement du Bouton "STOP"
	  class BoutonStop implements ActionListener{
		    
		    public void actionPerformed(ActionEvent e) {
		    	t.stop();
		    	
		    	
		    }
	  } 
	  
	// Classe qui gère l'évènement du Bouton "+"
	  class BoutonPlus implements ActionListener{
		    
		    public void actionPerformed(ActionEvent e) {
		    	
		    	pan.addBall();
		    	container.add(pan, BorderLayout.CENTER);
		    	fenetre.setContentPane(container);
		    	
		    	
		    }
	  } 
	  
	  // Classe qui gère l'évènement du Bouton "-"
	  class BoutonMoins implements ActionListener{
		    
		    public void actionPerformed(ActionEvent e) {
		    	
		    	pan.suppBall();
		    	container.add(pan, BorderLayout.CENTER);
		    	fenetre.setContentPane(container);
		    	
		    }
	  }  

}
