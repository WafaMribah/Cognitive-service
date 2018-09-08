package com.TextClassification;

import com.Chart.UI.PieChartTextClassification;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
 
public class ServerReaderMeaningCloud
{
	
    public void load(String str, String model)
    {
    	OkHttpClient client = new OkHttpClient();
    	

    	MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, "key=3f50560568031fa14228539896a34655&txt="+str+"&model="+model+"");
    	Request request = new Request.Builder()
    	  .url("http://api.meaningcloud.com/class-1.1")
    	  .post(body)
    	  .addHeader("content-type", "application/x-www-form-urlencoded")
    	  .build();

    	try {
			Response response = client.newCall(request).execute();
			String json= response.body().string();
			System.out.println(json);
			Gson gson = new Gson();
            textClassification classification = gson.fromJson(json , textClassification.class);
            ArrayList <String> label1 = new ArrayList <String>(); 
            ArrayList <Double> abs_relevance1= new ArrayList <Double>(); 
            ArrayList <Double> relevance1= new ArrayList <Double>(); 
            
			for (int i=0; i<classification.getCategory_list().size(); i++){     		
				label1.add(classification.getCategory_list().get(i).getLabel());
				abs_relevance1.add(classification.getCategory_list().get(i).getAbs_relevance());
				relevance1.add(classification.getCategory_list().get(i).getRelevance());
            }
			System.out.println(label1);
			System.out.println(abs_relevance1);
			System.out.println(relevance1);
	    	PieChartTextClassification pie = new PieChartTextClassification(label1, abs_relevance1);
	    	pie.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}
