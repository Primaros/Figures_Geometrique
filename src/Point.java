import java.io.Serializable;


@SuppressWarnings("serial")
public class Point implements Serializable{
	private int x;
	private int y;
	
	public Point(int ix, int iy){
		this.x = ix;
		this.y = iy;
	}
	
	public double distance(Point i){
		double X, Y;
		
		X = Math.pow((this.rendreX()-i.rendreX()),2);
		Y = Math.pow((this.rendreY()-i.rendreY()),2);
		double a = Math.sqrt(X+Y);
		return Math.abs(a);
	}
	
	public int rendreX(){
		return this.x;
	}
	
	public int rendreY(){
		return this.y;
	}
	
	public void incrementerX(int x){
		this.x += x;
	}
	
	public void incrementerY(int y){
		this.y += y;
	}
	
	public void modifierX(int x){
		this.x = x;
	}
	
	public void modifierY(int y){
		this.y = y;
	}
	
	public void translation(int y, int x){
		this.x = x;
		this.y = y;
	}
}
