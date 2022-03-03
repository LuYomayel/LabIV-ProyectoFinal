package Dao;

import java.util.ArrayList;

import Entidad.Provincia;

public interface ProvinciaDao {
	public int AgregarProvincia(Provincia provincia);
	public ArrayList<Provincia> ListarProvincia(int idPais);
	public int eliminarProvincia(int id);
	public Provincia obtenerProvincia(int id);
	public int getId(String nombreProvincia);
}
