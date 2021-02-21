package patologia.logica;

import javax.swing.JList;

import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import transfers.TPatologia;

/**
 * Clase de FachadaPatologia.
 * @author Grupo 9
 */
public class FachadaPatologia implements IFachadaPatologia
{
	///////////////////////////////////ATRIBUTOS//////////////////////////////////////////////////
	
	/**
	 * SA de la patología.
	 */
	private ISAPatologia sPat;
	
	///////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////////
	
	/**
	 * Constructor de FachadaPatologia.
	 */
	public FachadaPatologia(){this.sPat = new SAPatologia();}

	///////////////////////////////////MÉTODOS PÚBLICOS////////////////////////////////////////////
	
	public void altaPatologia(TPatologia patologia) throws CampoVacioException, ExistenciaException, BaseDeDatosException
	{
		this.sPat.altaPatologia(patologia);
	}
	
	public void bajaPatologia(String nombrePatologia) throws BaseDeDatosException{this.sPat.bajaPatologia(nombrePatologia);}
	
	public JList<String> consultarPatologias() throws BaseDeDatosException{return this.sPat.consultarPatologias();}
	
	public JList<String> consultarPatologiasFiltro(String nombrePatologia) throws BaseDeDatosException
	{
		return this.sPat.consultarPatologiasFiltro(nombrePatologia);
	}
	
	public TPatologia mostrarPatologia(int idPatologia) throws BaseDeDatosException{return this.sPat.mostrarPatologia(idPatologia);}
	
	public void modificarPatologia(TPatologia patologia) throws CampoVacioException, BaseDeDatosException{this.sPat.modificarPatologia(patologia);}
}