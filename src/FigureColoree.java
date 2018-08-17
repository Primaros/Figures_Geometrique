import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public abstract class FigureColoree extends JPanel implements Serializable{
	public final static int TAILLE_CARRE_SELECTION = 10;
	public final static int PERIPHERIE_CARRE_SELECTION = 10;
	protected boolean selected;
	protected Color couleur;
	protected ArrayList<Point> tab_mem;
	
	public FigureColoree(){
		super();
		this.couleur = Color.GREEN;
		this.selected = false;
		tab_mem = new ArrayList<Point>();
	}
	public int nbPoints(){
		return this.tab_mem.size();
	}
	
	public abstract int nbClics();
	
	public abstract boolean estDedans(int x, int y);
	
	public abstract void modifierPoints(Point[] p);
	
	public void translation(int x, int y){
		for (int i=0;i<this.tab_mem.size();i++){
			this.tab_mem.set(i, new Point(this.tab_mem.get(i).rendreX()+x,this.tab_mem.get(i).rendreY()+y));
		}
	}
	
	public void transformation(int x, int y, int indice){
		Point[] tmp = new Point[this.nbPoints()];
		for (int i=0;i<this.nbPoints();i++){
			tmp[i] = new Point(this.tab_mem.get(i).rendreX(),this.tab_mem.get(i).rendreY());
			if(i == indice)
				tmp[i] = new Point(x,y);
		}
		
		this.modifierPoints(tmp);
	}
	
	public int carreDeSelection(int x, int y){
		int tmp = -1;
		for (int i=0; i<this.tab_mem.size();i++){
			if (x>this.tab_mem.get(i).rendreX()-(FigureColoree.TAILLE_CARRE_SELECTION/2) && x<this.tab_mem.get(i).rendreX()+(FigureColoree.TAILLE_CARRE_SELECTION/2) && y>this.tab_mem.get(i).rendreY()-(FigureColoree.TAILLE_CARRE_SELECTION/2) && y<this.tab_mem.get(i).rendreY()+(FigureColoree.TAILLE_CARRE_SELECTION/2))
			tmp = i;
		}
		
		return tmp;
	}
	
	public void affiche(Graphics g) {
			g.setColor(this.couleur);
			int[] x,y;
			x = new int [this.tab_mem.size()];
			y = new int [this.tab_mem.size()];
			for(int i=0;i<this.tab_mem.size();i++){
				x[i] = this.tab_mem.get(i).rendreX();
				y[i] = this.tab_mem.get(i).rendreY();
			}
			
			g.fillPolygon(x, y, this.tab_mem.size());
			
			if (selected){
				for(int i=0;i<this.tab_mem.size();i++){
					g.setColor(Color.RED);
					g.drawRect(x[i]-FigureColoree.TAILLE_CARRE_SELECTION/2, y[i]-FigureColoree.TAILLE_CARRE_SELECTION/2, FigureColoree.TAILLE_CARRE_SELECTION, FigureColoree.TAILLE_CARRE_SELECTION);
				}
			}
			
	}
	
	public void selectionne(){
		this.selected = true;
	}
	
	public void deSelecctionne(){
		this.selected = false;
	}
	
	public void changeCouleur(Color c){
		this.couleur = c;
	}
	
}
