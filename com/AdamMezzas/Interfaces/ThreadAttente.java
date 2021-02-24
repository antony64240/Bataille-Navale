package com.AdamMezzas.Interfaces;

import javax.swing.JLabel;
import javax.swing.JTextPane;

import com.AdamMezzas.TCP.InterfaceAPI;

public class ThreadAttente extends Thread{

	private InterfaceAPI API;
	private JLabel Jtext;
	private JLabel Result;
	public ThreadAttente(InterfaceAPI api, JLabel textResult,JLabel lastImpact) {
		this.API=api;
		this.Jtext=textResult;
		this.Result=lastImpact;
		
	}
	
	public void run() {
		while(!isInterrupted()) {
			if(API.isTour()) {
				Jtext.setText("A vous des jouer");
			}else {
				Jtext.setText("A l'adversaire de jouer");
			}
			if(API.isTour()) {
				Result.setText(API.isResult());
			}else {
				Result.setText(API.isResult());
			}
			
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}	
}
