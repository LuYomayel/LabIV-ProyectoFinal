package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.AlumnoxcursoDao;
import Entidad.Alumnoxcurso;

public class AlumnoxcursoDaoImpl implements AlumnoxcursoDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "root"; // "root"
	private static String dbName = "dbutn2";
	
	
	@Override
	public int agregarAlumnoxcurso(Alumnoxcurso alumnoxcurso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="Update  alumnosxcurso set parcial1="+ alumnoxcurso.getParcial1() +", parcial2="+ alumnoxcurso.getParcial2()+", recuperatorio1= "+alumnoxcurso.getRecupera1()+", recuperatorio2="+alumnoxcurso.getRecupera2()+", estado='"+alumnoxcurso.getEstado()+"' where idAlumno="+alumnoxcurso.getIdAlumno()+" and idCurso=" + alumnoxcurso.getIdCurso();
		Connection cn = null;
		int filas =0;
		try {
			System.out.println(alumnoxcurso.getIdAlumno());
			System.out.println(alumnoxcurso.getIdCurso());
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
	public ArrayList<Alumnoxcurso> ListarAlumnosxcurso(int idCurso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Alumnoxcurso>listaAlumnosxcurso = new ArrayList<Alumnoxcurso>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			 
			Statement st = cn.createStatement();
			
			String query = "SELECT axc.idAlumnosxcurso,a.Nombre, a.Apellido,c.Descripcion_curso, axc.estado, axc.parcial1, axc.parcial2, axc.recuperatorio1, axc.recuperatorio2, axc.idCurso, axc.idAlumno FROM  alumnosxcurso axc LEFT JOIN cursos c ON axc.idCurso = c.idCurso LEFT JOIN docentes d ON c.idDocente = d.idDocente LEFT JOIN alumnos a ON axc.idAlumno = a.idAlumno where c.idCurso ="+idCurso ;
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				if(rs != null) {
				Alumnoxcurso x = new Alumnoxcurso();
				x.setId(rs.getInt("idAlumnosxcurso"));
				x.setEstado(rs.getString("estado"));
				x.setParcial1(rs.getDouble("parcial1"));
				x.setParcial2(rs.getDouble("parcial2"));	
				x.setRecupera1(rs.getDouble("recuperatorio1"));
				x.setRecupera2(rs.getDouble("recuperatorio2"));
				x.setIdCurso(rs.getInt("idCurso"));
				x.setIdAlumno(rs.getInt("idAlumno"));	
				
				listaAlumnosxcurso.add(x);
				
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listaAlumnosxcurso;
	}
	
	
	@Override
	public int eliminarAlumnoxcurso(int id) {
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
			String query = "DELETE FROM alumnosxcurso WHERE idAlumnosxcurso="+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	
	
	@Override
	public Alumnoxcurso obtenerAlumnoxcurso(int id) {
		Alumnoxcurso x = new Alumnoxcurso();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "SELECT * FROM alumnosxcurso WHERE idAlumnosxcurso="+id;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			x.setId(rs.getInt("idAlumnosxcurso"));
			x.setEstado(rs.getString("estado"));
			x.setParcial1(rs.getDouble("parcial1"));
			x.setParcial2(rs.getDouble("parcial2"));	
			x.setRecupera1(rs.getDouble("recupera1"));
			x.setRecupera2(rs.getDouble("recupera2"));
			x.setIdCurso(rs.getInt("idCurso"));
			x.setIdAlumno(rs.getInt("idAlumno"));		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}


	@Override
	public int cargarNota1(Alumnoxcurso alumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="Update  alumnosxcurso set parcial1="+ alumno.getParcial1() +" where idAlumno="+alumno.getIdAlumno()+" and idCurso=" + alumno.getIdCurso();
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
	public int cargarNota2(Alumnoxcurso alumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="Update  alumnosxcurso set parcial2="+ alumno.getParcial2() +" where idAlumno="+alumno.getIdAlumno()+" and idCurso=" + alumno.getIdCurso();
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
	public int cargarRecupera1(Alumnoxcurso alumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="Update  alumnosxcurso set recuperatorio1="+ alumno.getRecupera1() +" where idAlumno="+alumno.getIdAlumno()+" and idCurso=" + alumno.getIdCurso();
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
	public int cargarRecupera2(Alumnoxcurso alumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="Update  alumnosxcurso set recuperatorio2="+ alumno.getRecupera2() +" where idAlumno="+alumno.getIdAlumno()+" and idCurso=" + alumno.getIdCurso();
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
	
	public int setEstado(Alumnoxcurso alumno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="Update  alumnosxcurso set estado='"+ alumno.getEstado() +"' where idAlumno="+alumno.getIdAlumno()+" and idCurso=" + alumno.getIdCurso();
		Connection cn = null;
		int filas =0;
		try {
			System.out.println("Estado "+alumno.getEstado());
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	
}
