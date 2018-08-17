import java.io.Serializable;


@SuppressWarnings("serial")
public class Liste implements Serializable{
	
	Point[] points;
	
	public Liste(){
		this.points=new Point[0];
	}
	
	public boolean add(Point arg0) {
		Point[] tmp = this.points;
		this.points = new Point[this.points.length+1];
		for(int i=0;i<tmp.length;i++)
			this.points[i] = tmp[i];
		this.points[this.points.length-1] = arg0;
		return false;
	}
	
	public void clear() {
		this.points=new Point[0];
	}
	
	public Point get(int arg0) {
		return this.points[arg0];
	}
	
	public void set(int arg0, Point arg1) {
		this.points[arg0] = arg1;
	}
	
	public int size() {
		return this.points.length;
	}
	
}
