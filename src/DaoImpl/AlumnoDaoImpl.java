package DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.AlumnoDao;
import Entidad.Alumno;
import Entidad.Carrera;

public class AlumnoDaoImpl implements AlumnoDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "root";  // "root"
	private static String dbName = "dbutn2";
	
	
	@Override
	public int agregarAlumno(Alumno alumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		CarreraDaoImpl daoCarrera = new CarreraDaoImpl();
		int id = daoCarrera.getIdCarrera("Tecnico Superior en Programacion");
		
		String query="INSERT INTO alumnos(legajo, dni,nombre,apellido,fechaNac,direccion,idPais,idProvincia,idLocalidad,email,telefono,idCarrera)VALUES("+alumno.getLegajo()+",'"+alumno.getDni()+"','"+alumno.getNombre()+"','"+alumno.getApellido()+"',STR_TO_DATE('"+alumno.getFechanacimiento()+"','%d/%m/%Y'),'"+alumno.getDireccion()+"','"+alumno.getNacionalidad()+"','"+alumno.getProvincia()+"','"+alumno.getLocalidad()+"','"+alumno.getEmail()+"','"+alumno.getTelefono()+"',"+id+")";
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
	public ArrayList<Alumno> ListarAlumnos() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Alumno>listaAlumnos = new ArrayList<Alumno>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			
			CarreraDaoImpl daoCarrera = new CarreraDaoImpl();
			int id = daoCarrera.getIdCarrera("Tecnico Superior en Programacion");
			
			ResultSet rs = st.executeQuery("SELECT a.idAlumno idAlumno,a.legajo Legajo,a.dni Dni,a.nombre Nombre,a.apellido Apellido, date_format(FechaNac, \"%d/%m/%Y\") FechaNacimiento, a.direccion Direccion, p.descripcion Pais, pr.descripcion Provincia, l.descripcion Localidad, a.email Email, a.telefono Telefono FROM alumnos a join paises p on p.idPais = a.idPais join provincias pr on pr.idProvincia = a.idProvincia join localidades l on l.idLocalidad = a.idLocalidad where a.estado = 1");
					
			
			while (rs.next()) {
				Alumno x = new Alumno();
				
				x.setId(rs.getInt("idAlumno"));
				x.setLegajo(rs.getInt("Legajo"));
				x.setDni(rs.getString("Dni"));
				x.setNombre(rs.getString("Nombre"));
				x.setApellido(rs.getString("Apellido"));
				x.setFechanacimiento(rs.getString("FechaNacimiento"));
				x.setDireccion(rs.getString("Direccion"));
				x.setNacionalidad(rs.getString("Pais"));
				x.setProvincia(rs.getString("Provincia"));
				x.setLocalidad(rs.getString("Localidad"));
				x.setEmail(rs.getString("Email"));
				x.setTelefono(rs.getString("Telefono"));	
				
				listaAlumnos.add(x);
			}
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
		}
		return listaAlumnos;
	}
	public ArrayList<Alumno> ListarAlumnosCurso(int idCurso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Alumno>listaAlumnos = new ArrayList<Alumno>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			
			CarreraDaoImpl daoCarrera = new CarreraDaoImpl();
			int id = daoCarrera.getIdCarrera("Tecnico Superior en Programacion");
			
			ResultSet rs = st.executeQuery("SELECT a.idAlumno idAlumno,a.legajo Legajo,a.dni Dni,a.nombre Nombre,a.apellido Apellido, date_format(FechaNac, \"%d/%m/%Y\") FechaNacimiento, a.direccion Direccion, p.descripcion Pais, pr.descripcion Provincia, l.descripcion Localidad, a.email Email, a.telefono Telefono FROM alumnos a join paises p on p.idPais = a.idPais join provincias pr on pr.idPais = p.idPais join localidades l on l.idLocalidad = a.idLocalidad join alumnosxcurso axc on axc.idAlumno = a.idAlumno join cursos c on c.idCurso = axc.idCurso where a.estado = 1 and c.idCurso ="+ idCurso);
					
			
			while (rs.next()) {
				Alumno x = new Alumno();
				
				x.setId(rs.getInt("idAlumno"));
				x.setLegajo(rs.getInt("Legajo"));
				x.setDni(rs.getString("Dni"));
				x.setNombre(rs.getString("Nombre"));
				x.setApellido(rs.getString("Apellido"));
				x.setFechanacimiento(rs.getString("FechaNacimiento"));
				x.setDireccion(rs.getString("Direccion"));
				x.setNacionalidad(rs.getString("Pais"));
				x.setProvincia(rs.getString("Provincia"));
				x.setLocalidad(rs.getString("Localidad"));
				x.setEmail(rs.getString("Email"));
				x.setTelefono(rs.getString("Telefono"));	
				
				listaAlumnos.add(x);
			}
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
		}
		return listaAlumnos;
	}
	
	@Override
	public int eliminarAlumno(int legajo) {
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
			String query = "Update alumnos set estado= 0 where legajo = "+legajo;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	
	
	@Override
	public Alumno obtenerAlumno(String apellido) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		Alumno x = new Alumno();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM alumnos WHERE apellido="+apellido;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setId(rs.getInt("idAlumno"));
			x.setLegajo(rs.getInt("legajo"));
			x.setDni(rs.getString("dni"));
			x.setNombre(rs.getString("nombre"));
			x.setApellido(rs.getString("apellido"));
			x.setFechanacimiento(rs.getString("FechaNac"));
			x.setDireccion(rs.getString("direccion"));
			x.setNacionalidad(rs.getString("idPais"));
			x.setProvincia(rs.getString("idProvincia"));
			x.setLocalidad(rs.getString("idLocalidad"));
			x.setEmail(rs.getString("email"));
			x.setTelefono(rs.getString("telefono"));	
			x.setIdCarrera(rs.getInt("idcarrera"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	@Override
	public Alumno getAlumno(int legajo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		Alumno x = new Alumno();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM alumnos WHERE legajo="+legajo;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setId(rs.getInt("idAlumno"));
			x.setLegajo(rs.getInt("legajo"));
			x.setDni(rs.getString("dni"));
			x.setNombre(rs.getString("nombre"));
			x.setApellido(rs.getString("apellido"));
			x.setFechanacimiento(rs.getString("FechaNac"));
			x.setDireccion(rs.getString("direccion"));
			x.setNacionalidad(rs.getString("idPais"));
			x.setProvincia(rs.getString("idProvincia"));
			x.setLocalidad(rs.getString("idLocalidad"));
			x.setEmail(rs.getString("email"));
			x.setTelefono(rs.getString("telefono"));	
			x.setIdCarrera(rs.getInt("idcarrera"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	public Alumno getAlumnoId(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		Alumno x = new Alumno();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM alumnos WHERE idAlumno="+id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setId(rs.getInt("idAlumno"));
			x.setLegajo(rs.getInt("legajo"));
			x.setDni(rs.getString("dni"));
			x.setNombre(rs.getString("nombre"));
			x.setApellido(rs.getString("apellido"));
			x.setFechanacimiento(rs.getString("FechaNac"));
			x.setDireccion(rs.getString("direccion"));
			x.setNacionalidad(rs.getString("idPais"));
			x.setProvincia(rs.getString("idProvincia"));
			x.setLocalidad(rs.getString("idLocalidad"));
			x.setEmail(rs.getString("email"));
			x.setTelefono(rs.getString("telefono"));	
			x.setIdCarrera(rs.getInt("idcarrera"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	public int modificarAlumno(Alumno a) {
		//Alumno alumno = new Alumno();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		int filas =0;
		Connection cn = null;
				
		try {
			CarreraDaoImpl carrera = new CarreraDaoImpl();
			int idCarrera = carrera.getIdCarrera("Tecnico Superior en Programacion");
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			String query=
			"UPDATE alumnos set dni ='"+a.getDni()+"',nombre='"+a.getNombre()+"',apellido ='"+a.getApellido()+"',fechaNac= "+ "STR_TO_DATE( '"+a.getFechanacimiento()+"','%d/%m/%Y'), direccion = '" +a.getDireccion()+"',idPais = "+a.getNacionalidad()+",idProvincia = "+a.getProvincia()+",idLocalidad ="+a.getLocalidad()+",email = '"+a.getEmail()+"',telefono = '"+a.getTelefono()+"' where legajo = "+	a.getLegajo();
			
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	
	}
	public int agregarAlCurso(ArrayList<Alumno> listaAlumnos, int id) {
		int filas = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		try {
			Connection cn = null;
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			cn.setAutoCommit(false);
			System.out.println("idCurso: "+id);
		
		listaAlumnos.forEach(alumno -> 
		
		{
			try {
				st.executeUpdate("Insert into alumnosxcurso(idAlumno,idCurso)values (" +alumno.getId()+ "," + id +")");
			} catch (SQLException e) {
				System.out.println("Error en AlumnoDao");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		);
			
		cn.commit();
		System.out.println("Sali");
		
		st.close();
		cn.close();
		
		
		}catch(Exception e) {
			
		}
		
		
		return filas;
	}


	@Override
	public ArrayList<Alumno> listarTodosAlumnos() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Alumno>listaAlumnos = new ArrayList<Alumno>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			
			CarreraDaoImpl daoCarrera = new CarreraDaoImpl();
			int id = daoCarrera.getIdCarrera("Tecnico Superior en Programacion");
			
			ResultSet rs = st.executeQuery("SELECT a.idAlumno idAlumno,a.legajo Legajo,a.dni Dni,a.nombre Nombre,a.apellido Apellido, date_format(FechaNac, \"%d/%m/%Y\") FechaNacimiento, a.direccion Direccion, p.descripcion Pais, pr.descripcion Provincia, l.descripcion Localidad, a.email Email, a.telefono Telefono FROM alumnos a join paises p on p.idPais = a.idPais join provincias pr on pr.idPais = p.idPais join localidades l on l.idLocalidad = a.idLocalidad");
					
			
			while (rs.next()) {
				Alumno x = new Alumno();
				
				x.setId(rs.getInt("idAlumno"));
				x.setLegajo(rs.getInt("Legajo"));
				x.setDni(rs.getString("Dni"));
				x.setNombre(rs.getString("Nombre"));
				x.setApellido(rs.getString("Apellido"));
				x.setFechanacimiento(rs.getString("FechaNacimiento"));
				x.setDireccion(rs.getString("Direccion"));
				x.setNacionalidad(rs.getString("Pais"));
				x.setProvincia(rs.getString("Provincia"));
				x.setLocalidad(rs.getString("Localidad"));
				x.setEmail(rs.getString("Email"));
				x.setTelefono(rs.getString("Telefono"));	
				
				listaAlumnos.add(x);
			}
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
		}
		return listaAlumnos;
	}
	
	
}
