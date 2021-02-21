package patologia.logica;

import javax.swing.JList;

import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import transfers.TPatologia;
/**
 * Interfaz de la FachadaPatologia.
 * @author Grupo 9
 */
public interface IFachadaPatologia
{
	/**
	 * Da de alta un patologia.
	 * @param patologia -
	 * 			Patologia que queremos dar de alta.
	 * @throws CampoVacioException -
	 * 			Si algún campo está vacío.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 * @throws ExistenciaException -
	 * 			Existente niño en la base datos.
	 */
	public void altaPatologia(TPatologia patologia) throws CampoVacioException, ExistenciaException, BaseDeDatosException;
	
	/**
	 * Da de baja a la patologia dada por su id.
	 * @param nombrePatologia -
	 * 			Nombre de la patologia.
	 * @return Base de datos sin la patologia.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	public void bajaPatologia(String nombrePatologia) throws BaseDeDatosException;
	
	/**
	 * Consulta todas las patologías almacenadas en la base de datos.
	 * @return Lista de patologías existentes.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	public JList<String> consultarPatologias() throws BaseDeDatosException;
	
	/**
	 * Consulta todas las patologías que coincidan con el filtro a cuestión en la base de datos.
	 * @param nombrePatologia -
	 * 				Filtro de búsqueda.
	 * @return Lista de patologías coincidentes.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos. 
	 */
	public JList<String> consultarPatologiasFiltro(String nombrePatologia) throws BaseDeDatosException;
	
	/**
	 * Muestra una patologia dada por su id.
	 * @param idPatologia -
	 * 				Id de la patología a mostrar.
	 * @return Patología a mostrar.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos. 
	 */
	public TPatologia mostrarPatologia(int idPatologia) throws BaseDeDatosException;
	
	/**
	 * Modifica una patología.
	 * @param patologia - 
	 * 			Patología a modificar.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos. 
	 * @throws CampoVacioException -
	 * 			Si algún campo está vacío.
	 */
	public void modificarPatologia(TPatologia patologia) throws CampoVacioException, BaseDeDatosException;
}