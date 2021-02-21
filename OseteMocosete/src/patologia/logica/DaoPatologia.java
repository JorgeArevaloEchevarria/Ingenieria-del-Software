package patologia.logica;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import excepciones.BaseDeDatosException;
import transfers.TPatologia;

/**
 * Clase de DaoPatologia.
 * @author Grupo 9
 */
public class DaoPatologia implements IDaoPatologia
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
	
	//////////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////////////
	
	/**
	 * Constructor de DaoPatología.
	 */
	public DaoPatologia(){}
	
	//////////////////////////////////////////////MÉTODOS PÚBLICOS////////////////////////////////////////////////
	
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
				preparedStatement.setString(1,nombrePatologia);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				cont = resultSet.getInt(1);
				close();
            }
		}
		catch (SQLException e) {throw new BaseDeDatosException();}
	
		 return cont != 0;
	}
	
	public void altaPatologia(TPatologia patologia) throws BaseDeDatosException
	{
		int filasAfectadas = 0;
		try
		{
			conectar();
			
			if (connect != null)
            {
				preparedStatement = connect
				          .prepareStatement("insert into patologias (nombrepatologia, "
				          		+ "peligrosidadpatologia, descripcionpatologia) values (?,?,?)");
			     preparedStatement.setString(1, patologia.getNombre());
			     preparedStatement.setString(2, patologia.getPeligrosidad());
			     preparedStatement.setString(3, patologia.getDescripcion());
			     filasAfectadas = preparedStatement.executeUpdate();
			 	close();
            }
			if(filasAfectadas == 0) throw new SQLException();
		}
		catch (SQLException e){throw new BaseDeDatosException();};
	}
	
	public void bajaPatologia(String nombrePatologia) throws BaseDeDatosException
	{
		int filasAfectadas = 0;
		try
		{
			conectar();

			if (connect != null)
            {
				preparedStatement = connect
						.prepareStatement("DELETE from patologias WHERE nombrepatologia = ?");
				preparedStatement.setString(1,nombrePatologia);
				filasAfectadas = preparedStatement.executeUpdate();
				close();
            }
			if(filasAfectadas == 0) throw new SQLException();
		}
		catch (SQLException e){throw new BaseDeDatosException();};
	}
	
	public JList<String> consultarPatologias() throws BaseDeDatosException
	{
		DefaultListModel<String> modListaPanel = new DefaultListModel<String>();
		JList<String> listaNombre = new JList<String>(modListaPanel);
		try
		{
			conectar();

			if (connect != null)
            {
				preparedStatement = connect
				          .prepareStatement("SELECT nombrepatologia FROM patologias ORDER by nombrepatologia");
				resultSet = preparedStatement.executeQuery();
			
				while(resultSet.next())	{modListaPanel.addElement(resultSet.getString("nombrepatologia"));}
				close();
            }
		}
		catch (SQLException e){throw new BaseDeDatosException();}
			
		return listaNombre;
	}
	
	public JList<String> consultarPatologiasFiltro(String nombrePatologia) throws BaseDeDatosException
	{
		DefaultListModel<String> modListaPanel = new DefaultListModel<String>();
		JList<String> listaNombre = new JList<String>(modListaPanel);
		try
		{
			conectar();
			
			if (connect != null)
            {
				preparedStatement = connect
				          .prepareStatement("SELECT nombrepatologia FROM patologias where "
				          		+ "nombrepatologia like ? ORDER by nombrepatologia");
				preparedStatement.setString(1,"%" + nombrePatologia + "%");
				resultSet = preparedStatement.executeQuery();
			
				while(resultSet.next()){modListaPanel.addElement(resultSet.getString("nombrepatologia"));}
				close();
            }
		}
		catch (SQLException e){throw new BaseDeDatosException();}
			
		return listaNombre;
	}

	public TPatologia mostrarPatologia(int idPatologia) throws BaseDeDatosException
	{
		TPatologia pat = new TPatologia(null, null,null);
		try
		{
			conectar();
			
			if (connect != null)
            {
				preparedStatement = connect
						.prepareStatement("SELECT idpatologia, nombrepatologia, peligrosidadpatologia, descripcionpatologia"
								+ " FROM patologias WHERE idpatologia = ?");
				preparedStatement.setInt(1,idPatologia);
				resultSet = preparedStatement.executeQuery();
				resultSet.next();

				pat.setId(resultSet.getInt("idpatologia"));
				pat.setNombre(resultSet.getString("nombrepatologia"));
				pat.setPeligrosidad(resultSet.getString("peligrosidadpatologia"));
				pat.setDescripcion(resultSet.getString("descripcionpatologia"));
				close();
            }
		}
		catch (SQLException e){throw new BaseDeDatosException();}
		return pat;
	}

	public void modificarPatologia(TPatologia patologia) throws BaseDeDatosException
	{
		int filasAfectadas = 0;
		try
		{
			conectar();
			
			if (connect != null)
            {
				preparedStatement = connect
						.prepareStatement("UPDATE patologias SET nombrepatologia= ?, peligrosidadpatologia= ?,"
								+ "descripcionpatologia = ? WHERE idpatologia = ?");
				
				preparedStatement.setString(1, patologia.getNombre());
				preparedStatement.setString(2, patologia.getPeligrosidad());
				preparedStatement.setString(3, patologia.getDescripcion());
				preparedStatement.setInt(4, patologia.getId());
				filasAfectadas = preparedStatement.executeUpdate();
				
				close();
            }
			if(filasAfectadas == 0) throw new SQLException();
		}
		catch (SQLException e){throw new BaseDeDatosException();};
	}
	
	//////////////////////////////////////////MÉTODOS PRIVADOS//////////////////////////////////////////////

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