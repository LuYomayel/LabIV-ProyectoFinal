package Negocio;

import java.util.ArrayList;

import Entidad.Alumno;
import Entidad.Alumnoxcurso;

public interface AlumnoxcursoNegocio {
	public ArrayList<Alumnoxcurso> ListarAlumnosxcurso(int idCurso);
	public int agregarAlumnoxcurso(Alumnoxcurso alumno);
	public int agregarNotaGlobal(ArrayList<Alumnoxcurso> listaAlumnos);
	
}
