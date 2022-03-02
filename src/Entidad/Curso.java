package Entidad;

import java.util.ArrayList;

public class Curso {
	private int id;
	private Materia materia;
	private String semestre;
	private int año;
	private Docente docente;
	private ArrayList<Alumno> alumno;
	
	public Curso() {
		
	}
	
	
	public Curso(String semestre, int año) {
		super();	
		this.semestre = semestre;
		this.año = año;
		
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
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
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
