package DaoImpl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dao.DocenteDao;
import Entidad.Alumno;
import Entidad.Docente;

public class DocenteDaoImpl implements DocenteDao{

	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root"; //"root";
	private static String dbName = "dbutn2";
	
	@Override
	public int agregarDocente(Docente docente) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		CarreraDaoImpl carrera = new CarreraDaoImpl();
		int idCarrera = carrera.getIdCarrera("Tecnico Superior en Programacion");
		String query="INSERT INTO docentes(Legajo, Dni, Nombre, Apellido, FechaNac, Direccion, idPais,idProvincia,idLocalidad, Telefono, Email,idCarrera)VALUES("+docente.getLegajo()+",'"+docente.getDni()+"','"+docente.getNombre()+"','"+docente.getApellido()+"',STR_TO_DATE('"+docente.getFechanacimiento()+"','%d/%m/%Y'),'"+docente.getDireccion()+"',"+docente.getNacionalidad()+","+docente.getProvincia()+","+docente.getLocalidad()+","+docente.getTelefono()+",'"+docente.getEmail()+"',"+idCarrera+")";
		Connection cn = null;
		int filas =0;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(filas > 0) {
			UsuarioDaoImpl uDao = new UsuarioDaoImpl();
			uDao.agregarDocente(docente);
		}
		return filas;
	}

	@Override
	public ArrayList<Docente> ListarDocentes() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Docente>listaDocentes = new ArrayList<Docente>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "\r\n" + 
					"SELECT a.idDocente Id,a.legajo Legajo,a.dni Dni,a.nombre Nombre,a.apellido Apellido, date_format(a.FechaNac , \"%d/%m/%Y\") FechaNacimiento, a.direccion Direccion, p.descripcion Pais, pr.descripcion Provincia, l.descripcion Localidad, a.email Email, a.telefono Telefono  FROM docentes a join paises p on p.idPais = a.idPais join provincias pr on pr.idPais = p.idPais join localidades l on l.idLocalidad = a.idLocalidad where a.estado = 1;\r\n" + 
					"";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Docente x = new Docente();
				x.setId(rs.getInt("Id"));
				x.setLegajo(rs.getInt("legajo"));
				x.setDni(rs.getString("dni"));
				x.setNombre(rs.getString("nombre"));
				x.setApellido(rs.getString("apellido"));
				x.setFechanacimiento(rs.getString("fechaNacimiento"));
				x.setDireccion(rs.getString("direccion"));
				x.setNacionalidad(rs.getString("Pais"));
				x.setProvincia(rs.getString("provincia"));
				x.setLocalidad(rs.getString("Localidad"));
				x.setEmail(rs.getString("email"));
				x.setTelefono(rs.getString("telefono"));			
				listaDocentes.add(x);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listaDocentes;
	}

	@Override
	public int eliminarDocente(int id) {
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
			
			String query1 = "Update Usuarios set estado = 0 where idDocente_Usuario="+id;
			filas = st.executeUpdate(query1);
			String query = "Update Docentes set estado= 0 where idDocente = "+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Docente obtenerDocente(String apellido) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Docente x = new Docente();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM docentes WHERE apellido="+apellido;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setLegajo(rs.getInt("legajo"));
			x.setDni(rs.getString("dni"));
			x.setNombre(rs.getString("nombre"));
			x.setApellido(rs.getString("apellido"));
			x.setFechanacimiento(rs.getString("fechanacimiento"));
			x.setDireccion(rs.getString("direccion"));
			x.setLocalidad(rs.getString("localidad"));
			x.setNacionalidad(rs.getString("nacionalidad"));			
			x.setEmail(rs.getString("email"));
			x.setTelefono(rs.getString("telefono"));			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int obtenerIdDocente(String mail) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Docente d = new Docente();
		Connection cn = null;	
		int id = -1;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "select idDocente from docentes where email like('%"+mail+"%')";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			id = rs.getInt("idDocente");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(id > 0) return id;
		else return -1;
		
	}
	public int obtenerIdDocentexLegajo(Docente docente) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Docente d = new Docente();
		Connection cn = null;	
		int id = -1;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "select idDocente from docentes where legajo="+docente.getLegajo();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			id = rs.getInt("idDocente");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(id > 0) return id;
		else return -1;
		
	}
	public int modificarDocente(Docente d) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		int filas =0;
		Connection cn = null;
				
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query=
			"UPDATE docentes set dni ='"+d.getDni()+"',nombre='"+d.getNombre()+"',apellido ='"+d.getApellido()+"',fechaNac= "+ "STR_TO_DATE( '"+d.getFechanacimiento()+"','%d/%m/%Y'), direccion = '" +d.getDireccion()+"',idPais = "+d.getNacionalidad()+",idProvincia = "+d.getProvincia()+",idLocalidad ="+d.getLocalidad()+",email = '"+d.getEmail()+"',telefono = '"+d.getTelefono()+"' where legajo = "+	d.getLegajo();
			
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	
	}

	
}
