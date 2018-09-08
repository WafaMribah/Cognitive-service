package com.KeyPhrasesInterpretation;

import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class KeyPhrasesServer 
{
    public void load(String str, String lang) 
    {
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/text/analytics/v2.0/keyPhrases");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "357291169f134c20a3337320f4c838c1");


            // Request body
            StringEntity reqEntity = new StringEntity("{\"documents\": [{\"language\": \""+lang+"\",\"id\": \"1\",\"text\": \""+str+"\"}]}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
            	 String json= EntityUtils.toString(entity);
                 System.out.println(json);
 	             Gson gson = new Gson();   
 	            KeyPhrasesObject language = gson.fromJson(json , KeyPhrasesObject.class);
             	for (int i=0; i<language.getDocuments().size(); i++){     		
             		ArrayList<String> langue = language.getDocuments().get(i).getKeyPhrases();
                 	System.out.println(langue);  
             		
                 }
        }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
	