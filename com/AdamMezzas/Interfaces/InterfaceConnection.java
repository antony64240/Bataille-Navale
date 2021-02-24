package com.AdamMezzas.Interfaces;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.AdamMezzas.TCP.InterfaceAPI;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class InterfaceConnection extends JFrame {
	private InterfaceAPI screenOut;
	private JPanel contentPane;
	private Client Joueur;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param client 
	 * @param screen 
	 * @param interfaceJeu 
	 */
	public InterfaceConnection(Client client, InterfaceClient interfaceClient, InterfaceAPI screen) {
		this.Joueur = client;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.screenOut=screen;
		JTextArea textAreaUser = new JTextArea();
		textAreaUser.setBounds(152, 90, 130, 22);
		contentPane.add(textAreaUser);
		
		JLabel lblNewLabel = new JLabel("Bataille Navale !");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(57, 41, 331, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblEntrerVotreUsername = new JLabel("Entrer votre username :");
		lblEntrerVotreUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrerVotreUsername.setBounds(0, 91, 162, 22);
		contentPane.add(lblEntrerVotreUsername);
		
//		JList list = new JList();
//		list.setEnabled(false);
//		list.setModel(new AbstractListModel() {
//			String[] values = new String[] {"Save1", "Save2", "Save3"};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
//		list.setBounds(339, 167, 43, 83);
//		contentPane.add(list);
		JButton ValideUsername = new JButton("Valider");	
		ValideUsername.setBounds(312, 89, 89, 23);
		contentPane.add(ValideUsername);
		JLabel lblNewLabel_1 = new JLabel("Vos Parties :");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(312, 148, 89, 14);
		contentPane.add(lblNewLabel_1);
		JButton BtnStart = new JButton("Chercher Partie");

		BtnStart.setEnabled(false);
		BtnStart.setBounds(137, 144, 165, 23);
		contentPane.add(BtnStart);
		JButton btnReprendrePartie = new JButton("Reprendre Partie");
		btnReprendrePartie.setEnabled(false);
		btnReprendrePartie.setBounds(137, 202, 165, 23);
		contentPane.add(btnReprendrePartie);
		JLabel LabelStat = new JLabel("Stats:");
		LabelStat.setEnabled(false);
		LabelStat.setBounds(10, 148, 98, 14);
		contentPane.add(LabelStat);
		JLabel NbPartieG = new JLabel("");
		NbPartieG.setBounds(10, 178, 116, 14);
		contentPane.add(NbPartieG);
		JLabel NbPartie = new JLabel("");
		NbPartie.setBounds(10, 202, 117, 14);
		contentPane.add(NbPartie);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 115, 116, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel Chargement = new JLabel("");
		Chargement.setHorizontalAlignment(SwingConstants.CENTER);
		Chargement.setBounds(152, 123, 130, 14);
		contentPane.add(Chargement);
		
		
		
		ValideUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((textAreaUser.getText() != "") && (ValideUsername.isEnabled())) {
					Joueur.send(textAreaUser.getText());
					Chargement.setText("Chargement");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Chargement.setText("");
					BtnStart.setEnabled(true);
					LabelStat.setEnabled(true); 
					NbPartieG.setText("Partie gagné : "+ screenOut.getNbrGagne());
					NbPartie.setText("Partie : "+ screenOut.getNbrPerdu());
					ValideUsername.setEnabled(false);
				}
			}
		});
		
		BtnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				interfaceClient.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		
	}
}
