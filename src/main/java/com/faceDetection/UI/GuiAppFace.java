package com.faceDetection.UI;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import com.codebind.FaceObj;
import com.codebind.FaceRectangle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GuiAppFace {
	
	/**
	 * @param args
	 */
	private String str;
	
	ArrayList<FaceRectangle> recList = new ArrayList <FaceRectangle>();
	
	public ArrayList<FaceRectangle> getRecList() {
		return recList;
	}

	public void setRecList(ArrayList<FaceRectangle> recList) {
		this.recList = recList;
	}
	

	@Override
	public String toString() {
		return "GuiApp [recList=" + recList + "]";
	}


	public GuiAppFace(String str) {
		this.str=str;
	}

	public void display(HttpEntity entity) throws Exception{
		Image image;
				
		drawing frame = new drawing(str);
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
	            	System.out.println(rec);
	            	recList.add(rec);
	            	}
	            frame.setRecList(recList);
	            frame.setVisible(true);
	            	            
	            JFrame f = new JFrame();
	            f.setSize(1000, 1000);
	            
	            f.setVisible(true);
	            f.getContentPane().add(frame); 
	            }
			
	            catch (Exception e) {
				e.printStackTrace();
	            }
                 
        }
	
	}
}
