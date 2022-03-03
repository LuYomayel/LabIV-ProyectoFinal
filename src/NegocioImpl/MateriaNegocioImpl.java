package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.MateriaDaoImpl;
import Entidad.Materia;
import Negocio.MateriaNegocio;

public class MateriaNegocioImpl implements MateriaNegocio{
	MateriaDaoImpl materiaDao = new MateriaDaoImpl();
	@Override
	public ArrayList<Materia> listarMaterias() {
		return materiaDao.listarMaterias();
	}
	@Override
	public int agregarMateria(Materia materia) {
		int estado = -1;
		if(materia.getNombreMateria()!=null && materia.getNombreMateria() != "") {
			estado = materiaDao.agregarMateria(materia);
		}
		
		return estado;
	}

}
