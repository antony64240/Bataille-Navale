package com.AdamMezzas.Interfaces;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.AdamMezzas.TCP.InterfaceAPI;
import com.AdamMezzas.TCP.ThreadEcouteClient;
import com.AdamMezzas.TCP.houseAPIClient;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class InterfaceJeu extends JFrame {

	private JPanel contentPane;
	private JTableM table = new JTableM();
	private Client Joueur;
	private InterfaceAPI API;
	String ResultImpact="";

	public InterfaceJeu(Client client, InterfaceAPI screen) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Joueur = client;
		this.API=screen;
		contentPane = new JPanel();
		JButton Abandonner = new JButton("Abandonner");
		JLabel TextResult = new JLabel();
		MouseCoord mouse = new MouseCoord();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(100, 100, 450, 300);
		table.setBounds(33, 22, 360, 160);
		contentPane.add(table);
		TextResult.setBackground(SystemColor.menu);
		TextResult.setBounds(33, 230, 360, 20);
		contentPane.add(TextResult);
		Abandonner.setBounds(290, 193, 103, 23);
		contentPane.add(Abandonner);
		MouseCoord Mouse = new MouseCoord();
		JLabel LastImpact = new JLabel("");
		LastImpact.setBounds(33, 199, 184, 20);
		contentPane.add(LastImpact);
		
		ThreadAttente threadAttente = new ThreadAttente(API,TextResult,LastImpact);
		threadAttente.start();
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));

		
		
		
	 
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(API.isTour()) {
					Mouse.setMouseCoord(e.getX(),e.getY());
					System.out.println("Tir"+","+Mouse.getMouseCoordX()+","+Mouse.getMouseCoordY());
					Joueur.send("Tir"+","+Mouse.getMouseCoordX()+","+Mouse.getMouseCoordY());
				}
			}
		});
	



	}
}



