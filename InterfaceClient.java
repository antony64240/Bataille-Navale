package com.AdamMezzas.WarShip;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class InterfaceClient extends JFrame {

	private JPanel contentPane;
	private JButton Btn_Croiser;
	private JTableM table;
	MouseCoord PosMouse = new MouseCoord(0,0);
	EnsembleNavire Navire = new EnsembleNavire();
	Boolean Direction = false;
	private JTextField textField;

	public InterfaceClient() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JButton Btn_Porte_Avion = new JButton("Porte_Avion");
		Btn_Porte_Avion.setBounds(303, 11, 121, 23);
		panel.add(Btn_Porte_Avion);
		Btn_Croiser = new JButton("Croiseur");
		Btn_Croiser.setBounds(303, 45, 121, 23);
		panel.add(Btn_Croiser);
		JButton Btn_Contre_Torpilleur = new JButton("Contre Torpilleur");
		Btn_Contre_Torpilleur.setBounds(303, 80, 121, 23);
		panel.add(Btn_Contre_Torpilleur);
		JButton Btn_Torpilleur = new JButton("Torpilleur");
		Btn_Torpilleur.setBounds(303, 114, 121, 23);
		panel.add(Btn_Torpilleur);
		JButton btn_Sous_Marin = new JButton("Sous_Marin");
		btn_Sous_Marin.setBounds(303, 148, 121, 23);
		panel.add(btn_Sous_Marin);
		JButton Btn_Direction = new JButton("Horizontal");
		
		Btn_Direction.setBounds(325, 194, 89, 23);
		panel.add(Btn_Direction);	
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(10, 228, 414, 23);
		panel.add(btnValider);
		
		
		table = new JTableM();
		
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
		table.setBounds(7, 29, 280, 160);
		
		table.setTableToO();
		
		panel.add(table);
		
		textField = new JTextField();
		textField.setBounds(10, 195, 277, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		//FIN D'initialisation de la FRAME /////////////////////////////////////////////////////////////////////////
		//FIN D'initialisation de la FRAME /////////////////////////////////////////////////////////////////////////
		//FIN D'initialisation de la FRAME /////////////////////////////////////////////////////////////////////////
		//FIN D'initialisation de la FRAME /////////////////////////////////////////////////////////////////////////
		
		
		
		
		//Porte_Avion /////////////////////////////////////////////////////////////////////////
		//Porte_Avion/////////////////////////////////////////////////////////////////////////
		//Porte_Avion/////////////////////////////////////////////////////////////////////////
		//Porte_Avion/////////////////////////////////////////////////////////////////////////
		
		
		Btn_Porte_Avion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(table.PositionnerShip(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(), 5, Direction)&& Btn_Porte_Avion.isEnabled()) {
					textField.setText(" ");
					Navire.add(new Porte_Avion(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(),Direction));
					JTableM.setEnsembleNavire(Navire);
					table.NavireToTable();
					Btn_Porte_Avion.setEnabled(false);
				}else {
					textField.setText("Le bateau est mal placé !");
				}
			}
		});
		
		//Btn_Croiser /////////////////////////////////////////////////////////////////////////
		//Btn_Croiser /////////////////////////////////////////////////////////////////////////
		//Btn_Croiser /////////////////////////////////////////////////////////////////////////
		//Btn_Croiser /////////////////////////////////////////////////////////////////////////
		
		
		Btn_Croiser.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.PositionnerShip(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(), 4, Direction)&& Btn_Croiser.isEnabled()) {
					textField.setText(" ");
					Navire.add(new Croiseur(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(),Direction));
					JTableM.setEnsembleNavire(Navire);
					table.NavireToTable();
					Btn_Croiser.setEnabled(false);
				}else {
					textField.setText("Le bateau est mal placé !");
				}
			}
		});
		
		//Btn_Contre_Torpilleur /////////////////////////////////////////////////////////////////////////
		//Btn_Contre_Torpilleur /////////////////////////////////////////////////////////////////////////
		//Btn_Contre_Torpilleur /////////////////////////////////////////////////////////////////////////
		//Btn_Contre_Torpilleur /////////////////////////////////////////////////////////////////////////
		
		Btn_Contre_Torpilleur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.PositionnerShip(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(), 2, Direction) && Btn_Contre_Torpilleur.isEnabled()) {
					textField.setText(" ");
					Navire.add(new Contre_Torpilleur(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(),Direction));
					JTableM.setEnsembleNavire(Navire);
					table.NavireToTable();
					Btn_Contre_Torpilleur.setEnabled(false);
				}else {
					textField.setText("Le bateau est mal placé !");
				}
			}
		});
		
		//btn_Sous_Marin /////////////////////////////////////////////////////////////////////////
		//btn_Sous_Marin /////////////////////////////////////////////////////////////////////////
		//btn_Sous_Marin /////////////////////////////////////////////////////////////////////////
		//btn_Sous_Marin /////////////////////////////////////////////////////////////////////////
		
		btn_Sous_Marin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.PositionnerShip(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(), 3, Direction) && btn_Sous_Marin.isEnabled()) {
					textField.setText(" ");
					Navire.add(new Sous_Marin(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(),Direction));
					JTableM.setEnsembleNavire(Navire);
					table.NavireToTable();
					btn_Sous_Marin.setEnabled(false);
				}else {
					textField.setText("Le bateau est mal placé !");
				}
				
			}
		});
		
		//BOUTON VALIDER  /////////////////////////////////////////////////////////////////////////
		//BOUTON VALIDER  /////////////////////////////////////////////////////////////////////////
		//BOUTON VALIDER  /////////////////////////////////////////////////////////////////////////
		//BOUTON VALIDER  /////////////////////////////////////////////////////////////////////////
		
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(" ");
				JTableM.setEnsembleNavire(Navire);
				table.NavireToTable();
				try {
					Navire.Write();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//Btn_Torpilleur/////////////////////////////////////////////////////////////////////////
		//Btn_Torpilleur  /////////////////////////////////////////////////////////////////////////
		//Btn_Torpilleur  /////////////////////////////////////////////////////////////////////////
		//Btn_Torpilleur  /////////////////////////////////////////////////////////////////////////
		
		Btn_Torpilleur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.PositionnerShip(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(), 3, Direction) && Btn_Torpilleur.isEnabled()) {
					textField.setText(" ");
					Navire.add(new Torpilleur(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(),Direction));
					JTableM.setEnsembleNavire(Navire);
					table.NavireToTable();
					Btn_Torpilleur.setEnabled(false);
				}else {
					textField.setText("Le bateau est mal placé !");
				}
			}
		});
		
		
		Btn_Direction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!Direction) {
					Btn_Direction.setText("Vertical");
					Direction = true;
				}else {
					Btn_Direction.setText("Horizontal");
					Direction = false;
				}
				System.out.println(Direction);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PosMouse.setMouseCoord((e.getX()/28), (e.getY()/16));
			}
		});
		
		
		
		
		
	}
}
