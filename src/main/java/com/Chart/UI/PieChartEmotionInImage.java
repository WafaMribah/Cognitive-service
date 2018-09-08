package com.Chart.UI;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.codebind.EmotionScores;


public class PieChartEmotionInImage extends JFrame { 
	  private JPanel pnl; 
	  
	  ArrayList<EmotionScores> EmotionList;
		
		public void setEmotionScores(ArrayList<EmotionScores> EmotionList){
			this.EmotionList = EmotionList;
		}


	  public void PieChartImgAnalyze() { 
	    addWindowListener(new WindowAdapter() { 
	      public void windowClosing(WindowEvent e) { 
	        dispose(); 
	      } 
	    }); 
	    pnl = new JPanel(new BorderLayout()); 
	    setContentPane(pnl); 
	    setSize(748, 480); 

		
	    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
	    
	    for (EmotionScores scores : EmotionList ){
	    pieDataset.setValue("Anger", new Integer((int) ((scores.getAnger())*10))); 
	    pieDataset.setValue("Contempt", new Integer((int) ((scores.getContempt())*10))); 
	    pieDataset.setValue("Disgust", new Integer((int) ((scores.getDisgust())*10))); 
	    pieDataset.setValue("Fear", new Integer((int) ((scores.getFear())*10))); 
	    pieDataset.setValue("Happiness", new Integer((int) ((scores.getHappiness())*10))); 
	    pieDataset.setValue("Neutral", new Integer((int) ((scores.getNeutral())*10))); 
	    pieDataset.setValue("Sadness", new Integer((int) ((scores.getSadness())*10))); 
	    pieDataset.setValue("Surprise", new Integer((int) ((scores.getSurprise())*10))); 


	    }
	    
	    JFreeChart pieChart = ChartFactory.createPieChart("Analysis of emotions within images", 
	      pieDataset, true, true, true); 
	    ChartPanel cPanel = new ChartPanel(pieChart); 
	    pnl.add(cPanel); 
	    setVisible(true);
	  } 

	}
