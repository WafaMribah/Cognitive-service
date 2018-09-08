package com.FaceDetectionInVideoV2;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class ServerReader {
	
	public String read(String UrlRegion, String key, String str) {

		HttpClient httpclient = HttpClients.createDefault();
		String oid="";

        try
        {
            URIBuilder builder = new URIBuilder(UrlRegion);


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);


            // Request body
            StringEntity reqEntity = new StringEntity("{\"url\":\""+str+"\"}");
            
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
    		HttpEntity entity = response.getEntity();
            String responseStr = response.toString();
            System.out.println(responseStr);
    		String oid1= ""+responseStr.substring(201,237);      
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
