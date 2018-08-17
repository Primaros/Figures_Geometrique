import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Menu extends JPanel{
	
	private DessinFigures dessin;
	
	public Menu(DessinFigures i){
		this.dessin = i;
		
		JButton sav = new JButton("Sauvegarder");
		JButton charg = new JButton("Charger");
		JButton screenS = new JButton("ScreenShoot");

		this.setLayout(new GridLayout(1,3));
		this.add(sav);
		this.add(charg);
		this.add(screenS);
		
		
		
		sav.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dessin.sauvgarder();
			}
			
		});
		
		charg.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dessin.charger();
			}
			
		});
		
		screenS.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dessin.screenShoot();
			}
			
		});
	}

}
