package Entidad;

public class Pais {
	  private int idPais;
	  private String descripcionPais;
	  
	  public Pais() {
		  
	  }

	  public Pais(int idPais, String descPais)
	  {
		  this.idPais = idPais;
		  this.descripcionPais = descPais;
		  
	  }
	  public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getDescripcionPais() {
		return descripcionPais;
	}

	public void setDescripcionPais(String descripcionPais) {
		this.descripcionPais = descripcionPais;
	}



}
