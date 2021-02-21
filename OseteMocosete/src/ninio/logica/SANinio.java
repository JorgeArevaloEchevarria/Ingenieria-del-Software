package ninio.logica;

import javax.swing.JList;

import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import excepciones.InexistenciaException;
import excepciones.TelefonoException;
import transfers.TNinio;

/**
 * Clase de SANinio.
 * @author Grupo 9
 */
public class SANinio implements ISANinio
{
	//////////////////////////////////////////ATRIBUTOS///////////////////////////////////////////////////
	
	/**
	 * Dao del Niño.
	 */
	private IDaoNinio dNin;
	
	//////////////////////////////////////////CONSTRUCTOR////////////////////////////////////////////////
	
	/**
	 * Constructor de SANinio.
	 */
	public SANinio(){this.dNin = new DaoNinio();}
	
	//////////////////////////////////////////MÉTODOS PÚBLICOS///////////////////////////////////////////
	public void altaNinio(TNinio ninio) throws CampoVacioException, InexistenciaException, ExistenciaException, BaseDeDatosException, TelefonoException
	{
		if(!comprobarCampoNoVacio(ninio.getNombre())) throw new CampoVacioException("l nombre del niño");
		if(!comprobarCampoNoVacio(ninio.getApellidos())) throw new CampoVacioException(" los apellidos del niño");
		if(!comprobarCampoNoVacio(ninio.getNombrePatologia())) throw new CampoVacioException("l nombre de la patologia del niño");
		if(!this.dNin.existePatologia(ninio.getNombrePatologia())) throw new InexistenciaException("Patologia");
		if(this.dNin.existeNinio(ninio.getNombre(), ninio.getApellidos(), ninio.getNombrePatologia())) throw new ExistenciaException("Niño");
		if(comprobarCampoNoVacio(ninio.getNombreTutor())) throw new CampoVacioException("l nombre del tutor del niño");
		comprobarCampoTelefono(ninio.getTelefonoCasa());
		comprobarCampoTelefono(ninio.getMovilTutor());
		this.dNin.altaNinio(ninio);
	}
	
	public void bajaNinio(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException
	{
		this.dNin.bajaNinio(nombreNinio,apellidosNinio, nombrePatologia);
	}
	
	public JList<TNinio> consultarNinios() throws BaseDeDatosException{return this.dNin.consultarNinios();}
	
	public JList<TNinio> consultarNiniosFiltro(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException
	{
		return this.dNin.consultarNiniosFiltro(nombreNinio, apellidosNinio, nombrePatologia);
	}
	
	public TNinio mostrarNinio(int idNinio) throws BaseDeDatosException{return this.dNin.mostrarNinio(idNinio);}
	
	public void modificarNinio(TNinio ninio) throws CampoVacioException, TelefonoException, BaseDeDatosException
	{
		if(!comprobarCampoNoVacio(ninio.getNombre())) throw new CampoVacioException("l nombre del niño");
		if(!comprobarCampoNoVacio(ninio.getApellidos())) throw new CampoVacioException(" los apellidos del niño");
		if(comprobarCampoNoVacio(ninio.getNombreTutor())) throw new CampoVacioException("l nombre del tutor del niño");
		
		comprobarCampoTelefono(ninio.getTelefonoCasa());
		comprobarCampoTelefono(ninio.getMovilTutor());
		
		this.dNin.modificarNinio(ninio);
	}
	
	///////////////////////////////////////////////MÉTODOS PRIVADOS//////////////////////////////////////////////
	
	/**
	 * Comprueba que el campo del telefono se ha introducido correctamente
	 * @param telefono -
	 * 			Telefono a comprobar.
	 * @throws CampoVacioException -
	 * 			Si algún campo está vacío.
	 * @throws TelefonoException -
	 * 			Teléfono mal introducido.
	 */
	private void comprobarCampoTelefono(String telefono) throws CampoVacioException, TelefonoException
	{
		if(!comprobarCampoNoVacio(telefono)) throw new CampoVacioException("l teléfono de casa del niño");
		if(telefono.length() == 9) throw new TelefonoException("teléfono de casa");
	}

	/**
	 * Comprueba que se ha introducido el campo deseado.
	 * @param string -
	 * 			Campo a comprobar.
	 * @return Campo relleno o no.
	 */
	private boolean comprobarCampoNoVacio(String string){return string != null;}
}