package patologia.logica;

import javax.swing.JList;

import excepciones.BaseDeDatosException;
import transfers.TPatologia;

/**
 * Interfaz del DaoPatologia.
 * @author Grupo 9
 */
public interface IDaoPatologia
{
	/**
	 * Comprueba si existe la patología dada por el nombre en la base de datos.
	 * @param nombrePatologia -
	 * 			Nombre de la patología.
	 * @return Existencia o no.
	 * @throws BaseDeDatosException -
	 * 			Error con la base datos.  
	 */
	public boolean existePatologia(String nombrePatologia) throws BaseDeDatosException;
	
	/**
	 * Da de alta un patologia.
	 * @param patologia -
	 * 			Patologia que queremos dar de alta.
	 * @throws BaseDeDatosException -
	 * 			Error con la base datos. 
	 */
	public void altaPatologia(TPatologia patologia) throws BaseDeDatosException;
	
	/**
	 * Da de baja a la patologia dada por su id.
	 * @param nombrePatologia -
	 * 			Nombre de la patologia.
	 * @throws BaseDeDatosException -
	 * 			Error con la base datos.
	 */
	public void bajaPatologia(String nombrePatologia) throws BaseDeDatosException;
	
	/**
	 * Consulta todas las patologías almacenadas en la base de datos.
	 * @return Lista de patologías existentes.
	 * @throws BaseDeDatosException -
	 * 			Error con la base datos.
	 */
	public JList<String> consultarPatologias() throws BaseDeDatosException;
	
	/**
	 * Consulta todas las patologías que coincidan con el filtro a cuestión en la base de datos.
	 * @param nombrePatologia -
	 * 				Filtro de búsqueda.
	 * @return Lista de patologías coincidentes.
	 * @throws BaseDeDatosException -
	 * 			Error con la base datos.
	 */
	public JList<String> consultarPatologiasFiltro(String nombrePatologia) throws BaseDeDatosException;
	
	/**
	 * Muestra una patologia dada por su id.
	 * @param idPatologia -
	 * 				Id de la patología a mostrar.
	 * @return Patología a mostrar.
	 * @throws BaseDeDatosException -
	 * 			Error con la base datos.
	 */
	public TPatologia mostrarPatologia(int idPatologia) throws BaseDeDatosException;
	
	/**
	 * Modifica una patología.
	 * @param patologia - 
	 * 			Patología a modificar.
	 * @throws BaseDeDatosException -
	 * 			Error con la base datos.
	 */
	public void modificarPatologia(TPatologia patologia) throws BaseDeDatosException;
}