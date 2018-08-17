
@SuppressWarnings("serial")
public abstract class ConiqueCentree extends FigureColoree{
	
	protected Point centre;
	
	public ConiqueCentree(){
		this.centre = new Point(0,0);
	}
	
	@Override
	public int nbClics() {
		return 2;
	}

	@Override
	public boolean estDedans(int x, int y) {
		return this.centre.distance(new Point(x,y))<this.centre.distance(this.tab_mem.get(1));
	}

	@Override
	public void modifierPoints(Point[] p) {
		this.tab_mem.clear();
		for (int i=0;i<p.length;i++){
			this.tab_mem.add(p[i]);
		}
		this.centre = p[0];
	}
	
	public Point rendreCentre(){
		return this.centre;
	}
	
	
}
