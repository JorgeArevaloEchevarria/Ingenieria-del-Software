package ninio.logica;


import javax.swing.JList;

import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import excepciones.InexistenciaException;
import excepciones.TelefonoException;
import transfers.TNinio;

/**
 * Clase de la FachadaNinio.
 * @author Grupo 9
 */
public class FachadaNinio implements IFachadaNinio
{
	//////////////////////////////////////////ATRIBUTOS///////////////////////////////////////////////////
	
	/**
	* SA del Niño.
	*/
	private ISANinio saNin;
	
	//////////////////////////////////////////CONSTRUCTOR////////////////////////////////////////////////
	
	/**
	* Constructor de FachadaNinio.
	*/
	public FachadaNinio() {this.saNin = new SANinio();}

	//////////////////////////////////////////MÉTODOS PÚBLICOS///////////////////////////////////////////
	
	public void altaNinio(TNinio ninio) throws CampoVacioException, InexistenciaException, ExistenciaException, BaseDeDatosException, TelefonoException
	{
		this.saNin.altaNinio(ninio);
	}
	
	public void bajaNinio(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException
	{
		this.saNin.bajaNinio(nombreNinio,apellidosNinio, nombrePatologia);
	}
	
	public JList<TNinio> consultarNinios() throws BaseDeDatosException{return this.saNin.consultarNinios();}
	
	public JList<TNinio> consultarNiniosFiltro(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException
	{
		return this.saNin.consultarNiniosFiltro(nombreNinio, apellidosNinio, nombrePatologia);
	}
	
	public TNinio mostrarNinio(int idNinio) throws BaseDeDatosException{return this.saNin.mostrarNinio(idNinio);}
	
	public void modificarNinio(TNinio ninio) throws CampoVacioException, TelefonoException, BaseDeDatosException
	{
		this.saNin.modificarNinio(ninio);
	}
}