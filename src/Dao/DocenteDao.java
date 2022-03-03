package Dao;

import java.util.ArrayList;

import Entidad.Docente;

public interface DocenteDao {
	String getApellido = null;
	public int agregarDocente(Docente docente);
	public ArrayList<Docente> ListarDocentes();
	public int eliminarDocente(int id);
	public Docente obtenerDocente(String apellido);
	public int obtenerIdDocente(String mail);
	public int obtenerIdDocentexLegajo(Docente docente);
	public int modificarDocente(Docente docente);
	public Docente getDocente(int idDocente);
}
