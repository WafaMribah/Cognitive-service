/*package com.MediaPlayerDetection.UI;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.DirectMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;


@SuppressWarnings("serial")
public class MediaPanel {
	
	final static Logger logger = Logger.getLogger(MediaPanel.class);
	

	public void read (String file, JFrame f){
		
		/*JFrame f = new JFrame();
		f.setSize(1000, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);*/
		/*
		Canvas c = new Canvas();
		c.setBackground(Color.black);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(c);
		f.add(p);
		
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "lib");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		MediaPlayerFactory mpf = new MediaPlayerFactory();
		EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
		emp.setVideoSurface(mpf.newVideoSurface(c));
		emp.getOverlay();
		//emp.setEnableMouseInputHandling(false);
		//emp.setEnableKeyInputHandling(false);
		
		
		emp.prepareMedia(file);
		emp.play();
		

	}
	
	public static void main (String[] args){
		
		// Set up a simple configuration that logs on the console.
	    BasicConfigurator.configure();
		
		//read and display video
		/*String file="dance_redacted1.mp4";
		MediaPanel media = new MediaPanel();*/
		
		/*logger.info("webServiceReader");
		
		serverReader webServiceReading = new serverReader();
		String UrlRegion= "https://westus.api.cognitive.microsoft.com/video/v1.0/trackface";
		String key="4b555c36885242969e0d1597f6d112d3";
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
		
		logger.info("Display a rectangle");
		GetResultJSON fileJSON = new GetResultJSON();
		fileJSON.GetJSON(oid, key);
		//fileJSON.Show();
		//media.read(file);

		   
	}	
}
	*/