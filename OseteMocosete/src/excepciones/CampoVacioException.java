package excepciones;

/**
 * Clase de CampoVacioException
 * @author Grupo 9
 */
public class CampoVacioException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public CampoVacioException(String msg){super("Campo de" + msg + " vacío");}
}