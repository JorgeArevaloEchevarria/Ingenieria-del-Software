package patologia.logica;

import javax.swing.JList;

import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import transfers.TPatologia;

/**
 * Clase de SAPatologia.
 * @author Grupo 9
 */
public class SAPatologia implements ISAPatologia
{
	/////////////////////////////////ATRIBUTOS/////////////////////////////////////////////////////
	
	/**
	 * Dao de la Patología.
	 */
	private IDaoPatologia dPat;
	
	////////////////////////////////CONSTRUCTOR////////////////////////////////////////////////////
	
	/**
	 * Constructor de SAPatologia.
	 */
	public SAPatologia(){this.dPat = new DaoPatologia();}
	
	////////////////////////////////MÉTODOS PUBLICOS/////////////////////////////////////////////////
	
	public void altaPatologia(TPatologia patologia) throws CampoVacioException, ExistenciaException, BaseDeDatosException
	{
		if(!comprobarCampoNoVacio(patologia.getNombre())) throw new CampoVacioException("l nombre de la patología ");
		if(!comprobarCampoNoVacio(patologia.getPeligrosidad())) throw new CampoVacioException(" la patología de la patología");
		if(!comprobarCampoNoVacio(patologia.getDescripcion())) throw new CampoVacioException(" la descripción de la patología ");
		if(this.dPat.existePatologia(patologia.getNombre())) throw new ExistenciaException("Patología");
		
		this.dPat.altaPatologia(patologia);
	}

	public void bajaPatologia(String nombrePatologia) throws BaseDeDatosException{this.dPat.bajaPatologia(nombrePatologia);}
	
	public JList<String> consultarPatologias() throws BaseDeDatosException{return this.dPat.consultarPatologias();}

	public JList<String> consultarPatologiasFiltro(String nombrePatologia) throws BaseDeDatosException
	{
		return this.dPat.consultarPatologiasFiltro(nombrePatologia);
	}

	public TPatologia mostrarPatologia(int idPatologia) throws BaseDeDatosException{return this.dPat.mostrarPatologia(idPatologia);}

	public void modificarPatologia(TPatologia patologia) throws CampoVacioException, BaseDeDatosException
	{
		if(!comprobarCampoNoVacio(patologia.getNombre())) throw new CampoVacioException("l nombre de la patología ");
		if(!comprobarCampoNoVacio(patologia.getPeligrosidad())) throw new CampoVacioException(" la patología de la patología");
		if(!comprobarCampoNoVacio(patologia.getDescripcion())) throw new CampoVacioException(" la descripción de la patología ");
		
		this.dPat.modificarPatologia(patologia);
	}

	/////////////////////////////////MÉTODOS PRIVADOS////////////////////////////////////////////////
	
	/**
	 * Comprueba que se ha introducido el campo deseado.
	 * @param string -
	 * 			Campo a comprobar.
	 * @return Campo relleno o no.
	 */
	private boolean comprobarCampoNoVacio(String string){return string != null;}
}