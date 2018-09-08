package com.SentimentInterpretation;

import java.awt.GraphicsConfiguration;
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

import com.Chart.UI.PieChartSentimentAnalysisInText;
import com.google.gson.Gson;

public class SentimentServer 
{
    public static void load(String str, String langue) 
    {
    	double score=0;
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/text/analytics/v2.0/sentiment");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "357291169f134c20a3337320f4c838c1");


            // Request body
            StringEntity reqEntity = new StringEntity("{\"documents\": [{\"language\": \""+langue+"\",\"id\": \"1\",\"text\": \""+str+"\"}]}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {               
                String json= EntityUtils.toString(entity);
                System.out.println(json);
	             Gson gson = new Gson();   
	            SentimentObject sentiment = gson.fromJson(json , SentimentObject.class);
            	for (int i=0; i<sentiment.getDocuments().size(); i++){     		
            		score = sentiment.getDocuments().get(i).getScore();
                	System.out.println(score);  
            		
                }
            	
				PieChartSentimentAnalysisInText chart = new PieChartSentimentAnalysisInText(score);
            	chart.setVisible(true);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}


