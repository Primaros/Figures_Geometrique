import java.awt.Color;
import java.awt.Graphics;


@SuppressWarnings("serial")
public class Cercle extends ConiqueCentree {

	private double rayon;

	public Cercle(){
		super();
		this.setRayon(0);
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public void modifierPoints(Point[] p) {
		this.tab_mem.clear();
		this.setRayon(p[1].distance(p[0]));
		this.centre = p[0];
		this.tab_mem.add(p[0]);
		this.tab_mem.add(p[1]);
	}

	public void affiche(Graphics g) {
		g.setColor(this.couleur);
		g.fillOval(this.centre.rendreX()-((int)this.rayon), this.centre.rendreY()-((int)this.rayon), (int)this.rayon*2, (int)this.rayon*2);

		if (selected){
			for(int i=0;i<this.tab_mem.size();i++){
				g.setColor(Color.RED);
				g.drawRect(this.tab_mem.get(i).rendreX()-FigureColoree.TAILLE_CARRE_SELECTION/2, this.tab_mem.get(i).rendreY()-FigureColoree.TAILLE_CARRE_SELECTION/2, FigureColoree.TAILLE_CARRE_SELECTION, FigureColoree.TAILLE_CARRE_SELECTION);
			}
		}

	}

	public void transformation(int dx, int dy, int indice){
		Point[] tmp=new Point[2];
		if (indice == 0){
			tmp[0] = new Point(dx,dy);
			tmp[1] = this.tab_mem.get(1);
		} else {
			tmp[1] = new Point(dx,dy);
			tmp[0] = this.tab_mem.get(0);
		}
		this.modifierPoints(tmp);	
	}
	
	public void translation(int x, int y){
		for (int i=0;i<this.tab_mem.size();i++){
			this.tab_mem.set(i, new Point(this.tab_mem.get(i).rendreX()+x,this.tab_mem.get(i).rendreY()+y));
		}
		Point[] tmp = new Point[2];
		tmp[0] = this.tab_mem.get(0);
		tmp[1] = this.tab_mem.get(1);
		this.modifierPoints(tmp);
	}

	public boolean estDedans(int x, int y) {
		return this.centre.distance(new Point(x,y))<this.rayon;
	}

}
