package Dao;

import java.util.ArrayList;

import Entidad.Localidad;

public interface LocalidadDao {
	public int AgregarLocalidad(Localidad localidad);
	public ArrayList<Localidad> ListarLocalidad(int idProvincia);
	public int eliminarLocalidad(int id);
	public Localidad obtenerLocalidad(int id);
	public int getId(String nombreLocalidad);
}
