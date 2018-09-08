package com.Chart.UI;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import org.jfree.chart.*; 
import org.jfree.chart.plot.*; 
import org.jfree.data.*; 
import org.jfree.data.general.DefaultPieDataset;

import com.MediaPlayerDetection.UI.FaceRectangle;

public class PieChart extends JFrame { 
  private JPanel pnl; 

  public PieChart() { 
    addWindowListener(new WindowAdapter() { 
      public void windowClosing(WindowEvent e) { 
        dispose(); 
      } 
    }); 
    pnl = new JPanel(new BorderLayout()); 
    setContentPane(pnl); 
    setSize(748, 480); 

    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
    pieDataset.setValue("ID=0", new Integer(FaceRectangle.getId_0())); 
    pieDataset.setValue("ID=1", new Integer(FaceRectangle.getId_1())); 
    pieDataset.setValue("ID=2", new Integer(FaceRectangle.getId_2())); 
    pieDataset.setValue("ID=3", new Integer(FaceRectangle.getId_3())); 
    pieDataset.setValue("ID=4", new Integer(FaceRectangle.getId_4())); 
    pieDataset.setValue("ID=5", new Integer(FaceRectangle.getId_5())); 
    pieDataset.setValue("other", new Integer(FaceRectangle.getId_other())); 


    
    JFreeChart pieChart = ChartFactory.createPieChart("PieChart", 
      pieDataset, true, true, true); 
    ChartPanel cPanel = new ChartPanel(pieChart); 
    pnl.add(cPanel); 
  } 

}



