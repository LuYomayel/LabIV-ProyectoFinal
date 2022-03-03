package NegocioImpl;

import java.util.ArrayList;

import Dao.AlumnoDao;
import DaoImpl.AlumnoDaoImpl;
import Entidad.Alumno;
import Negocio.AlumnoNegocio;

public class AlumnoNegocioImpl implements AlumnoNegocio{
	AlumnoDaoImpl adao = new AlumnoDaoImpl();

	@Override
	public int agregarAlumno(Alumno alumno) {
		int estado=-1;
		if(alumno.getLegajo()>0 && 
				alumno.getDni().trim().length()>0 &&
				alumno.getNombre().trim().length()>0 &&
				alumno.getApellido().trim().length()>0 &&
				alumno.getFechanacimiento().trim().length()>0 &&
				alumno.getDireccion().trim().length()>0 &&
				alumno.getNacionalidad().trim().length()>0 &&
				alumno.getProvincia().trim().length()>0 &&
				alumno.getLocalidad().trim().length()>0 &&
				alumno.getEmail().trim().length()>0 &&
				alumno.getTelefono().trim().length()>0 
				)
		{
			estado=adao.agregarAlumno(alumno);
		}
		
		
		return estado;
	}

	@Override
	public ArrayList<Alumno> ListarAlumnos() {
		return adao.ListarAlumnos();
	}

	@Override
	public int eliminarAlumno(int legajo) {
		int estado=-1;
		AlumnoDaoImpl alumnoDao = new AlumnoDaoImpl();
		Alumno alumno = alumnoDao.getAlumno(legajo);
		if(alumno.getLegajo()>0 )//También se puede preguntar si existe ese ID 
		{
			estado=adao.eliminarAlumno(legajo);
		}
		return estado; 
	}
	
	@Override
	public Alumno obtenerAlumno(int id) {
		Alumno alumno = new Alumno();
		/*alumno = obtenerAlumno(id);
		if(alumno.getLegajo()>0 )
		{
			alumno=adao.obtenerAlumno(id);
		}*/
		return alumno; 
	}

	@Override
	public Alumno obtenerAlumno(String Apellido) {
		
		Alumno alumno = obtenerAlumno(Apellido);
		if(alumno.getLegajo()>0 )
		{
			alumno=adao.obtenerAlumno(Apellido);
		}
		return alumno; 
	}

	@Override
	public int modificarAlumno(Alumno alumno) {
		int estado=-1;
		if(alumno.getLegajo()>0 && 
				alumno.getDni().trim().length()>0 &&
				alumno.getNombre().trim().length()>0 &&
				alumno.getApellido().trim().length()>0 &&
				alumno.getFechanacimiento().trim().length()>0 &&
				alumno.getDireccion().trim().length()>0 &&
				alumno.getNacionalidad().trim().length()>0 &&
				alumno.getProvincia().trim().length()>0 &&
				alumno.getLocalidad().trim().length()>0 &&
				alumno.getEmail().trim().length()>0 &&
				alumno.getTelefono().trim().length()>0 
				)
		{
			estado=adao.modificarAlumno(alumno);
		}
		
		
		return estado;
	}

	@Override
	public ArrayList<Alumno> ListarAlumnosCurso(int idCurso) {
		ArrayList<Alumno> listaAlumnosCurso = adao.ListarAlumnosCurso(idCurso);
		return listaAlumnosCurso;
	}

	@Override
	public Alumno getAlumno(int idAlumno) {
		return adao.getAlumno(idAlumno);
	}

	@Override
	public ArrayList<Alumno> listarTodosAlumnos() {
		return adao.listarTodosAlumnos();
	}
}
