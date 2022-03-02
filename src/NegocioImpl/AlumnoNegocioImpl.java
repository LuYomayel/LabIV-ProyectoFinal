/*package NegocioImpl;

import java.util.ArrayList;

import Dao.AlumnoDao;
import DaoImpl.AlumnoDaoImpl;
import Entidad.Alumno;
import Negocio.AlumnoNegocio;

public class AlumnoNegocioImpl implements AlumnoNegocio{
	AlumnoDao adao = new AlumnoDaoImpl();

	@Override
	public int agregarAlumno(Alumno alumno) {
		boolean estado=false;
		if(alumno.getLegajo()>0 && 
				alumno.getDni().trim().length()>0 &&
				alumno.getNombre().trim().length()>0 &&
				alumno.getApellido().trim().length()>0 &&
				alumno.getFechanacimiento().trim().length()>0 &&
				alumno.getDireccion().trim().length()>0 &&
				alumno.getNacionalidad().trim().length()>0 &&
				alumno.getProvincia().trim().length()>0 &&
				alumno.getEmail().trim().length()>0 &&
				alumno.getTelefono().trim().length()>0 && 
				alumno.getIdCarrera()>0 
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
	public int eliminarAlumno(int id) {
		boolean estado=false;
		String Apellido = adao.getApellido;		
		Alumno alumno = obtenerAlumno(Apellido);
		if(alumno.getLegajo()>0 )//También se puede preguntar si existe ese ID 
		{
			estado=adao.eliminarAlumno(id);
		}
		return estado; 
	}
	
	@Override
	public Alumno obtenerAlumno(int id) {
		boolean estado=false;
		Alumno alumno = obtenerAlumno(id);
		if(alumno.getLegajo()>0 )
		{
			estado=adao.obtenerAlumno(id);
		}
		return estado; 
	}

	@Override
	public Alumno obtenerAlumno(String Apellido) {
		boolean estado=false;
		Alumno alumno = obtenerAlumno(Apellido);
		if(alumno.getLegajo()>0 )
		{
			estado=adao.obtenerAlumno(Apellido);
		}
		return estado; 
	}
}*/
