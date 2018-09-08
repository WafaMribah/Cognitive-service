package com.faceDetection.UI;

import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import com.codebind.WebServiceReader;;


public class TestMain {

	public void load( String str) throws Exception {
		
			GuiAppFace gui = new GuiAppFace(str);
        	System.out.println("display image");
        	WebServiceReader webServiceReading = new WebServiceReader();
        	String UrlRegion= "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";
        	String key="4d19fb79cfba4ac992e24679a6a129dd";
        	HttpEntity entity=webServiceReading.read(UrlRegion, key, str);
	        gui.display(entity);
 
	}

}
