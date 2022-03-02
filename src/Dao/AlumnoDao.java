package Dao;

import java.util.ArrayList;

import Entidad.Alumno;

public interface AlumnoDao {
	String getApellido = null;
	public int agregarAlumno(Alumno alumno);
	public ArrayList<Alumno> ListarAlumnos();
	public int eliminarAlumno(int id);
	public Alumno obtenerAlumno(String apellido);
	public int modificarAlumno(Alumno alumno);
	public Alumno getAlumno(int legajo);
	public int agregarAlCurso(ArrayList<Alumno> listaAlumnos, int id);
}
