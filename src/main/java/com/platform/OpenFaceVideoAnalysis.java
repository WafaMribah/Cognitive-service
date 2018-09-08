package com.platform;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.Chart.UI.PieChart;
import com.Chart.UI.PieChartAverage;
import com.MediaPlayerDetection.UI.FaceRectangle;
import com.TestVideo.AnalysisVideo;

public class OpenFaceVideoAnalysis extends JInternalFrame implements ActionListener{
	
	private JPanel JP = new JPanel ();
		
	private JLabel lbl;
    private JButton btnOk, btn2;
    private JMenuBar menuBar = new JMenuBar();

    
    OpenFaceVideoAnalysis()
	{
		super ("Video Processing {Video Analysis}", true, true, true, true);
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JMenu menu = new JMenu("menu");
        menu.add(new JMenuItem("Continue"));
        menu.add(new JMenuItem("Exit"));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
        
        btnOk=new JButton("     Number of each person's appearance    ");
		btnOk.addActionListener (this);

        btn2=new JButton("The average of the appearance of each person");
        btn2.addActionListener (this);

        toolBar.add(btnOk);
        toolBar.add(btn2);
        
        JPanel north = new JPanel(new BorderLayout());
        north.add(toolBar, "West");       
        JDesktopPane desktop = new JDesktopPane(){
  		  private Image img;
		    {
		        try {
		            img = ImageIO.read(new URL("https://www.zoho.com/reports/images/visual-analysis.png"));
		            //img = ImageIO.read(new URL("https://www.wirelessguardians.com/wp-content/uploads/2017/05/icon-analysis500x500.png"));
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
        setJMenuBar(menuBar);
        getContentPane().add(north, "West");
        getContentPane().add(desktop);
        setLocation(390,82);
		setSize (620, 420); 
        setVisible(true);
			
	}

	public void actionPerformed(ActionEvent arg) {
		Object obj = arg.getSource();

		if (obj == btnOk) {	
			
						
			String inStr = JOptionPane.showInputDialog(null, "Enter Image URL ",
		            "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		      System.out.println("You have entered " + inStr);
		      
		      int answer = JOptionPane.showConfirmDialog(null, "Would You Like To Continue!!",
		            "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
		      switch (answer) {
		         case JOptionPane.YES_OPTION:
		            System.out.println("You clicked YES"); 
		            AnalysisVideo analyze = new AnalysisVideo();
		            ArrayList<FaceRectangle> recList=analyze.Analyze(inStr);
		            for ( FaceRectangle rec : recList ){				
		            	rec.LearningTime();		   
		            }
					PieChart tpc = new PieChart(); 
				    tpc.setVisible(true); 
		            break;
		         case JOptionPane.NO_OPTION:
		            System.out.println("You clicked NO"); break;
		         case JOptionPane.CANCEL_OPTION:
		            System.out.println("You clicked Cancel"); break;}
		}
		
		if (obj == btn2){
			String inStr = JOptionPane.showInputDialog(null, "Enter Image URL ",
		            "Input Dialog", JOptionPane.PLAIN_MESSAGE);
		      System.out.println("You have entered " + inStr);
		      
		      int answer = JOptionPane.showConfirmDialog(null, "Would You Like To Continue!!",
		            "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
		      switch (answer) {
		         case JOptionPane.YES_OPTION:
		            System.out.println("You clicked YES"); 
		            AnalysisVideo analyze = new AnalysisVideo();
		            ArrayList<FaceRectangle> recList=analyze.Analyze(inStr);
		            for ( FaceRectangle rec : recList ){				
		            	rec.AverageRectangle();		   
		            }
		            PieChartAverage tpc = new PieChartAverage(); 
				    tpc.setVisible(true); 
		            break;
		         case JOptionPane.NO_OPTION:
		            System.out.println("You clicked NO"); break;
		         case JOptionPane.CANCEL_OPTION:
		            System.out.println("You clicked Cancel"); break;}
		}

	}


}
