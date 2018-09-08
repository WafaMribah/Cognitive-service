package com.FaceDetectionInVideoV2;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

public class getOperationResult {
	public void GetStatus(String oid, String key){
		HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/video/v1.0/operations/"+oid);


            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", key);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();    
            System.out.println(response.toString());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	}

}
