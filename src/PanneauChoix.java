import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class PanneauChoix extends JPanel{
	private DessinFigures dessin;
	private FigureColoree figure;

	public PanneauChoix(DessinFigures i){

		this.dessin = i;
		this.figure = new Polygone();
		JRadioButton jr1 = new JRadioButton("Nouvelle figure");
		JRadioButton jr2 = new JRadioButton("Tracer");
		JRadioButton jr3 = new JRadioButton("Manipuler");
		JButton effacer = new JButton("Effacer");
		JComboBox<String> forme = new JComboBox<String>(new String[] {"triangle","carre","rectangle","quadrilatere","cercle"});
		JComboBox<String> couleur = new JComboBox<String>(new String[] {"Noir","Blanc","Bleu","Rouge","Vert","Jaune"});
		JPanel tmp_1 = new JPanel(),tmp_2 = new JPanel();
		ButtonGroup group = new ButtonGroup();
		group.add(jr1);
		group.add(jr2);
		group.add(jr3);
		
		
		tmp_1.setLayout(new GridLayout(1,4));
		tmp_1.add(jr1);
		tmp_1.add(jr2);
		tmp_1.add(jr3);
		tmp_1.add(effacer);
		tmp_2.setLayout(new GridLayout(1,2));
		tmp_2.add(forme);
		tmp_2.add(couleur);
		
		
		this.setLayout(new GridLayout(2,1));
		this.add(tmp_1);
		this.add(tmp_2);
		jr3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				forme.setEnabled(false);
				couleur.setEnabled(true);
				dessin.supprimeAuditeurs();
				dessin.activeManipulationsSouris();
			}

		});

		jr2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				forme.setEnabled(false);
				couleur.setEnabled(true);
				dessin.supprimeAuditeurs();
				dessin.trace(PanneauChoix.determineCouleur(couleur.getSelectedIndex()));
			}

		});

		jr1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				forme.setEnabled(true);
				couleur.setEnabled(true);
				dessin.supprimeAuditeurs();
				figure = PanneauChoix.creeFigure(forme.getSelectedIndex());
				figure.changeCouleur(PanneauChoix.determineCouleur(couleur.getSelectedIndex()));
				dessin.construit(figure);
			}
		});
		jr1.setSelected(true);

		couleur.setSelectedIndex(0);
		forme.setSelectedIndex(0);

		forme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dessin.supprimeAuditeurs();
				figure = PanneauChoix.creeFigure(forme.getSelectedIndex());
				dessin.construit(figure);
				
			}
		});

		couleur.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color tmp = PanneauChoix.determineCouleur(couleur.getSelectedIndex());
				if (dessin.traceur != null)
					dessin.traceur.setCouleur(tmp);
				else if(jr3.isSelected()){
					if(dessin.figureSelection() != null)
					dessin.figureSelection().changeCouleur(tmp);
					dessin.repaint();
				}
					
				dessin.couleur = tmp;
			}

		});

		effacer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dessin.supprimeAuditeurs();
				dessin.effacer();
				if(jr1.isSelected()){
					forme.setEnabled(true);
					couleur.setEnabled(true);
					dessin.supprimeAuditeurs();
					figure = PanneauChoix.creeFigure(forme.getSelectedIndex());
					figure.changeCouleur(PanneauChoix.determineCouleur(couleur.getSelectedIndex()));
					dessin.construit(figure);
				} else if (jr2.isSelected()){
					forme.setEnabled(false);
					couleur.setEnabled(true);
					dessin.supprimeAuditeurs();
					dessin.trace(PanneauChoix.determineCouleur(couleur.getSelectedIndex()));
				} else if (jr3.isSelected()) {
					forme.setEnabled(false);
					couleur.setEnabled(true);
					dessin.supprimeAuditeurs();
					dessin.activeManipulationsSouris();
				}
			}
		});
		
		forme.setEnabled(true);
		couleur.setEnabled(true);
		dessin.supprimeAuditeurs();
		figure = PanneauChoix.creeFigure(forme.getSelectedIndex());
		dessin.construit(figure);




	}


	public static FigureColoree creeFigure(int i){
		FigureColoree tmp = null;
		switch (i){
		case 0:
			tmp = new Triangle();
			break;
		case 1:
			tmp = new Carre();
			break;
		case 2:
			tmp = new RectangleRec();
			break;
		case 3:
			tmp = new Quadrilatere();
			break;
		case 4:
			tmp = new Cercle();
			break;
		default:
			tmp = new Quadrilatere();
			break;
		}

		return tmp;
	}

	public static Color determineCouleur(int i){
		Color tmp = Color.BLACK;
		switch (i){
		case 0:
			tmp = Color.BLACK;
			break;
		case 1:
			tmp = Color.WHITE;
			break;
		case 2:
			tmp = Color.BLUE;
			break;
		case 3:
			tmp = Color.RED;
			break;
		case 4:
			tmp = Color.GREEN;
			break;
		case 5:
			tmp = Color.YELLOW;
			break;
		default:
			tmp = Color.BLACK;
			break;
		}

		return tmp;
	}

}
