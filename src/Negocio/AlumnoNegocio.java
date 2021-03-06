package Negocio;

import java.util.ArrayList;

import Entidad.Alumno;

public interface AlumnoNegocio {
	public int agregarAlumno(Alumno alumno);
	public ArrayList<Alumno> ListarAlumnos();
	public int eliminarAlumno(int id);
	//?Apellido y nombre?
	public Alumno obtenerAlumno(String Apellido);
	Alumno obtenerAlumno(int id);
	public int modificarAlumno(Alumno alumno);
	public ArrayList<Alumno> ListarAlumnosCurso(int idCurso);
	public Alumno getAlumno(int idAlumno);
	public ArrayList<Alumno> listarTodosAlumnos();
}
