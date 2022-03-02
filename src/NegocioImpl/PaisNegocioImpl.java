/*package NegocioImpl;

import java.util.ArrayList;

import Dao.PaisDao;
import DaoImpl.PaisDaoImpl;
import Entidad.Pais;
import Negocio.PaisNegocio;

public class PaisNegocioImpl implements PaisNegocio{
	PaisDao udao = new PaisDaoImpl();
	
	@Override
	public int agregarPais(Pais pais) {
		int estado=0;
		if(	Pais.getIdPais()>0 && 
				usuario.getDescripcionPais.trim().length()>=0)
		{
			estado=padao.agregarPais(pais);
		}
		return estado;
	}

	@Override
	public ArrayList<Pais> ListarPais() {
		return padao.ListarPaises();
	}

	@Override
	public int eliminarPaises(int id) {
		int estado=0;
		Pais pais =obtenerPais(id);
		if(pais.getIdPais()>0 )//El tema es que el ID lo maneja la base de datos. 
		{
			estado=padao.eliminarPais(id);
		}
		return estado;  //estado al ser int pregunto por el 0
	}

		@Override
	public Alumno obtenerPais(int id) {

		return null;
	}
		

}*/
