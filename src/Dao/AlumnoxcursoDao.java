package Dao;

import java.util.ArrayList;

import Entidad.Alumnoxcurso;

public interface AlumnoxcursoDao {
	public int agregarAlumnoxcurso(Alumnoxcurso alumnoxcurso);
	public ArrayList<Alumnoxcurso> ListarAlumnosxcurso(int idCurso);
	public int eliminarAlumnoxcurso(int id);
	public Alumnoxcurso obtenerAlumnoxcurso(int id); //modific Anibal
	public int cargarNota1(Alumnoxcurso alumno);
	public int cargarNota2(Alumnoxcurso alumno);
	public int cargarRecupera1(Alumnoxcurso alumno);
	public int cargarRecupera2(Alumnoxcurso alumno);
	public int setEstado(Alumnoxcurso alumno);
}
