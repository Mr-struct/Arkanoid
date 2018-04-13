package Views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Controls.SoundPlay;

@SuppressWarnings("serial")
public class ButtonImage extends JButton implements MouseListener  {
	//les attributs
	private Image defaultImg,enteredImg,clickedImg,disableImg,currentImg; // les images du bouton  pardéfaut et lors du  survole clique de la souris  
	
	protected SoundPlay sound;	 // le son du bouton
	
	/*
	 * le contructeur init le bouton normalement
	 * @param defaultImg l'image par défaut du bouton
	 * @param enteredImg l'image du bouton lors du survole de la souris
	 * @param clickedImg l'image du bouton lors du clique de la souris
	 * @param SoundPlay le son du bouton
	 */
	public ButtonImage(Image defaultImg, Image enteredImg, Image clickedImg,SoundPlay sound) {
		
		this.currentImg = defaultImg;
		
		this.defaultImg = defaultImg;
		
		this.enteredImg = enteredImg;
		
		this.clickedImg = clickedImg;
		
		this.setFocusPainted(false); // désactive le carré qui entoure le bouton lors du clique
		
		this.setBorderPainted(false); // désactive le bord du bouton 
		
		this.setOpaque(false); // désactive l'opacitée du bouton 
		
		this.setContentAreaFilled(false); // désactive le fond du bouton

		this.sound = sound;
		
		this.sound.setPnogrameChange(4); // le son est init avec le canal 4 du system mid
		
		this.addMouseListener(this);
		

	}
	
	/*
	 * le contructeur init le bouton qui peut etre désactivé
	 * @param defaultImg l'image par défaut du bouton
	 * @param enteredImg l'image du bouton lors du survole de la souris
	 * @param clickedImg l'image du bouton lors du clique de la souris
	 * @param disableImg l'image lorsque le bouton est désactivé
	 * @param SoundPlay le son du bouton
	 */
	public ButtonImage(Image defaultImg, Image enteredImg, Image clickedImg, Image disableImg,SoundPlay sound) {
		
		this.currentImg = defaultImg;
		
		this.defaultImg = defaultImg;
		
		this.enteredImg = enteredImg;
		
		this.clickedImg = clickedImg;
		
		this.disableImg = disableImg;
		
		setFocusPainted(false);
		
		setBorderPainted(false);
		
		setOpaque(false);
		
		setContentAreaFilled(false);

		this.sound = sound;
		
		this.sound.setPnogrameChange(4);
		
		this.addMouseListener(this);
		

	}
	//on désactive le paintComponent pour déssiner notre propre bouton avec nos propre options
	public void paintComponent(Graphics g){
	}
	
	/*
	 * déssine le bouton avec des coordonnée compatible avec le scale du parent 
	 * @param x la position x du bouton 
	 * @param y la position y du bouton
	 * @param width la largeur du bouton
	 * @param height la hauteur du bouton
	 * @param scaleX le scale x selon le scale x du parent
	 * @param scaleY le scale y selon le scale y du parent
	 * @param g2d le graphique associeer
	 */
	public void drawButton(int x , int y, int width, int height,float  scaleX,float scaleY ,Graphics2D g2d){

			this.setBounds( (int)(scaleX*x), (int) (scaleY*y), (int) (scaleX*width), (int)(scaleY*height));	// mis en place du bouton avec le bon x, y ...
			
			if(!this.isEnabled()) { // on test si le bouton est désactivé pour metre à jour l'image par défaut 
				
				currentImg = disableImg;
				
			}
			
			g2d.drawImage(currentImg, x, y, width, height, null); // dessine l'image du bouton
			
	}
	/*
	 * fonction appler depuis l'éxterieur pour metre à jour l'image du bouton 
	 */
	public void updateImg() {
		
		this.currentImg = this.defaultImg;
		
	}
	
	@Override
	//lors du survole sortant de la souris l'image est mise à jour et le parent est repaint
	public void mouseExited(MouseEvent me) {
		
		currentImg  = defaultImg;
		
		this.getParent().repaint();
	
    }
	@Override
	//lors du survole entrant de la souris l'image est mise à jour et le parent est repaint

    public  void mouseEntered(MouseEvent me) {	
		
    	currentImg  = enteredImg;
    	
    	this.getParent().repaint();
    	
    	sound.note_on(67); // joue du son
          
           
    }
    
    @Override
	//lors du clique entrant de la souris l'image est mise à jour et le parent est repain

    public void mousePressed(MouseEvent me)
    {
    	currentImg = clickedImg;
    	
    	this.getParent().repaint();
    	
    	sound.note_on(67); //joue du son
    	
    }
	
	@Override
	//lors du clique sortant de la souris l'image est mise à jour et le parent est repain

	public void mouseReleased(MouseEvent arg0) {
		
		currentImg = defaultImg;
		
		this.getParent().repaint();
		
		sound.note_on(67);//joue du son
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	

}

