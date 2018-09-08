package com.EmotionDetectionInVideo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;



public class MainTest {

	/**
	 * @param args
	 */
	final static Logger logger = Logger.getLogger(MainTest.class);

	
	public static void main(String[] args) {
	    BasicConfigurator.configure();

		// TODO Auto-generated method stub
		ServerReader webServiceReading = new ServerReader();
		String UrlRegion= "https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognizeinvideo";
		String key="7b9c2f633bb64f37b575d0b4e5144ea3";
		String oid=webServiceReading.read(UrlRegion, key);
		try 
		{
		   Thread.sleep(30000);
		} 
		catch (InterruptedException e) 
		{
		   e.printStackTrace();
		}
		GetOperationResult status = new GetOperationResult();
		status.GetStatus(oid, key);
		try 
		{
		   Thread.sleep(50000);
		} 
		catch (InterruptedException e) 
		{
		   e.printStackTrace();
		}
		//GetResultJSON fileJSON = new GetResultJSON();
		//fileJSON.GetJSON(oid, key);
		logger.info("ended.");
	}

}
