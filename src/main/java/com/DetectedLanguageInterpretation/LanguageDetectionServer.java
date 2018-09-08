package com.DetectedLanguageInterpretation;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import com.google.gson.Gson;

public class LanguageDetectionServer {
	
	public static String LanguageDetection(String str) 
    {
        HttpClient httpclient = HttpClients.createDefault();
        String langue = null;

        try
        {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/text/analytics/v2.0/languages");

            builder.setParameter("numberOfLanguagesToDetect", "1");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "b2bbbeea89dd45168e5f5e282702e664");
                    
            // Request body
            StringEntity reqEntity = new StringEntity("{\"documents\": [{\"id\": \"1\",\"text\": \""+str+"\"}]}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                String json= EntityUtils.toString(entity);
                System.out.println(json);
	            Gson gson = new Gson();   
	            LanguageObject language = gson.fromJson(json , LanguageObject.class);
            	System.out.println(language);
            	for (int i=0; i<language.getDocuments().size(); i++){
            		langue = language.getDocuments().get(i).getDetectedLanguages().get(i).getIso6391Name();
                	System.out.println(langue);

            	}
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return langue;
    }
	
	

}
