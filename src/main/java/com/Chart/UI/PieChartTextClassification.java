package com.Chart.UI;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.Iterator;

public class PieChartTextClassification  extends JFrame{

	 private JPanel pnl; 
	 private ArrayList <String> label1;
	 private ArrayList <String> abs_relevance1;
	 	 
	  public ArrayList<String> getLabel1() {
		return label1;
	}
	public void setLabel1(ArrayList<String> label1) {
		this.label1 = label1;
	}
	public ArrayList<String> getAbs_relevance1() {
		return abs_relevance1;
	}
	public void setAbs_relevance1(ArrayList<String> abs_relevance1) {
		this.abs_relevance1 = abs_relevance1;
	}

	public PieChartTextClassification(ArrayList <String> label1, ArrayList <Double> abs_relevance1) { 
	    addWindowListener(new WindowAdapter() { 
	      public void windowClosing(WindowEvent e) { 
	        dispose(); 
	      } 
	    }); 
	    pnl = new JPanel(new BorderLayout()); 
	    setContentPane(pnl); 
	    setSize(748, 480); 

	    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
	    
	    Iterator <String> itrLabel1 = label1.iterator();
	    Iterator <Double> itrRelevance1 = abs_relevance1.iterator();
	    
	    while (itrLabel1.hasNext() && itrRelevance1.hasNext()){
	    	
	    	 pieDataset.setValue(itrLabel1.next(), itrRelevance1.next()*100);
	    }
	    
    
	    JFreeChart pieChart = ChartFactory.createPieChart("PieChart", 
	      pieDataset, true, true, true); 
	    ChartPanel cPanel = new ChartPanel(pieChart); 
	    pnl.add(cPanel); 
	  } 
}
