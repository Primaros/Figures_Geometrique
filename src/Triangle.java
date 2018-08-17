

@SuppressWarnings("serial")
public class Triangle extends Polygone{

	public Triangle(){
		super();
		Point[] p = new Point[3];
		p[0] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		p[1] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		p[2] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		this.modifierPoints(p);
	}
	
	@Override
	public int nbClics() {
		return 3;
	}
	
	

}
