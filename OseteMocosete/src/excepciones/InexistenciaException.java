package excepciones;

/**
 * Clase de InexistenciaException
 * @author Grupo 9
 */
public class InexistenciaException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InexistenciaException(String msg){super(msg + " no existente en la base de datos");}
}
