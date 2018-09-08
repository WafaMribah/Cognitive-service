package com.platform;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class HomePage implements ActionListener{
	
	  private static JDesktopPane desktop = new JDesktopPane(){
		  private Image image;
		    {
		        try {
		            //image = ImageIO.read(new URL("http://i2.cdn.turner.com/money/dam/assets/140916123203-fbi-biometric-scanner-1024x576.jpg"));
		        	image = ImageIO.read(new URL("http://i1.wp.com/abcey.com/wp-content/uploads/2016/08/ABCey-Affectiva-Pic-1-.jpg?resize=640%2C301"));
		        	//http://cdn2.hubspot.net/hubfs/2372627/hub_generated/resized/efef3843-16bd-4514-84b2-51d93b0a14ad.png
		        	//image = ImageIO.read(new URL("http://fanci-project.eu/wp-content/uploads/2016/06/Banner-FACET-page-A.jpg"));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		    }
		};
		
	  private JMenuItem FaceDetection, EmotionRecognition, FaceDetectionVideo, EmotionRecognitionVideo, VideoAnalysis, TextAnalysis;
	
	 public JMenuBar createMenuBar()
	    {
		 
		 
	        //Create the menu bar.
	        JMenuBar menuBar = new JMenuBar(){
	  		  private Image img;
			    {
			        try {
			            img = ImageIO.read(new URL("http://paroisse.pontarlier.free.fr/images/p1s11010.jpeg"));
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }

			    @Override
			    protected void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			    }
			};
	        
	        menuBar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
	        menuBar.setPreferredSize(new Dimension(40, 40));
	        
	        //Add a JMenu
	        JMenu about = new JMenu("ABOUT US");
	        JMenu services = new JMenu("SERVICES");
	        JMenu help = new JMenu("HELP");



	        menuBar.add(about);
	        menuBar.add(services);
	        menuBar.add(Box.createHorizontalGlue());
	        menuBar.add(help);

	        			
	        JMenu vision =  new JMenu("Vision");
	        vision.setIcon(new ImageIcon("vision.png"));
	        
	        JMenu video = new JMenu("Video Processing");
	        video.setIcon(new ImageIcon("video.png"));
	        FaceDetectionVideo=new JMenuItem("Face Detection");
	        EmotionRecognitionVideo=new JMenuItem("Emotion Recognition");
	        VideoAnalysis= new JMenuItem("Video Analysis");
	        		
	        FaceDetectionVideo.addActionListener(this);
	        EmotionRecognitionVideo.addActionListener(this);
	        VideoAnalysis.addActionListener(this);
	        
	        video.add(FaceDetectionVideo);
	        video.add(EmotionRecognitionVideo);	
	        video.add(VideoAnalysis);	        


	        JMenu image = new JMenu("Image Processing");
	        image.setIcon(new ImageIcon("image.png"));
	        FaceDetection=new JMenuItem("Face Detection");
	        EmotionRecognition=new JMenuItem("Emotion Recognition");
	        FaceDetection.addActionListener(this);
	        EmotionRecognition.addActionListener(this);

	        image.add(FaceDetection);
	        image.add(EmotionRecognition);
	        
	        vision.add(video);
	        vision.add(image);
			
	        JMenuItem speech = new JMenuItem("Speech");
	        speech.setIcon(new ImageIcon("speech.png"));

	        JMenu language = new JMenu("Language");
	        language.setIcon(new ImageIcon("language.png"));
	        TextAnalysis= new JMenuItem("Text Analysis");
	        TextAnalysis.addActionListener(this);
	        TextAnalysis.setIcon(new ImageIcon("TextAnalysis.png"));
	        language.add(TextAnalysis);
 	        
	        JMenuItem Knowledge = new JMenuItem("Knowledge");
	        Knowledge.setIcon(new ImageIcon("knowledge.png"));

	        JMenuItem Search = new JMenuItem("Search");
	        Search.setIcon(new ImageIcon("search.png"));


	        ButtonGroup sides = new ButtonGroup();
	        JRadioButtonMenuItem Other = new JRadioButtonMenuItem("Other...");
	        sides.add(Other);
	       
	        
	        services.add(vision);
	        services.add(speech);
	        services.add(language);
	        services.add(Knowledge);
	        services.add(Search);
	        services.addSeparator();
	        services.add(Other);      
	        		   
	        return menuBar;
	    }
	 
	 public void actionPerformed(ActionEvent arg) {
			
			if(arg.getSource()==( JMenuItem) FaceDetection)
			{
				OpenFrameImage oc= new OpenFrameImage(); 
				desktop.add(oc);
				oc.show();
	    
			}
	 	   
			if(arg.getSource()==( JMenuItem) EmotionRecognition)
			{
				OpenEmotionRecogImg oc= new OpenEmotionRecogImg(); 
				desktop.add(oc);
				oc.show();	        
			}
			
			if(arg.getSource()==( JMenuItem) FaceDetectionVideo)
			{
				OpenFaceDetVideo oc= new OpenFaceDetVideo(); 
				desktop.add(oc);
				oc.show();	        
			}
			
			if(arg.getSource()==( JMenuItem) VideoAnalysis)
			{
				OpenFaceVideoAnalysis oc= new OpenFaceVideoAnalysis(); 
				desktop.add(oc);
				oc.show();	        
			}
			
			if(arg.getSource()==( JMenuItem) TextAnalysis)
			{
				OpenTextAnalysis oc= new OpenTextAnalysis(); 
				desktop.add(oc);
				oc.show();
	    
			}			
	}
	 
	 private static void createAndShowGUI() {

	        JFrame.setDefaultLookAndFeelDecorated(true);
	        JFrame frame = new JFrame("[=] Home Page [=]");

	        frame.setPreferredSize(new Dimension(800, 600));
	        frame.setMinimumSize(new Dimension(800, 600));
	        frame.setMaximumSize(new Dimension(800, 600));
	        frame.setLocation(100, 100);
	        
	        
	        //Create and set up the content pane.
	        HomePage demo = new HomePage();
	       // frame.setContentPane(demo.createContentPane());
	        // We now also set the MenuBar of the Frame to our MenuBar 
	        frame.setJMenuBar(demo.createMenuBar());
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        panel.setBorder(new TitledBorder("Home Page"));
	        
	        panel.add(desktop);
	        
	        frame.getContentPane().add (panel, BorderLayout.CENTER);

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	public static void main(String[] args) {
		 //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Font f = new Font("Comic Sans MS", Font.ITALIC, 14);
                UIManager.put("Menu.font", f);
                UIManager.put("Menu.selectionBackground",new Color(202,188,153));
                UIManager.put("MenuItem.selectionBackground",new Color(202,188,153));
                UIManager.put("Menu.selectionForeground",Color.black);
                UIManager.put("MenuItem.selectionForeground",Color.black);
                UIManager.put("MenuItem.font", f);
                createAndShowGUI();
            }
        });
	}

}
