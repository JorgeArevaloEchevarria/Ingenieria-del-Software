package excepciones;

/**
 * Clase de TelefonoException
 * @author Grupo 9
 */
public class TelefonoException extends Exception
{
	private static final long serialVersionUID = 1L;

	public TelefonoException(String msg){super("El " + msg + " puesto incorrectamente");}
}
