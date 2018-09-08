package com.EmotionDetection;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import com.codebind.WebServiceReader;
import com.faceDetection.UI.GuiApp;

public class TestEmotion {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public void load( String str) throws Exception {
		// TODO Auto-generated method stub
		GuiApp gui = new GuiApp(str);
    	System.out.println("display image");
    	WebServiceReader webServiceReading = new WebServiceReader();
    	String UrlRegion= "https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognize";
    	String key=" 4936e555fa4247d3802112495b721da4";
        //String str= "http://data2.archives.ca/ap/a/a146456.jpg";
    	HttpEntity entity=webServiceReading.read(UrlRegion, key, str);
        gui.display(entity);

}
}
