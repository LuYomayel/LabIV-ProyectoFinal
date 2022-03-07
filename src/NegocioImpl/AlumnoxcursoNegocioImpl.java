package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.AlumnoDaoImpl;
import DaoImpl.AlumnoxcursoDaoImpl;
import Entidad.Alumno;
import Entidad.Alumnoxcurso;
import Negocio.AlumnoxcursoNegocio;

public class AlumnoxcursoNegocioImpl implements AlumnoxcursoNegocio{
	AlumnoxcursoDaoImpl axcDao = new AlumnoxcursoDaoImpl();
	@Override
	public ArrayList<Alumnoxcurso> ListarAlumnosxcurso(int idCurso) {
		// TODO Auto-generated method stub
		return axcDao.ListarAlumnosxcurso(idCurso);
	}
	@Override
	public int agregarAlumnoxcurso(Alumnoxcurso alumno) {
		int estado = -1;
		
		System.out.println(alumno.getIdAlumno());
		System.out.println(alumno.getIdCurso());
		if(		!( alumno.getIdAlumno() <= 0) &&
				!( alumno.getIdCurso() <= 0) &&
				(alumno.getParcial1()>=0 && alumno.getParcial1()<=10) &&
				(alumno.getParcial2()>=0 && alumno.getParcial2()<=10) &&
				(alumno.getRecupera1()>=0 && alumno.getRecupera1()<=10) &&
				(alumno.getRecupera2()>=0 && alumno.getRecupera2()<=10) 
				) {
			estado = axcDao.agregarAlumnoxcurso(alumno);
		}
		
		return estado;
	}
	@Override
	public int agregarNotaGlobal(ArrayList<Alumnoxcurso> listaAlumnos) {
		int estado = -1;
		
		for(Alumnoxcurso alumno : listaAlumnos) {
			if(alumno.getParcial1() > 0) estado = axcDao.cargarNota1(alumno);
			if(alumno.getParcial2() > 0) estado = axcDao.cargarNota2(alumno);
			if(alumno.getRecupera1() > 0) estado = axcDao.cargarRecupera1(alumno);
			if(alumno.getRecupera2() > 0) estado = axcDao.cargarRecupera2(alumno);
			estado = axcDao.setEstado(alumno);
		}
		
		
		return estado;
	}

}
