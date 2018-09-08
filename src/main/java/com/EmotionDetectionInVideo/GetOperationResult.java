package com.EmotionDetectionInVideo;


import java.io.IOException;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetOperationResult 
{
	public void GetStatus(String oid, String key){

		HttpClient httpclient = HttpClients.createDefault();

        try
        {
		    URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/emotion/v1.0/operations/"+oid);


            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();    
            System.out.println(response.toString());
            
            if (entity != null) 
		    {
		    	String json;
				try {
					json = EntityUtils.toString(entity);
					System.out.println(json); 
			     
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
    }
}

