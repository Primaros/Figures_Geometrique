import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	private DessinFigures dessin;

	public Fenetre(String s, int w, int h){
		this.dessin = new DessinFigures();
		PanneauChoix pan = new PanneauChoix(this.dessin);
		Menu men = new Menu(this.dessin);
		
		this.dessin.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(s);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(w,h));
		
		this.getContentPane().add(pan,BorderLayout.NORTH);
		this.getContentPane().add(this.dessin,BorderLayout.CENTER);
		this.getContentPane().add(men,BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		Fenetre fenet = new Fenetre("Figures Geometriques",600,400);
		
	}

}
