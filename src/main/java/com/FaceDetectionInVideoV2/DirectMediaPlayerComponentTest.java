package com.FaceDetectionInVideoV2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.DirectMediaPlayerComponent;
import uk.co.caprica.vlcj.player.direct.BufferFormat;
import uk.co.caprica.vlcj.player.direct.BufferFormatCallback;
import uk.co.caprica.vlcj.player.direct.DirectMediaPlayer;
import uk.co.caprica.vlcj.player.direct.RenderCallback;
import uk.co.caprica.vlcj.player.direct.RenderCallbackAdapter;
import uk.co.caprica.vlcj.player.direct.format.RV32BufferFormat;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;



public class DirectMediaPlayerComponentTest {

final static Logger logger = Logger.getLogger(DirectMediaPlayerComponentTest.class);
	
	//Media player component.
    private final DirectMediaPlayerComponent mediaPlayerComponent;
    
    private final int width = 720;
    private final int height = 480;
    private final JPanel panel;
    
    private final BufferedImage image;
    private final JLayeredPane layered;
    private Thread thread;

    private static Drawing  panel1=new Drawing(); 

 
    static ArrayList<FacesRectangle> recList;
    
    public void setRecList(ArrayList<FacesRectangle> recList) {
		this.recList = recList;
	}	
    
	ArrayList<FacesRectangle> recToDisplay = new ArrayList<FacesRectangle>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
BasicConfigurator.configure();	    
	    
    	ServerReader webServiceReading = new ServerReader();
		String UrlRegion= "https://westus.api.cognitive.microsoft.com/video/v1.0/trackface";
		String key="895e02d5ca1a494a9485156ed82e2a7c";
		String str="http://breakdown.blob.core.windows.net/public/Microsoft%20HoloLens-%20RoboRaid.mp4";
		String oid=webServiceReading.read(UrlRegion, key, str);
		try 
		{
		   Thread.sleep(20000);
		} 
		catch (InterruptedException e) 
		{
		   e.printStackTrace();
		}
		
		getOperationResult status = new getOperationResult();
		status.GetStatus(oid, key);
		try 
		{
		   //Thread.sleep(40000);
		   Thread.sleep(1000000);

		} 
		catch (InterruptedException e) 
		{
		   e.printStackTrace();
		}
		
		getResultJson fileJSON = new getResultJson();
		recList= fileJSON.GetJSON(oid, key);
		panel1.setRecList(recList);
       
        final String mrl = "Microsoft HoloLens- RoboRaid.mp4";       		
        SwingUtilities.invokeLater(new Thread(new Runnable() {
            public void run() {
            	
                new DirectMediaPlayerComponentTest().start(mrl);
            }
        }));
        
	}
	
	public DirectMediaPlayerComponentTest() {
        JFrame frame = new JFrame("vlcj Direct Media Player Component Test");
         layered=new JLayeredPane();
    
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
        		//super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(Color.black);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.drawImage(image, null, 0, 0);
                             
            }
        };
        
        layered.setBackground(Color.WHITE);
        layered.setOpaque(true);
        layered.setPreferredSize(new Dimension(width, height));
        layered.setMinimumSize(new Dimension(width, height));
        layered.setMaximumSize(new Dimension(width, height));    
        
       // panel1 = new DrawingComponent();      
        panel.setBounds(10, 10, width, height);
        panel.setOpaque(false);
        panel.setVisible(true);
        
        panel1.setBackground(new Color(0,0,0));
        panel1.setBounds(10, 10, width, height);
        panel1.setOpaque(false);
        panel1.setVisible(true);
        
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "lib");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        
        image = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(width, height);

        BufferFormatCallback bufferFormatCallback = new BufferFormatCallback() {
            public BufferFormat getBufferFormat(int sourceWidth, int sourceHeight) {
                return new RV32BufferFormat(width, height);
            }
        };

        mediaPlayerComponent = new DirectMediaPlayerComponent(bufferFormatCallback) {
            @Override
            protected RenderCallback onGetRenderCallback() {
                return new TestRenderCallbackAdapter();
            }
        };
        
        
        layered.add(panel, 0, JLayeredPane.DEFAULT_LAYER);
        layered.add(panel1,1,  JLayeredPane.DEFAULT_LAYER);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setLocation(100, 100);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(layered);
        frame.setVisible(true);
  
    }

    
    //  Start playing a movie.
    
    private void start(String mrl) {
        // One line of vlcj code to play the media...
        mediaPlayerComponent.getMediaPlayer().playMedia(mrl);
    }

    private class TestRenderCallbackAdapter extends RenderCallbackAdapter {

        private TestRenderCallbackAdapter() {
            super(new int[width * height]);
        }

        @Override
        protected void onDisplay(DirectMediaPlayer mediaPlayer, int[] rgbBuffer) {
            // Simply copy buffer to the image and repaint        	
        	image.setRGB(0, 0, width, height, rgbBuffer, 0, width);
        	panel.repaint();
            panel1.start();

    	}
    }

}
