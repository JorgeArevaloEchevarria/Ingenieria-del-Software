package ninio.logica;

import javax.swing.JList;

import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import excepciones.InexistenciaException;
import excepciones.TelefonoException;
import transfers.TNinio;

/**
 * Interfaz del FachadaNinio.
 * @author Grupo 9
 */
public interface IFachadaNinio
{
	/**
	 * Da de alta un niño.
	 * @param ninio -
	 * 			Niño que queremos dar de alta.
	 * @throws CampoVacioException -
	 * 			Si algún campo está vacío.
	 * 	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 * @throws ExistenciaException -
	 * 			Existente niño en la base datos.
	 * @throws InexistenciaException -
	 * 			No existe la patologia en la base de datos.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos. 
	 */
	public void altaNinio(TNinio ninio) throws CampoVacioException, InexistenciaException, ExistenciaException, BaseDeDatosException, TelefonoException;
	
	/**
	 * Da de baja al niño dado por su nombre, apellidos y el nombre de la patologia.
	 * @param nombreNinio -
	 * 			Nombre del niño.
	 * @param apellidosNinio -
	 * 			Apellidos del niño.
	 * @param nombrePatologia -
	 * 			Nombre de la patología.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	public void bajaNinio(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException;

	/**
	 * Consulta todos los niños almacenados en la base de datos.
	 * @return Lista de niños existentes.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos. 
	 */
	public JList<TNinio> consultarNinios() throws BaseDeDatosException;

	/**
	 * Consulta todos los niños que coincidan con el filtro a cuestión en la base de datos.
	 *  @param nombreNinio -
	 * 			Filtro del nombre del niño.
	 * @param apellidosNinio -
	 * 			Filtro de los apellidos del niño.
	 * @param nombrePatologia -
	 * 			Filtro del nombre de la patología.
	 * @return Lista de niños coincidentes.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos. 
	 */
	public JList<TNinio> consultarNiniosFiltro(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException;
	
	/**
	 * Muestra un niño dado por su id.
	 * @param idNinio -
	 * 				Id del niño a mostrar.
	 * @return Niño a mostrar.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	public TNinio mostrarNinio(int idNinio) throws BaseDeDatosException;
	
	/**
	 * Modifica un niño.
	 * @param ninio - 
	 * 			Niño a modificar.
	 * @return Niño modicifado en la base de datos.
	 * @throws CampoVacioException -
	 * 			Si algún campo está vacío.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 * @throws TelefonoException -
	 * 			Teléfono mal introducido. 
	 */
	public void modificarNinio(TNinio ninio) throws CampoVacioException, TelefonoException, BaseDeDatosException;
}