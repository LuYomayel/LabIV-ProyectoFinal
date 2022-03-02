package Entidad;

public class Provincia {
	private int idProvincia;
	private String DescripcionProv;
	private int idPais;
	public Provincia() {
		
	}
	public Provincia(int id, String desc, int idPa) {
		super();
		this.idProvincia = id;
		this.DescripcionProv = desc;
		this.idPais = idPa;
	}
	
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getDescripcionProv() {
		return DescripcionProv;
	}
	public void setDescripcionProv(String descripcionProv) {
		DescripcionProv = descripcionProv;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	
}
