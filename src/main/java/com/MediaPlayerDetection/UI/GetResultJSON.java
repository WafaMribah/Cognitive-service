package com.MediaPlayerDetection.UI;


import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class GetResultJSON {
	
	ArrayList<FaceRectangle> recList = new ArrayList <FaceRectangle>();
	ArrayList<ArrayList<FaceRectangle>> rectFace = new ArrayList<ArrayList<FaceRectangle>>();
	ArrayList<Integer>Interval= new ArrayList<Integer>();
	ArrayList<Integer>Duration= new ArrayList<Integer>();
	
	
	public ArrayList<FaceRectangle> getRecList() {
		return recList;
	}

	public void setRecList(ArrayList<FaceRectangle> recList) {
		this.recList = recList;
	}	
	
	public ArrayList<ArrayList<FaceRectangle>> getRectFace() {
		return rectFace;
	}

	public void setRectFace(ArrayList<ArrayList<FaceRectangle>> rectFace) {
		this.rectFace = rectFace;
	}
	
	//public ArrayList<ArrayList<FaceRectangle>> GetJSON (String oid, String key){  
	public  ArrayList<FaceRectangle> GetJSON (String oid, String key ) {
		
		DrawingComponent draw = new DrawingComponent();
		
		HttpClient httpclient = HttpClients.createDefault();
		
		try
		{
			
		    URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/video/v1.0/operations/"+oid+"/content");
		
		
		    URI uri = builder.build();
		    HttpGet request = new HttpGet(uri);

		    request.setHeader("Ocp-Apim-Subscription-Key",  key);   
		  		
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();          
		
		    if (entity != null) 
		    {
		    	String json;
				try {
					json = EntityUtils.toString(entity);
					System.out.println(json); 
					
	                Gson gson = new Gson();
					ObjDetected lcs = gson.fromJson(json , ObjDetected.class);
		            	System.out.println(lcs);
		            	
		            	/** List of Interval**/
		            	for (int i=0; i<lcs.getFragments().size(); i++){
		            		int interval = lcs.getFragments().get(i).getInterval();
		            		Interval.add(interval);
		            	}
		            	
		            	//draw.setInterval(Interval);
		            	
		            	/**List of duration**/
		            	for (int j=0; j<lcs.getFragments().size(); j++){
		            		int duration=lcs.getFragments().get(j).getDuration();
		            		Duration.add(duration);
		            	}
		            	//draw.setDuration(Duration);

		            		/*FaceRectangle face = new FaceRectangle();
		            		for (int jj=0; jj<lcs.getFacesDetected().size(); jj++)
		            		{
		            			faceId.add(lcs.getFacesDetected().get(jj));
		            		}
		            		face.setFaceId(faceId);
		            		System.out.println(faceId);*/
		            		
		            	for (int i = 0; i < lcs.getFragments().size(); i++)
			            {
			            	for (int j=0; j<lcs.getFragments().get(i).getEvents().size(); j++)
			            	{

				            		for(int k=0; k<lcs.getFragments().get(i).getEvents().get(j).size(); k++)
				            		{
				            			    FaceRectangle rec = new FaceRectangle(lcs.getFragments().get(i).getEvents().get(j).get(k).getId(),lcs.getFragments().get(i).getEvents().get(j).get(k).getX(), lcs.getFragments().get(i).getEvents().get(j).get(k).getY(), lcs.getFragments().get(i).getEvents().get(j).get(k).getWidth(), lcs.getFragments().get(i).getEvents().get(j).get(k).getHeight());		            		
							            	recList.add(rec);	
							            	//rectFace.add(recList);
							            								            	
					            	}
			            	}
			            }
		            	
		            	System.out.println("the content of recList is not empty"); 
		            	
		            } 
				
				catch (IOException e) {
		               e.printStackTrace();
		               System.exit(-1);
		            }
		            
		    }
		}
		catch (Exception e)
		{
		    System.out.println(e.getMessage());
		}
		return recList;
		//return rectFace;
}

}