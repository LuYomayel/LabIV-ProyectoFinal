package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.LocalidadDao;
import Entidad.Localidad;
import Entidad.Pais;

public class LocalidadDaoImpl implements LocalidadDao {
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root";/* "root";*/
	private static String dbName = "dbutn2";
	@Override
	public int AgregarLocalidad(Localidad localidad) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String query = "INSERT INTO localidades(idLocalidad,descripcion,idProvincia) values("+localidad.getIdLocalidad()+",'"+localidad.getDescripcion()+",'"+localidad.getIdProvincia()+"');";
		
		Connection cn = null;
		int filas =0;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	@Override
	public ArrayList<Localidad> ListarLocalidad() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Localidad> listarLocalidad= new ArrayList<Localidad>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "Select idLocalidad, descripcion, idProvincia from localidades";
					Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
			Localidad x = new Localidad();
			x.setIdLocalidad(rs.getInt("idLocalidad"));
			x.setDescripcion(rs.getString("Descripcion"));
			x.setIdProvincia(rs.getInt("IdProvincia"));
			listarLocalidad.add(x);
			}
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listarLocalidad;

	}
	@Override
	public int eliminarLocalidad(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "DELETE FROM localidades WHERE idlocalidad ="+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	@Override
	public Localidad obtenerLocalidad(int id) {
		Localidad x = new Localidad();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM localidades WHERE idLocalidad="+id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setIdLocalidad(rs.getInt("IdLocalidad"));
			x.setDescripcion(rs.getString("Descripcion"));
			x.setIdProvincia(rs.getInt("IdProvincia"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public int getId(String nombreLocalidad) {
		int id = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT idLocalidad FROM Localidades WHERE descripcion='"+nombreLocalidad+"'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			id = rs.getInt("idLocalidad");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
}
