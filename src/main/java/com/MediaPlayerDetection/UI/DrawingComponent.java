package com.MediaPlayerDetection.UI;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class DrawingComponent extends JPanel implements Runnable {
      
	final static BasicStroke stroke = new BasicStroke(2.0f);
	ArrayList<Integer> Intervals=null;
	ArrayList<FaceRectangle> recList;
	ArrayList<FaceRectangle> recToDisplay = new ArrayList<FaceRectangle>();
	ArrayList<Integer>Interval;
	ArrayList<Integer>Duration;
	private Thread thread;

	
	public void setInterval(ArrayList<Integer> Interval) {
		this.Interval = Interval;
	}

	public void setDuration(ArrayList<Integer> Duration) {
		this.Duration = Duration;
	}
	   
	public void setRecList(ArrayList<FaceRectangle> recList){
		this.recList = recList;
	}
	
	public ArrayList<Integer> GetIntervals(){
		
		System.out.println(Duration);
		System.out.println(Interval);

		for(int ii=0; ii< Duration.size(); ii++){
			
			int duration=Duration.get(ii);
			int interval=Interval.get(ii);
			int counter= duration/interval;
			
			for (int jj=0; jj< counter; jj++){
				Intervals.add(interval);
			}
		}
		return Intervals;
	}
	  	  		
	public void display(){
		this.show();
		//ArrayList<Integer> Interval1 =GetIntervals();
		Iterator<FaceRectangle> itrFace = recList.iterator();
		//Iterator<Integer> itrInteger = Interval1.iterator();
		while(itrFace.hasNext()/*&& itrInteger.hasNext()*/) {
			FaceRectangle rect = (FaceRectangle) itrFace.next();
			recToDisplay.clear();
			recToDisplay.add(rect);
			this.repaint();
				
			try {
				//Thread.sleep((Integer) itrInteger.next());
				Thread.sleep(512);

			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

	/*public void display(){
		this.show();
		
		for(FaceRectangle rect : recList) {
			recToDisplay.clear();
			recToDisplay.add(rect);
			this.repaint();
				
			try {
				Thread.sleep(512);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}*/
	
	public void paintComponent (Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		        RenderingHints.VALUE_ANTIALIAS_ON);
		
		for ( FaceRectangle rec : recToDisplay ){
			System.out.println(rec);	
			g2.setColor(rec.getColor());
			rec.LearningTime();
		    g2.setStroke(stroke);
		    g2.draw(new Rectangle2D.Double((rec.getTop())*1000, (rec.getLeft())*1000, (rec.getWidth())*1000, (rec.getHeight())*1000));		  		        
		}
		
     }



	public void run() {
	   System.out.println("Running ");
			display();
	}
	
	public void start () {
	   System.out.println("Starting ");
	      if (thread == null) {
	    	  thread = new Thread (this);
	    	  thread.start ();
	      }
	   }
}
