import java.awt.Polygon;


@SuppressWarnings("serial")
public class Polygone extends FigureColoree{

	private Polygon p;
	
	public Polygone(){
		super();
		p = new Polygon();
	}
	
	public int nbClics() {
		return 999;
	}
	
	public boolean estDedans(int s_x, int s_y){
		
		int[] x,y;
		x = new int [this.tab_mem.size()];
		y = new int [this.tab_mem.size()];
		for(int i=0;i<this.tab_mem.size();i++){
			x[i] = this.tab_mem.get(i).rendreX();
			y[i] = this.tab_mem.get(i).rendreY();
		}
		
		p=new Polygon(x, y, this.tab_mem.size());
		
		return p.contains(s_x, s_y);
			
	}
	
	public void modifierPoints(Point[] p){
		this.tab_mem.clear();
		for (int i=0;i<p.length;i++){
			this.tab_mem.add(p[i]);
		}
	}

}
