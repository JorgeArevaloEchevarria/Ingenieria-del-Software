package patologia.vistas;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mocosete.VistaGui;
import patologia.control.ControlPatologia;
import transfers.TPatologia;

public class GUIMostrarPatologia extends JPanel{
	private static final long serialVersionUID = 1L;

	private JTextArea infoNinio;


	public GUIMostrarPatologia(List<TPatologia> p){
		initGUI(p);
	}

	public GUIMostrarPatologia(String e, ControlPatologia controlPatologia, VistaGui ventanaPrincipal) {
		// TODO Auto-generated constructor stub
	}

	private void initGUI(List<TPatologia> p){

		JFrame window = new JFrame();
		infoNinio = new JTextArea(5,30);
		infoNinio.setEditable(false);
		TPatologia[] j = (TPatologia[]) p.toArray();

		anadirDatos(" Nombre: "+j[0].getNombre());
		anadirDatos(" Peligrosidad: " + j[0].getPeligrosidad());
		anadirDatos(" Descripcion: " + j[0].getDescripcion());



		window.add(infoNinio);
		window.setResizable(false);
		window.setVisible(true);
		window.pack();

	}

	private void anadirDatos(String msg){
		infoNinio.append( msg +"\n");
	}

}