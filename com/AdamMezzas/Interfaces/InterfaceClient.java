package com.AdamMezzas.Interfaces;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import com.AdamMezzas.WarShip.CaseNavire;
import com.AdamMezzas.WarShip.Contre_Torpilleur;
import com.AdamMezzas.WarShip.Croiseur;
import com.AdamMezzas.WarShip.EnsembleNavire;
import com.AdamMezzas.WarShip.Porte_Avion;
import com.AdamMezzas.WarShip.Sous_Marin;
import com.AdamMezzas.WarShip.Torpilleur;

import javax.swing.JTextField;


@SuppressWarnings("serial")
public class InterfaceClient extends JFrame {

	private JPanel contentPane;
	private JButton Btn_Croiser;
	private JTableM table;
	MouseCoord PosMouse = new MouseCoord();
	EnsembleNavire Navire = new EnsembleNavire();
	Boolean Direction = false;
	private JTextField textField;
	private Client Joueur;
	private String Start = "";
	public InterfaceClient(Client client, InterfaceJeu interfaceJeu) {
		
		this.Joueur = client;
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
		
		Btn_Direction.setBounds(314, 194, 89, 23);
		panel.add(Btn_Direction);	
		JButton btnValider = new JButton("Valider");
		btnValider.setEnabled(false);
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
		table.setBounds(0, 0, 280, 160);
		table.setTableToO();
		panel.add(table);
		
		textField = new JTextField();
		textField.setBounds(3, 205, 277, 20);
		panel.add(textField);
		textField.setColumns(10);
		
	
		
		
		
		JButton BtnSave = new JButton("Sauvegarder Pos");
		BtnSave.setBounds(10, 177, 121, 23);
		panel.add(BtnSave);
		
		JButton BtnCharge = new JButton("Charger Pos");
		BtnCharge.setBounds(151, 177, 121, 23);
		panel.add(BtnCharge);
		
		//FIN D'initialisation de la FRAME /////////////////////////////////////////////////////////////////////////
		//FIN D'initialisation de la FRAME /////////////////////////////////////////////////////////////////////////
		//FIN D'initialisation de la FRAME /////////////////////////////////////////////////////////////////////////
		//FIN D'initialisation de la FRAME /////////////////////////////////////////////////////////////////////////
		
	
//		
//		Navire.randomPos();
//		JTableM.setEnsembleNavire(Navire);
//		table.NavireToTable();
//		for(Navire e : Navire) {
//			System.out.println(e.toString());
//		}
		
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
					System.out.println(Navire.get(0).toString());
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
		
		if(!Btn_Torpilleur.isEnabled()&&
				Btn_Contre_Torpilleur.isEnabled()&&
				Btn_Porte_Avion.isEnabled()&&
				btn_Sous_Marin.isEnabled()&&
				Btn_Croiser.isEnabled()) {
			btnValider.setEnabled(true);
		}
		
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Joueur.send(Navire.Write());
					interfaceJeu.setVisible(true);
					contentPane.setVisible(false);
					dispose();
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
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PosMouse.setMouseCoord((e.getX()/28), (e.getY()/16));
				System.out.println(Navire.contains(new CaseNavire(PosMouse.getMouseCoordX(),PosMouse.getMouseCoordY(),2)));
			}
		});
		
		BtnCharge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					Navire.read();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JTableM.setEnsembleNavire(Navire);
				table.NavireToTable();
				Navire.get(0).toString();
				Btn_Torpilleur.setEnabled(false);
				Btn_Contre_Torpilleur.setEnabled(false);
				Btn_Porte_Avion.setEnabled(false);
				btn_Sous_Marin.setEnabled(false);
				Btn_Croiser.setEnabled(false);
				btnValider.setEnabled(true);
				System.out.println(Navire.toString());
			}
		});
		
		BtnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					//Navire.Write();
					Navire.Write();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
	}
}
