package Entidad;

public class Materia {
	private int idMateria;
	private String nombreMateria;
	
	
	
	
	public Materia(int idMateria, String nombreMateria) {
		super();
		this.idMateria = idMateria;
		this.nombreMateria = nombreMateria;
	}
	
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}


	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}


	@Override
	public String toString() {
		return nombreMateria;
	}
}
