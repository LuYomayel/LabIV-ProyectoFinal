package Entidad;

public class Carrera {
	private int IdCarrera;
	private String nombreCarrera;
	
	public Carrera() {
		
	}
	
	public Carrera(int idCarrera, String nombreCarrera) {
		super();
		IdCarrera = idCarrera;
		this.nombreCarrera = nombreCarrera;
	}
	
	public int getIdCarrera() {
		return IdCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		IdCarrera = idCarrera;
	}
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	
	
}

