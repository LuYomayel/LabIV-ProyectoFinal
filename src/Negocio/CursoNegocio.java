package Negocio;

import java.util.ArrayList;

import Entidad.Curso;

public interface CursoNegocio {
	public int agregarCurso(Curso curso);
	public ArrayList<Curso> listarCursos(int idDocente);
	public Curso getCurso(int idCurso);
}
