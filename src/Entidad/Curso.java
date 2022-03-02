package Entidad;

import java.util.ArrayList;

public class Curso {
	private int id;
	private Materia materia;
	private String semestre;
	private int a�o;
	private Docente docente;
	private ArrayList<Alumno> alumno;
	
	public Curso() {
		
	}
	
	
	public Curso(String semestre, int a�o) {
		super();	
		this.semestre = semestre;
		this.a�o = a�o;
		
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public ArrayList<Alumno> getAlumno() {
		return alumno;
	}
	public void setAlumno(ArrayList<Alumno> alumno) {
		this.alumno = alumno;
	}

	public int getIdMateria() {
		return materia.getIdMateria();
	}
	
	public String getNombreMateria() {
		return materia.getNombreMateria();
		
	}
	
	public int getLegajoDocente() {
		return docente.getLegajo();
	}
	
	public String getNombreCompletoDocente() {
		return docente.toString();
		
	}
}
