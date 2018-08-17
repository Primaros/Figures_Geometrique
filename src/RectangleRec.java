
@SuppressWarnings("serial")
public class RectangleRec extends Quadrilatere{

	public RectangleRec(){
		Point[] p = new Point[2];
		p[0] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		p[1] = new Point((int)(this.getSize().getWidth()*Math.random()),(int)(this.getSize().getHeight()*Math.random()));
		
		this.modifierPoints(p);
	}
	
	public void modifierPoints(Point[] tab_saisie){
		Point[] p = new Point[2];
		p[0] = new Point (tab_saisie[1].rendreX(),tab_saisie[0].rendreY());
		p[1] = new Point (tab_saisie[0].rendreX(),tab_saisie[1].rendreY());
		
		this.tab_mem.clear();
		this.tab_mem.add(tab_saisie[0]);
		this.tab_mem.add(p[0]);
		this.tab_mem.add(tab_saisie[1]);
		this.tab_mem.add(p[1]);
	}
	
	public int nbClics(){
		return 2;
	}
	
	public void transformation(int dx, int dy, int indice){
		
		this.tab_mem.set(indice, new Point(dx, dy));
		switch (indice){
		case 0:
			this.tab_mem.set(1, new Point(this.tab_mem.get(1).rendreX(),this.tab_mem.get(0).rendreY()));
			this.tab_mem.set(3, new Point(this.tab_mem.get(0).rendreX(),this.tab_mem.get(3).rendreY()));
			break;
		case 1:
			this.tab_mem.set(0, new Point(this.tab_mem.get(0).rendreX(),this.tab_mem.get(1).rendreY()));
			this.tab_mem.set(2, new Point(this.tab_mem.get(1).rendreX(),this.tab_mem.get(2).rendreY()));
			break;
		case 2:
			this.tab_mem.set(1, new Point(this.tab_mem.get(2).rendreX(),this.tab_mem.get(1).rendreY()));
			this.tab_mem.set(3, new Point(this.tab_mem.get(3).rendreX(),this.tab_mem.get(2).rendreY()));
			break;
		case 3:
			this.tab_mem.set(0, new Point(this.tab_mem.get(3).rendreX(),this.tab_mem.get(0).rendreY()));
			this.tab_mem.set(2, new Point(this.tab_mem.get(2).rendreX(),this.tab_mem.get(3).rendreY()));
			break;
		}		
	}
	

}
