package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.CursoDaoImpl;
import Entidad.Curso;

import Negocio.CursoNegocio;

public class CursoNegocioImpl implements CursoNegocio {
	CursoDaoImpl cdao = new CursoDaoImpl();

	@Override
	public int agregarCurso(Curso curso) {
		int estado=-1;
		if(curso.getDocente().getId()>0 && 
				curso.getMateria().getIdMateria()>0 &&
				curso.getAño() > 1900 &&
				curso.getSemestre().trim().length()>0 &&
				curso.getAlumno().size()>0
				)
		{
			estado=cdao.agregarCurso(curso);
		}
		
		
		return estado;
	}

	@Override
	public ArrayList<Curso> listarCursos(int idDocente) {
		ArrayList<Curso>listaCursos = cdao.listarCursos(idDocente);
		return listaCursos;
	}

	@Override
	public Curso getCurso(int idCurso) {
		return cdao.getCurso(idCurso);
	}
}
