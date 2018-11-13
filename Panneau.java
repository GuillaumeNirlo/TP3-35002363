//NIRLO GUILLAUME
//35002363

import java.awt.*;
import javax.swing.*;
import java.util.*;
 
public class Panneau extends JPanel {
	  
	  //Déclaration variable 
	  private int posX = -50;
	  private int posY = -50;
	  private int size = 50;
	  ArrayList<Balle> listBall = new ArrayList<Balle>();
	  public static int Score;
	  
	  //Constructeur de la Classe Panneau
	  public Panneau() {
		  
		  Score=0;
		  
	  }

	  //Méthode
	  public void paintComponent(Graphics g){
	    g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	    if(listBall.size()>0) {
	    	for(int i=0; i<listBall.size(); i++) {
	    		listBall.get(i).paintComponent(g);
	    	}	
	    }  
	  }
	  
	   
	 // Méthode qui gère le déplacement et les rebondissements de la balle
	 public void mvt() {
		
		 //System.out.println("list"+listBall.size());
		  for(int i=0; i<listBall.size();i++) { 
			  System.out.println("x="+listBall.get(i).posX);
			  System.out.println("y="+listBall.get(i).posY);
			 
			  
			  listBall.get(i).posX+=listBall.get(i).vx;
			  listBall.get(i).posY+=listBall.get(i).vy;
			  
			  if(listBall.get(i).posX < 1) {
				  System.out.println("x<");
				  //listBall.get(i).posX+=1;
				  listBall.get(i).vx = 1;
			  }

			   
			  if(listBall.get(i).posX > getWidth()-listBall.get(i).getsize()) {
				  System.out.println("x>");
				  //listBall.get(i).posX -=1;
				  listBall.get(i).vx=-1;
			  }

			    
			  if(listBall.get(i).posY  < 1) {
				  System.out.println("y<");
				  //listBall.get(i).posY +=1;
				  listBall.get(i).vy=1;
			  }
			  
			  if(listBall.get(i).posY >= getHeight()-listBall.get(i).size) {
				  System.out.println("y>");
				  //listBall.get(i).posY -=1;
				  listBall.get(i).vy=-1;
			  }
		  }
			  
		  
	  }
	  
	  // Méthode qui permet d'ajouter plusieurs Balle
	  public void addBall() {
		  Balle b = new Balle();
		  // min = 0;
		  int maxX = this.getWidth() ;
		  int maxY = getHeight()-b.size;
		  
		  b.posX = 0 +(int)(Math.random() * ((maxX -0) + 1));
		  b.posY = 0 + (int)(Math.random() * ((maxY -0) + 1));
		  
		  listBall.add(b);
		
	  }
	  
	  // Méthode qui permet de supprimer les balles
	  public void suppBall() {
		  if(listBall.size() >0) 
		  {
			 listBall.remove(listBall.size()-1);
		  }
	  }
	  
	  // Méthode qui gère la collision de deux balle
	  public void Collision() {
		    for(int i = 0; i< listBall.size(); i++) {
		        for(int j = 0; j< listBall.size(); j++) {
		            Balle ball1 = listBall.get(i);
		            double ball1x = ball1.getPosX();
		            double ball1y = ball1.getPosY();
		            double ball1s = ball1.getsize();
		            Balle ball2 = listBall.get(j);
		            double ball2x = ball2.getPosX();
		            double ball2y = ball2.getPosY();
		            double ball2s = ball2.getsize();
		            double dx = ball2x - ball1x;
		            double dy = ball2y - ball1y;
		            double distance = Math.sqrt(dx * dx + dy * dy);
							
		            if(distance < ball2s + ball1s && i!=j) { 
		                listBall.remove(j);
		                listBall.remove(i);
		                Score++;
		                break;
		            }
		        }
		    }	
		}
	  
	  // Méthode qui incrémente le score de 1 à chaque collision
	  public int Score() {
		  return Score;
	  }
	}
	  

