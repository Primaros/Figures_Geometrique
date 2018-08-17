
@SuppressWarnings("serial")
public class Quadrilatere extends Polygone{
	public Quadrilatere(){
		super();
		Point[] p = new Point[4];
		p[0] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		p[1] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		p[2] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		p[3] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		this.modifierPoints(p);
	}
	
	public int nbClics(){
		return 4;
	}
}
