package com.practice.digitalClock;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MyWindow extends JFrame
{
	private JLabel heading;
	
	private JLabel clockLabel;
	
	private Font font =new Font ("",Font.BOLD,35);
	
	MyWindow(){
		super.setTitle("MyClock");
		super.setSize(400,400);
		super.setLocation(300,50);
		this.startClock();
		
		super.setVisible(true);
	}
	
	
	
	public void startClock() {
		Timer timer=new Timer(1000, (ActionListener) new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			//	String dateTime=new Date().toString();
				
				//String dateTime=new Date().toLocalString
				
				Date d=new Date();
				SimpleDateFormat sfd=new SimpleDateFormat("hh : mm : ss");
				String dateTime=sfd.format(d);
				
				clockLabel.setText(dateTime);
				
				
			}
			
		});
		timer.start();
	
		
	}



	public void createGUI() {
		//gui
		
		heading =new JLabel("My Clock");
		clockLabel=new JLabel("clock");
		
		heading.setFont(font);
		clockLabel.setFont(font);
		
		this.setLayout(new GridLayout(2,1));
		this.add(heading);
		this.add(clockLabel);
		
	}

}
