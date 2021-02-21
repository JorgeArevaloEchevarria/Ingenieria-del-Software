package ninio.logica;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import excepciones.BaseDeDatosException;

import transfers.TNinio;

/**
 * Clase de DaoNinio.
 * @author Grupo 9
 */
public class DaoNinio implements IDaoNinio
{
	/////////////////////////////////////////////ATRIBUTOS////////////////////////////////////////////////////////
	
	/**
	* Conexión entre la aplicación y la base de datos.
	*/
	private Connection connect = null;
	
	/**
	* Declaración de la base de batos.
	*/
	private Statement statement = null;
	
	/**
	* Preparación de la declaración.
	*/
	private PreparedStatement preparedStatement = null;
	
	/**
	* Resultado de la conexión.
	*/
	private ResultSet resultSet = null;
	
	/**
	* Usuario de la base datos.
	*/
	private String _usuario = "root";
	
	/**
	* Contraseña de la base datos.
	*/
	private String _pwd = "";
	
	/**
	* Nombre de la base de datos.
	*/
	private static String _bd = "osetemocosete";
	
	/**
	* Dirección en la que se situa la base de datos.
	*/
	static String _url = "jdbc:mysql://localhost/" + _bd + "?useServerPrepStmts=true";
	
	/**
	* Driver de la base de datos.
	*/
	private static String driver = "com.mysql.jdbc.Driver";
	
	//////////////////////////////////////////////CONTRUCTOR///////////////////////////////////////////
	/**
	 * Contructor del DaoNinio
	 */
	public DaoNinio(){}
	
	/////////////////////////////////////////////MÉTODOS PÚBLICOS//////////////////////////////////////
	
