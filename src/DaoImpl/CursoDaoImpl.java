package DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidad.Alumno;
import Entidad.Curso;
import Entidad.Docente;
import Entidad.Materia;
import Dao.CursoDao;

public class CursoDaoImpl implements CursoDao{
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "root";  // "root"
	private static String dbName = "dbutn2";
	@Override
	public int agregarCurso(Curso curso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		
		/*CarreraDaoImpl daoCarrera = new CarreraDaoImpl();
		int id = daoCarrera.getIdCarrera("Tecnico Superior en Programacion");*/
		
		
		String query="Insert into cursos(idMateria, Descripcion_curso, Semestre, Año, idDocente)VALUES("+curso.getIdMateria()+",' Aula A1 ','"+curso.getSemestre()+"',"+curso.getAño()+","+ curso.getDocente().getId()+")";
		Connection cn = null;
		int filas =0;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			filas = st.executeUpdate(query);
			
			query = "SELECT idCurso, Descripcion_curso FROM cursos";
			ResultSet rs = st.executeQuery(query);
			int idCurso = -1;
			while(rs.next()) {
				
				idCurso = rs.getInt("idCurso");
			}
			
			System.out.println("idCurso:"+ idCurso);
			AlumnoDaoImpl daoAlu = new AlumnoDaoImpl();
			daoAlu.agregarAlCurso(curso.getAlumno(), idCurso);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	@Override
	public ArrayList<Curso> listarCursos(int idDocente) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Curso>listaCursos = new ArrayList<Curso>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			
			/*CarreraDaoImpl daoCarrera = new CarreraDaoImpl();
			int id = daoCarrera.getIdCarrera("Tecnico Superior en Programacion");*/
			
			ResultSet rs = st.executeQuery("select c.idCurso idCurso, m.Descripcion_Materia as Materia, c.Semestre as Semestre, c.Año as Año, d.Nombre NombreDocente, d.Apellido ApellidoDocente from cursos c join materias m on m.idMateria = c.idMateria join docentes d on c.idDocente = d.idDocente where d.idDocente ="+ idDocente);
					
			
			while (rs.next()) {
				Curso x = new Curso();
				Materia materia = new Materia();
				Docente docente = new Docente();
				materia.setNombreMateria(rs.getString("Materia"));
				docente.setNombre(rs.getString("NombreDocente"));
				docente.setApellido(rs.getString("ApellidoDocente"));
				x.setMateria(materia);
				x.setDocente(docente);
				x.setSemestre(rs.getString("Semestre"));
				x.setAño(rs.getInt("Año"));
				x.setId(rs.getInt("idCurso"));
				
				listaCursos.add(x);
			}
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
		}
		return listaCursos;
	}
	@Override
	public int getCantidadAlumnos(int idCurso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cant = 0;
		ArrayList<Curso>listaCursos = new ArrayList<Curso>();
		Connection cn= null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			
			/*CarreraDaoImpl daoCarrera = new CarreraDaoImpl();
			int id = daoCarrera.getIdCarrera("Tecnico Superior en Programacion");*/
			
			ResultSet rs = st.executeQuery("SELECT a.Nombre, axc.idAlumnosxcurso FROM alumnosxcurso axc join alumnos a on a.idAlumno = axc.idAlumno  where idCurso ="+ idCurso);
					
			
			while (rs.next()) {
				Curso x = new Curso();
				Materia materia = new Materia();
				Docente docente = new Docente();
				materia.setNombreMateria(rs.getString("Materia"));
				docente.setNombre(rs.getString("NombreDocente"));
				docente.setApellido(rs.getString("ApellidoDocente"));
				x.setMateria(materia);
				x.setDocente(docente);
				x.setSemestre(rs.getString("Semestre"));
				x.setAño(rs.getInt("Año"));
				
				
				listaCursos.add(x);
			}
			cn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			
		}
		return cant;
	}
	@Override
	public Curso getCurso(int idCurso) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		Curso x = new Curso();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			String query = "select c.idCurso idCurso, m.Descripcion_Materia as Materia, c.Semestre as Semestre, c.Año as Año, d.Nombre NombreDocente, d.Apellido ApellidoDocente from cursos c join materias m on m.idMateria = c.idMateria join docentes d on c.idDocente = d.idDocente where c.idCurso="+ idCurso;
			ResultSet rs = st.executeQuery(query);
			rs.next();
			Materia materia = new Materia();
			Docente docente = new Docente();
			materia.setNombreMateria(rs.getString("Materia"));
			docente.setNombre(rs.getString("NombreDocente"));
			docente.setApellido(rs.getString("ApellidoDocente"));
			x.setMateria(materia);
			x.setDocente(docente);
			x.setSemestre(rs.getString("Semestre"));
			x.setAño(rs.getInt("Año"));
			x.setId(rs.getInt("idCurso"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	

}
