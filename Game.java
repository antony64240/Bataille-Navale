import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.lang.management.MemoryUsage;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import java.util.stream.IntStream;
import java.beans.PropertyChangeEvent;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.util.Collections;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game extends JFrame {

	
	private JPanel contentPane;
	private JSplitPane Tirer;
	private JTextField textField;
	private JButton Tirer_1;
	private static Vector<Navire> VectorNavire;
	private boolean EndGame=false;
	private JPanel panel;
	private JButton btnDestroyer;
	private boolean direction = false; 



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		VectorNavire = new Vector<Navire>();
		Grille GrilleJeu = new Grille(20, 20);
		message messageEvent = new message();
		textField = new JTextField();
		Tirer = new JSplitPane();
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		btnDestroyer = new JButton("Destroyer");
		Tirer_1 = new JButton("Tirer");
		JButton Oriente = new JButton("Sens orientation");
		JTextPane TextDirection = new JTextPane();
		
		
		Grille.setTabto0();//initialisation de la grille
		
		
		
		
		setContentPane(contentPane);
		contentPane.add(Tirer, BorderLayout.SOUTH);
		TextDirection.setText("Horizontal");
		Tirer.setLeftComponent(textField);
		textField.setColumns(10);
		
		
		
		Tirer.setRightComponent(Tirer_1);
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(TextDirection, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(Oriente))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDestroyer)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(57)
					.addComponent(btnDestroyer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Oriente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TextDirection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	
		Oriente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (direction == false) {
					direction = true;
					TextDirection.setText("Vertical");
				} else {
					direction = false;
					TextDirection.setText("Horizontal");
				}
			}
		});
		
		
		Tirer_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GrilleJeu.showTab();
			}
		});
		
		
		btnDestroyer.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				Navire Destroyer = new Navire(2);
				VectorNavire.add(Destroyer); // ajoute le Destroyer dans le tableau de navires
				for(int i = 0; i < Destroyer.getTaille();i++) {
					if(!direction ) {
						Destroyer.addPart(conversionLig(textField.getText())+i,conversionCol(textField.getText()),Destroyer.getTaille());
					}else {
						Destroyer.addPart(conversionLig(textField.getText()),conversionCol(textField.getText())+i,Destroyer.getTaille());
					}
				}
				for (int i = 0 ; i < Destroyer.getTaille(); i++){
					
					System.out.println(" X : " + Destroyer.getParts().get(i).getValue());
					System.out.println(" Y : " + Destroyer.getParts().get(i).getValue());
					System.out.println();
				}
				
				
					GrilleJeu.PositionnerShip(conversionLig(textField.getText()), conversionCol(textField.getText()), Destroyer.getTaille(), Destroyer.getTaille(), direction);
				
			}
		});
	}
	
	
	
	private int conversionCol(String position) {
		int resultat;
		if(position.length()==3) {
			String colonne = (position.substring(1,3));	
			resultat = Integer.parseInt(colonne);
		}else {
			String colonne = (position.substring(1,2));	
			resultat = Integer.parseInt(colonne);
		}
		return(resultat-1);
	}


	private int conversionLig(String position) {	
		int ligne = (Character.codePointAt(position,0))-65;	
		return(ligne);
	}
	
	private Object GetCodeCase(String position) {
		int c = conversionCol(position);
		int l = conversionLig(position);
		return (null);// retourner le resultat de la case (C,L)
	}
	
	
	
}

