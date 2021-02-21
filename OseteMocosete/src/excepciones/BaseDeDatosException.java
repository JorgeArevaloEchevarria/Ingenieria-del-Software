package excepciones;

/**
 * Clase de BaseDeDatosException
 * @author Grupo 9
 */
public class BaseDeDatosException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public BaseDeDatosException(){super("Error en la base de datos");}
}