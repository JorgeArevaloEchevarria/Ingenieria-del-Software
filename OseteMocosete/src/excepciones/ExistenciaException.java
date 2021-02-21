package excepciones;

/**
 * Clase de ExistenciaException
 * @author Grupo 9
 */
public class ExistenciaException extends Exception
{
	private static final long serialVersionUID = 1L;

	public ExistenciaException(String msg){super(msg + " existente en la base de datos");}
}