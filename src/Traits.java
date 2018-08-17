import java.awt.Graphics;


@SuppressWarnings("serial")
public class Traits extends FigureColoree{

	public Traits(){
		super();
	}
	
	@Override
	public int nbClics() {
		return 1;
	}

	@Override
	public boolean estDedans(int x, int y) {
		boolean tmp = false;
		for(int i=0;i<this.tab_mem.size()-1;i++){
			if (x >= this.tab_mem.get(i).rendreX()-5 && x <= this.tab_mem.get(i).rendreX()+5 && y >= this.tab_mem.get(i).rendreY()-5 && y <= this.tab_mem.get(i).rendreY()+5){
				tmp = true;
				System.out.println("zz");
			}
		}
		return tmp;
	}

	@Override
	public void modifierPoints(Point[] p) {
		this.tab_mem.clear();
		for (int i=0;i<p.length;i++){
			this.tab_mem.add(p[i]);
		}
	}
	
	public void affiche(Graphics g) {
		g.setColor(this.couleur);
		if (this.tab_mem.size()>1)
		for(int i=0;i<this.tab_mem.size()-1;i++){
			g.setColor(this.couleur);
			g.drawLine(this.tab_mem.get(i).rendreX(), this.tab_mem.get(i).rendreY(), this.tab_mem.get(i+1).rendreX(), this.tab_mem.get(i+1).rendreY());
			}
		else
		g.drawLine(this.tab_mem.get(0).rendreX(), this.tab_mem.get(0).rendreY(), this.tab_mem.get(0).rendreX(), this.tab_mem.get(0).rendreY());
	
	}
	
	public void addPoint(Point p){
		this.tab_mem.add(p);
	}
	
	
	
}
