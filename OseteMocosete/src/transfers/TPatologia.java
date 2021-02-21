package transfers;

/**
 * Clase del tipo Patologia.
 * @author Grupo 9
 */
public class TPatologia
{
	//////////////////////////////////////////ATRIBUTOS//////////////////////////////////////////
	
	/**
	 * Id de la patología.
	 */
	private int idpatologia;
	
	/**
	 * Nombre de la patología.
	 */
	private String nombrepatologia;
	
	/**
	 * Nivel de peligrosidad de la patología.
	 */
	private String peligrosidadpatologia;
	
	/**
	 * Descripción de la patología.
	 */
	private String descripcionpatologia;

	/////////////////////////////////////////CONSTRUCTOR////////////////////////////////////////
	
	/**
	 * Constructor de la patología sin parámetros. Pone a null todo.
	 */
	public TPatologia(){}
	
	/**
	 * Contructor de la patología.
	 * @param nombre -
	 * 				Nombre de la patología.
	 * @param peligrosidad -
	 * 				Nivel de peligrosidad de la patología.
	 * @param descripcion -
	 * 				Descripción de la patología.
	 */
	public TPatologia(String nombre,String peligrosidad,String descripcion)
	{
		this.nombrepatologia = nombre;
		this.peligrosidadpatologia = peligrosidad;
		this.descripcionpatologia = descripcion;
	}
	
	///////////////////////////////////////GETTERS & SETTERS////////////////////////////////////
	
	/**
	 * Coge la id de la patología.
	 * @return Id de la patología.
	 */
	public int getId(){return this.idpatologia;}
	
	/**
	 * Pone la id de la patología.
	 * @param idPatologia -
	 * 				Id de la patología.
	 */
	public void setId(int idPatologia){this.idpatologia = idPatologia;}
	
	/**
	 * Coge el nombre de la patología.
	 * @return Nombre de la patología.
	 */
	public String getNombre(){return this.nombrepatologia;}
	
	/**
	 * Pone el nombre de la patología.
	 * @param nombrePatologia -
	 * 				Nombre de la patología.
	 */
	public void setNombre(String nombrePatologia){this.nombrepatologia = nombrePatologia;}
	
	/**
	 * Coge la peligrosidad de la patología.
	 * @return Peligrosidad de la patología.
	 */
	public String getPeligrosidad(){return this.peligrosidadpatologia;}
	
	/**
	 * Pone la peligrosidad de la patología.
	 * @param peligrosidadPatologia -
	 * 				Peligrosidad de la patología.
	 */
	public void setPeligrosidad(String peligrosidadPatologia){this.peligrosidadpatologia = peligrosidadPatologia;}	

	/**
	 * Coge la descripción de la patología.
	 * @return Descripción de la patología.
	 */
	public String getDescripcion(){return this.descripcionpatologia;}
	/**
	 * Pone la descripción de la patología.
	 * @param descripcionPatologia -
	 * 				Descripción de la patología.
	 */
	public void setDescripcion(String descripcionPatologia){this.descripcionpatologia = descripcionPatologia;}
}