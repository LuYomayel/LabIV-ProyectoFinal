package Dao;

import java.util.ArrayList;

import Entidad.Pais;


public interface PaisDao {
	public int AgregarPais(Pais pais);
	public ArrayList<Pais> ListarPais();
	public int eliminarPais(int id);
	public Pais obtenerPais(int id);
	public int getId(String nombrePais) ;
	
}
