//NIRLO GUILLAUME
//35002363

import java.awt.*;
import java.util.*;

public class Balle {
	  //Déclaration variable
	  int posX;
	  int posY;
	  int size;
	  int vx;
	  int vy;
	  private Color randomColor;
	  Random rand = new Random();
	  float r = rand.nextFloat();
	  float g = rand.nextFloat();
	  float b = rand.nextFloat();
	  
	  // Constructeur
	  public Balle() {
		  posX = 0;
		  posY = 0;
		  vx=1;
		  vy=1;
		  size = 50;
		  randomColor = new Color(r, g, b);
	  }
	  
	  //Méthode 
	  public int getPosX() {
		  return posX;
	  }

	  public void setPosX(int posX) {
		  this.posX = posX;
	  }

	  public int getPosY() {
		  return posY;
	  }

	  public void setPosY(int posY) {
		  this.posY = posY;
	  }
		  
	  public void setsize(int size) {
		  this.size = size;
	  }
		  
	  public int getsize() {
		  return size;
	  }
		  
	  public Color getColor() {
		  return randomColor;
	  }
		 
	  public void paintComponent(Graphics g) {
		  g.setColor(randomColor);
		  g.fillOval(posX, posY, size, size );
	  }
}
