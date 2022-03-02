package Entidad;

public class Localidad {
	private int idLocalidad;
	private String descripcion;
	private int idProvincia;
	
	public Localidad() {
		
	}
	public Localidad(int id,String desc, int idProv) {
		super();
		this.idLocalidad=id;
		this.descripcion=desc;
		this.idProvincia=idProv;
		
	}
	
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	
}
