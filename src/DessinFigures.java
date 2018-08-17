import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class DessinFigures extends JPanel{
	public final static int NOMBRE_FIGURES_MAX = 100;
	protected FigureColoree[] figures;
	protected TraceurForme traceur;
	protected FabricantFigures ff;
	private int nbf,sel;
	protected Color couleur;
	private int carreSelect;
	private Point pointDuCliquePourTranslation;

	private class ManipulateurFormes implements MouseMotionListener,MouseListener{

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
			boolean uneFigEstSelect = false;
			DessinFigures tmp = (DessinFigures)(e.getSource());
			for (int i=0;i<nbf;i++){
				if (figures[i].estDedans(e.getX(), e.getY()) || tmp.figures[i].carreDeSelection(e.getX(), e.getY()) != -1){
					tmp.selectionProchaineFigure(i);
					tmp.repaint();
					uneFigEstSelect = true;
					tmp.carreSelect = tmp.figureSelection().carreDeSelection(e.getX(), e.getY());
					tmp.pointDuCliquePourTranslation = new Point(e.getX(),e.getY());
				}
			}
			if (!uneFigEstSelect){
				tmp.desactiveManipulationsSouris();
				tmp.repaint();
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			DessinFigures tmp = (DessinFigures)(e.getSource());
			tmp.carreSelect = -1;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			DessinFigures tmp = (DessinFigures)(e.getSource());

			if (tmp.sel != -1){
				if(SwingUtilities.isRightMouseButton(e)){
					tmp.figureSelection().translation(e.getX()-tmp.pointDuCliquePourTranslation.rendreX(), e.getY()-tmp.pointDuCliquePourTranslation.rendreY());
					tmp.pointDuCliquePourTranslation = new Point(e.getX(),e.getY());
				} else if (tmp.carreSelect != -1){
					if(SwingUtilities.isLeftMouseButton(e))
						tmp.figureSelection().transformation(e.getX(), e.getY(), carreSelect);
				}
				tmp.repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}


	private ManipulateurFormes mf;


	public DessinFigures() {
		this.figures = new FigureColoree[DessinFigures.NOMBRE_FIGURES_MAX];
		this.nbf = 0;
		this.sel = -1;
		this.traceur = null;
		this.couleur = Color.BLACK;
		this.carreSelect = -1;
	}

	public void effacer(){
		this.figures = new FigureColoree[DessinFigures.NOMBRE_FIGURES_MAX];
		this.nbf = 0;
		this.sel = -1;
		this.traceur = null;
		this.repaint();
	}

	public void activeManipulationsSouris(){
		this.mf = new ManipulateurFormes();
		this.addMouseListener(this.mf);
		this.addMouseMotionListener(this.mf);
	}

	public void ajoute(FigureColoree fc){
		if (this.nbFigures() < DessinFigures.NOMBRE_FIGURES_MAX){
		this.figures[this.nbf] = fc;
		this.nbf+=1;
		}
	}

	public void construit(FigureColoree fc){
		if (this.nbFigures() < DessinFigures.NOMBRE_FIGURES_MAX){
			ff = new FabricantFigures(fc);
			this.addMouseListener(ff);
		} 
	}

	public void desactiveManipulationsSouris(){
		if (this.sel != -1 && this.sel < this.nbFigures())
			this.figures[this.sel].deSelecctionne();
		this.sel = -1;
	}

	public FigureColoree figureSelection(){
		if (this.sel != -1){
			return this.figures[this.sel];
		}
		return null;
	}

	public int nbFigures(){
		return this.nbf;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0;i<this.nbFigures();i++){
			this.figures[i].affiche(g);
		}
	}

	public void selectionProchaineFigure(int i){
		if (this.sel != -1)
			this.figures[this.sel].deSelecctionne();
		this.sel = i;
		this.figures[this.sel].selectionne();


	}

	public void supprimeAuditeurs(){
		this.removeMouseListener(traceur);
		this.removeMouseListener(ff);
		this.removeMouseMotionListener(traceur);
		this.desactiveManipulationsSouris();
		this.removeMouseListener(this.mf);
		this.removeMouseMotionListener(this.mf);
		this.traceur = null;
		this.repaint();
	}

	public void trace(Color c){
		if (this.nbFigures() < DessinFigures.NOMBRE_FIGURES_MAX){
			Graphics g = getGraphics();
			g.setColor(c);
			traceur = new TraceurForme(g);
			this.addMouseListener(traceur);
			this.addMouseMotionListener(traceur);
			traceur.setCouleur(c);
		}
	}

	public void sauvgarder(){
		try {
			this.desactiveManipulationsSouris();
			ObjectOutputStream file= new ObjectOutputStream( new FileOutputStream("Tab_Figures.figures"));
			file.writeInt(this.nbFigures());
			file.writeObject(this.figures);
			file.close();
		} catch (IOException e) {
			System.out.println("Impossible de sauvgarder les figures");
			e.printStackTrace();
		}
	}

	public void charger(){
		try {
			ObjectInputStream file= new ObjectInputStream( new FileInputStream("Tab_Figures.figures"));
			this.figures = new FigureColoree[DessinFigures.NOMBRE_FIGURES_MAX];
			this.nbf = file.readInt();
			this.sel = -1;
			this.carreSelect = -1;
			this.figures=(FigureColoree[]) file.readObject();
			this.repaint();
			file.close();
		} catch (IOException e) {
			System.out.println("Impossible de charger les figures");
		} catch (ClassNotFoundException e) {
			System.out.println("La class de chargement n'exisye pas");
		}
	}
	
	public void screenShoot(){
		BufferedImage bI = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_BYTE_INDEXED);
		this.paint(bI.getGraphics());
		try {
		FileOutputStream fichier = new FileOutputStream(new File("capture.jpg"));
		ImageIO.write(bI, "jpg", fichier);
		fichier.close();
		} catch (Exception e) {
		System.out.println("Capture d'ecran impossible");
		e.printStackTrace();
		} 
		
	}

}
