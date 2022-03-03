package Negocio;

import java.util.ArrayList;

import Entidad.Materia;

public interface MateriaNegocio {
	public ArrayList<Materia> listarMaterias();
	public int agregarMateria(Materia materia);
}