	public boolean existeNinio(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException
	{
		int cont = 0;
		try
		{
			conectar();
			preparedStatement = connect.prepareStatement("SELECT count(*) FROM ninios WHERE nombreninio = ?, apellidosninio = ?, nombrepatologia = ?");
			preparedStatement.setString(1, nombreNinio);
			preparedStatement.setString(2, apellidosNinio);
			preparedStatement.setString(3, nombrePatologia);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			cont = resultSet.getInt(1);
			close();
			return cont != 0;
		}
		catch (SQLException e){throw new BaseDeDatosException();}
	}

	public boolean existePatologia(String nombrePatologia) throws BaseDeDatosException
	{
		int cont = 0;
		try
		{
			conectar();
			
			if (connect != null)
            {
				preparedStatement = connect
				          .prepareStatement("SELECT count(*) FROM patologias WHERE nombrepatologia = ?");
				preparedStatement.setString(1, nombrePatologia);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				cont = resultSet.getInt(1);
				close();
            }
			return cont != 0;
		}
		catch (SQLException e) {throw new BaseDeDatosException();}
	}

	public void altaNinio(TNinio ninio) throws BaseDeDatosException
	{
		int filasAfectadas = 0;
		try
		{
			conectar();
			
			if (connect != null)
            {
				preparedStatement = connect
				          .prepareStatement("insert into ninios (nombreninio, "
				          		+ "apellidosninio, telefonocasaninio,"
				          		+ "nombretutorninio, moviltutorninio,"
				          		+ "nombrepatologia) values (?,?,?,?,?,?)");
			     preparedStatement.setString(1, ninio.getNombre());
			     preparedStatement.setString(2, ninio.getApellidos());
			     preparedStatement.setString(3, ninio.getTelefonoCasa());
			     preparedStatement.setString(4, ninio.getNombreTutor());
			     preparedStatement.setString(5, ninio.getMovilTutor());
			     preparedStatement.setString(6, ninio.getNombrePatologia());
			     filasAfectadas = preparedStatement.executeUpdate();
			 	close();
            }
			if(filasAfectadas == 0) throw new SQLException();
		}
		catch (SQLException e){throw new BaseDeDatosException();};
	}

	public void bajaNinio(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException
	{
		int filasAfectadas = 0;
		try
		{
			conectar();
			if (connect != null)
            {
				preparedStatement = connect
						.prepareStatement("DELETE from patologias WHERE nombreninio = ?, apellidosninio = ? nombrepatologia = ?");
				preparedStatement.setString(1, nombreNinio);
				preparedStatement.setString(2, apellidosNinio);
				preparedStatement.setString(3, nombrePatologia);
				filasAfectadas = preparedStatement.executeUpdate();
				close();
            }
			if(filasAfectadas == 0) throw new SQLException();
		}
		catch (SQLException e){throw new BaseDeDatosException();}
	}

	public JList<TNinio> consultarNinios() throws BaseDeDatosException{
		
		DefaultListModel<TNinio> modListaPanel = new DefaultListModel<TNinio>();
		JList<TNinio> listaNombre = new JList<TNinio>(modListaPanel);
		
		try
		{
			conectar();
			if (connect != null)
            {
				
				preparedStatement = connect
				          .prepareStatement("SELECT idninio, nombreninio, apellidosninio, telefonocasaninio,"
				          		+ " nombretutorninio, moviltutorninio, nombrepatologia"
				          		+ "FROM ninios ORDER by nombreninio");
				resultSet = preparedStatement.executeQuery();
			
				while(resultSet.next())	
				{
					TNinio nin = new TNinio();
					nin.setIdNinio(resultSet.getInt("idninio"));
					nin.setNombre(resultSet.getString("nombreninio"));
					nin.setApellidos("apellidosninio");
					nin.setTelefonoCasa("telefonocasaninio");
					nin.setNombreTutor("nombretutorninio");
					nin.setMovilTutor("moviltutorninio");
					nin.setNombrePatologia("nombrepatologia");
					modListaPanel.addElement(nin);
				}
				close();
            }
		}
		catch (SQLException e){throw new BaseDeDatosException();}
			
		return listaNombre;
	}
	
	public JList<TNinio> consultarNiniosFiltro(String nombreNinio, String apellidosNinio, String nombrePatologia) throws BaseDeDatosException
	{
		DefaultListModel<TNinio> modListaPanel = new DefaultListModel<TNinio>();
		JList<TNinio> listaNombre = new JList<TNinio>(modListaPanel);
		
		try
		{
			conectar();
			if (connect != null)
            {
				
				preparedStatement = connect
				          .prepareStatement("SELECT idninio, nombreninio, apellidosninio, telefonocasaninio,"
				          		+ " nombretutorninio, moviltutorninio, nombrepatologia"
				          		+ "FROM ninios where nombreninio like ?, apellidosninio like ?, nombrepatologia like ? ORDER by nombreninio");
				preparedStatement.setString(1,"%" + nombreNinio + "%");
				preparedStatement.setString(2,"%" + apellidosNinio + "%");
				preparedStatement.setString(3,"%" + nombrePatologia + "%");
				resultSet = preparedStatement.executeQuery();
			
				while(resultSet.next())	
				{
					TNinio nin = new TNinio();
					nin.setIdNinio(resultSet.getInt("idninio"));
					nin.setNombre(resultSet.getString("nombreninio"));
					nin.setApellidos("apellidosninio");
					nin.setTelefonoCasa("telefonocasaninio");
					nin.setNombreTutor("nombretutorninio");
					nin.setMovilTutor("moviltutorninio");
					nin.setNombrePatologia("nombrepatologia");
					modListaPanel.addElement(nin);
				}
				close();
            }
		}
		catch (SQLException e){throw new BaseDeDatosException();}
			
		return listaNombre;
	}

	public TNinio mostrarNinio(int idNinio) throws BaseDeDatosException
	{
		TNinio nin = new TNinio();
		try
		{
			conectar();
			if (connect != null)
            {
				preparedStatement = connect
						.prepareStatement("SELECT idninio, nombreninio, apellidosninio, telefonocasaninio,"
				          		+ " nombretutorninio, moviltutorninio, nombrepatologia"
								+ " FROM ninios WHERE idninio = ?");
				preparedStatement.setInt(1,idNinio);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();

				nin.setIdNinio(resultSet.getInt("idninio"));
				nin.setNombre(resultSet.getString("nombreninio"));
				nin.setApellidos(resultSet.getString("apellidosninio"));
				nin.setTelefonoCasa(resultSet.getString("telefonocasaninio"));
				nin.setNombreTutor(resultSet.getString("nombretutorninio"));
				nin.setMovilTutor(resultSet.getString("moviltutorninio"));
				nin.setNombrePatologia(resultSet.getString("nombrepatologia"));
				
				close();
            }
		}
		catch (SQLException e){throw new BaseDeDatosException();}
		return nin;
	}

	public void modificarNinio(TNinio ninio) throws BaseDeDatosException
	{
		int filasAfectadas = 0;
		try
		{
			conectar();
			if (connect != null)
            {
				preparedStatement = connect
						.prepareStatement("UPDATE ninios SET nombreninio = ?, apellidosninio = ?, telefonocasaninio = ?,"
				          		+ " nombretutorninio = ?, moviltutorninio = ?, nombrepatologia = ? WHERE idninio = ?");
				
				preparedStatement.setString(1, ninio.getNombre());
				preparedStatement.setString(2, ninio.getApellidos());
				preparedStatement.setString(3, ninio.getTelefonoCasa());
				preparedStatement.setString(4, ninio.getNombreTutor());
				preparedStatement.setString(5, ninio.getMovilTutor());
				preparedStatement.setString(6, ninio.getNombrePatologia());
				preparedStatement.setInt(7, ninio.getIdNinio());
				filasAfectadas = preparedStatement.executeUpdate();
				
				close();
            }
			if(filasAfectadas == 0) throw new SQLException();
		}
		catch (SQLException e){throw new BaseDeDatosException();}
	}
	
	///////////////////////////////////////////////MÉTODOS PRIVADOS///////////////////////////////////////

	/**
	 * Conecta la aplicación a la base de datos OseteMocosete.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	private void conectar() throws BaseDeDatosException
	{
		try
		{
			Class.forName(driver).newInstance();
			connect = DriverManager.getConnection(_url, _usuario, _pwd);
			statement = conexion();
		}
		catch (Exception e){throw new BaseDeDatosException();}
	}
	
	/**
	 * Activa la funcionalidad de la base de datos OseteMocosete.
	 * @return Base de datos funcionando.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos.
	 */
	private Statement conexion() throws BaseDeDatosException
	{
		Statement st = null;
		
	 	try{st = connect.createStatement();}
        catch (SQLException e){throw new BaseDeDatosException();}
        return st;
	}
	
	/**
	 * Cierra la conexión entre la aplicacion y la base de datos OseteMocosete.
	 * @throws BaseDeDatosException -
	 * 			Error con la base de datos. 
	 */
	private void close() throws BaseDeDatosException
	{
		try
		{
			if (resultSet != null) resultSet.close();
			if (statement != null) statement.close();
			if (connect != null)   connect.close();
		}
		catch (SQLException e){throw new BaseDeDatosException();}
	}
}