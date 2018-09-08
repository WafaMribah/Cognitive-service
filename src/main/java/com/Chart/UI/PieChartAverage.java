package com.Chart.UI;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import org.jfree.chart.*; 
import org.jfree.chart.plot.*; 
import org.jfree.data.*; 
import org.jfree.data.general.DefaultPieDataset;

import com.MediaPlayerDetection.UI.FaceRectangle;

public class PieChartAverage extends JFrame { 
  private JPanel pnl; 

  public PieChartAverage() { 
    addWindowListener(new WindowAdapter() { 
      public void windowClosing(WindowEvent e) { 
        dispose(); 
        //System.exit(0); 
      } 
    }); 
    pnl = new JPanel(new BorderLayout()); 
    setContentPane(pnl); 
    setSize(748, 480); 

    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
    pieDataset.setValue("ID=0", new Integer((int) ((FaceRectangle.getAvg_0()*1000)/FaceRectangle.getId_0()))); 
    pieDataset.setValue("ID=1", new Integer((int) ((FaceRectangle.getAvg_1()*1000)/FaceRectangle.getId_1()))); 
    pieDataset.setValue("ID=2", new Integer((int) ((FaceRectangle.getAvg_2()*1000)/FaceRectangle.getId_2()))); 
    pieDataset.setValue("ID=3", new Integer((int) ((FaceRectangle.getAvg_3()*1000)/FaceRectangle.getId_3()))); 
    pieDataset.setValue("ID=4", new Integer((int) ((FaceRectangle.getAvg_4()*1000)/FaceRectangle.getId_4())));
    pieDataset.setValue("ID=5", new Integer((int) ((FaceRectangle.getAvg_5()*1000)/FaceRectangle.getId_5()))); 
    pieDataset.setValue("other", new Integer(0));


    
    JFreeChart pieChart = ChartFactory.createPieChart("PieChartAverage", 
      pieDataset, true, true, true); 
    ChartPanel cPanel = new ChartPanel(pieChart); 
    pnl.add(cPanel); 
  } 

 
}
