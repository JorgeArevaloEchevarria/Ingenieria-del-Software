package ninio.vista;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import transfers.TNinio;

public class GUIMostrarNinio extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextArea infoNinio;

	
	public GUIMostrarNinio(List<TNinio> n){
		
		initGUI(n);
		
	}
	
	private void initGUI(List<TNinio> n){
		
		JFrame window = new JFrame();
		infoNinio = new JTextArea(5,30);
		infoNinio.setEditable(false);
		TNinio[] j = (TNinio[]) n.toArray();
		
		anadirDatos(" Nombre: "+j[0].getNombre());
		anadirDatos(" Apellidos: " + j[0].getApellidos());
		anadirDatos(" Telefono: " + j[0].getTelefonoCasa());
		anadirDatos(" Tutores: " + j[0].getNombreTutor());
		anadirDatos(" Movil Tutor: " + j[0].getMovilTutor());
		anadirDatos(" Patologias: ");
		
		for(TNinio ninio : j )
			anadirDatos(" - " + ninio.getNombrePatologia());
			
	
		window.add(infoNinio);
		window.setResizable(false);
		window.setVisible(true);
		window.pack();
	
	}
	
	private void anadirDatos(String msg){
		infoNinio.append( msg +"\n");
	}
	
}
