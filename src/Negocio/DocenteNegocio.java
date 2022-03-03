package Negocio;

import java.util.ArrayList;

import Entidad.Docente;

public interface DocenteNegocio {
	public int agregarDocente(Docente docente);
	public ArrayList<Docente> ListarDocentes();
	public int eliminarDocente(int id);
	public Docente obtenerDocente(String apellido);
	public Docente obtenerDocente(int legajo);
	public Docente obtenerIdDocente(String mail);
	public int modificarDocente(Docente docente);
	
}
