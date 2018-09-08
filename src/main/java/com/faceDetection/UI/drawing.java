package com.faceDetection.UI;

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
import javax.swing.JPanel;

import com.codebind.FaceRectangle;

public class drawing extends JPanel{

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
	   
		   public  drawing(String PATH) throws IOException {
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

		ArrayList<FaceRectangle> recList;
		
		
		
		public void paintComponent (Graphics g){
			super.paintComponent(g);
			if (backgroundImg != null) {
		         g.drawImage(backgroundImg, 0, 0, this);
		      }
			Iterator<FaceRectangle> itrFace = recList.iterator();

			while(itrFace.hasNext() ) {
				Graphics2D g2 = (Graphics2D) g;	
				FaceRectangle rec = (FaceRectangle) itrFace.next();
		        Rectangle rect = new Rectangle(rec.getLeft(), rec.getTop(), rec.getWidth(), rec.getHeight());
		        g.setColor(Color.RED);
		        g.drawRect(rec.getTop(), rec.getLeft(), rec.getWidth(), rec.getHeight());	
		       
			}
	 		
	       }
}
