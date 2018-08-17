import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class TraceurForme extends JPanel implements MouseMotionListener,MouseListener {
	
	private Graphics g;
	private Traits tracer;
	
	public TraceurForme(Graphics gg){
		this.g = gg;
		this.tracer = new Traits();
	}

	public void trace(int x, int y){
		tracer.addPoint(new Point(x,y));
		tracer.affiche(g);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		if (SwingUtilities.isLeftMouseButton(arg0)){
			this.trace(arg0.getX(),arg0.getY());
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			this.trace(e.getX(),e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		DessinFigures a = (DessinFigures)(e.getSource());
		a.ajoute(this.tracer);
		a.supprimeAuditeurs();
		tracer = new Traits();
		a.trace(g.getColor());
	}
	
	public void setCouleur(Color c){
		this.g.setColor(c);
		this.tracer.changeCouleur(c);
	}

}
