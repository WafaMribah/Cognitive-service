package com.EmotionDetectionInVideo;


import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;


public class ServerReader 
{
	public String read(String UrlRegion, String key) 
    {
		String oid="";

        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder(UrlRegion);

            builder.setParameter("outputStyle", "aggregate");
            

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);


            // Request body
            StringEntity reqEntity = new StringEntity("{\"url\":\"http://referencestream-samplestream.streaming.mediaservices.windows.net/ad6e24a2-4f9c-46ee-9fa7-bf05e20d19ac/dance_redacted1.mp4\"}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            
            request.setEntity(reqEntity);

           
            String responseStr = response.toString();
            System.out.println(responseStr);
    		String oid1= ""+responseStr.substring(203,239);      
            System.out.println(oid1);
            oid=oid1;
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return oid; 

    }
}

