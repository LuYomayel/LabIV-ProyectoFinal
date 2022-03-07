package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.ProvinciaDao;
import Entidad.Localidad;
import Entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root";/* "root";*/
	private static String dbName = "dbutn2";
	
	public int AgregarProvincia(Provincia provincia) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String query = "INSERT INTO provincias(idProvincia,descripcion,idPais) values("+provincia.getIdProvincia()+",'"+provincia.getDescripcionProv()+",'"+provincia.getIdPais()+"');";
		
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
	public ArrayList<Provincia> ListarProvincia() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Provincia> listarProvincia= new ArrayList<Provincia>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			//String query = "Select idProvincia, descripcion, idPais from provincias";
					Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select idProvincia, descripcion, idPais FROM provincias");
			
			while (rs.next()) {
			Provincia x = new Provincia();
			x.setIdProvincia(rs.getInt("idProvincia"));
			x.setDescripcionProv(rs.getString("descripcion"));
			x.setIdPais(rs.getInt("IdPais"));
			listarProvincia.add(x);
			}
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
		}
		return listarProvincia;

}

	@Override
	public int eliminarProvincia(int id) {
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
			String query = "DELETE FROM provincias WHERE idprovincia ="+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;	}

	@Override
	public Provincia obtenerProvincia(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Provincia x = new Provincia();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM Provincias WHERE idProvincia="+id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setIdProvincia(rs.getInt("IdProvincia"));
			x.setDescripcionProv(rs.getString("Descripcion"));
			x.setIdPais(rs.getInt("IdPais"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int getId(String nombreProvincia) {
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
			String query = "SELECT idProvincia FROM Provincias WHERE descripcion='"+nombreProvincia+"'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			id = rs.getInt("idProvincia");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}

}
