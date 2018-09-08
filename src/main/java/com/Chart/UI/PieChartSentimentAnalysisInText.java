package com.Chart.UI;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.MediaPlayerDetection.UI.FaceRectangle;

public class PieChartSentimentAnalysisInText extends JFrame { 
	  private JPanel pnl;
	  private double score;

	  public PieChartSentimentAnalysisInText(double score) { 
		  this.score=score;
	    addWindowListener(new WindowAdapter() { 
	      public void windowClosing(WindowEvent e) { 
	        dispose(); 
	      } 
	    }); 
	    pnl = new JPanel(new BorderLayout()); 
	    setContentPane(pnl); 
	    setSize(748, 480); 

	    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
	    
	    if (score >0.4){
	    pieDataset.setValue("Positif", score * 100); 
	    pieDataset.setValue("Negatif", (1-score)*100);
	    }
	    else{
	    pieDataset.setValue("Negatif", (1-score)*100); 
	    pieDataset.setValue("Positif", score * 100); 
	    } 


	    
	    JFreeChart pieChart = ChartFactory.createPieChart("PieChart", 
	      pieDataset, true, true, true); 
	    ChartPanel cPanel = new ChartPanel(pieChart); 
	    pnl.add(cPanel); 
	  } 

	}