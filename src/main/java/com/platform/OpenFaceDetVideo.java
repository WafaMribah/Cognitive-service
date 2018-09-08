package com.platform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.TestVideo.DirectMediaPlayerComponentTest;

public class OpenFaceDetVideo extends JInternalFrame implements ActionListener{
	
	private JPanel JP = new JPanel ();
	private JLabel lbl, lbl1;
    private JButton btnOk;
    private JMenuBar menuBar = new JMenuBar();

    
    OpenFaceDetVideo()
	{
		super ("Image Processing {Face Detection}", true, true, true, true);
		setLocation(390,82);
		setSize (620, 420);  
		
		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		lbl = new JLabel (" The 'Face Detection' model returns probability coordinate ");
		lbl.setFont( new Font("Comic Sans MS", Font.BOLD, 15));
		lbl.setForeground (Color.white);
		//lbl.setBounds (40, 15, 200, 120);
		
		lbl1= new JLabel("locations of where those faces appear with a bounding box.");
		lbl1.setFont( new Font("Comic Sans MS", Font.BOLD, 15));
		lbl1.setForeground (Color.white);
		
		btnOk = new JButton ("TRY YOUR OWN VIDEO");
		btnOk.setPreferredSize(new Dimension(400,100));
		btnOk.addActionListener (this);
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(lbl);	
		getContentPane().add(lbl1);		
		getContentPane().add( Box.createVerticalStrut(50) );
		getContentPane().add(btnOk);
		setVisible (true);
		setOpaque(false);
		getContentPane().setBackground(new Color(0.1f,0f,0f,0.2f));
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
		            DirectMediaPlayerComponentTest imgDetect = new DirectMediaPlayerComponentTest();
				try {
					imgDetect.load(inStr);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		            break;
		         case JOptionPane.NO_OPTION:
		            System.out.println("You clicked NO"); break;
		         case JOptionPane.CANCEL_OPTION:
		            System.out.println("You clicked Cancel"); break;}
		}

	}

}

