package com.faceDetection.UI;

import com.Chart.UI.PieChartEmotionInImage;
import com.codebind.*;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import com.codebind.WebServiceReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class GuiApp {

	/**
	 * @param args
	 */
	private String str;
	
	ArrayList<FaceRectangle> recList = new ArrayList <FaceRectangle>();
	
	ArrayList<EmotionScores> EmotionList = new ArrayList <EmotionScores>();

	
	public ArrayList<FaceRectangle> getRecList() {
		return recList;
	}

	public void setRecList(ArrayList<FaceRectangle> recList) {
		this.recList = recList;
	}
	
	
	
	public ArrayList<EmotionScores> getEmotionList() {
		return EmotionList;
	}

	public void setEmotionList(ArrayList<EmotionScores> EmotionList) {
		this.EmotionList = EmotionList;
	}

	@Override
	public String toString() {
		return "GuiApp [recList=" + recList + "]";
	}

	/*public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}*/

	public GuiApp(String str) {
		this.str=str;
	}

	public void display(HttpEntity entity) throws Exception{
		Image image;
		
		
		drawingComponent frame = new drawingComponent(str);
		PieChartEmotionInImage pie = new PieChartEmotionInImage();
        frame.setSize(600, 600);
                
    	System.out.println("image displayed");
    	        
         if (entity != null)
        {       	                
            String json;
			try {
				json = EntityUtils.toString(entity);
				System.out.println(json);     
	            Gson gson = new Gson();   
	            List <FaceObj> faceObj= gson.fromJson(json, new TypeToken<List<FaceObj>>(){}.getType());
	            for (FaceObj item : faceObj ){
	            	System.out.println(item);
	            	FaceRectangle rec = new FaceRectangle(item.getFaceRectangle().getLeft(), item.getFaceRectangle().getTop(), item.getFaceRectangle().getWidth(), item.getFaceRectangle().getHeight());
	            	EmotionScores scores= new EmotionScores(item.getScores().getAnger(), item.getScores().getContempt(),item.getScores().getDisgust(), item.getScores().getFear(), item.getScores().getHappiness(), item.getScores().getNeutral(), item.getScores().getSadness(), item.getScores().getSurprise());
	            	System.out.println(rec);
	            	System.out.println(scores);
	            	recList.add(rec);
	            	EmotionList.add(scores);
	            	}
	            frame.setRecList(recList);
	            frame.setEmotionScores(EmotionList);
	            pie.setEmotionScores(EmotionList);
	            frame.setVisible(true);
	            
	           /* drawingComponent mainPanel = null;
	            try {
	               mainPanel = new drawingComponent(str);
	            } catch (IOException e) {
	               e.printStackTrace();
	               System.exit(-1);
	            }*/
	            
	            JFrame f = new JFrame();
	            f.setSize(1000, 1000);	            
	            f.setVisible(true);
	            f.getContentPane().add(frame); 
	            pie.PieChartImgAnalyze();

	            }
			
	            catch (Exception e) {
				e.printStackTrace();
	            }
                 
        }
	
	}
}
