package Dao;

import java.util.ArrayList;

import Entidad.Curso;

public interface CursoDao {
	public int agregarCurso(Curso curso);
	public ArrayList<Curso> listarCursos(int idDocente);
	public int getCantidadAlumnos(int idCurso);
	public Curso getCurso(int idCurso);
}
