import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class PanelSettings extends JPanel{
	private Image imgBackground;
	private ImageIcon picBackGround;
	private Font firstWord;
	private Vue vue;


	PanelSettings(int width, int height ,Vue vue) {

		super();

		this.vue = vue;

		this.setSize(width,height);

		try {
			firstWord = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/Streamster.ttf")).deriveFont(40f);

		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//init les image 
		try {
			this.imgBackground = ImageIO.read(new File("./Obj/Menu.jpg"));
			this.picBackGround =  new ImageIcon("./Obj/param.gif");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * init le button de retour
		 */
		this.add(this.vue.backButtonSetting);
		/*
		 * init le slider du son principale 
		 */

		vue.sliderMainSound.setUI(new Slider(vue.sliderMainSound));
		vue.sliderMainSound.setMinorTickSpacing(5);
		vue.sliderMainSound.setMajorTickSpacing(20);
		vue.sliderMainSound.setPaintTicks(true);
		vue.sliderMainSound.setPaintLabels(true);
		vue.sliderMainSound.setLabelTable(vue.sliderMainSound.createStandardLabels(10));
		vue.sliderMainSound.setBackground(new Color(255,255,255,0));
		vue.sliderMainSound.setForeground(new Color(255,255,255));
		this.add(vue.sliderMainSound);

		/*
		 * init le slider des bruitage
		 */

		vue.sliderFxSound.setUI(new Slider(vue.sliderFxSound));
		vue.sliderFxSound.setMinorTickSpacing(5);
		vue.sliderFxSound.setMajorTickSpacing(20);
		vue.sliderFxSound.setPaintTicks(true);
		vue.sliderFxSound.setPaintLabels(true);
		vue.sliderFxSound.setLabelTable(vue.sliderMainSound.createStandardLabels(10));
		vue.sliderFxSound.setBackground(new Color(255,255,255,0));
		vue.sliderFxSound.setForeground(new Color(255,255,255));
		this.add(vue.sliderFxSound);


		//init le slider du niveau de dificultée

		vue.sliderLevel.setUI(new Slider(vue.sliderLevel));
		vue.sliderLevel.setMinorTickSpacing(5);
		vue.sliderLevel.setMajorTickSpacing(50);
		vue.sliderLevel.setPaintTicks(true);
		vue.sliderLevel.setPaintLabels(true);
		vue.sliderLevel.setLabelTable(vue.sliderLevel.createStandardLabels(50));
		vue.sliderLevel.setBackground(new Color(255,255,255,0));
		vue.sliderLevel.setForeground(new Color(255,255,255));
		this.add(vue.sliderLevel);

	}

	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D)g;
		AffineTransform tx = new AffineTransform();
		AffineTransform oldTransform = new AffineTransform();
		oldTransform = g2d.getTransform();
		tx.scale((float) this.getWidth()/ (float)vue.modele.gameWidth, (float) this.getHeight()/ (float)vue.modele.gameHeight);
		g2d.setTransform(tx);
		//dessine le fond 
		g2d.drawImage(picBackGround.getImage(), 0, 0,vue.modele.gameWidth, vue.modele.gameHeight,null);
		//de la transparance sur les coter de la fenaitre pour un effet !
		Color transparentColor1 = new Color(59, 59, 112, 128);
		Color transparentColor2 = new Color(159, 59, 240,255);

		//dégradé1 de couleur
		GradientPaint gp0 = new GradientPaint(vue.modele.gameWidth-100, 0, transparentColor1,vue.modele.gameWidth - 100, vue.modele.gameHeight, transparentColor2, true);                
		g2d.setPaint(gp0);
		g2d.fillRect(100, 0, vue.modele.gameWidth - 200, vue.modele.gameHeight);
		
		//g2d.setTransform(tx);
		//dessines les labeles
		
		g2d.setColor(new Color(5, 234, 255));
		g2d.setFont(firstWord);
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawString("Music : ", vue.modele.gameWidth / 2 - 400, vue.modele.gameHeight / 2 - 200);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawString("Fx Sound : ", vue.modele.gameWidth / 2 - 400, vue.modele.gameHeight / 2 - 120);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawString("Difficulty : ", vue.modele.gameWidth / 2 - 400, vue.modele.gameHeight / 2 - 40);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);


		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		if(vue.sliderLevel.getValue() >= 0 && vue.sliderLevel.getValue()<=20) {

			g2d.drawString("Grany Mode " + (vue.modele.levelDifficulty*10-10) +"%", vue.modele.gameWidth / 2, vue.modele.gameHeight / 2 + 80 );

		}else if(vue.sliderLevel.getValue()>20 && vue.sliderLevel.getValue()<=40) {

			g2d.drawString("Easy " + (vue.modele.levelDifficulty*10-10)+"%", vue.modele.gameWidth / 2, vue.modele.gameHeight / 2 + 80 );

		}else if(vue.sliderLevel.getValue()>40 && vue.sliderLevel.getValue()<=60) {

			g2d.drawString("Normal " +(vue.modele.levelDifficulty*10-10)+"%", vue.modele.gameWidth / 2, vue.modele.gameHeight / 2 + 80 );
		}
		else if(vue.sliderLevel.getValue()>60 && vue.sliderLevel.getValue()<=80) {

			g2d.drawString("Hard " + (vue.modele.levelDifficulty*10-10)+"%", vue.modele.gameWidth / 2, vue.modele.gameHeight / 2 + 80 );
		}
		else if(vue.sliderLevel.getValue()>80 && vue.sliderLevel.getValue()<=100) {

			g2d.drawString("God Mode " + (vue.modele.levelDifficulty*10-10)+"%", vue.modele.gameWidth / 2, vue.modele.gameHeight / 2 + 80 );
		}
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);

		g2d.setTransform(oldTransform);
		// dessine les sliders
		vue.sliderMainSound.paintImmediately(this.getWidth()/2-200, this.getHeight()/2-220, this.getWidth()/2, 50);
		vue.sliderMainSound.setBounds(this.getWidth()/2-200, this.getHeight()/2-220, this.getWidth()/2, 50);
		vue.sliderFxSound.setBounds(this.getWidth()/2-200, this.getHeight()/2-140,  this.getWidth()/2, 50);
		//dessine le slider pour le niveau de dificulté 
		vue.sliderLevel.setBounds(this.getWidth()/2-200, this.getHeight()/2-60  ,  this.getWidth()/2, 50);
		// dessine le bouton
		this.vue.backButtonSetting.setBounds(this.getWidth()/2-400 , this.getHeight()-200,64,64);
	}

	// class interne qui redefinie le slider
	public class Slider extends BasicSliderUI {

		public Slider(JSlider b) {
			super(b);
		}

		@Override
		public void paintTrack(Graphics g) {

			Graphics2D g2d = (Graphics2D) g;
			//c.getParent();
			Rectangle r = trackRect;
			GradientPaint gp = new GradientPaint(r.x, r.y,new Color(5, 234, 255) ,r.x + r.width, r.y + r.height,new Color(119, 19, 103));
			g2d.setPaint(gp);
			g.fillRect(r.x, r.y, r.width, r.height);
		}
		@Override
		public void paintThumb(Graphics g) {
			super.paintThumb(g);
		}
	}



}
