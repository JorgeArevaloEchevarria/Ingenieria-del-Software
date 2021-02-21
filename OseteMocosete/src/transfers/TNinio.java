package transfers;

/**
 * Clase del tipo Ninio.
 * @author Grupo 9
 */
public class TNinio
{
	///////////////////////////////////////////ATRIBUTOS//////////////////////////////////
	
	/**
	 * Id del niño.
	 */
	private int idninio;
	
	/**
	 * Nombre del niño.
	 */
	private String nombreninio;
	
	/**
	 * Apellidos del niño.
	 */
	private String apellidosninio;
	
	/**
	 * Teléfono de casa del niño.
	 */
	private String telefonocasaninio;
	
	/**
	 * Nombre del tutor legal del niño.
	 */
	private String nombretutorninio;
	
	/**
	 * Móvil del tutor legal del niño.
	 */
	private String moviltutorninio;
	
	/**
	 * Nombre de la patología del niño.
	 */
	private String nombrepatologianinio;
	
	//////////////////////////////////////////CONSTRUCTOR//////////////////////////////////
	
	/**
	 * Constructor del niño sin parámetros. Pone a null todo.
	 */
	public TNinio(){}
	
	/**
	 * Constructor del niño.
	 * @param nombreNinio -
	 * 				Nombre del niño.
	 * @param apellidosNinio -
	 * 				Apellidos del niño.
	 * @param telefonoCasaninio -
	 * 				Teléfono de casa del niño.
	 * @param nombreTutorNinio
	 * 				Nombre del tutor legal del niño.
	 * @param movilTutorNinio
	 * 				Móvil del tutor legal del niño.
	 * @param nombrePatologia
	 * 				Nombre de la patología del niño.
	 */
	public TNinio(String nombreNinio, String apellidosNinio, String telefonoCasaNinio, String nombreTutorNinio, String movilTutorNinio, String nombrePatologia)
	{
		this.nombreninio = nombreNinio;
		this.apellidosninio = apellidosNinio;
		this.telefonocasaninio = telefonoCasaNinio;
		this.nombretutorninio = nombreTutorNinio;
		this.moviltutorninio = movilTutorNinio;
		this.nombrepatologianinio = nombrePatologia;
	}

	///////////////////////////////////////GETTERS & SETTERS////////////////////////////////////
	
	/**
	 * Coge la id del niño.
	 * @return Id del niño.
	 */
	public int getIdNinio(){return idninio;}
	
	/**
	 * Pone la id del niño.
	 * @param idNinio -
	 * 				Id del niño.
	 */
	public void setIdNinio(int idNinio){this.idninio = idNinio;}
	
	/**
	 * Coge el nombre del niño.
	 * @return Nombre del niño.
	 */
	public String getNombre(){return nombreninio;}
	
	/**
	 * Pone el nombre del niño.
	 * @param nombreNinio -
	 * 				Nombre del niño.
	 */
	public void setNombre(String nombreNinio){this.nombreninio = nombreNinio;}

	/**
	 * Coge los apellidos del niño.
	 * @return Apellidos del niño.
	 */
	public String getApellidos(){return apellidosninio;}
	
	/**
	 * Pone los apellidos del niño.
	 * @param apellidosNinio -
	 * 				Apellidos del niño.
	 */
	public void setApellidos(String apellidos){this.apellidosninio = apellidos;}

	/**
	 * Coge el teléfono de la casa del niño.
	 * @return Teléfono de la casa del niño.
	 */
	public String getTelefonoCasa(){return this.telefonocasaninio;}
	
	/**
	 * Pone el teléfono de la casa del niño.
	 * @param telefonoCasaNinio -
	 * 				Teléfono de la casa del niño.
	 */
	public void setTelefonoCasa(String telefonoCasaNinio){this.telefonocasaninio = telefonoCasaNinio;}

	/**
	 * Coge el nombre del tutor del niño.
	 * @return Nombre del tutor del niño.
	 */
	public String getNombreTutor(){return this.nombretutorninio;}
	
	/**
	 * Pone el nombre del tutor del niño.
	 * @param nombreTutorNinio -
	 * 				Nombre del tutor del niño.
	 */
	public void setNombreTutor(String nombreTutorNinio){this.nombretutorninio = nombreTutorNinio;}

	/**
	 * Coge el móvil del tutor del niño.
	 * @return Móvil del tutor del niño.
	 */
	public String getMovilTutor(){return this.moviltutorninio;}
	
	/**
	 * Pone el móvil del tutor del niño.
	 * @param movilTutorNinio -
	 * 				Móvil del tutor del niño.
	 */
	public void setMovilTutor(String movilTutorNinio){this.moviltutorninio = movilTutorNinio;}

	/**
	 * Coge el nombre de la patología del niño.
	 * @return Nombre de la patología del niño.
	 */
	public String getNombrePatologia(){return this.nombrepatologianinio;}
	
	/**
	 * Pone el nombre de la patología del niño.
	 * @param nombrePatologiaNinio -
	 * 				Nombre de la patología del niño.
	 */
	public void setNombrePatologia(String nombrePatologiaNinio) {this.nombrepatologianinio = nombrePatologiaNinio;}
}