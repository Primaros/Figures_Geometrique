import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;


public class FabricantFigures implements MouseListener,EventListener{

	private FigureColoree figure_en_cours_de_fabrication;
	private int  nb_points_cliques;
	private Point[] points_cliques;

	public FabricantFigures(FigureColoree fc){
		this.figure_en_cours_de_fabrication = fc;
		this.nb_points_cliques = 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.nb_points_cliques+=1;
		if (this.nb_points_cliques > 1){
			Point[] tmp = this.points_cliques;
			this.points_cliques = new Point [this.nb_points_cliques];
			for (int i=0;i<tmp.length;i++)
				this.points_cliques[i]=tmp[i];
		} else 
			this.points_cliques = new Point [this.nb_points_cliques];

		this.points_cliques[this.nb_points_cliques-1] = new Point(e.getX(),e.getY());
		if(this.nb_points_cliques == figure_en_cours_de_fabrication.nbClics()){
			// la figure est complète, on la fabrique
			this.figure_en_cours_de_fabrication.modifierPoints(this.points_cliques);
			DessinFigures a = (DessinFigures)(e.getSource());
			Graphics b = a.getGraphics();
			this.figure_en_cours_de_fabrication.changeCouleur(a.couleur);
			this.figure_en_cours_de_fabrication.affiche(b);
			
			a.ajoute(this.figure_en_cours_de_fabrication);
			a.supprimeAuditeurs();
			
			// préparation pour la fabrication d'une nouvelle figure
			
				this.nb_points_cliques = 0;
				this.points_cliques = null;
				FigureColoree tmp = null;
				if (this.figure_en_cours_de_fabrication instanceof Triangle)
					tmp = new Triangle();
				else if (this.figure_en_cours_de_fabrication instanceof Cercle)
					tmp = new Cercle();
				else if (this.figure_en_cours_de_fabrication instanceof Carre)
					tmp = new Carre();
				else if (this.figure_en_cours_de_fabrication instanceof RectangleRec)
					tmp = new RectangleRec();
				else if (this.figure_en_cours_de_fabrication instanceof Quadrilatere)
					tmp = new Quadrilatere();
				
				
				tmp.changeCouleur(a.couleur);
				a.construit(tmp);
			
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
