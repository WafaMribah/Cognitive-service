package com.platform;

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

import com.EmotionDetection.TestEmotion;;

public class OpenEmotionRecogImg extends JInternalFrame implements ActionListener{
	
	private JPanel JP = new JPanel ();
	private JLabel lbl;
    private JButton btnOk;
    private JMenuBar menuBar = new JMenuBar();

    
        
    OpenEmotionRecogImg()
	{
		super ("Image Processing {Emotion Detection}", true, true, true, true);
		setLocation(390,82);
		setSize (620, 420); 
        try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lbl = new JLabel (" Click On Start Button To Begin");
		lbl.setFont( new Font("Comic Sans MS", Font.BOLD, 17));
		lbl.setForeground (Color.white);
		lbl.setBounds (40, 15, 200, 120);
				
		btnOk = new JButton ("TRY YOUR OWN IMAGE");

		btnOk.setPreferredSize(new Dimension(400,100));
		btnOk.addActionListener (this);
		JP.setLayout (null);
		JP.add(lbl);
		JP.add (btnOk);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(lbl);
		getContentPane().add( Box.createVerticalStrut(90) );
		getContentPane().add(btnOk);
		//getContentPane().add (JP, BorderLayout.CENTER);
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
		            TestEmotion imgEmotion = new TestEmotion();
				try {
					imgEmotion.load( inStr);
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

