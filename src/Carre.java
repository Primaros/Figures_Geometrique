
@SuppressWarnings("serial")
public class Carre extends RectangleRec {
	
	public Carre(){
		super();
	}
	
	public void modifierPoints(Point[] tab_saisie){
		Point[] p = new Point[2];
		tab_saisie[1].modifierY(tab_saisie[0].rendreY());
		p[0] = new Point (tab_saisie[1].rendreX(),(int)tab_saisie[0].distance(tab_saisie[1])+tab_saisie[0].rendreY());
		p[1] = new Point (tab_saisie[0].rendreX(),(int)tab_saisie[0].distance(tab_saisie[1])+tab_saisie[0].rendreY());
		
		this.tab_mem.clear();
		this.tab_mem.add(tab_saisie[0]);
		this.tab_mem.add(tab_saisie[1]);
		this.tab_mem.add(p[0]);
		this.tab_mem.add(p[1]);
		
	}
	
	public void transformation(int dx, int dy, int indice){
		
		switch (indice){
		case 0:
			if(dx>this.tab_mem.get(indice).rendreX()&&dy>this.tab_mem.get(indice).rendreY())
				this.tab_mem.set(indice, new Point(this.tab_mem.get(indice).rendreX()+1,this.tab_mem.get(indice).rendreY()+1));
			else 
				this.tab_mem.set(indice, new Point(this.tab_mem.get(indice).rendreX()-1,this.tab_mem.get(indice).rendreY()-1));
			
			this.tab_mem.set(1,new Point(this.tab_mem.get(1).rendreX(),this.tab_mem.get(0).rendreY()));
			this.tab_mem.set(3,new Point(this.tab_mem.get(0).rendreX(),this.tab_mem.get(3).rendreY()));
			break;
		case 1:
			if(dx<this.tab_mem.get(indice).rendreX()&&dy>this.tab_mem.get(indice).rendreY())
				this.tab_mem.set(indice, new Point(this.tab_mem.get(indice).rendreX()-1,this.tab_mem.get(indice).rendreY()+1));
			else 
				this.tab_mem.set(indice, new Point(this.tab_mem.get(indice).rendreX()+1,this.tab_mem.get(indice).rendreY()-1));
			
			this.tab_mem.set(0,new Point(this.tab_mem.get(0).rendreX(),this.tab_mem.get(1).rendreY()));
			this.tab_mem.set(2,new Point(this.tab_mem.get(1).rendreX(),this.tab_mem.get(2).rendreY()));
			break;
		case 2:
			if(dx<this.tab_mem.get(indice).rendreX()&&dy<this.tab_mem.get(indice).rendreY())
				this.tab_mem.set(indice, new Point(this.tab_mem.get(indice).rendreX()-1,this.tab_mem.get(indice).rendreY()-1));
			else 
				this.tab_mem.set(indice, new Point(this.tab_mem.get(indice).rendreX()+1,this.tab_mem.get(indice).rendreY()+1));
			
			this.tab_mem.set(1,new Point(this.tab_mem.get(2).rendreX(),this.tab_mem.get(1).rendreY()));
			this.tab_mem.set(3,new Point(this.tab_mem.get(3).rendreX(),this.tab_mem.get(2).rendreY()));
			break;
		case 3:
			if(dx>this.tab_mem.get(indice).rendreX()&&dy<this.tab_mem.get(indice).rendreY())
				this.tab_mem.set(indice, new Point(this.tab_mem.get(indice).rendreX()+1,this.tab_mem.get(indice).rendreY()-1));
			else 
				this.tab_mem.set(indice, new Point(this.tab_mem.get(indice).rendreX()-1,this.tab_mem.get(indice).rendreY()+1));
			
			this.tab_mem.set(0,new Point(this.tab_mem.get(3).rendreX(),this.tab_mem.get(0).rendreY()));
			this.tab_mem.set(2,new Point(this.tab_mem.get(2).rendreX(),this.tab_mem.get(3).rendreY()));
			break;
		}		
		
		if (this.tab_mem.get(0).rendreX()>this.tab_mem.get(2).rendreX()){
			Point[] tmp = new Point[2];
			tmp[0]=this.tab_mem.get(2);
			tmp[1]=this.tab_mem.get(3);
			this.modifierPoints(tmp);
		}
			
	}
	
}
