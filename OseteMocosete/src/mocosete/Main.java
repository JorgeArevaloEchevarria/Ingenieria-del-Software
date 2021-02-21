package mocosete;

import ninio.control.ControlNinio;
import patologia.control.ControlPatologia;

public class Main
{
	public static void main(String[] args)
	{
		ControlPatologia controlPatologia = new ControlPatologia();
		ControlNinio controlNinio = new ControlNinio();
		
		VistaGui vistaPrincipal = new VistaGui(controlPatologia, controlNinio);
		vistaPrincipal.setVisible(true);
	}
}