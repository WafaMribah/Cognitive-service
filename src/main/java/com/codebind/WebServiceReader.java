package com.codebind;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;


public class WebServiceReader {
	
	
	public HttpEntity read(String UrlRegion, String key, String str) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpEntity entity=null;
        
    try
    {
        URIBuilder uriBuilder = new URIBuilder(UrlRegion);
        
        uriBuilder.setParameter("returnFaceId", "true");
        uriBuilder.setParameter("returnFaceLandmarks", "false");
        uriBuilder.setParameter("returnFaceAttributes", "age");

        URI uri = uriBuilder.build();
        HttpPost request = new HttpPost(uri);

        request.setHeader("Content-Type", "application/json");
        request.setHeader("Ocp-Apim-Subscription-Key", key);
        StringEntity reqEntity = new StringEntity("{\"url\":\""+str+"\"}");
        request.setEntity(reqEntity);

        HttpResponse response = httpClient.execute(request);
        entity = response.getEntity();
        
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }  
    
    return entity; 
}

}
