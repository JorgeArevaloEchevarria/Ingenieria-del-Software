package patologia.control;

import javax.swing.JList;

import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import patologia.logica.FachadaPatologia;
import patologia.logica.IFachadaPatologia;
import transfers.TPatologia;

/**
 * Clase de ControlPatología
 * @author Grupo 9
 */
public class ControlPatologia
{
	////////////////////////////////////////ATRIBUTOS////////////////////////////////////////////////
	
	/**
	 * Fachada de la patología.
	 */
	private IFachadaPatologia fPat;
	
	////////////////////////////////////////CONSTRUCTOR//////////////////////////////////////////////
	
	/**
	 * Contructor de ControlPatologia.
	 */
	public ControlPatologia(){this.fPat = new FachadaPatologia();}
	
	/////////////////////////////////////////MÉTODOS PÚBLICOS////////////////////////////////////////
	
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
	public void altaPatologia(TPatologia patologia) throws CampoVacioException, ExistenciaException, BaseDeDatosException
	{
		this.fPat.altaPatologia(patologia);
	}
	
	/**
	 * Da de baja a la patologia dada por su id
	 * @param nombrePatologia -
	 * 			Nombre de la patologia.
	 * @return Base de datos sin la patologia.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */	
	public void bajaPatologia(String nombrePatologia) throws BaseDeDatosException{this.fPat.bajaPatologia(nombrePatologia);}
	
	/**
	 * Consulta todas las patologías almacenadas en la base de datos.
	 * @return Lista de patologías existentes.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	public JList<String> consultarPatologias() throws BaseDeDatosException{return this.fPat.consultarPatologias();}
	
	/**
	 * Consulta todas las patologías que coincidan con el filtro a cuestión.
	 * @param nombrePatologia -
	 * 				Filtro de búsqueda.
	 * @return Lista de patologías coincidentes.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	public JList<String> consultarPatologiaFiltros(String nombrePatologia) throws BaseDeDatosException
	{
		return this.fPat.consultarPatologiasFiltro(nombrePatologia);
	}
	
	/**
	 * Muestra una patologia dada por su id.
	 * @param idPatologia -
	 * 				Id de la patología a mostrar.
	 * @return Patología a mostrar.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	public TPatologia mostrarPatologia(int idPatologia) throws BaseDeDatosException
	{
		return this.fPat.mostrarPatologia(idPatologia);
	}
	
	/**
	 * Modifica una patología. 
	 * @param patologia -
	 * 			Patología a modificar.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos. 
	 * @throws CampoVacioException -
	 * 			Si algún campo está vacío.
	 */
	public void modificarPatologia(TPatologia patologia) throws CampoVacioException, BaseDeDatosException
	{
		this.fPat.modificarPatologia(patologia);
	}
}
