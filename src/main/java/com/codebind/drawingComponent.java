package com.codebind;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class drawingComponent extends JPanel {

	//private final static String PATH = "http://data2.archives.ca/ap/a/a146456.jpg";
	  
		private static String PATH;
		
		public String getPATH() {
			return PATH;
		}

		public void setPATH(String PATH) {
			this.PATH = PATH;
		}

	   private BufferedImage backgroundImg;
	   private int prefW;
	   private int prefH;
   
	   public  drawingComponent(String PATH) throws IOException {
		      URL imgUrl = new URL(PATH);
		      BufferedImage bImg = ImageIO.read(imgUrl);
		      prefW = bImg.getWidth();
		      prefH = bImg.getHeight();
		      backgroundImg = new BufferedImage(prefW, prefH,
		            BufferedImage.TYPE_INT_ARGB);
		      Graphics g = backgroundImg.getGraphics();
		      g.drawImage(bImg, 0, 0, this);
		      g.dispose();
		   }
	   
	   
	public void setRecList(ArrayList<FaceRectangle> recList){
		this.recList = recList;
	}

	ArrayList<EmotionScores> EmotionList;
	
	public void setEmotionScores(ArrayList<EmotionScores> EmotionList){
		this.EmotionList = EmotionList;
	}

	ArrayList<FaceRectangle> recList;
	
	
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		if (backgroundImg != null) {
	         g.drawImage(backgroundImg, 0, 0, this);
	      }
		Iterator<FaceRectangle> itrFace = recList.iterator();
		Iterator<EmotionScores> itrEmotion = EmotionList.iterator();

		while(itrFace.hasNext() && itrEmotion.hasNext()) {
			Graphics2D g2 = (Graphics2D) g;	
			FaceRectangle rec = (FaceRectangle) itrFace.next();
	        Rectangle rect = new Rectangle(rec.getLeft(), rec.getTop(), rec.getWidth(), rec.getHeight());
	        g.setColor(Color.white);
	        g.drawRect(rec.getTop(), rec.getLeft(), rec.getWidth(), rec.getHeight());	
	        EmotionScores scores =(EmotionScores) itrEmotion.next();
			g.drawString("anger="+scores.getAnger(), rec.getTop(), rec.getLeft()+rec.getHeight()+10);
			g.drawString("happiness="+scores.getHappiness(), rec.getTop(), rec.getLeft()+rec.getHeight()+25);
			g.drawString("neutral="+scores.getNeutral(), rec.getTop(), rec.getLeft()+rec.getHeight()+40);
			g.drawString("sadness="+scores.getSadness(), rec.getTop(), rec.getLeft()+rec.getHeight()+55);
			g.drawString("surprise="+scores.getSurprise(), rec.getTop(), rec.getLeft()+rec.getHeight()+70);

		}
 		
       }
}
