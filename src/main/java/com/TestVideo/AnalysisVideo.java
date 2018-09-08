package com.TestVideo;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.Chart.UI.PieChart;
import com.MediaPlayerDetection.UI.FaceRectangle;
import com.MediaPlayerDetection.UI.GetOperationResult;
import com.MediaPlayerDetection.UI.GetResultJSON;
import com.MediaPlayerDetection.UI.serverReader;

public class AnalysisVideo {
	final static Logger logger = Logger.getLogger(AnalysisVideo.class);
    static ArrayList<FaceRectangle> recList;
    
	
	public  ArrayList<FaceRectangle> Analyze(String str){
		 BasicConfigurator.configure();	    
		    
	    	serverReader webServiceReading = new serverReader();
			String UrlRegion= "https://westus.api.cognitive.microsoft.com/video/v1.0/trackface";
			String key="39f93b4661ec4329ad8946e88301a445";
			//String str="http://referencestream-samplestream.streaming.mediaservices.windows.net/ad6e24a2-4f9c-46ee-9fa7-bf05e20d19ac/dance_redacted1.mp4";
			String oid=webServiceReading.read(UrlRegion, key, str);
			try 
			{
			   Thread.sleep(20000);
			} 
			catch (InterruptedException e) 
			{
			   e.printStackTrace();
			}
			
			GetOperationResult status = new GetOperationResult();
			status.GetStatus(oid, key);
			try 
			{
			   Thread.sleep(50000);

			} 
			catch (InterruptedException e) 
			{
			   e.printStackTrace();
			}
			
			GetResultJSON fileJSON = new GetResultJSON();
			recList= fileJSON.GetJSON(oid, key);
			
			return recList;
	}

}
