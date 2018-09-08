package com.FaceDetectionInVideoV2;

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

public class getResultJson {
	ArrayList<FacesRectangle> recList = new ArrayList <FacesRectangle>();
	
	
	public ArrayList<FacesRectangle> getRecList() {
		return recList;
	}

	public void setRecList(ArrayList<FacesRectangle> recList) {
		this.recList = recList;
	}	
	
		
	public  ArrayList<FacesRectangle> GetJSON (String oid, String key ) {
		
		Drawing draw = new Drawing();
		
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
					RootObject lcs = gson.fromJson(json , RootObject.class);
		            	System.out.println(lcs);
		  		            		
		            	for (int i = 0; i < lcs.getFragments().size(); i++)
			            {
			            	for (int j=0; j<lcs.getFragments().get(i).getEvents().size(); j++)
			            	{

				            		for(int k=0; k<lcs.getFragments().get(i).getEvents().get(j).size(); k++)
				            		{
				            			    FacesRectangle rec = new FacesRectangle(lcs.getFragments().get(i).getEvents().get(j).get(k).getId(),lcs.getFragments().get(i).getEvents().get(j).get(k).getX(), lcs.getFragments().get(i).getEvents().get(j).get(k).getY(), lcs.getFragments().get(i).getEvents().get(j).get(k).getWidth(), lcs.getFragments().get(i).getEvents().get(j).get(k).getHeight());		            		
							            	recList.add(rec);	
							            								            	
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
}
}
